package inmorate.init;

import inmorate.controlador.Controlador;
import inmorate.controlador.constants.CONSTANTS.TipoSectorEnum;
import inmorate.controlador.constants.CONSTANTS.ValoradorEnum;
import inmorate.controlador.sector.Sector;
import inmorate.controlador.valoracion.Usuario;
import inmorate.core.MotorInferencia;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;
import inmorate.gui.VistaVivienda;

import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Start {
	private static Logger logger = Logger.getLogger(Start.class);
	
	/**
	 * Clase de arranque del programa
	 * @param args
	 */
	public static void main(String[] args) {
		//  INICIAR LOGS
		PropertyConfigurator.configure("InmorateLog4j.properties");
		logger.info("Arrancando aplicacion de valoracion de Inmuebles");		
		try {
			Controlador controlador = new Controlador();
			controlador.crearDriverBBDD();
			VistaInicial vistaInicial = new VistaInicial(controlador);
			VistaPareja vistaPareja = new VistaPareja(controlador); 
			VistaMatrimonio vistaMatrimonio = new VistaMatrimonio(controlador);
			VistaSoltero vistaSoltero = new VistaSoltero(controlador);
			VistaSoltera vistaSoltera = new VistaSoltera(controlador);
			VistaVivienda vistaVivienda = new VistaVivienda(controlador);
			controlador.registrarVistaInicial(vistaInicial);
			controlador.registrarVistaPareja(vistaPareja);
			controlador.registrarVistaMatrimonio(vistaMatrimonio);
			controlador.registrarVistaSoltero(vistaSoltero);
			controlador.registrarVistaSoltera(vistaSoltera);
			controlador.registrarVistaVivienda(vistaVivienda);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), // mensaje
					"EXCEPCION", // título
					JOptionPane.ERROR_MESSAGE); // icono
		}		
		
		pruebas();
	}

	private static void pruebas(){
		TipoSectorEnum tipoSector = TipoSectorEnum.FAMILIA_2_3_HIJOS;
		Sector sector = new Sector(tipoSector);
		
		ValoradorEnum valorador = ValoradorEnum.USUARIO;
		
		Usuario usuario = new Usuario(sector, valorador );
		MotorInferencia mi = new MotorInferencia(usuario);
		mi.computar();
	}
}
