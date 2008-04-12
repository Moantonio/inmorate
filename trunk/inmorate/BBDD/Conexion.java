package inmorate.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Conexion {
	private static Logger logger = Logger.getLogger(Conexion.class);
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
		logger.debug("Conectando a la BBDD con nombre: " + db + " URL: " + url);
		conexion = DriverManager.getConnection(url, "", ""); 
	}
	
	public void cierraConexion() throws SQLException {
		conexion.close();
		logger.debug("Cerrada la conexion con la bd.");
	}
	
	public ResultSet datosPropiedadFinca() throws SQLException {	
		ResultSet resultado = null;
		String consulta = "SELECT * FROM Viviendas ORDER BY DMXX";
		Statement stat = conexion.createStatement();
		// stat.execute("use BBDD");
		resultado = stat.executeQuery(consulta);
		// resultado = stat.executeQuery("select * from Propiedad-Otros;");
		logger.debug("Realizada consulta de todos los inmuebles de la bd.");
		return resultado;
	}
	
}
