package inmorate.controlador.valoracion;

public class IdentificadorValoracion {

	private String identificador;
	
	private double valoracion;
	
	private int posicion;

	public IdentificadorValoracion() {
		identificador = "";
		valoracion = 0.0;
		posicion = 0;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
}
