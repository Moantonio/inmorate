package inmorate.modelo.inmueble;

import static inmorate.modelo.constants.CONSTANTS.ALTURA;
import static inmorate.modelo.constants.CONSTANTS.ANTIGUEDAD;
import static inmorate.modelo.constants.CONSTANTS.ASCENSOR;
import static inmorate.modelo.constants.CONSTANTS.ESTADO_DEL_PORTAL;
import static inmorate.modelo.constants.CONSTANTS.ESTADO_GENERAL;
import static inmorate.modelo.constants.CONSTANTS.FACHADA;
import static inmorate.modelo.constants.CONSTANTS.GARAJE;
import static inmorate.modelo.constants.CONSTANTS.LUMINOSIDAD;
import static inmorate.modelo.constants.CONSTANTS.METROS_CONSTRUIDOS;
import static inmorate.modelo.constants.CONSTANTS.METROS_HABITABLES;
import static inmorate.modelo.constants.CONSTANTS.NUMERO_BANOS;
import static inmorate.modelo.constants.CONSTANTS.NUMERO_ELEMENTOS;
import static inmorate.modelo.constants.CONSTANTS.NUMERO_HABITACIONES;
import static inmorate.modelo.constants.CONSTANTS.ORIENTACION;
import static inmorate.modelo.constants.CONSTANTS.PRECIO_SALIDA;
import static inmorate.modelo.constants.CONSTANTS.PRECIO_TASACION;
import static inmorate.modelo.constants.CONSTANTS.PRECIO_VENTA;
import static inmorate.modelo.constants.CONSTANTS.REPRESENTATIVIDAD;
import static inmorate.modelo.constants.CONSTANTS.TIPO_INMUEBLE;
import static inmorate.modelo.constants.CONSTANTS.VISTAS;
import static inmorate.modelo.constants.CONSTANTS.ZONAS_COMUNES;
import static inmorate.modelo.constants.CONSTANTS.ZONA_SUBZONA;

import inmorate.modelo.constants.CONSTANTS.OrientacionEnum;

import java.util.Random;

import org.apache.log4j.Logger;

public class Inmueble {
	private static Logger logger = Logger.getLogger(Inmueble.class);
	
	private String DMXX;
	private String tipoDeInmueble;
	private int luminosidad;
	private OrientacionEnum orientacion;
	private int representatividad;
	private int estadoDelPortal;
	private int fachada;
	private int vistas;
	private int numeroHabitaciones;
	private int numeroBanos;
	private int antiguedad;
	private int altura;
	private boolean ascensor;
	private int garaje;
	private int estadoGeneral;
	private boolean zonasComunes;
	private String zona;
	private int metros_construidos;
	private int metrosHabitables;
	private int precioTasacion;
	private int precioSalida;
	private int precioVenta;
	private String direccion;
	private boolean amueblado;
	private boolean piscina;
	private boolean aireAcondicionado;
	private boolean conserje;
	private boolean trastero;
	
	public Inmueble() {
	}

