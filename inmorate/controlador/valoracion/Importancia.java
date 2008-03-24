package inmorate.controlador.valoracion;

import inmorate.controlador.constants.CONSTANTS.GradoImportanciaEnum;

// De momento lo dejo sin tipo enumerado
// public enum GradoImportancia = {MUY_IMPORTANTE, IMPORTANTE, POCO_IMPORTANTE, NADA_IMPORTANTE, SIN_DEFINIR};

public class Importancia {

	private GradoImportanciaEnum importancia;

	// public static final int MUY_IMPORTANTE = 3;
	// public static final int IMPORTANTE = 2;
	// public static final int POCO_IMPORTANTE = 1;
	// public static final int NADA_IMPORTANTE = 0;
	// public static final int SIN_DEFINIR = -1;

	public Importancia(GradoImportanciaEnum importancia) {
		super();
		this.importancia = importancia;
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
}
