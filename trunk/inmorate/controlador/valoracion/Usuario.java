package inmorate.controlador.valoracion;

import static inmorate.controlador.constants.CONSTANTS.*;
import org.apache.log4j.Logger;
import inmorate.controlador.elementos.Elemento;
import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.sector.Sector;

public class Usuario {
	private static Logger logger = Logger.getLogger(Usuario.class);
	
	private final Sector sector;
	private Elementos elementos;
	private ValoradorEnum valorador;

	public Usuario(Sector sector, ValoradorEnum valorador) {
		super();
		logger.debug("Creando Usuario de sector: " + sector + " valorador: " + valorador);
		
		this.elementos = new Elementos();
		this.sector = sector;
		this.valorador = valorador;
		
		inicializaImportanciaElementos();
	}

	private void inicializaImportanciaElementos() {
		Elemento[] elementosArray = elementos.getElementos();
		
		for (int i=1; i < elementosArray.length; i++){
			GradoImportanciaEnum tmp = null;
			if (valorador == ValoradorEnum.USUARIO){
				switch (sector.getTipoSector()) {
				case PAREJA_JOVEN_SIN_HIJOS:
					tmp = PAREJA_JOVEN_SIN_HIJOS[i];
					break;
				case FAMILIA_2_3_HIJOS:
					tmp = FAMILIA_2_3_HIJOS[i];
					break;
				case SOLTERO:
					tmp = SOLTERO[i];
					break;
				case SOLTERA:
					tmp = SOLTERA[i];
					break;
				}
			}
			else if (valorador == ValoradorEnum.EXPERTO){
				switch (sector.getTipoSector()) {
				case PAREJA_JOVEN_SIN_HIJOS:
					tmp = EXPERTO_PAREJA_JOVEN_SIN_HIJOS[i];
					break;
				case FAMILIA_2_3_HIJOS:
					tmp = EXPERTO_FAMILIA_2_3_HIJOS[i];
					break;
				case SOLTERO:
					tmp = EXPERTO_SOLTERO[i];
					break;
				case SOLTERA:
					tmp = EXPERTO_SOLTERA[i];
					break;
				}
			}
			System.out.println(" " +i);
			Importancia importanciaTmp = new Importancia(tmp);
			elementosArray[i].setImportancia(importanciaTmp);
			logger.debug("Actualizada importancia del elemento \"" + elementosArray[i].getNombre() + "\" a " + importanciaTmp);
		}
	}
	

	public void setImportanciaTipoInmueble        (Importancia importancia){elementos.getElementos()[ TIPO_INMUEBLE       ].setImportancia(importancia);}
	public void setImportanciaLuminosidad         (Importancia importancia){elementos.getElementos()[ LUMINOSIDAD         ].setImportancia(importancia);}
	public void setImportanciaOrientacion         (Importancia importancia){elementos.getElementos()[ ORIENTACION         ].setImportancia(importancia);}
	public void setImportanciaRepresentatividad   (Importancia importancia){elementos.getElementos()[ REPRESENTATIVIDAD   ].setImportancia(importancia);}
	public void setImportanciaEstadoDelPortal     (Importancia importancia){elementos.getElementos()[ ESTADO_DEL_PORTAL   ].setImportancia(importancia);}
	public void setImportanciaFachada             (Importancia importancia){elementos.getElementos()[ FACHADA             ].setImportancia(importancia);}
	public void setImportanciaVistas              (Importancia importancia){elementos.getElementos()[ VISTAS              ].setImportancia(importancia);}
	public void setImportanciaNumeroHabitaciones  (Importancia importancia){elementos.getElementos()[ NUMERO_HABITACIONES ].setImportancia(importancia);}
	public void setImportancianumeroBanos         (Importancia importancia){elementos.getElementos()[ NUMERO_BANOS        ].setImportancia(importancia);}
	public void setImportanciaAntiguedad          (Importancia importancia){elementos.getElementos()[ ANTIGUEDAD          ].setImportancia(importancia);}
	public void setImportanciaAltura              (Importancia importancia){elementos.getElementos()[ ALTURA              ].setImportancia(importancia);}
	public void setImportanciaAscensor            (Importancia importancia){elementos.getElementos()[ ASCENSOR            ].setImportancia(importancia);}
	public void setImportanciaEstadoGeneral       (Importancia importancia){elementos.getElementos()[ ESTADO_GENERAL      ].setImportancia(importancia);}
	public void setImportanciaZonasComunes        (Importancia importancia){elementos.getElementos()[ ZONAS_COMUNES       ].setImportancia(importancia);}
	public void setImportanciaZonaSubzona         (Importancia importancia){elementos.getElementos()[ ZONA_SUBZONA        ].setImportancia(importancia);}
	public void setImportanciaMetrosConstruidos   (Importancia importancia){elementos.getElementos()[ METROS_CONSTRUIDOS  ].setImportancia(importancia);}
	public void setImportanciaMetrosHabitables    (Importancia importancia){elementos.getElementos()[ METROS_HABITABLES   ].setImportancia(importancia);}
	public void setImportanciaPrecioTasacion      (Importancia importancia){elementos.getElementos()[ PRECIO_TASACION     ].setImportancia(importancia);}
	public void setImportanciaPrecioSalida        (Importancia importancia){elementos.getElementos()[ PRECIO_SALIDA       ].setImportancia(importancia);}
	public void setImportanciaPrecioVenta         (Importancia importancia){elementos.getElementos()[ PRECIO_VENTA        ].setImportancia(importancia);}

