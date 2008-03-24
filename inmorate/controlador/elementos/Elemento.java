package inmorate.controlador.elementos;

import inmorate.controlador.valoracion.Importancia;
import inmorate.controlador.valoracion.Valoracion;

public class Elemento {
	private final String nombre;
	private final int idElemento;
	private Importancia importancia;
	private boolean computado = false;
	private Valoracion valoracion;
	
	public Elemento(String nombre, int idElemento) {
		super();
		this.nombre = nombre;
		this.idElemento = idElemento;
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
	}

	public boolean isComputado() {
		return computado;
	}

	public void setComputado(boolean computado) {
		this.computado = computado;
	}

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}


	
	
	
}
