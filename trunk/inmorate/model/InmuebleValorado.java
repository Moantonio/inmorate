package inmorate.model;

import org.apache.log4j.Logger;

import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.valoracion.Valoracion;
import inmorate.core.MotorInferencia;

public class InmuebleValorado {
	private static Logger logger = Logger.getLogger(InmuebleValorado.class);
	Inmueble inmueble;
	Valoracion[] valoraciones;
	Valoracion valoracionGeneral;
	
	public InmuebleValorado(Inmueble inmueble, Valoracion[] valoraciones,
			Valoracion valoracionGeneral) {
		super();
		this.inmueble = inmueble;
		this.valoraciones = valoraciones;
		this.valoracionGeneral = valoracionGeneral;
		
		String datosDebug = "Datos: ";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + " ";
		logger.debug("Creado inmueble valorado. Clave: " + inmueble.getDMXX() + 
				" Valoracion General: " + valoracionGeneral.getValor() +
				" Datos: " + datosDebug); 
	}

	@Override
	public String toString() {
		String datosDebug = "Datos: ";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + " ";
		
		return "Inmueble con clave: " + inmueble.getDMXX() + 
				" Valoracion General: " + valoracionGeneral.getValor() +
				" Datos: " + datosDebug; 
	}
	
	public String toStringOnlyValues() {
		String datosDebug = "";
		for (int i = 0; i < valoraciones.length; i++)
			datosDebug += valoraciones[i].getValor() + "\t";
		
		return inmueble.getDMXX() + 
				"\t" + valoracionGeneral.getValor() +
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

	

	

	
}
