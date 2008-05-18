package inmorate.modelo.bbdd;

import inmorate.modelo.inmueble.Inmueble;

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

	public void crearViviendas(Inmueble i) throws SQLException {
		String consulta = "INSERT INTO Viviendas (DMXX,TipoDeInmueble,Luminosidad,Orientacion,Representatividad," +
				"EstadoDelPortal,Fachada,Vistas,NumDormitorios,NumBanos,Antiguedad,Altura,Ascensor,PlazasDeGaraje," +
				"EstadoGeneral,ZonasComunes,ZonaSubzona,MetrosConstruidos,MetrosHabitables,PrecioDeTasacion," +
				"PrecioDeSalida,PrecioDeVenta,Direccion,Amueblado,Piscina,AireAcondicionado,Conserje,Trastero) " +
				//"VALUES ('0001','Piso',7,'Norte',6,5,8,7,9,4,5,8,yes,2,8,no,'Centro',200,235,200000.00,350000.00,0.00," +
				//"'C/Alcala, 54',yes,no,yes,no,no)";
				"VALUES ('"+i.getDMXX()+"','"+i.getTipoDeInmueble()+"',"+i.getLuminosidad()+",'"+i.getOrientacion()+
						"',"+i.getRepresentatividad()+","+i.getEstadoDelPortal()+","+i.getFachada()+","+i.getVistas()+
						","+i.getNumeroHabitaciones()+","+i.getNumeroBanos()+","+i.getAntiguedad()+","+i.getAltura()+",";
		if (i.isAscensor())
			consulta += "yes,";
		else
			consulta += "no,";
		consulta += i.getPlazasGaraje()+","+i.getEstadoGeneral()+",";
		if (i.isZonasComunes())
			consulta += "yes,";
		else
			consulta += "no,";
		consulta += "'"+i.getZona()+"',"+i.getMetrosConstruidos()+","+i.getMetrosHabitables()+","+i.getPrecioTasacion()+
				","+i.getPrecioSalida()+","+i.getPrecioVenta()+",'"+i.getDireccion()+"',";
		if (i.isAmueblado())
			consulta += "yes,";
		else
			consulta += "no,";
		if (i.isPiscina())
			consulta += "yes,";
		else
			consulta += "no,";
		if (i.isAireAcondicionado())
			consulta += "yes,";
		else
			consulta += "no,";
		if (i.isConserje())
			consulta += "yes,";
		else
			consulta += "no,";
		if (i.isTrastero())
			consulta += "yes)";
		else
			consulta += "no)";
		Statement stat = conexion.createStatement();
		boolean insertada = stat.execute(consulta);
		if (!insertada)
			logger.debug("Insertado el inmueble "+i.getDMXX()+" en la tabla Viviendas.");
	}

	public void borrarBBDD() throws SQLException {
		String consultaBorrarTabla = "DELETE * FROM Viviendas";
		Statement stat = conexion.createStatement();		
		boolean borradaTabla = stat.execute(consultaBorrarTabla);
		if (!borradaTabla)
			logger.debug("Borrada la tabla Viviendas.");
	}
	
}
