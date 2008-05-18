package inmorate.modelo.inmueble;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import inmorate.modelo.valoracion.Valoracion;
import static inmorate.modelo.constants.CONSTANTS.SEPARATOR;

public class InmuebleValorado {
	private static Logger logger = Logger.getLogger(InmuebleValorado.class);
	Inmueble inmueble;
	Valoracion[] valoraciones;
	Valoracion valoracionGeneral;
	Valoracion valoracionUsuario;
	Valoracion valoracionExperto;
	
	public InmuebleValorado(Inmueble inmueble, Valoracion[] valoraciones,
			Valoracion valoracionGeneral, Valoracion valoracionUsuario, Valoracion valoracionExperto) {
		super();
		this.inmueble = inmueble;
		this.valoraciones = valoraciones;
		this.valoracionGeneral = valoracionGeneral;
		this.valoracionUsuario = valoracionUsuario;
		this.valoracionExperto = valoracionUsuario;
		
		String datosDebug = "Datos: ";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + " ";
		logger.debug("Creado inmueble valorado. Clave: " + inmueble.getDMXX() + 
				" Valoracion General: " + valoracionGeneral.getValor() +
				" Valoracion Usuario: " + valoracionUsuario.getValor() +
				" Valoracion Experto: " + valoracionExperto.getValor() +
				" Datos: " + datosDebug); 
	}

	@Override
	public String toString() {
		String datosDebug = "Datos: ";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + " ";
		
		return "Inmueble con clave: " + inmueble.getDMXX() + 
				" Valoracion General: " + valoracionGeneral.getValor() +
				" Valoracion Usuario: " + valoracionUsuario.getValor() +
				" Valoracion Experto: " + valoracionExperto.getValor() +
				" Datos: " + datosDebug; 
	}
	
	public String toStringOnlyValues() {
		String datosDebug = "";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + SEPARATOR;
		
		return inmueble.getDMXX() + 
				SEPARATOR + valoracionGeneral.getValor() +
				SEPARATOR + valoracionUsuario.getValor() +
				SEPARATOR + valoracionExperto.getValor() +
				SEPARATOR + datosDebug; 
	}
	public String toStringOnlyValuesFuzzy() {
		String datosDebug = "";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].fuzzy().toString() + SEPARATOR;
		
		return inmueble.getDMXX() + 
				SEPARATOR + valoracionGeneral.fuzzy() +
				SEPARATOR + valoracionUsuario.fuzzy() +
				SEPARATOR + valoracionExperto.fuzzy() +
				SEPARATOR + datosDebug; 
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Valoracion[] getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Valoracion[] valoraciones) {
		this.valoraciones = valoraciones;
	}

	public Valoracion getValoracionGeneral() {
		return valoracionGeneral;
	}

	public void setValoracionGeneral(Valoracion valoracionGeneral) {
		this.valoracionGeneral = valoracionGeneral;
	}

	public Valoracion getValoracionUsuario() {
		return valoracionUsuario;
	}

	public void setValoracionUsuario(Valoracion valoracionUsuario) {
		this.valoracionUsuario = valoracionUsuario;
	}

	public Valoracion getValoracionExperto() {
		return valoracionExperto;
	}

	public void setValoracionExperto(Valoracion valoracionExperto) {
		this.valoracionExperto = valoracionExperto;
	}
	
	public static void toFile(String filename, InmuebleValorado[] inmueblesValorados){
		toFile(filename + "_fuzzy.csv", inmueblesValorados, true);
		toFile(filename + "_nofuzzy.csv", inmueblesValorados, false);
	}
	private static void toFile(String filename, InmuebleValorado[] inmueblesValorados, boolean fuzzy){
		String sFichero = filename;
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(sFichero));
			bw.write("CLAVE" + SEPARATOR);
			bw.write("Valoracion General" + SEPARATOR);
			bw.write("Valoracion Usuario" + SEPARATOR);
			bw.write("Valoracion Experto" + SEPARATOR);
			bw.write("TipoInmueble" + SEPARATOR);
			bw.write("Luminosidad" + SEPARATOR);
			bw.write("Orientacion" + SEPARATOR);
			bw.write("Representatividad" + SEPARATOR);
			bw.write("EstadoDelPortal" + SEPARATOR);
			bw.write("Fachada" + SEPARATOR);
			bw.write("Vistas" + SEPARATOR);
			bw.write("NumeroHabitaciones" + SEPARATOR);
			bw.write("numeroBanos" + SEPARATOR);
			bw.write("Antiguedad" + SEPARATOR);
			bw.write("Altura" + SEPARATOR);
			bw.write("Ascensor" + SEPARATOR);
			bw.write("Garaje" + SEPARATOR);
			bw.write("EstadoGeneral" + SEPARATOR);
			bw.write("ZonasComunes" + SEPARATOR);
			bw.write("ZonaSubzona" + SEPARATOR);
			bw.write("MetrosConstruidos" + SEPARATOR);
			bw.write("MetrosHabitables" + SEPARATOR);
			bw.write("PrecioTasacion" + SEPARATOR);
			bw.write("PrecioSalida" + SEPARATOR);
			bw.write("PrecioVenta\n");
			
			for (int i = 0; i < inmueblesValorados.length; i++){
				if (fuzzy)
					bw.write(inmueblesValorados[i].toStringOnlyValues());
				else
					bw.write(inmueblesValorados[i].toStringOnlyValuesFuzzy());
				bw.write("\n");
			}
			
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	

	
}
