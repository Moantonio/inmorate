package inmorate.core;

import org.apache.log4j.Logger;
import inmorate.controlador.elementos.Elemento;
import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.valoracion.Usuario;
import inmorate.controlador.valoracion.Valoracion;
import inmorate.init.Start;
import inmorate.model.Inmueble;
import inmorate.model.InmuebleValorado;
import inmorate.xfuzzy.valoracionInmuebles;
import static inmorate.controlador.constants.CONSTANTS.*;

public class MotorInferencia {
	private static Logger logger = Logger.getLogger(MotorInferencia.class);
	private Usuario usuario;
	private Inmueble[] inmuebles;
	private InmuebleValorado[] inmueblesValorados;
	
	public MotorInferencia(Usuario usuario, Inmueble[] inmuebles ) {
		super();
		this.usuario = usuario;
		this.inmuebles = inmuebles;
	}
	
	public InmuebleValorado[] computar(){
		logger.info("Computando...");
		InmuebleValorado[] inmueblesValoradosTmp = new InmuebleValorado[inmuebles.length];
		
		for (int i = 0; i < inmuebles.length; i++){
			double [] entrada = inmuebles[i].extraerDatos();	
			entrada[NUMERO_ELEMENTOS -1] = usuario.getSector().getId();
		
			double[] salida = null;
			//aqui se llama al motor de inferencia del xfuzzy
			logger.debug("Invocando al motor de inferencia");
			try{
				valoracionInmuebles fe = new valoracionInmuebles();
				salida = fe.crispInference(entrada);
			}
			catch(Exception e){
				logger.error("Se ha producido un error al ejecutar el motor de inferencia.", e);

			}
			logger.debug("Inmueble computado en X-Fuzzy");
			
			Valoracion[] valoraciones = new Valoracion[salida.length];
			
			for (int i1 = 0; i1 < salida.length; i1++){
				valoraciones[i1] = new Valoracion( salida[i1]);
				
			}
			Valoracion valoracionGeneral = new Valoracion(calculaValoracionGeneral(salida));
			inmueblesValoradosTmp[i] = new InmuebleValorado(inmuebles[i], valoraciones, valoracionGeneral);
		}
		inmueblesValorados = inmueblesValoradosTmp;
		return inmueblesValoradosTmp;
	}
	
	private double[] extraerImportancias(){
		double [] elementos = new double[NUMERO_ELEMENTOS - 1];
		
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
		elementos[GARAJE - 1]                 = usuario.getImportanciaGaraje().defuzzy();
		elementos[ESTADO_GENERAL - 1]         = usuario.getImportanciaEstadoGeneral().defuzzy();
		elementos[ZONAS_COMUNES - 1]          = usuario.getImportanciaZonasComunes().defuzzy();
		elementos[ZONA_SUBZONA - 1]           = usuario.getImportanciaZonaSubzona().defuzzy();
		elementos[METROS_CONSTRUIDOS - 1]     = usuario.getImportanciaMetrosConstruidos().defuzzy();
		elementos[METROS_HABITABLES - 1]      = usuario.getImportanciaMetrosHabitables().defuzzy();
		elementos[PRECIO_TASACION - 1]        = usuario.getImportanciaPrecioTasacion().defuzzy();
		elementos[PRECIO_SALIDA - 1]          = usuario.getImportanciaPrecioSalida().defuzzy();
		elementos[PRECIO_VENTA - 1]           = usuario.getImportanciaPrecioVenta().defuzzy();
		return elementos;
	}
	
	private double calculaValoracionGeneral(double[] valoraciones){
		double[] importancias = extraerImportancias();
		double valoracion = 0;
		for (int i = 0; i < valoraciones.length - 1; i++){ //Es menos 1 porque el ultimo elemento es para indicar el perfil
			valoracion += (valoraciones[i] * importancias[i])/10;
		}
		valoracion /= valoraciones.length;
		valoracion *= 1.8;
		return valoracion;
		
	}
	
}
