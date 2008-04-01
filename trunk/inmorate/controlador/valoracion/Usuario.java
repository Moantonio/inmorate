package inmorate.controlador.valoracion;

import static inmorate.controlador.constants.CONSTANTS.*;
import inmorate.controlador.elementos.Elemento;
import inmorate.controlador.elementos.Elementos;
import inmorate.controlador.sector.Sector;

public class Usuario {
	private final Sector sector;
	private Elementos elementos;
	private Valorador valorador;

	public Usuario(Sector sector, Valorador valorador) {
		super();
		this.sector = sector;
		this.valorador = valorador;
		inicializaImportanciaElementos();
	}

	private void inicializaImportanciaElementos() {
		Elemento[] elementosArray = elementos.getElementos();
		
		for (int i=1; i < elementosArray.length; i++){
			GradoImportanciaEnum tmp = null;
			if (valorador == Valorador.USUARIO){
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
			else if (valorador == Valorador.EXPERTO){
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
			Importancia importanciaTmp = new Importancia(tmp);
			elementosArray[i].setImportancia(importanciaTmp);
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
	public void setImportanciaSemanasOferta       (Importancia importancia){elementos.getElementos()[ SEMANAS_OFERTA      ].setImportancia(importancia);}
	public void setImportanciaValoracionExperto   (Importancia importancia){elementos.getElementos()[ VALORACION_EXPERTO  ].setImportancia(importancia);}
	public void setImportanciaObservaciones       (Importancia importancia){elementos.getElementos()[ OBSERVACIONES       ].setImportancia(importancia);}
	

	public void getImportanciaTipoInmueble        (){elementos.getElementos()[ TIPO_INMUEBLE       ].getImportancia();}
	public void getImportanciaLuminosidad         (){elementos.getElementos()[ LUMINOSIDAD         ].getImportancia();}
	public void getImportanciaOrientacion         (){elementos.getElementos()[ ORIENTACION         ].getImportancia();}
	public void getImportanciaRepresentatividad   (){elementos.getElementos()[ REPRESENTATIVIDAD   ].getImportancia();}
	public void getImportanciaEstadoDelPortal     (){elementos.getElementos()[ ESTADO_DEL_PORTAL   ].getImportancia();}
	public void getImportanciaFachada             (){elementos.getElementos()[ FACHADA             ].getImportancia();}
	public void getImportanciaVistas              (){elementos.getElementos()[ VISTAS              ].getImportancia();}
	public void getImportanciaNumeroHabitaciones  (){elementos.getElementos()[ NUMERO_HABITACIONES ].getImportancia();}
	public void getImportancianumeroBanos         (){elementos.getElementos()[ NUMERO_BANOS        ].getImportancia();}
	public void getImportanciaAntiguedad          (){elementos.getElementos()[ ANTIGUEDAD          ].getImportancia();}
	public void getImportanciaAltura              (){elementos.getElementos()[ ALTURA              ].getImportancia();}
	public void getImportanciaAscensor            (){elementos.getElementos()[ ASCENSOR            ].getImportancia();}
	public void getImportanciaEstadoGeneral       (){elementos.getElementos()[ ESTADO_GENERAL      ].getImportancia();}
	public void getImportanciaZonasComunes        (){elementos.getElementos()[ ZONAS_COMUNES       ].getImportancia();}
	public void getImportanciaZonaSubzona         (){elementos.getElementos()[ ZONA_SUBZONA        ].getImportancia();}
	public void getImportanciaMetrosConstruidos   (){elementos.getElementos()[ METROS_CONSTRUIDOS  ].getImportancia();}
	public void getImportanciaMetrosHabitables    (){elementos.getElementos()[ METROS_HABITABLES   ].getImportancia();}
	public void getImportanciaPrecioTasacion      (){elementos.getElementos()[ PRECIO_TASACION     ].getImportancia();}
	public void getImportanciaPrecioSalida        (){elementos.getElementos()[ PRECIO_SALIDA       ].getImportancia();}
	public void getImportanciaPrecioVenta         (){elementos.getElementos()[ PRECIO_VENTA        ].getImportancia();}
	public void getImportanciaSemanasOferta       (){elementos.getElementos()[ SEMANAS_OFERTA      ].getImportancia();}
	public void getImportanciaValoracionExperto   (){elementos.getElementos()[ VALORACION_EXPERTO  ].getImportancia();}
	public void getImportanciaObservaciones       (){elementos.getElementos()[ OBSERVACIONES       ].getImportancia();}

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
