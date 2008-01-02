package inmorate.dao;

import inmorate.model.Inmueble;

import java.util.HashSet;
import java.util.Set;


/**
 * Clase de acceso a la BD 
 * @author nacho
 *
 */
public class InmueblesDao {
	public Set<Inmueble> getAllInmuebles(){
		Set<Inmueble> s = new HashSet<Inmueble>();

		Inmueble inm1 = new Inmueble("inmueble1", "descripcion1", "piso", "nombre comercial 1", 150000.3, "13 de enero" , false, "23 junio", 180000.30, 130.5, 110.3, 12.5, true, 12.5 , true  , 3, 3, 12.5,  9.5, 3.5, 9.5, 5.5, true, true, 2, 3.5, 2.5, 2.5);
		Inmueble inm2 = new Inmueble("inmueble2", "descripcion2", "piso", "nombre comercial 2", 250000.3, "13 de enero" , false, "23 junio", 180000.30, 130.5, 110.3, 12.5, true, 12.5 , true  , 3, 3, 12.5,  9.5, 15.5, 9.5, 5.5, true, true, 2, 3.5, 2.5, 2.5);
		Inmueble inm3 = new Inmueble("inmueble3", "descripcion3", "piso", "nombre comercial 3", 350000.3, "13 de enero" , false, "23 junio", 180000.30, 130.5, 110.3, 12.5, true, 12.5 , true  , 3, 3, 12.5,  9.5, 12.5, 9.5, 5.5, true, true, 2, 3.5, 2.5, 2.5);
		Inmueble inm4 = new Inmueble("inmueble4", "descripcion4", "piso", "nombre comercial 4", 450000.3, "13 de enero" , false, "23 junio", 180000.30, 130.5, 110.3, 12.5, true, 12.5 , true  , 3, 3, 12.5,  9.5, 9.5, 9.5, 5.5, true, true, 2, 3.5, 2.5, 2.5);
		Inmueble inm5 = new Inmueble("inmueble5", "descripcion5", "piso", "nombre comercial 5", 550000.3, "13 de enero" , false, "23 junio", 180000.30, 130.5, 110.3, 12.5, true, 12.5 , true  , 3, 3, 12.5,  9.5, 9.5, 9.5, 5.5, true, true, 2, 3.5, 2.5, 2.5);
		
		s.add(inm1);
		s.add(inm2);
		s.add(inm3);
		s.add(inm4);
		s.add(inm5);
		return s;

	}
	
	/**
	 * Devuelve el inmueble correspondiente al ID
	 * @param id
	 * @return
	 */
	public Inmueble getInmueble(String id){
		Inmueble inm1 = null;
		return inm1;
	}
	
	/**
	 * Añade!modifica los valores del inmueble en la BD
	 * @param inm
	 * @return
	 */
	public boolean setInmueble(Inmueble inm){
		
		return true;
	}
}
