package inmorate.core;

import inmorate.controlador.elementos.Elemento;
import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.valoracion.Usuario;

public class MotorInferencia {
	Usuario usuario;

	public MotorInferencia(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	public Elementos Computar(){
		Elementos elementos = usuario.getElementos();
		Elemento[] elemento = elementos.getElementos();
		//aqui se llama al motor de inferencia del xfuzzy
		
		for (int i = 1; i < elementos.getElementos().length; i++){
			//			Valoracion nuevaValoracion = new Valoracion( aqui poner lo que devuelva xfuzzy)
			elemento[i].setComputado(true);
			elemento[i].setValoracion(null); // valoracion sacada del motor de inferencia
		}
		
		
		return elementos;
	}
	
}
