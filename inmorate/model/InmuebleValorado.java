package inmorate.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.valoracion.Valoracion;
import inmorate.core.MotorInferencia;

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
			datosDebug += valoraciones[i].getValor() + "\t";
		
		return inmueble.getDMXX() + 
				"\t" + valoracionGeneral.getValor() +
				"\t" + valoracionUsuario.getValor() +
				"\t" + valoracionExperto.getValor() +
				"\t" + datosDebug; 
	}
	public String toStringOnlyValuesFuzzy() {
		String datosDebug = "";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].fuzzy().toString() + "\t";
		
		return inmueble.getDMXX() + 
				"\t" + valoracionGeneral.getValor() +
				"\t" + datosDebug; 
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
			bw.write("CLAVE\t");
			bw.write("Valoracion General\t");
			bw.write("Valoracion Usuario\t");
			bw.write("Valoracion Experto\t");
			bw.write("TipoInmueble\t");
			bw.write("Luminosidad\t");
			bw.write("Orientacion\t");
			bw.write("Representatividad\t");
			bw.write("EstadoDelPortal\t");
			bw.write("Fachada\t");
			bw.write("Vistas\t");
			bw.write("NumeroHabitaciones\t");
			bw.write("numeroBanos\t");
			bw.write("Antiguedad\t");
			bw.write("Altura\t");
			bw.write("Ascensor\t");
			bw.write("Garaje\t");
			bw.write("EstadoGeneral\t");
			bw.write("ZonasComunes\t");
			bw.write("ZonaSubzona\t");
			bw.write("MetrosConstruidos\t");
			bw.write("MetrosHabitables\t");
			bw.write("PrecioTasacion\t");
			bw.write("PrecioSalida\t");
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
