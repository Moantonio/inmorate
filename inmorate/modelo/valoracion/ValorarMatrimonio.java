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

public class ValorarMatrimonio {

	Controlador controlador;
	InmuebleValorado[] inmueblesValorados;

	public ValorarMatrimonio(Controlador c){
		controlador = c;
		inmueblesValorados = null;
	}
	
	public InmuebleValorado[] valorar() {
		TipoSectorEnum tipoSector = TipoSectorEnum.FAMILIA_2_3_HIJOS;
		Sector sector = new Sector(tipoSector);
		
		ValoradorEnum valoradorUsuario = ValoradorEnum.USUARIO;
		ValoradorEnum valoradorExperto = ValoradorEnum.EXPERTO;
		
		Usuario usuario = new Usuario(sector, valoradorUsuario);
		Usuario experto = new Usuario(sector, valoradorExperto);
		
		ArrayList<String> cambios = controlador.getComboBox();
		if (cambios.get(0).equals("Muy Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(0).equals("Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(0).equals("Poco Importante")) 
			usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		
		if (cambios.get(1).equals("Muy Importante")) 
			usuario.setImportanciaNumeroBanos(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(1).equals("Importante")) 
			usuario.setImportanciaNumeroBanos(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(1).equals("Poco Importante")) 
			usuario.setImportanciaNumeroBanos(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		
		if (cambios.get(2).equals("Muy Importante")) 
			usuario.setImportanciaAltura(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		else if (cambios.get(2).equals("Importante")) 
			usuario.setImportanciaAltura(new Importancia(GradoImportanciaEnum.IMPORTANTE));
		else if (cambios.get(2).equals("Poco Importante")) 
			usuario.setImportanciaAltura(new Importancia(GradoImportanciaEnum.POCO_IMPORTANTE));
		
		
		ArrayList<Inmueble> inmuebles = null;
		try {
			inmuebles = Conversor.parseQuery(controlador.datosPropiedadFinca());
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		MotorInferencia mi = new MotorInferencia(usuario, experto, inmuebles.toArray(new Inmueble[0]));
		inmueblesValorados = mi.computar();
		InmuebleValorado.toFile("fichero", inmueblesValorados);		
		
		return maxPosiciones();
	}
	
	public InmuebleValorado[] maxPosiciones() {
		InmuebleValorado[] resultado = new InmuebleValorado[15];
		quicksort(inmueblesValorados);
		for (int n=0; n<15; n++) 
			resultado[n] = new InmuebleValorado(inmueblesValorados[299-n].getInmueble(),
					inmueblesValorados[299-n].getValoraciones(),
					inmueblesValorados[299-n].getValoracionGeneral(),
					inmueblesValorados[299-n].getValoracionUsuario(),
					inmueblesValorados[299-n].getValoracionExperto());
		
		return resultado;
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
        return (x < y);
    }
    
    public static void quicksort(InmuebleValorado[] a) {
        shuffle(a);                        // to guard against worst-case
        quicksort(a, 0, a.length - 1);
    }

    // quicksort a[left] to a[right]
    public static void quicksort(InmuebleValorado[] a, int left, int right) {
        if (right <= left) return;
        int i = partition(a, left, right);
        quicksort(a, left, i-1);
        quicksort(a, i+1, right);
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
	
}