	public Importancia getImportanciaTipoInmueble        (){return elementos.getElementos()[ TIPO_INMUEBLE       ].getImportancia();}
	public Importancia getImportanciaLuminosidad         (){return elementos.getElementos()[ LUMINOSIDAD         ].getImportancia();}
	public Importancia getImportanciaOrientacion         (){return elementos.getElementos()[ ORIENTACION         ].getImportancia();}
	public Importancia getImportanciaRepresentatividad   (){return elementos.getElementos()[ REPRESENTATIVIDAD   ].getImportancia();}
	public Importancia getImportanciaEstadoDelPortal     (){return elementos.getElementos()[ ESTADO_DEL_PORTAL   ].getImportancia();}
	public Importancia getImportanciaFachada             (){return elementos.getElementos()[ FACHADA             ].getImportancia();}
	public Importancia getImportanciaVistas              (){return elementos.getElementos()[ VISTAS              ].getImportancia();}
	public Importancia getImportanciaNumeroHabitaciones  (){return elementos.getElementos()[ NUMERO_HABITACIONES ].getImportancia();}
	public Importancia getImportancianumeroBanos         (){return elementos.getElementos()[ NUMERO_BANOS        ].getImportancia();}
	public Importancia getImportanciaAntiguedad          (){return elementos.getElementos()[ ANTIGUEDAD          ].getImportancia();}
	public Importancia getImportanciaAltura              (){return elementos.getElementos()[ ALTURA              ].getImportancia();}
	public Importancia getImportanciaAscensor            (){return elementos.getElementos()[ ASCENSOR            ].getImportancia();}
	public Importancia getImportanciaEstadoGeneral       (){return elementos.getElementos()[ ESTADO_GENERAL      ].getImportancia();}
	public Importancia getImportanciaZonasComunes        (){return elementos.getElementos()[ ZONAS_COMUNES       ].getImportancia();}
	public Importancia getImportanciaZonaSubzona         (){return elementos.getElementos()[ ZONA_SUBZONA        ].getImportancia();}
	public Importancia getImportanciaMetrosConstruidos   (){return elementos.getElementos()[ METROS_CONSTRUIDOS  ].getImportancia();}
	public Importancia getImportanciaMetrosHabitables    (){return elementos.getElementos()[ METROS_HABITABLES   ].getImportancia();}
	public Importancia getImportanciaPrecioTasacion      (){return elementos.getElementos()[ PRECIO_TASACION     ].getImportancia();}
	public Importancia getImportanciaPrecioSalida        (){return elementos.getElementos()[ PRECIO_SALIDA       ].getImportancia();}
	public Importancia getImportanciaPrecioVenta         (){return elementos.getElementos()[ PRECIO_VENTA        ].getImportancia();}

	public Elementos getElementos() {
		return elementos;
	}

	public void setElementos(Elementos elementos) {
		this.elementos = elementos;
	}

	public Sector getSector() {
		return sector;
	}
}
