package inmorate.controlador.valoracion;

public class Valoracion {
	public static enum ValoracionEnum {MUY_MALA, MALA, NORMAL, BUENA, MUY_BUENA, EXCELENTE}
	private int valor;

	public Valoracion() {
		super();
	}
	
	public Valoracion(int valor) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor >= -1 && valor <= 10)
			this.valor = valor;
	}
	
	private static boolean rangoMuyMala(int i)  {	return i > 0 && i <= 2;	}
	private static boolean rangoMala(int i)     {	return i > 2 && i <= 4;	}
	private static boolean rangoNormal(int i)   {	return i > 4 && i <= 6;	}
	private static boolean rangoBuena(int i)    {	return i > 6 && i <= 7;	}
	private static boolean rangoMuyBuena(int i) {	return i > 7 && i <= 9;	}
	private static boolean rangoExcelente(int i){	return i > 9 && i <= 10;}
	
	public ValoracionEnum fuzzy(int valor) {
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
	
	public int defuzzy(ValoracionEnum valoracion) {
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
