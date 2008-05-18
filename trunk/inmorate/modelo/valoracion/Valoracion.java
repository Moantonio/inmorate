package inmorate.modelo.valoracion;

import static inmorate.modelo.constants.CONSTANTS.ValoracionEnum;

public class Valoracion {
	private double valor;

	public Valoracion() {
		super();
	}
	
	public Valoracion(double valor) {
		super();
		this.valor = valor;
//		logger.debug("Creada valoracion con valor: " + valor);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor >= -1 && valor <= 10)
			this.valor = valor;
	}
	
	private static boolean rangoMuyMala(double i)  {	return i > 0 && i <= 2;	}
	private static boolean rangoMala(double i)     {	return i > 2 && i <= 4;	}
	private static boolean rangoNormal(double i)   {	return i > 4 && i <= 6;	}
	private static boolean rangoBuena(double i)    {	return i > 6 && i <= 7;	}
	private static boolean rangoMuyBuena(double i) {	return i > 7 && i <= 9;	}
	private static boolean rangoExcelente(double i){	return i > 9 && i <= 10;}
	
	public ValoracionEnum fuzzy() {
		return fuzzy(valor);
	}
	
	public static ValoracionEnum fuzzy(double valor) {
		ValoracionEnum valoracion = null;
		if (rangoMuyMala(valor)) {
			valoracion = ValoracionEnum.MUY_MALA;
		} else if (rangoMala(valor)) {
			valoracion = ValoracionEnum.MALA;
		} else if (rangoNormal(valor)) {
			valoracion = ValoracionEnum.NORMAL;
		} else if (rangoBuena(valor)) {
			valoracion = ValoracionEnum.BUENA;
		} else if (rangoMuyBuena(valor)) {
			valoracion = ValoracionEnum.MUY_BUENA;
		} else if (rangoExcelente(valor)) {
			valoracion = ValoracionEnum.EXCELENTE;
		}
		return valoracion;
	}
	
	public static int defuzzy(ValoracionEnum valoracion) {
		int valor = 0;
		switch (valoracion) {
		case MUY_MALA:
			valor = 1;
			break;
		case MALA:
			valor = 3;
			break;
		case NORMAL:
			valor = 5;
			break;
		case BUENA:
			valor = 7;
			break;
		case MUY_BUENA:
			valor = 9;
			break;
		case EXCELENTE:
			valor = 10;
			break;
		}
		return valor;
	}
	
}
