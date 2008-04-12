package inmorate.controlador.elementos;

import org.apache.log4j.Logger;

import inmorate.controlador.valoracion.Importancia;
import inmorate.controlador.valoracion.Valoracion;

public class Elemento {
	private static Logger logger = Logger.getLogger(Elemento.class);
	
	private final String nombre;
	private final int idElemento;
	private Importancia importancia;
	private boolean computado = false;
	private Valoracion valoracion;
	
	public Elemento(String nombre, int idElemento) {
		super();
		this.nombre = nombre;
		this.idElemento = idElemento;
		logger.debug("Creado elemento \"" + nombre + "\" con id: " + idElemento);
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getIdElemento() {
		return idElemento;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
//		logger.debug("Actualizada la importancia del elemento \"" + nombre + "\" a: " + importancia);
	}

	public boolean isComputado() {
		return computado;
	}

	public void setComputado(boolean computado) {
		this.computado = computado;
		logger.debug("Actualizado el valor computado del elemento \"" + nombre + "\" a: " +  Boolean.toString(computado) ); 
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
		logger.debug("Actualizada la valoracion del elemento \"" + nombre + "\" a: " + valoracion);
	}


	
	
	
}
