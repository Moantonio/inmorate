package inmorate.core;

import org.apache.log4j.Logger;
import inmorate.controlador.elementos.Elemento;
import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.valoracion.Usuario;
import inmorate.init.Start;
import inmorate.xfuzzy.valoracionInmuebles;
import static inmorate.controlador.constants.CONSTANTS.*;

public class MotorInferencia {
	private static Logger logger = Logger.getLogger(MotorInferencia.class);
	Usuario usuario;

	public MotorInferencia(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	public Elementos computar(){
		logger.info("Computando...");
		
		Elementos elementos = usuario.getElementos();
		Elemento[] elemento = elementos.getElementos();
		
		double [] entrada = extraerDatos();		
		double[] salida = null;
		
		
		//aqui se llama al motor de inferencia del xfuzzy
		try{
			valoracionInmuebles fe = new valoracionInmuebles();
			salida = fe.crispInference(entrada);
		}
		catch(Exception e){
			logger.error("Se ha producido un error al ejecutar el motor de inferencia.", e);
			
		}
		
		
		
		
		for (int i = 0; i < salida.length; i++){
			System.out.println("\n Posicion " + i + " valor: " + salida[i]);
		}
//		
//		for (int i = 1; i < elementos.getElementos().length; i++){
//			//			Valoracion nuevaValoracion = new Valoracion( aqui poner lo que devuelva xfuzzy)
//			elemento[i].setComputado(true);
//			elemento[i].setValoracion(null); // valoracion sacada del motor de inferencia
//		}
//		
		
		return elementos;
	}
	
	private double[] extraerDatos(){
		double [] elementos = new double[NUMERO_ELEMENTOS];
		
		elementos[TIPO_INMUEBLE - 1]          = usuario.getImportanciaTipoInmueble().defuzzy();
		elementos[LUMINOSIDAD - 1]            = usuario.getImportanciaLuminosidad().defuzzy();
		elementos[ORIENTACION - 1]            = usuario.getImportanciaOrientacion().defuzzy();
		elementos[REPRESENTATIVIDAD - 1]      = usuario.getImportanciaRepresentatividad().defuzzy();
		elementos[ESTADO_DEL_PORTAL - 1]      = usuario.getImportanciaEstadoDelPortal().defuzzy();
		elementos[FACHADA - 1]                = usuario.getImportanciaFachada().defuzzy();
		elementos[VISTAS - 1]                 = usuario.getImportanciaVistas().defuzzy();
		elementos[NUMERO_HABITACIONES - 1]    = usuario.getImportanciaNumeroHabitaciones().defuzzy();
		elementos[NUMERO_BANOS - 1]           = usuario.getImportancianumeroBanos().defuzzy();
		elementos[ANTIGUEDAD - 1]             = usuario.getImportanciaAntiguedad().defuzzy();
		elementos[ALTURA - 1]                 = usuario.getImportanciaAltura().defuzzy();
		elementos[ASCENSOR - 1]               = usuario.getImportanciaAscensor().defuzzy();
		elementos[ESTADO_GENERAL - 1]         = usuario.getImportanciaEstadoGeneral().defuzzy();
		elementos[ZONAS_COMUNES - 1]          = usuario.getImportanciaZonasComunes().defuzzy();
		elementos[ZONA_SUBZONA - 1]           = usuario.getImportanciaZonaSubzona().defuzzy();
		elementos[METROS_CONSTRUIDOS - 1]     = usuario.getImportanciaMetrosConstruidos().defuzzy();
		elementos[METROS_HABITABLES - 1]      = usuario.getImportanciaMetrosHabitables().defuzzy();
		elementos[PRECIO_TASACION - 1]        = usuario.getImportanciaPrecioTasacion().defuzzy();
		elementos[PRECIO_SALIDA - 1]          = usuario.getImportanciaPrecioSalida().defuzzy();
		elementos[PRECIO_VENTA - 1]           = usuario.getImportanciaPrecioVenta().defuzzy();
		elementos[NUMERO_ELEMENTOS -1] = usuario.getSector().getId();
		return elementos;
	}
}
