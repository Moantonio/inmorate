package inmorate.init;

import inmorate.controlador.Controlador;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;
import inmorate.gui.VistaVivienda;

import javax.swing.JOptionPane;

public class Start {

	/**
	 * Clase de arranque del programa
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Controlador controlador = new Controlador();
			controlador.crearDriverBBDD();
			controlador.datosPropiedadFinca();
			VistaInicial vistaInicial = new VistaInicial(controlador);
			VistaPareja vistaPareja = new VistaPareja(controlador); 
			VistaMatrimonio vistaMatrimonio = new VistaMatrimonio(controlador);
			VistaSoltero vistaSoltero = new VistaSoltero(controlador);
			VistaSoltera vistaSoltera = new VistaSoltera(controlador);
			//VistaVivienda vistaVivienda = new VistaVivienda();
			controlador.registrarVistaInicial(vistaInicial);
			controlador.registrarVistaPareja(vistaPareja);
			controlador.registrarVistaMatrimonio(vistaMatrimonio);
			controlador.registrarVistaSoltero(vistaSoltero);
			controlador.registrarVistaSoltera(vistaSoltera);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), // mensaje
					"EXCEPCION", // título
					JOptionPane.ERROR_MESSAGE); // icono
		}		
	}

}
