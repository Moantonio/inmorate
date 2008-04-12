package inmorate.model;

import org.apache.log4j.Logger;

public class Inmueble {
	private static Logger logger = Logger.getLogger(Inmueble.class);
	
	private String DMXX;
	private String tipoDeInmueble;
	private int luminosidad;
	private String orientacion;
	private int representatividad;
	private String estadoDelPortal;
	private int fachada;
	private int vistas;
	private int numDormitorios;
	private int numAseos;
	private int antiguedad;
	private int planta;
	private boolean ascensor;
	private int plazasGaraje;
	private String estadoGeneral;
	private boolean zonasComunes;
	private String zona;
	private int metrosConstruidos;
	private int metrosHabitables;
	private String precioTasacion;
	private String precioSalida;
	private String precioVenta;
	private String direccion;
	private boolean amueblado;
	private boolean piscina;
	private boolean aireAcondicionado;
	private boolean conserje;
	private boolean trastero;
	
	public Inmueble() {
	}

	public Inmueble(String dmxx, String tipoDeInmueble, int luminosidad, String orientacion, int representatividad, String estadoDelPortal, int fachada, int vistas, int numDormitorios, int numAseos, int antiguedad, int planta, boolean ascensor, int plazasGaraje, String estadoGeneral, boolean zonasComunes, String zona, int metrosConstruidos, int metrosHabitables, String precioTasacion, String precioSalida, String precioVenta, String direccion, boolean amueblado, boolean piscina, boolean aireAcondicionado, boolean conserje, boolean trastero) {
		this.DMXX = dmxx;
		this.tipoDeInmueble = tipoDeInmueble;
		this.luminosidad = luminosidad;
		this.orientacion = orientacion;
		this.representatividad = representatividad;
		this.estadoDelPortal = estadoDelPortal;
		this.fachada = fachada;
		this.vistas = vistas;
		this.numDormitorios = numDormitorios;
		this.numAseos = numAseos;
		this.antiguedad = antiguedad;
		this.planta = planta;
		this.ascensor = ascensor;
		this.plazasGaraje = plazasGaraje;
		this.estadoGeneral = estadoGeneral;
		this.zonasComunes = zonasComunes;
		this.zona = zona;
		this.metrosConstruidos = metrosConstruidos;
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

	public String getEstadoDelPortal() {
		return estadoDelPortal;
	}

	public void setEstadoDelPortal(String estadoDelPortal) {
		this.estadoDelPortal = estadoDelPortal;
	}

	public String getEstadoGeneral() {
		return estadoGeneral;
	}

	public void setEstadoGeneral(String estadoGeneral) {
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
		return metrosConstruidos;
	}

	public void setMetrosConstruidos(int metrosConstruidos) {
		this.metrosConstruidos = metrosConstruidos;
	}

	public int getMetrosHabitables() {
		return metrosHabitables;
	}

	public void setMetrosHabitables(int metrosHabitables) {
		this.metrosHabitables = metrosHabitables;
	}

	public int getNumAseos() {
		return numAseos;
	}

	public void setNumAseos(int numAseos) {
		this.numAseos = numAseos;
	}

	public int getNumDormitorios() {
		return numDormitorios;
	}

	public void setNumDormitorios(int numDormitorios) {
		this.numDormitorios = numDormitorios;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getPlazasGaraje() {
		return plazasGaraje;
	}

	public void setPlazasGaraje(int plazasGaraje) {
		this.plazasGaraje = plazasGaraje;
	}

	public String getPrecioSalida() {
		return precioSalida;
	}

	public void setPrecioSalida(String precioSalida) {
		this.precioSalida = precioSalida;
	}

	public String getPrecioTasacion() {
		return precioTasacion;
	}

	public void setPrecioTasacion(String precioTasacion) {
		this.precioTasacion = precioTasacion;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
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


	
}