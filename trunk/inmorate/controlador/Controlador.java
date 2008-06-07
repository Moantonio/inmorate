package inmorate.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import inmorate.modelo.bbdd.Conexion;
import inmorate.modelo.valoracion.ValorarMatrimonio;
import inmorate.modelo.valoracion.ValorarPareja;
import inmorate.modelo.valoracion.ValorarSoltera;
import inmorate.modelo.valoracion.ValorarSoltero;
import inmorate.gui.VistaFinal;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;
import inmorate.modelo.inmueble.Inmueble;
import inmorate.modelo.inmueble.InmuebleValorado;

public class Controlador {
	
	private VistaInicial vistaInicial;	
	private VistaPareja vistaPareja;	
	private VistaMatrimonio vistaMatrimonio;	
	private VistaSoltero vistaSoltero;	
	private VistaSoltera vistaSoltera;	
	private VistaFinal vistaFinal;
	private Conexion conexion;
	private ArrayList<String> comboBox;
	private InmuebleValorado[] resultado;
	private int vista;
	private ValorarPareja pareja;
	private ValorarMatrimonio matrimonio;
	private ValorarSoltero soltero;
	private ValorarSoltera soltera;

	public Controlador() {
		vistaInicial = null;
		vistaPareja = null;
		vistaMatrimonio = null;
		vistaSoltero = null;
		vistaSoltera = null;
		conexion = null;
		comboBox = new ArrayList<String>();
		for (int i=0; i<5; i++)
			comboBox.add("");
		resultado = null;
		vista = -1;
		pareja = null;
		matrimonio = null;
		soltero = null;
		soltera = null;
	}
	
	public void registrarVistaInicial(VistaInicial VI) {
		this.vistaInicial = VI;
	}
	
	public void registrarVistaPareja(VistaPareja VP) {
		this.vistaPareja = VP;
	}
	
	public void registrarVistaMatrimonio(VistaMatrimonio VM) {
		this.vistaMatrimonio = VM;
	}
	
	public void registrarVistaSoltero(VistaSoltero VSO) {
		this.vistaSoltero = VSO;
	}
	
	public void registrarVistaSoltera(VistaSoltera VSA) {
		this.vistaSoltera = VSA;
	}

	public void registrarVistaFinal(VistaFinal VF) {
		this.vistaFinal = VF;
	}
	
	public void activarVP() {
		vistaInicial.setVisible(false);
		vistaPareja.setVisible(true);
	}
	
	public void activarVM() {
		vistaInicial.setVisible(false);
		vistaMatrimonio.setVisible(true);
	}

	public void activarVSO() {
		vistaInicial.setVisible(false);
		vistaSoltero.setVisible(true);
	}

	public void activarVSA() {
		vistaInicial.setVisible(false);
		vistaSoltera.setVisible(true);
	}
	
	public void activarVVP() throws SQLException {
		vistaPareja.setVisible(false);
		vistaFinal.pareja();
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}
	
	public void activarVVM() throws SQLException {
		vistaMatrimonio.setVisible(false);
		vistaFinal.matrimonio();
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}
	
	public void activarVVSO() throws SQLException {
		vistaSoltero.setVisible(false);
		vistaFinal.soltero();
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}

	public void activarVVSA() throws SQLException {
		vistaSoltera.setVisible(false);
		vistaFinal.soltera();
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}
	
	public void cerrarPrograma() throws SQLException {
		conexion.cierraConexion();
		System.exit(0);
	}
	
	public void crearDriverBBDD() throws ClassNotFoundException {
		conexion = new Conexion(); 
	}
	
	public ResultSet datosPropiedadFinca() throws SQLException {
		conexion.conectar();
		ResultSet resultado = conexion.datosPropiedadFinca();
		return resultado;
	}
	
	public void cierraConexion() throws SQLException {
		conexion.cierraConexion();
	}

	public void volverAtras() {
		// Ocultamos todas las vistas menos la Inicial
		vistaPareja.setVisible(false);
		vistaMatrimonio.setVisible(false);
		vistaSoltera.setVisible(false);
		vistaSoltero.setVisible(false);	
		vistaFinal.setVisible(false);
		vistaInicial.setVisible(true);
		vistaPareja.inicializar(); 
		vistaMatrimonio.inicializar();
		vistaSoltero.inicializar();
		vistaSoltera.inicializar();
	}

	public ArrayList<String> getComboBox() {
		return comboBox;
	}

	public void traducirEspanol() {
		vistaInicial.traducirEspanol();
		vistaPareja.traducirEspanol(); 
		vistaMatrimonio.traducirEspanol();
		vistaSoltero.traducirEspanol();
		vistaSoltera.traducirEspanol();
		vistaFinal.traducirEspanol();
	}

	public void traducirIngles() {
		vistaInicial.traducirIngles();	
		vistaPareja.traducirIngles();
		vistaMatrimonio.traducirIngles();
		vistaSoltero.traducirIngles();
		vistaSoltera.traducirIngles();
		vistaFinal.traducirIngles();
	}

	public void crearViviendas() throws SQLException {
		Inmueble inmueble = new Inmueble();
		conexion.conectar();
		conexion.borrarBBDD();
		for (int valor=1; valor<=300; valor++) {
			inmueble.crearInmueble(valor);
			conexion.crearViviendas(inmueble);
		}
		conexion.cierraConexion();
	}

	public InmuebleValorado[] getResultado() {
		return resultado;
	}
	
	public void valorarPareja() {
		pareja = new ValorarPareja(this);
		vista = 0;
		resultado = pareja.valorar();
	}

	public void valorarMatrimonio() {
		matrimonio = new ValorarMatrimonio(this);
		vista = 1;
		resultado = matrimonio.valorar();
	}

	public void valorarSoltero() {
		soltero = new ValorarSoltero(this);
		vista = 2;
		resultado = soltero.valorar();		
	}

	public void valorarSoltera() {
		soltera = new ValorarSoltera(this);
		vista = 3;
		resultado = soltera.valorar();			
	}

	public void escribirPanel(String string) {
		switch(vista) {
		case 0: vistaPareja.escribir(string);
			break;
		case 1: vistaMatrimonio.escribir(string);
			break;
		case 2: vistaSoltero.escribir(string);
			break;
		case 3: vistaSoltera.escribir(string);
			break;
		default: break;
		}
	}

	public void ordenarInmuebles(int perfil) {
		switch(perfil) {
		case 0: pareja.maxPosiciones();
			break;
		case 1: matrimonio.maxPosiciones();
			break;
		case 2: soltero.maxPosiciones();
			break;
		case 3: soltera.maxPosiciones();
			break;
		default: break;
		}
	}

	public void ordenarIdent(int perfil) {
		switch(perfil) {
		case 0: pareja.identificadores();
			break;
		case 1: matrimonio.identificadores();
			break;
		case 2: soltero.identificadores();
			break;
		case 3: soltera.identificadores();
			break;
		default: break;
		}
	}
	
}