	public Inmueble(String dmxx, String tipoDeInmueble, int luminosidad, OrientacionEnum orientacion, int representatividad, int estadoDelPortal, int fachada, int vistas, int numDormitorios, int numAseos, int antiguedad, int planta, boolean ascensor, int plazasGaraje, int estadoGeneral, boolean zonasComunes, String zona, int metrosConstruidos, int metrosHabitables, int precioTasacion, int precioSalida, int precioVenta, String direccion, boolean amueblado, boolean piscina, boolean aireAcondicionado, boolean conserje, boolean trastero) {
		this.DMXX = dmxx;
		this.tipoDeInmueble = tipoDeInmueble;
		this.luminosidad = luminosidad;
		this.orientacion = orientacion;
		this.representatividad = representatividad;
		this.estadoDelPortal = estadoDelPortal;
		this.fachada = fachada;
		this.vistas = vistas;
		this.numeroHabitaciones = numDormitorios;
		this.numeroBanos = numAseos;
		this.antiguedad = antiguedad;
		this.altura = planta;
		this.ascensor = ascensor;
		this.garaje = plazasGaraje;
		this.estadoGeneral = estadoGeneral;
		this.zonasComunes = zonasComunes;
		this.zona = zona;
		this.metros_construidos = metrosConstruidos;
		this.metrosHabitables = metrosHabitables;
		this.precioTasacion = precioTasacion;
		this.precioSalida = precioSalida;
		this.precioVenta = precioVenta;
		this.direccion = direccion;
		this.amueblado = amueblado;
		this.piscina = piscina;
		this.aireAcondicionado = aireAcondicionado;
		this.conserje = conserje;
		this.trastero = trastero;
		
		logger.debug("Creado inmueble con valores: " +
				" DMXX: " + DMXX +
				" tipoDeInmueble: " + tipoDeInmueble +
				" luminosidad: " + luminosidad +
				" orientacion: " + orientacion +
				" representatividad: " + representatividad +
				" estadoDelPortal: " + estadoDelPortal +
				" fachada: " + fachada +
				" vistas: " + vistas +
				" numDormitorios: " + numDormitorios +
				" numAseos: " + numAseos +
				" antiguedad: " + antiguedad +
				" planta: " + planta +
				" ascensor: " + Boolean.toString(ascensor) +
				" plazasGaraje: " + plazasGaraje +
				" estadoGeneral: " + estadoGeneral +
				" zonasComunes: " + zonasComunes +
				" zona: " + zona +
				" metrosConstruidos: " + metrosConstruidos +
				" metrosHabitables: " + metrosHabitables +
				" precioTasacion: " + precioTasacion +
				" precioSalida: " + precioSalida +
				" precioVenta: " + precioVenta +
				" direccion: " + direccion +
				" amueblado: " + amueblado +
				" piscina: " + piscina +
				" aireAcondicionado: " + aireAcondicionado +
				" conserje: " + conserje +
				" trastero: " + trastero );
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	public boolean isConserje() {
		return conserje;
	}

	public void setConserje(boolean conserje) {
		this.conserje = conserje;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDMXX() {
		return DMXX;
	}

	public void setDMXX(String dmxx) {
		DMXX = dmxx;
	}

	public int getEstadoDelPortal() {
		return estadoDelPortal;
	}

	public void setEstadoDelPortal(int estadoDelPortal) {
		this.estadoDelPortal = estadoDelPortal;
	}

	public int getEstadoGeneral() {
		return estadoGeneral;
	}

	public void setEstadoGeneral(int estadoGeneral) {
		this.estadoGeneral = estadoGeneral;
	}

	public int getFachada() {
		return fachada;
	}

	public void setFachada(int fachada) {
		this.fachada = fachada;
	}

	public int getLuminosidad() {
		return luminosidad;
	}

	public void setLuminosidad(int luminosidad) {
		this.luminosidad = luminosidad;
	}

	public int getMetrosConstruidos() {
		return metros_construidos;
	}

	public void setMetrosConstruidos(int metrosConstruidos) {
		this.metros_construidos = metrosConstruidos;
	}

	public int getMetrosHabitables() {
		return metrosHabitables;
	}

	public void setMetrosHabitables(int metrosHabitables) {
		this.metrosHabitables = metrosHabitables;
	}

	public int getNumeroBanos() {
		return numeroBanos;
	}

	public void setNumeroBanos(int numAseos) {
		this.numeroBanos = numAseos;
	}

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numDormitorios) {
		this.numeroHabitaciones = numDormitorios;
	}

	public String getOrientacionAsString() {
		return orientacion.toString();
	}

	public OrientacionEnum getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(OrientacionEnum orientacion) {
		this.orientacion = orientacion;
	}

	public int getGaraje() {
		return garaje;
	}

	public void setGaraje(int garaje) {
		this.garaje = garaje;
	}

	public int getMetros_construidos() {
		return metros_construidos;
	}

	public void setMetros_construidos(int metros_construidos) {
		this.metros_construidos = metros_construidos;
	}

	public void setOrientacion(String orientacion) {
		if (orientacion.compareToIgnoreCase("norte")==0)
			this.orientacion = OrientacionEnum.NORTE;
		else if (orientacion.compareToIgnoreCase("sur")==0)
			this.orientacion = OrientacionEnum.SUR;
		else if (orientacion.compareToIgnoreCase("este")==0)
			this.orientacion = OrientacionEnum.ESTE;
		else if (orientacion.compareToIgnoreCase("oeste")==0)
			this.orientacion = OrientacionEnum.OESTE;
		else if (orientacion.compareToIgnoreCase("noreste")==0)
			this.orientacion = OrientacionEnum.NORESTE;
		else if (orientacion.compareToIgnoreCase("noroeste")==0)
			this.orientacion = OrientacionEnum.NOROESTE;
		else if (orientacion.compareToIgnoreCase("sureste")==0)
			this.orientacion = OrientacionEnum.SURESTE;
		else if (orientacion.compareToIgnoreCase("suroeste")==0)
			this.orientacion = OrientacionEnum.SUROESTE;

	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPlazasGaraje() {
		return garaje;
	}

	public void setPlazasGaraje(int plazasGaraje) {
		this.garaje = plazasGaraje;
	}

	public int getPrecioSalida() {
		return precioSalida;
	}

	public void setPrecioSalida(int precioSalida) {
		this.precioSalida = precioSalida;
	}

	public int getPrecioTasacion() {
		return precioTasacion;
	}

	public void setPrecioTasacion(int precioTasacion) {
		this.precioTasacion = precioTasacion;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getRepresentatividad() {
		return representatividad;
	}

	public void setRepresentatividad(int representatividad) {
		this.representatividad = representatividad;
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}

	public void setTipoDeInmueble(String tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}

	public boolean isTrastero() {
		return trastero;
	}

	public void setTrastero(boolean trastero) {
		this.trastero = trastero;
	}

	public int getVistas() {
		return vistas;
	}

	public void setVistas(int vistas) {
		this.vistas = vistas;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public boolean isZonasComunes() {
		return zonasComunes;
	}

	public void setZonasComunes(boolean zonasComunes) {
		this.zonasComunes = zonasComunes;
	}

	public void crearInmueble(int valor) {
		// Identificador
		if (valor<10) 
			this.DMXX = "DM0000"+valor;
		else if (valor<100)
			this.DMXX = "DM000"+valor;
		else
			this.DMXX = "DM00"+valor;
		// Tipo de Inmueble
		Random rnd = new Random();
		switch(rnd.nextInt(6)) {
		case 0: this.tipoDeInmueble = "Piso"; 
			break;
		case 1: this.tipoDeInmueble = "Adosado"; 
			break;
		case 2: this.tipoDeInmueble = "Pareado"; 
			break;
		case 3: this.tipoDeInmueble = "Independiente"; 
			break;
		case 4: this.tipoDeInmueble = "Estudio"; 
			break;
		case 5: this.tipoDeInmueble = "Apartamento"; 
			break;
		}
		// Luminosidad
		this.luminosidad = rnd.nextInt(10)+1;
		// Orientacion
		switch(rnd.nextInt(8)) {
		case 0: this.orientacion = OrientacionEnum.NORTE;;
			break;			
		case 1: this.orientacion = OrientacionEnum.SUR;
			break;
		case 2: this.orientacion = OrientacionEnum.ESTE;
			break;
		case 3: this.orientacion = OrientacionEnum.OESTE;
			break;
		case 4: this.orientacion = OrientacionEnum.NORESTE;
			break;
		case 5: this.orientacion = OrientacionEnum.NOROESTE;
			break;
		case 6: this.orientacion = OrientacionEnum.SURESTE;
			break;
		case 7: this.orientacion = OrientacionEnum.SUROESTE;
			break;
		}
		this.representatividad = rnd.nextInt(11);
		this.estadoDelPortal = rnd.nextInt(11);
		this.fachada = rnd.nextInt(11);
		this.vistas = rnd.nextInt(11);
		this.numeroHabitaciones = rnd.nextInt(5)+1;
		this.numeroBanos = rnd.nextInt(3)+1;
		this.antiguedad = rnd.nextInt(20);
		this.altura = rnd.nextInt(10)+1;
		// Ascensor
		switch(rnd.nextInt(2)) {
		case 0: this.ascensor = false;
			break;
		case 1: this.ascensor = true;
			break;
		}		
		this.garaje = rnd.nextInt(3);
		this.estadoGeneral = rnd.nextInt(11);
		// Zonas Comunes
		switch(rnd.nextInt(2)) {
		case 0: this.zonasComunes = false;
			break;
		case 1: this.zonasComunes = true;
			break;
		}	
		// Zona / Subzona
		switch(rnd.nextInt(22)) {
		case 0:
			this.zona = "Centro";
			break;
		case 1:
			this.zona = "Chamberi";
			break;
		case 2:
			this.zona = "Moncloa";
			break;
		case 3:
			this.zona = "Retiro";
			break;
		case 4:
			this.zona = "Salamanca";
			break;
		case 5:
			this.zona = "Tetuan";
			break;
		case 6:
			this.zona = "Pasillo Verde";
			break;
		case 7:
			this.zona = "Dehesa de la Villa";
			break;
		case 8:
			this.zona = "Carabanchel";
			break;
		case 9:
			this.zona = "Aluche";
			break;
		case 10:
			this.zona = "Chamartin";
			break;
		case 11:
			this.zona = "Prosperidad";
			break;
		case 12:
			this.zona = "Canillejas";
			break;
		case 13:
			this.zona = "Puerta del Angel";
			break;
		case 14:
			this.zona = "Arturo Soria";
			break;
		case 15:
			this.zona = "Conde Orgaz";
			break;
		case 16:
			this.zona = "Paseo de Extremadura";
			break;
		case 17:
			this.zona = "Pacifico";
			break;
		case 18:
			this.zona = "Avenida de la Ilustracion";
			break;
		case 19:
			this.zona = "Campamento";
			break;
		case 20:
			this.zona = "Hortaleza";
			break;
		case 21:
			this.zona = "Mendez Alvaro";
			break;
		}
		// Metros Contruidos y Habitables
		this.metrosHabitables = 70+rnd.nextInt(150);
		this.metros_construidos = this.metrosHabitables+10+rnd.nextInt(20);
		this.precioTasacion = this.metrosHabitables*1000;
		this.precioSalida = (int) Math.round(this.metros_construidos*1000*1.16);
		this.precioVenta = 0;
		switch(rnd.nextInt(9)) {
		case 0:
			this.direccion = "C/ Alcala, "+valor;
			break;
		case 1:
			this.direccion = "C/ Quintana, "+valor;
			break;
		case 2:
			this.direccion = "C/ Fernandez, "+valor;
			break;
		case 3:
			this.direccion = "C/ Ladera, "+valor;
			break;
		case 4:
			this.direccion = "C/ Machado, "+valor;
			break;
		case 5:
			this.direccion = "C/ Gaztambide, "+valor;
			break;
		case 6:
			this.direccion = "C/ Canton, "+valor;
			break;
		case 7:
			this.direccion = "C/ Arroyo, "+valor;
			break;
		case 8:
			this.direccion = "C/ Tren, "+valor;
			break;
		}
		switch(rnd.nextInt(2)) {
		case 0: this.amueblado = false;
			break;
		case 1: this.amueblado = true;
			break;
		}
		switch(rnd.nextInt(2)) {
		case 0: this.piscina = false;
			break;
		case 1: this.piscina = true;
			break;
		}
		switch(rnd.nextInt(2)) {
		case 0: this.aireAcondicionado = false;
			break;
		case 1: this.aireAcondicionado = true;
			break;
		}
		switch(rnd.nextInt(2)) {
		case 0: this.conserje = false;
			break;
		case 1: this.conserje = true;
			break;
		}
		switch(rnd.nextInt(2)) {
		case 0: this.trastero = false;
			break;
		case 1: this.trastero = true;
			break;
		}
	}

	public double[] extraerDatos(){
		double [] elementos = new double[NUMERO_ELEMENTOS];
		
		elementos[TIPO_INMUEBLE - 1]          = defuzzyTipoInmueble();
		elementos[LUMINOSIDAD - 1]            = getLuminosidad();
		elementos[ORIENTACION - 1]            = defuzzyOrientacion();
		elementos[REPRESENTATIVIDAD - 1]      = getRepresentatividad();
		elementos[ESTADO_DEL_PORTAL - 1]      = getEstadoDelPortal();
		elementos[FACHADA - 1]                = getFachada();
		elementos[VISTAS - 1]                 = getVistas();
		elementos[NUMERO_HABITACIONES - 1]    = getNumeroHabitaciones();
		elementos[NUMERO_BANOS - 1]           = getNumeroBanos();
		elementos[ANTIGUEDAD - 1]             = getAntiguedad();
		elementos[ALTURA - 1]                 = getAltura();
		elementos[ASCENSOR - 1]               = defuzzyAscensor();
		elementos[GARAJE - 1]                 = defuzzyAscensor();
		elementos[ESTADO_GENERAL - 1]         = getEstadoGeneral();
		elementos[ZONAS_COMUNES - 1]          = defuzzyZonasComunes();
		elementos[ZONA_SUBZONA - 1]           = defuzzyZonaSubzona();
		elementos[METROS_CONSTRUIDOS - 1]     = getMetrosConstruidos();
		elementos[METROS_HABITABLES - 1]      = getMetrosHabitables();
		elementos[PRECIO_TASACION - 1]        = getPrecioTasacion();
		elementos[PRECIO_SALIDA - 1]          = getPrecioSalida();
		elementos[PRECIO_VENTA - 1]           = getPrecioVenta();
		return elementos;
	}
	
	public double defuzzyTipoInmueble(){
		if (tipoDeInmueble.compareToIgnoreCase("piso")==0)
			return 1.0;
		else if(tipoDeInmueble.compareToIgnoreCase("adosado")==0)
			return 2.0;
		else if(tipoDeInmueble.compareToIgnoreCase("pareado")==0)
			return 3.0;
		else if(tipoDeInmueble.compareToIgnoreCase("independiente")==0)
			return 4.0;
		else if(tipoDeInmueble.compareToIgnoreCase("estudio")==0)
			return 5.0;
		else if(tipoDeInmueble.compareToIgnoreCase("apartamento")==0)
			return 6.0;
		return 1.0;
	}
	public double defuzzyOrientacion(){
		switch (orientacion){
		case NORTE: return 1.0;	
		case SUR: return 2.0;	
		case ESTE: return 3.0;	
		case OESTE: return 4.0;	
		case NORESTE: return 5.0;		
		case NOROESTE: return 6.0;		
		case SURESTE: return 7.0;		
		case SUROESTE: return 8.0;		
		default: return 1.0;
		
		}
	}
	public double defuzzyAscensor(){
		return ascensor ? 1.0 : 0.0;
	}
	public double defuzzyZonasComunes(){
		return zonasComunes ? 1.0 : 0.0;
	}
	
	public double defuzzyZonaSubzona(){
		return 5.0;
	}
	
}