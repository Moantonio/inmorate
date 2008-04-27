package inmorate.controlador.elementos;

import org.apache.log4j.Logger;

import inmorate.controlador.valoracion.Importancia;
import inmorate.controlador.valoracion.Valoracion;

public class Elemento {
	private static Logger logger = Logger.getLogger(Elemento.class);
	
	private final String nombre;
	private final int idElemento;
	private Importancia importancia;
	
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






	
	
	
}
