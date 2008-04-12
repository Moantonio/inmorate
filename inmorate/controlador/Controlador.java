package inmorate.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import inmorate.BBDD.Conexion;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;
import inmorate.gui.VistaVivienda;

public class Controlador {
	private static Logger logger = Logger.getLogger(Controlador.class);
	
	private VistaInicial vistaInicial;	
	private VistaPareja vistaPareja;	
	private VistaMatrimonio vistaMatrimonio;	
	private VistaSoltero vistaSoltero;	
	private VistaSoltera vistaSoltera;	
	private VistaVivienda vistaVivienda;	
	private Conexion conexion;
	private ArrayList<String> comboBox;

	public Controlador() {
		vistaInicial = null;
		vistaPareja = null;
		vistaMatrimonio = null;
		vistaSoltero = null;
		vistaSoltera = null;
		vistaVivienda = null;
		conexion = null;
		comboBox = new ArrayList<String>();
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
	
	public void registrarVistaVivienda(VistaVivienda VV) {
		this.vistaVivienda = VV;
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
	
	public void activarVVP() {
		vistaPareja.setVisible(false);
		vistaVivienda.setVisible(true);
	}
	
	public void cerrarPrograma() {
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
		vistaVivienda.traducirEspanol();
	}

	public void traducirIngles() {
		vistaInicial.traducirIngles();	
		vistaPareja.traducirIngles();
		vistaMatrimonio.traducirIngles();
		vistaSoltero.traducirIngles();
		vistaSoltera.traducirIngles();
		vistaVivienda.traducirIngles();
	}
	
}
