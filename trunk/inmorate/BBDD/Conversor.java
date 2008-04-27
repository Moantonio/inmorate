package inmorate.BBDD;

import inmorate.model.Inmueble;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conversor {
	public static ArrayList<Inmueble> parseQuery(ResultSet query) throws SQLException {
		ArrayList<Inmueble> valores = new ArrayList<Inmueble>();
		while(query.next()) {
			// Crear el inmueble y meterlo a valores
			Inmueble inmueble = new Inmueble();
			inmueble.setDMXX(query.getString(1));
			inmueble.setTipoDeInmueble(query.getString(2));
			inmueble.setLuminosidad(query.getInt(3));
			inmueble.setOrientacion(query.getString(4));
			inmueble.setRepresentatividad(query.getInt(5));
			inmueble.setEstadoDelPortal(query.getInt(6));
			inmueble.setFachada(query.getInt(7));
			inmueble.setVistas(query.getInt(8));
			inmueble.setNumeroHabitaciones(query.getInt(9));
			inmueble.setNumeroBanos(query.getInt(10));
			inmueble.setAntiguedad(query.getInt(11));
			inmueble.setAltura(query.getInt(12));
			inmueble.setAscensor(query.getBoolean(13));
			inmueble.setPlazasGaraje(query.getInt(14));
			inmueble.setEstadoGeneral(query.getInt(15));
			inmueble.setZonasComunes(query.getBoolean(16));
			inmueble.setZona(query.getString(17));
			inmueble.setMetrosConstruidos(query.getInt(18));
			inmueble.setMetrosHabitables(query.getInt(19));
			inmueble.setPrecioTasacion(query.getInt(20));
			inmueble.setPrecioSalida(query.getInt(21));
			inmueble.setPrecioVenta(query.getInt(22));
			inmueble.setDireccion(query.getString(23));
			inmueble.setAmueblado(query.getBoolean(24));
			inmueble.setPiscina(query.getBoolean(25));
			inmueble.setAireAcondicionado(query.getBoolean(26));
			inmueble.setConserje(query.getBoolean(27));
			inmueble.setTrastero(query.getBoolean(28));
			valores.add(inmueble);
		}
		return valores;
	}
}
