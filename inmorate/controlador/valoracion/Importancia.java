package inmorate.controlador.valoracion;

import org.apache.log4j.Logger;

import inmorate.controlador.constants.CONSTANTS.GradoImportanciaEnum;
import static inmorate.controlador.constants.CONSTANTS.ValoracionEnum;
import inmorate.init.Start;

// De momento lo dejo sin tipo enumerado
// public enum GradoImportancia = {MUY_IMPORTANTE, IMPORTANTE, POCO_IMPORTANTE, NADA_IMPORTANTE, SIN_DEFINIR};

public class Importancia {
	private static Logger logger = Logger.getLogger(Importancia.class);
	private GradoImportanciaEnum importancia;

	// public static final int MUY_IMPORTANTE = 3;
	// public static final int IMPORTANTE = 2;
	// public static final int POCO_IMPORTANTE = 1;
	// public static final int NADA_IMPORTANTE = 0;
	// public static final int SIN_DEFINIR = -1;

	public Importancia(GradoImportanciaEnum importancia) {
		super();
		this.importancia = importancia;
//		logger.debug("Creado objeto de tipo Importancia. Valor: " + getAsString(importancia));
	}

	public GradoImportanciaEnum getImportancia() {
		return importancia;
	}

	public void setImportancia(GradoImportanciaEnum importancia) {
		this.importancia = importancia;
	}

	public String toString() {
		return getAsString(importancia);
	}

	public static String getAsString(GradoImportanciaEnum importancia) {
		String retorno = null;

		switch (importancia) {
		case MUY_IMPORTANTE:
			retorno = "Muy Importante";
			break;
		case IMPORTANTE:
			retorno = "Importante";
			break;
		case POCO_IMPORTANTE:
			retorno = "Poco Importante";
			break;
		case NADA_IMPORTANTE:
			retorno = "Nada Importante";
			break;
		case SIN_DEFINIR:
			retorno = "Sin definir";
			break;
		default:
			retorno = "Sin definir";
		}
		return retorno;
	}

	public static String getAsString(int importancia) {
		String retorno = null;

		switch (importancia) {
		case 3:
			retorno = "Muy Importante";
			break;
		case 2:
			retorno = "Importante";
			break;
		case 1:
			retorno = "Poco Importante";
			break;
		case 0:
			retorno = "Nada Importante";
			break;
		case -1:
			retorno = "Sin definir";
			break;
		default:
			retorno = "Sin definir";
		}
		return retorno;
	}
	
	private static boolean rangoNadaImportante(double i)  {	return i > 0 && i <= 2;	}
	private static boolean rangoPocoImportante(double i)  {	return i > 2 && i <= 5;	}
	private static boolean rangoImportante(double i)      {	return i > 5 && i <= 8;	}
	private static boolean rangoMuyImportante(double i)   {	return i > 8 && i <= 10;}

	public ValoracionEnum fuzzy(Valoracion val) {
		return fuzzy(val.getValor());
	}
	
	public ValoracionEnum fuzzy(double valor) {
		ValoracionEnum valoracion = null;
		if (rangoNadaImportante(valor)) {
			valoracion = ValoracionEnum.MUY_MALA;
		} else if (rangoPocoImportante(valor)) {
			valoracion = ValoracionEnum.MALA;
		} else if (rangoImportante(valor)) {
			valoracion = ValoracionEnum.NORMAL;
		} else if (rangoMuyImportante(valor)) {
			valoracion = ValoracionEnum.BUENA;
		} 
		return valoracion;
	}
	
	public int defuzzy(){
		return defuzzy(importancia);
	}
	
	public int defuzzy(GradoImportanciaEnum importancia) {
		int valor = 0;
		
		switch (importancia) {
		case NADA_IMPORTANTE:
			valor = 2;
			break;
		case POCO_IMPORTANTE:
			valor = 3;
			break;
		case IMPORTANTE:
			valor = 7;
			break;
		case MUY_IMPORTANTE:
			valor = 9;
			break;
		}
		return valor;
	}
}
