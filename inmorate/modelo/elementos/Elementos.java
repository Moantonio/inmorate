package inmorate.modelo.elementos;

import static inmorate.modelo.constants.CONSTANTS.*;

import org.apache.log4j.Logger;

public class Elementos {
	private static Logger logger = Logger.getLogger(Elementos.class);
	private Elemento[] elementos = new Elemento[NUMERO_ELEMENTOS];
	
	public Elementos(){
		elementos[TIPO_INMUEBLE]          = new Elemento("Tipo Inmueble"     , TIPO_INMUEBLE);
		elementos[LUMINOSIDAD]            = new Elemento("Luminosidad"       , LUMINOSIDAD);
		elementos[ORIENTACION]            = new Elemento("Orientacion"       , ORIENTACION);
		elementos[REPRESENTATIVIDAD]      = new Elemento("Representatividad" , REPRESENTATIVIDAD);
		elementos[ESTADO_DEL_PORTAL]      = new Elemento("Estado del portal" , ESTADO_DEL_PORTAL);
		elementos[FACHADA]                = new Elemento("Fachada"           , FACHADA);
		elementos[VISTAS]                 = new Elemento("Vistas"            , VISTAS);
		elementos[NUMERO_HABITACIONES]    = new Elemento("Numero habitacione", NUMERO_HABITACIONES);
		elementos[NUMERO_BANOS]           = new Elemento("Numero banos"      , NUMERO_BANOS);
		elementos[ANTIGUEDAD]             = new Elemento("Antiguedad"        , ANTIGUEDAD);
		elementos[ALTURA]                 = new Elemento("Altura"            , ALTURA);
		elementos[ASCENSOR]               = new Elemento("Ascensor"          , ASCENSOR);
		elementos[GARAJE]                 = new Elemento("Garaje"            , GARAJE);
		elementos[ESTADO_GENERAL]         = new Elemento("Estado general"    , ESTADO_GENERAL);
		elementos[ZONAS_COMUNES]          = new Elemento("Zonas Comunes"     , ZONAS_COMUNES);
		elementos[ZONA_SUBZONA]           = new Elemento("Zona subzona"      , ZONA_SUBZONA);
		elementos[METROS_CONSTRUIDOS]     = new Elemento("Metros construidos", METROS_CONSTRUIDOS);
		elementos[METROS_HABITABLES]      = new Elemento("Metros habitables" , METROS_HABITABLES);
		elementos[PRECIO_TASACION]        = new Elemento("Precio tasacion"   , PRECIO_TASACION);
		elementos[PRECIO_SALIDA]          = new Elemento("Precio salida"     , PRECIO_SALIDA);
		elementos[PRECIO_VENTA]           = new Elemento("Precio venta"      , PRECIO_VENTA);
		
		logger.debug("Creado objeto de tipo Elementos.");
	}

	public Elemento[] getElementos() {
		return elementos;
	}

	public void setElementos(Elemento[] elementos) {
		this.elementos = elementos;
	}
}
