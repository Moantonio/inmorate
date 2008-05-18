package inmorate.modelo.sector;

import org.apache.log4j.Logger;

import inmorate.modelo.constants.CONSTANTS.TipoSectorEnum;

public class Sector {
	private static Logger logger = Logger.getLogger(Sector.class);
	private final TipoSectorEnum tipoSector;

	
	public Sector(TipoSectorEnum tipoSector) {
		super();
		this.tipoSector = tipoSector;
		logger.debug("Creado objeto de tipo Sector. Valor: " + getAsString(tipoSector));
	}

	public String toString(){
		return getAsString(tipoSector);
	}
	
	public static String getAsString(TipoSectorEnum idSector) {
		String retorno = null;

		switch (idSector) {
		case PAREJA_JOVEN_SIN_HIJOS:
			retorno = "Pareja joven sin hijos";
			break;
		case FAMILIA_2_3_HIJOS:
			retorno = "Familia 2-3 hijos";
			break;
		case SOLTERO:
			retorno = "Soltero";
			break;
		case SOLTERA:
			retorno = "Soltera";
			break;
		}
		return retorno;
	}
	public static String getAsString(int idSector) {
		String retorno = null;

		switch (idSector) {
		case 1:
			retorno = "Pareja joven sin hijos";
			break;
		case 2:
			retorno = "Familia 2-3 hijos";
			break;
		case 3:
			retorno = "Soltero";
			break;
		case 4:
			retorno = "Soltera";
			break;
		default:
			retorno = "Sin definir";
		}
		return retorno;
	}
	
	public int getId(){
		return getId(tipoSector);
	}
	
	public static int getId(TipoSectorEnum idSector){
		int retorno = -1;

		switch (idSector) {
		case PAREJA_JOVEN_SIN_HIJOS:
			retorno = 1;
			break;
		case FAMILIA_2_3_HIJOS:
			retorno = 2;
			break;
		case SOLTERO:
			retorno = 3;
			break;
		case SOLTERA:
			retorno = 4;
			break;
		}
		return retorno;	
	}

	public TipoSectorEnum getTipoSector() {
		return tipoSector;
	}
}
