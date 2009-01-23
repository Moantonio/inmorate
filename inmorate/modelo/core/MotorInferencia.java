package inmorate.modelo.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import inmorate.controlador.Controlador;
import inmorate.modelo.valoracion.Usuario;
import inmorate.modelo.valoracion.Valoracion;
import inmorate.modelo.inmueble.Inmueble;
import inmorate.modelo.inmueble.InmuebleValorado;
import inmorate.modelo.xfuzzy.valoracionInmuebles;
import static inmorate.modelo.constants.CONSTANTS.*;

public class MotorInferencia {
	private static Logger logger = Logger.getLogger(MotorInferencia.class);
	private Usuario usuario;
	private Usuario experto;
	private Inmueble[] inmuebles;
	private InmuebleValorado[] inmueblesValorados;
	private Controlador controlador;
	
	public MotorInferencia(Usuario usuario, Usuario experto, Inmueble[] inmuebles, Controlador c) {
		super();
		this.controlador = c;
		this.usuario = usuario;
		this.experto = experto;
		this.inmuebles = inmuebles;
	}
	
	private void filtrarInmuebles(){
		logger.debug("Filtrando inmuebles con precio superior a: " + usuario.getPrecioMaximo());
		List<Inmueble> nuevosInmuebles = new ArrayList<Inmueble>();
		if (usuario.isLimiteEconomico() ){
			for (int i = 0; i < inmuebles.length; i++){
				if(inmuebles[i].getPrecioSalida() < usuario.getPrecioMaximo()){
					nuevosInmuebles.add(inmuebles[i]);
				}
				else{
					logger.debug("El inmueble con Id: "+ inmuebles[i].getDMXX()
							+ " y precio: "+ inmuebles[i].getPrecioTasacion()
							+ " se elimina.");
				}
			}
		}
		Inmueble[] tmp = nuevosInmuebles.toArray(new Inmueble[nuevosInmuebles.size()]);
		this.inmuebles = tmp;
	}
	public InmuebleValorado[] computar(){
		logger.info("Computando...");
		
		if (usuario.isLimiteEconomico()){
			filtrarInmuebles();
		}
		
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
				valoraciones[i1] = new Valoracion(salida[i1]);
				
			}
			Valoracion valoracionUsuario = new Valoracion(calculaValoracionUsuario(salida));
			Valoracion valoracionExperto = new Valoracion(calculaValoracionExperto(salida));
			Valoracion valoracionGeneral = new Valoracion(calculaValoracionGeneral(valoracionUsuario, valoracionExperto));
			inmueblesValoradosTmp[i] = new InmuebleValorado(inmuebles[i], valoraciones, valoracionGeneral, valoracionUsuario, valoracionExperto );

			controlador.escribirPanel("     ====================    " + inmuebles[i].getDMXX() + "    ====================\n\n");
			controlador.escribirPanel("\tValoraci�n General: "+valoracionGeneral.getValor()+"\n");
			controlador.escribirPanel("\tValoraci�n Usuario: "+valoracionUsuario.getValor()+"\n");
			controlador.escribirPanel("\tValoraci�n Experto: "+valoracionExperto.getValor()+"\n\n");
			
		}
		inmueblesValorados = inmueblesValoradosTmp;
		return inmueblesValorados;
	}
	
	private double[] extraerImportancias(Usuario usuario){
		double [] elementos = new double[NUMERO_ELEMENTOS - 1];
		
		elementos[TIPO_INMUEBLE - 1]          = usuario.getImportanciaTipoInmueble().defuzzy();
		elementos[LUMINOSIDAD - 1]            = usuario.getImportanciaLuminosidad().defuzzy();
		elementos[ORIENTACION - 1]            = usuario.getImportanciaOrientacion().defuzzy();
		elementos[REPRESENTATIVIDAD - 1]      = usuario.getImportanciaRepresentatividad().defuzzy();
		elementos[ESTADO_DEL_PORTAL - 1]      = usuario.getImportanciaEstadoDelPortal().defuzzy();
		elementos[FACHADA - 1]                = usuario.getImportanciaFachada().defuzzy();
		elementos[VISTAS - 1]                 = usuario.getImportanciaVistas().defuzzy();
		elementos[NUMERO_HABITACIONES - 1]    = usuario.getImportanciaNumeroHabitaciones().defuzzy();
		elementos[NUMERO_BANOS - 1]           = usuario.getImportanciaNumeroBanos().defuzzy();
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
	
	private double calculaValoracionUsuario(double[] valoraciones){
		double[] importancias = extraerImportancias(usuario);
		double valoracion = 0;
		
		//Sumamos todas las importancias
		double sumaImportancias = 0;
		double sumaMaxima = 10*importancias.length;
		for (int i = 0; i < importancias.length; i++)
			sumaImportancias += importancias[i];
		
		
		for (int i = 0; i < valoraciones.length - 1; i++){ //Es menos 1 porque el ultimo elemento es para indicar el perfil
			valoracion += (valoraciones[i] * importancias[i])/10;
		}
		valoracion /= valoraciones.length;
		valoracion *= sumaMaxima / sumaImportancias;
		if (disperseMode){
			valoracion = disperse(valoracion);
		}
		return valoracion;
		
	}
	private double calculaValoracionExperto(double[] valoraciones){
		double[] importancias = extraerImportancias(experto);
		double valoracion = 0;
		
		//Sumamos todas las importancias
		double sumaImportancias = 0;
		double sumaMaxima = 10*importancias.length;
		for (int i = 0; i < importancias.length; i++)
			sumaImportancias += importancias[i];
		
		
		for (int i = 0; i < valoraciones.length - 1; i++){ //Es menos 1 porque el ultimo elemento es para indicar el perfil
			valoracion += (valoraciones[i] * importancias[i])/10;
		}
		valoracion /= valoraciones.length;
		valoracion *= sumaMaxima / sumaImportancias;
		if (disperseMode){
			valoracion = disperse(valoracion);
		}
		return valoracion;		
	}
	private double calculaValoracionGeneral(Valoracion valoracionUsuario, Valoracion valoracionExperto){
		return (valoracionUsuario.getValor() + valoracionExperto.getValor()) / 2;
	}
	
	private double disperse(double valor) {
		double media = 0;
		double mediaAlza = valor + valor * adjustFactor;
		double mediaBaja = valor - valor * adjustFactor;

		if (mediaAlza > 10)
			mediaAlza = 10;
		if (mediaBaja < 0)
			mediaBaja =0;
		
		if (valor > 5) {
			media = mediaAlza;
		} else if (valor < 5) {
			media = mediaBaja;
		}
		return media;
	}	
	
	
	
	
}