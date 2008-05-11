package inmorate.init;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import inmorate.BBDD.Conversor;
import inmorate.controlador.Controlador;
import inmorate.controlador.constants.CONSTANTS.GradoImportanciaEnum;
import inmorate.controlador.constants.CONSTANTS.TipoSectorEnum;
import inmorate.controlador.constants.CONSTANTS.ValoradorEnum;
import inmorate.controlador.sector.Sector;
import inmorate.controlador.valoracion.Importancia;
import inmorate.controlador.valoracion.Usuario;
import inmorate.core.MotorInferencia;
import inmorate.gui.VistaInicial;
import inmorate.gui.VistaMatrimonio;
import inmorate.gui.VistaPareja;
import inmorate.gui.VistaSoltera;
import inmorate.gui.VistaSoltero;
import inmorate.gui.VistaVivienda;
import inmorate.model.Inmueble;
import inmorate.model.InmuebleValorado;

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
		Controlador controlador = null;
		try {		
		    controlador = new Controlador();
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
		
		pruebas(controlador);
	}

	private static void pruebas(Controlador controlador){
		TipoSectorEnum tipoSector = TipoSectorEnum.FAMILIA_2_3_HIJOS;
		Sector sector = new Sector(tipoSector);
		
		ValoradorEnum valoradorUsuario = ValoradorEnum.USUARIO;
		ValoradorEnum valoradorExperto = ValoradorEnum.EXPERTO;
		
		Usuario usuario = new Usuario(sector, valoradorUsuario );
		Usuario experto = new Usuario(sector, valoradorExperto );
		
		usuario.setImportanciaEstadoDelPortal(new Importancia(GradoImportanciaEnum.MUY_IMPORTANTE));
		
		ArrayList<Inmueble> inmuebles = null;
		try {
			inmuebles = Conversor.parseQuery(controlador.datosPropiedadFinca());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		MotorInferencia mi = new MotorInferencia(usuario, experto, inmuebles.toArray(new Inmueble[0] ));
		InmuebleValorado[] inmueblesValorados = mi.computar();
		InmuebleValorado.toFile("fichero", inmueblesValorados);
		
	}
	
}
