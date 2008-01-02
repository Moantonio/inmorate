package inmorate.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import inmorate.BBDD.Conexion;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;

public class Controlador {
	
	private VistaInicial vistaInicial;
	
	private VistaPareja vistaPareja;
	
	private VistaMatrimonio vistaMatrimonio;
	
	private VistaSoltero vistaSoltero;
	
	private VistaSoltera vistaSoltera;
	
	private Conexion conexion;

	public Controlador() {
		vistaInicial = null;
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
	
	@SuppressWarnings("deprecation")
	public void activarVP() {
		vistaInicial.setVisible(false);
		vistaPareja.show();
		vistaInicial.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void activarVM() {
		vistaInicial.setVisible(false);
		vistaMatrimonio.show();
		vistaInicial.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void activarVSO() {
		vistaInicial.setVisible(false);
		vistaSoltero.show();
		vistaInicial.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void activarVSA() {
		vistaInicial.setVisible(false);
		vistaSoltera.show();
		vistaInicial.setVisible(true);
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
		System.out.println("1");
		resultado.next();
		//resultado.first();
		System.out.println("2");
		for (int i=1; i<7; i++) {
			System.out.println(resultado.getString(i));
		}
		//resultado.close();
		conexion.cierraConexion(); // Quitar cierraConexion y ponerlo fuera, sino no funciona
		return resultado;
	}
	
}
