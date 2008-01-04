package inmorate.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	
	private Connection conexion;

	public Conexion() throws ClassNotFoundException {
		cargarDriver();
	}
	
	private void cargarDriver() throws ClassNotFoundException {		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}
	
	public Connection dameConexion(){
		return conexion;
	}

	public void ponConexion(Connection conex){
		conexion = conex;
	}
	
	public void conectar() throws SQLException {
		// Conexion con la base de datos
		// conexion = DriverManager.getConnection("jdbc:odbc:Proyecto", "", "");
		String db = "BBDD.mdb";
		String url = "jdbc:odbc:MS Access Database;DBQ=" + db;
		conexion = DriverManager.getConnection(url, "", ""); 
	}
	
	public void cierraConexion() throws SQLException {
		conexion.close();
	}
	
	public ResultSet datosPropiedadFinca() throws SQLException {	
		ResultSet resultado = null;
		String consulta = "SELECT * FROM PropiedadFinca ORDER BY DMXX";
		Statement stat = conexion.createStatement();
		// stat.execute("use BBDD");
		resultado = stat.executeQuery(consulta);
		// resultado = stat.executeQuery("select * from Propiedad-Otros;");
		return resultado;
	}
	
}
