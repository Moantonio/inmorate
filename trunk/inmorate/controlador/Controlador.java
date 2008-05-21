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

	public Controlador() {
		vistaInicial = null;
		vistaPareja = null;
		vistaMatrimonio = null;
		vistaSoltero = null;
		vistaSoltera = null;
		conexion = null;
		comboBox = new ArrayList<String>();
		resultado = null;
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
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}
	
	public void activarVVM() throws SQLException {
		vistaMatrimonio.setVisible(false);
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}
	
	public void activarVVSO() throws SQLException {
		vistaSoltero.setVisible(false);
		vistaFinal.setVisible(true);
		vistaFinal.mostrarResultados();
		conexion.cierraConexion();
	}

	public void activarVVSA() throws SQLException {
		vistaSoltera.setVisible(false);
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
		for (int valor=1; valor<=500; valor++) {
			inmueble.crearInmueble(valor);
			conexion.crearViviendas(inmueble);
		}
		conexion.cierraConexion();
	}

	public InmuebleValorado[] getResultado() {
		return resultado;
	}
	
	public void valorarPareja() {
		ValorarPareja pareja = new ValorarPareja(this);
		resultado = pareja.valorar();
	}

	public void valorarMatrimonio() {
		ValorarMatrimonio matrimonio = new ValorarMatrimonio(this);
		resultado = matrimonio.valorar();
	}

	public void valorarSoltero() {
		ValorarSoltero soltero = new ValorarSoltero(this);
		resultado = soltero.valorar();		
	}

	public void valorarSoltera() {
		ValorarSoltera soltera = new ValorarSoltera(this);
		resultado = soltera.valorar();			
	}
	
}
