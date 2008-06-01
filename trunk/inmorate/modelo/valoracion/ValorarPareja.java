package inmorate.modelo.valoracion;

import inmorate.modelo.bbdd.Conversor;
import inmorate.controlador.Controlador;
import inmorate.modelo.constants.CONSTANTS.GradoImportanciaEnum;
import inmorate.modelo.constants.CONSTANTS.TipoSectorEnum;
import inmorate.modelo.constants.CONSTANTS.ValoradorEnum;
import inmorate.modelo.sector.Sector;
import inmorate.modelo.core.MotorInferencia;
import inmorate.modelo.inmueble.Inmueble;
import inmorate.modelo.inmueble.InmuebleValorado;

import java.sql.SQLException;
import java.util.ArrayList;

public class ValorarPareja {
	
	Controlador controlador;
	InmuebleValorado[] inmueblesValorados;

	public ValorarPareja(Controlador c){
		controlador = c;
		inmueblesValorados = null;
	}
	
	public InmuebleValorado[] valorar() {
		TipoSectorEnum tipoSector = TipoSectorEnum.PAREJA_JOVEN_SIN_HIJOS;
		Sector sector = new Sector(tipoSector);
		
		ValoradorEnum valoradorUsuario = ValoradorEnum.USUARIO;
		ValoradorEnum valoradorExperto = ValoradorEnum.EXPERTO;
		
		Usuario usuario = new Usuario(sector, valoradorUsuario);
		Usuario experto = new Usuario(sector, valoradorExperto);
		
		ArrayList<String> cambios = controlador.getComboBox();
		if (cambios.get(0).equals("Muy Importante")) 
			usuario.setImportanciaTipoInmueble(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(0).equals("Importante")) 
			usuario.setImportanciaTipoInmueble(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(0).equals("Poco Importante")) 
			usuario.setImportanciaTipoInmueble(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		else if (cambios.get(0).equals("Nada Importante")) 
			usuario.setImportanciaTipoInmueble(new Importancia(GradoImportanciaEnum.NADA_IMPORTANTE));

		if (cambios.get(1).equals("Muy Importante")) 
			usuario.setImportanciaRepresentatividad(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(1).equals("Importante")) 
			usuario.setImportanciaRepresentatividad(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(1).equals("Poco Importante")) 
			usuario.setImportanciaRepresentatividad(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		else if (cambios.get(1).equals("Nada Importante")) 
			usuario.setImportanciaRepresentatividad(new Importancia(GradoImportanciaEnum.NADA_IMPORTANTE));
		
		if (cambios.get(2).equals("Muy Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(2).equals("Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(2).equals("Poco Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		else if (cambios.get(2).equals("Nada Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.NADA_IMPORTANTE));
		
		if (cambios.get(3).equals("Muy Importante")) 
			usuario.setImportanciaMetrosHabitables(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(3).equals("Importante")) 
			usuario.setImportanciaMetrosHabitables(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(3).equals("Poco Importante")) 
			usuario.setImportanciaMetrosHabitables(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		else if (cambios.get(3).equals("Nada Importante")) 
			usuario.setImportanciaMetrosHabitables(new Importancia(GradoImportanciaEnum.NADA_IMPORTANTE));
		
		usuario.setLimiteEconomico(true);
		usuario.setPrecioMaximo(Integer.valueOf(cambios.get(4)));
		
		ArrayList<Inmueble> inmuebles = null;
		try {
			inmuebles = Conversor.parseQuery(controlador.datosPropiedadFinca());
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		MotorInferencia mi = new MotorInferencia(usuario, experto, inmuebles.toArray(new Inmueble[0]), controlador);
		inmueblesValorados = mi.computar();
		InmuebleValorado.toFile("fichero", inmueblesValorados);		
		
		return inmueblesValorados;
	}
	
	public void maxPosiciones() {
		quicksort(inmueblesValorados,true);
	}
	
	// QUICKSORT	

    private static long comparisons = 0;
    private static long exchanges   = 0;
	
	// exchange a[i] and a[j]
    private static void exch(InmuebleValorado[] a, int i, int j) {
        exchanges++;
        InmuebleValorado swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // shuffle the array a[]
    private static void shuffle(InmuebleValorado[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N-i));   // between i and N-1
            exch(a, i, r);
        }
    }
    
    // is x < y ?
    private static boolean less(double x, double y) {
        comparisons++;
        return (x > y);
    }
    
    private static boolean less2(String x, String y) {
        comparisons++;
        int n1 = Integer.valueOf(x.substring(4,7));
        int n2 = Integer.valueOf(y.substring(4,7));        
        return (n1 < n2);
    }
    
    public static void quicksort(InmuebleValorado[] a,boolean b) {
        shuffle(a);                        // to guard against worst-case
        quicksort(a, 0, a.length - 1,b);
    }

    // quicksort a[left] to a[right]
    public static void quicksort(InmuebleValorado[] a, int left, int right, boolean b) {
        if (right <= left) return;
        int i = 0;
        if (b)
        	i = partition(a, left, right);
        else 
        	i = partition2(a, left, right);
        quicksort(a, left, i-1, b);
        quicksort(a, i+1, right, b);
    }

    // partition a[left] to a[right], assumes left < right
    private static int partition(InmuebleValorado[] a, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (less(a[++i].getValoracionGeneral().getValor(), a[right].getValoracionGeneral().getValor()))      // find item on left to swap
                ;                               // a[right] acts as sentinel
            while (less(a[right].getValoracionGeneral().getValor(), a[--j].getValoracionGeneral().getValor()))      // find item on right to swap
                if (j == left) break;           // don't go out-of-bounds
            if (i >= j) break;                  // check if pointers cross
            exch(a, i, j);                      // swap two elements into place
        }
        exch(a, i, right);                      // swap with partition element
        return i;
    }
    
    private static int partition2(InmuebleValorado[] a, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (less2(a[++i].getInmueble().getDMXX(), a[right].getInmueble().getDMXX()))      // find item on left to swap
                ;                               // a[right] acts as sentinel
            while (less2(a[right].getInmueble().getDMXX(), a[--j].getInmueble().getDMXX()))      // find item on right to swap
                if (j == left) break;           // don't go out-of-bounds
            if (i >= j) break;                  // check if pointers cross
            exch(a, i, j);                      // swap two elements into place
        }
        exch(a, i, right);                      // swap with partition element
        return i;
    }

	public void identificadores() {
		quicksort(inmueblesValorados,false);
	}
	
}
