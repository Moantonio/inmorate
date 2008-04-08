package inmorate.gui;

import inmorate.controlador.Controlador;
import inmorate.controlador.constants.CONSTANTS;
import inmorate.model.Inmueble;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class VistaVivienda extends JFrame {
	
	private static final long serialVersionUID = 7915590254871824663L;	
	private Controlador controlador;	
	private ArrayList<Inmueble> valores;	
	private Inmueble inmueble;	
	private ResultSet resultado;
	private boolean ingles;
	private boolean depuracion;
	
	// ArrayList de depuracion
	private ArrayList<Double> dep;

	private JMenuBar menuBar1;
	private JMenu menu2;
	private JMenuItem menuItem1;
	private JMenu menu3;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JButton buttonConsulta;
	private JButton buttonSalir;
	private JLabel labelTitulo;
	private JScrollPane scrollPaneInmueble;
	private JList listInmueble;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JLabel label21;
	private JLabel label22;
	private JLabel label23;
	private JLabel label24;
	private JLabel label25;
	private JLabel label26;
	private JLabel label27;
	private JLabel label28;
	private JLabel label29;
	private JLabel label30;
	private JLabel label31;
	private JLabel label32;
	private JLabel label33;
	private JLabel label34;
	private JLabel label35;
	private JLabel label36;
	private JLabel label37;
	private JLabel label38;
	private JLabel label39;
	private JLabel label40;
	private JLabel label41;
	private JLabel label42;
	private JLabel label43;
	private JLabel label44;
	private JLabel label45;
	private JLabel label46;
	private JLabel label47;
	private JLabel label48;
	private JLabel label49;
	private JLabel label50;
	private JLabel label51;
	private JLabel label52;
	private JLabel label53;
	private JLabel label54;
	private JLabel label55;
	private JLabel label56;
	
	public VistaVivienda(Controlador control) {
		this.controlador = control;
		this.valores = new ArrayList<Inmueble>();
		inmueble = new Inmueble();
		resultado = null;
		ingles = false;
		depuracion = false;
		dep = new ArrayList<Double>();
		initComponents();
		setSize(800,645);
		setLocation(200,100);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Boton consulta
		buttonConsulta.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						String str = "";
						for (int i=0; i<controlador.getComboBox().size(); i++) {
							str += controlador.getComboBox().get(i) + "\n";
						}
						JOptionPane.showMessageDialog(null, str);
					}
				} // ActionListener			
		); // buttonConsulta.addActionListener		
		
		// Boton salir
		buttonSalir.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.cerrarPrograma();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
		
		// Muestra todas las viviendas del programa
		menuItem1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						try {
							resultado = controlador.datosPropiedadFinca();
							rellenarArrayList();
							rellenarList();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} // ActionListener			
		); // menuItem1.addActionListener
		
		// Activa el modo depuracion
		menuItem2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						depuracion = true;
					}
				} // ActionListener			
		); // menuItem2.addActionListener
		
		// Desactiva modo depuracion
		menuItem3.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						depuracion = false;
					}
				} // ActionListener			
		); // menuItem3.addActionListener
		
		// Evento para escribir los datos
		listInmueble.addMouseListener(
				new MouseListener() {
					public void mouseClicked(MouseEvent e) {
						int posicion = listInmueble.getSelectedIndex();
						// Coger Inmueble de valores y escribirlo
						inmueble = valores.get(posicion);
						if (!depuracion)
							mostrar();
						else 
							depurar();
					}

					public void mouseEntered(MouseEvent e) {}

					public void mouseExited(MouseEvent e) {}

					public void mousePressed(MouseEvent e) {}

					public void mouseReleased(MouseEvent e) {}
					
				} // ActionListener			
		); // listInmueble.addActionListener
	}

	private void rellenarList() {
		String array[] = new String[valores.size()];
		for (int i = 0; i < valores.size(); i++) {
			inmueble = valores.get(i);
			array[i] = inmueble.getDMXX();
		}
		listInmueble.setListData(array);
	}
	
	private void rellenarArrayList() throws SQLException {
		valores = new ArrayList<Inmueble>();
		while(resultado.next()) {
			// Crear el inmueble y meterlo a valores
			inmueble = new Inmueble();
			inmueble.setDMXX(resultado.getString(1));
			inmueble.setTipoDeInmueble(resultado.getString(2));
			inmueble.setLuminosidad(resultado.getInt(3));
			inmueble.setOrientacion(resultado.getString(4));
			inmueble.setRepresentatividad(resultado.getInt(5));
			inmueble.setEstadoDelPortal(resultado.getString(6));
			inmueble.setFachada(resultado.getInt(7));
			inmueble.setVistas(resultado.getInt(8));
			inmueble.setNumDormitorios(resultado.getInt(9));
			inmueble.setNumAseos(resultado.getInt(10));
			inmueble.setAntiguedad(resultado.getInt(11));
			inmueble.setPlanta(resultado.getInt(12));
			inmueble.setAscensor(resultado.getBoolean(13));
			inmueble.setPlazasGaraje(resultado.getInt(14));
			inmueble.setEstadoGeneral(resultado.getString(15));
			inmueble.setZonasComunes(resultado.getBoolean(16));
			inmueble.setZona(resultado.getString(17));
			inmueble.setMetrosConstruidos(resultado.getInt(18));
			inmueble.setMetrosHabitables(resultado.getInt(19));
			inmueble.setPrecioTasacion(resultado.getString(20));
			inmueble.setPrecioSalida(resultado.getString(21));
			inmueble.setPrecioVenta(resultado.getString(22));
			inmueble.setDireccion(resultado.getString(23));
			inmueble.setAmueblado(resultado.getBoolean(24));
			inmueble.setPiscina(resultado.getBoolean(25));
			inmueble.setAireAcondicionado(resultado.getBoolean(26));
			inmueble.setConserje(resultado.getBoolean(27));
			inmueble.setTrastero(resultado.getBoolean(28));
			valores.add(inmueble);
		}
	}
	
	private void mostrar() {
		label30.setText(inmueble.getTipoDeInmueble());
		label44.setText(String.valueOf(inmueble.getLuminosidad()));
		label34.setText(inmueble.getOrientacion());
		label16.setText(String.valueOf(inmueble.getRepresentatividad()));
		label14.setText(inmueble.getEstadoDelPortal());
		label8.setText(String.valueOf(inmueble.getFachada()));
		label36.setText(String.valueOf(inmueble.getVistas()));
		label20.setText(String.valueOf(inmueble.getNumDormitorios()));
		label48.setText(String.valueOf(inmueble.getNumAseos()));
		label38.setText(String.valueOf(inmueble.getAntiguedad()));
		label10.setText(String.valueOf(inmueble.getPlanta()));
		if (inmueble.isAscensor())
			if (!ingles)
				label24.setText("SI");
			else 
				label24.setText("YES");
		else 
			label24.setText("NO");
		label6.setText(inmueble.getEstadoGeneral());
		if (inmueble.isZonasComunes())
			if (!ingles)
				label50.setText("SI");
			else 
				label50.setText("YES");
		else
			label50.setText("NO");
		label32.setText(inmueble.getZona());
		label18.setText(String.valueOf(inmueble.getMetrosConstruidos()));
		label40.setText(String.valueOf(inmueble.getMetrosHabitables()));
		label42.setText(inmueble.getPrecioTasacion().substring(0, inmueble.getPrecioTasacion().length()-2)+" €");
		label12.setText(inmueble.getPrecioSalida().substring(0, inmueble.getPrecioSalida().length()-2)+" €");
		label46.setText(inmueble.getPrecioVenta().substring(0, inmueble.getPrecioVenta().length()-2)+" €");
		label22.setText(String.valueOf(inmueble.getPlazasGaraje()));
		if (inmueble.isAmueblado())
			if (!ingles)
				label54.setText("SI");
			else 
				label54.setText("YES");
		else 
			label54.setText("NO");
		label2.setText(inmueble.getDMXX());
		if (inmueble.isPiscina())
			if (!ingles)
				label52.setText("SI");
			else 
				label52.setText("YES");
		else
			label52.setText("NO");
		if (inmueble.isAireAcondicionado())
			if (!ingles)
				label26.setText("SI");
			else 
				label26.setText("YES");
		else
			label26.setText("NO");
		if (inmueble.isConserje())
			if (!ingles)
				label56.setText("SI");
			else 
				label56.setText("YES");
		else
			label56.setText("NO");
		if (inmueble.isTrastero())
			if (!ingles)
				label28.setText("SI");
			else 
				label28.setText("YES");
		else
			label28.setText("NO");
		label4.setText(inmueble.getDireccion());
	}
	
	private void depurar() {
		for (int i=0; i<CONSTANTS.NUMERO_ELEMENTOS; i++) {
			dep.add(i/10.0);
		}	
		label30.setText(dep.get(0).toString());
		label44.setText(dep.get(0).toString());
		label34.setText(dep.get(0).toString());
		label16.setText(dep.get(0).toString());
		label14.setText(dep.get(0).toString());
		label8.setText(dep.get(0).toString());
		label36.setText(dep.get(0).toString());
		label20.setText(dep.get(0).toString());
		label48.setText(dep.get(0).toString());
		label38.setText(dep.get(0).toString());
		label10.setText(dep.get(0).toString());
		label24.setText(dep.get(0).toString());
		label22.setText(dep.get(0).toString());
		label16.setText(dep.get(0).toString());
		label50.setText(dep.get(0).toString());
		label32.setText(dep.get(0).toString());
		label18.setText(dep.get(0).toString());
		label40.setText(dep.get(0).toString());
		label42.setText(dep.get(0).toString());
		label12.setText(dep.get(0).toString());
		label46.setText(dep.get(0).toString());
	}

	private void initComponents() {
		menuBar1 = new JMenuBar();
		menu2 = new JMenu();
		menuItem1 = new JMenuItem();
		menu3 = new JMenu();
		menuItem2 = new JMenuItem();
		menuItem3 = new JMenuItem();
		buttonConsulta = new JButton();
		buttonSalir = new JButton();
		labelTitulo = new JLabel();
		scrollPaneInmueble = new JScrollPane();
		listInmueble = new JList();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		label13 = new JLabel();
		label14 = new JLabel();
		label15 = new JLabel();
		label16 = new JLabel();
		label17 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		label20 = new JLabel();
		label21 = new JLabel();
		label22 = new JLabel();
		label23 = new JLabel();
		label24 = new JLabel();
		label25 = new JLabel();
		label26 = new JLabel();
		label27 = new JLabel();
		label28 = new JLabel();
		label29 = new JLabel();
		label30 = new JLabel();
		label31 = new JLabel();
		label32 = new JLabel();
		label33 = new JLabel();
		label34 = new JLabel();
		label35 = new JLabel();
		label36 = new JLabel();
		label37 = new JLabel();
		label38 = new JLabel();
		label39 = new JLabel();
		label40 = new JLabel();
		label41 = new JLabel();
		label42 = new JLabel();
		label43 = new JLabel();
		label44 = new JLabel();
		label45 = new JLabel();
		label46 = new JLabel();
		label47 = new JLabel();
		label48 = new JLabel();
		label49 = new JLabel();
		label50 = new JLabel();
		label51 = new JLabel();
		label52 = new JLabel();
		label53 = new JLabel();
		label54 = new JLabel();
		label55 = new JLabel();
		label56 = new JLabel();

		//======== this ========
		setTitle("Valores Inmuebles");
		setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== menuBar1 ========
		{
			
			//======== menu2 ========
			{
				menu2.setText("Viviendas");
				menu2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				
				//---- menuItem1 ----
				menuItem1.setText("Finca");
				menuItem1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				menu2.add(menuItem1);
			}
			menuBar1.add(menu2);
			
			//======== menu3 ========
			{
				menu3.setText("Depurar");
				menu3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				
				//---- menuItem2 ----
				menuItem2.setText("Modo Depuracion");
				menuItem2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				menu3.add(menuItem2);
				
				//---- menuItem3 ----
				menuItem3.setText("Modo Normal");
				menuItem3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				menu3.add(menuItem3);
			}
			menuBar1.add(menu3);
		}
		contentPane.add(menuBar1);
		menuBar1.setBounds(new Rectangle(new Point(0, 0), menuBar1.getPreferredSize()));

		//---- buttonConsulta ----
		buttonConsulta.setText("Nueva Consulta");
		buttonConsulta.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonConsulta.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonConsulta);
		buttonConsulta.setBounds(40, 485, 190, 40);

		//---- buttonSalir ----
		buttonSalir.setText("Salir del Programa");
		buttonSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonSalir.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonSalir);
		buttonSalir.setBounds(40, 550, 190, 40);

		//---- labelTitulo ----
		labelTitulo.setText("Ficha del Inmueble");
		labelTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(new Rectangle(new Point(250, 35), labelTitulo.getPreferredSize()));

		//======== scrollPaneInmueble ========
		{
			
			//---- listInmueble ----
			listInmueble.setVisibleRowCount(1000000);
			listInmueble.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			scrollPaneInmueble.setViewportView(listInmueble);
		}
		contentPane.add(scrollPaneInmueble);
		scrollPaneInmueble.setBounds(40, 95, 190, 365);

		//---- label1 ----
		label1.setText("Tipo de Inmueble:");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(500, 100), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("- - - - - - - - - -");
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(350, 100), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Orientacion:");
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(500, 170), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("- - - - - - - - - -");
		label4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label4);
		label4.setBounds(new Rectangle(320, 135, 200, label4.getPreferredSize().height));

		//---- label5 ----
		label5.setText("Estado del Portal:");
		label5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(250, 520), label5.getPreferredSize()));

		//---- label6 ----
		label6.setText("- - - - - - - - - -");
		label6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label6);
		label6.setBounds(new Rectangle(new Point(360, 170), label6.getPreferredSize()));

		//---- label7 ----
		label7.setText("Vistas:");
		label7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label7);
		label7.setBounds(new Rectangle(new Point(500, 240), label7.getPreferredSize()));

		//---- label8 ----
		label8.setText("- - - - - - - - - -");
		label8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label8);
		label8.setBounds(new Rectangle(new Point(315, 240), label8.getPreferredSize()));

		//---- label9 ----
		label9.setText("Nº Baños / Aseos:");
		label9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label9);
		label9.setBounds(new Rectangle(new Point(500, 310), label9.getPreferredSize()));

		//---- label10 ----
		label10.setText("- - - - - - - - - -");
		label10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label10);
		label10.setBounds(new Rectangle(new Point(300, 205), label10.getPreferredSize()));

		//---- label11 ----
		label11.setText("Planta:");
		label11.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label11);
		label11.setBounds(new Rectangle(new Point(250, 205), label11.getPreferredSize()));

		//---- label12 ----
		label12.setText("- - - - - - - - - -");
		label12.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label12);
		label12.setBounds(new Rectangle(615, 520, 140, label12.getPreferredSize().height));

		//---- label13 ----
		label13.setText("Estado General:");
		label13.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label13);
		label13.setBounds(new Rectangle(new Point(250, 170), label13.getPreferredSize()));

		//---- label14 ----
		label14.setText("- - - - - - - - - -");
		label14.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label14);
		label14.setBounds(new Rectangle(new Point(370, 520), label14.getPreferredSize()));

		//---- label15 ----
		label15.setText("Zona / Subzona:");
		label15.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label15);
		label15.setBounds(new Rectangle(new Point(500, 135), label15.getPreferredSize()));

		//---- label16 ----
		label16.setText("- - - - - - - - - -");
		label16.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label16);
		label16.setBounds(new Rectangle(new Point(380, 275), label16.getPreferredSize()));

		//---- label17 ----
		label17.setText("Metros Habitables:");
		label17.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label17);
		label17.setBounds(new Rectangle(new Point(500, 485), label17.getPreferredSize()));

		//---- label18 ----
		label18.setText("- - - - - - - - - -");
		label18.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label18);
		label18.setBounds(new Rectangle(new Point(385, 485), label18.getPreferredSize()));

		//---- label19 ----
		label19.setText("Precio de Salida: ");
		label19.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label19);
		label19.setBounds(new Rectangle(new Point(500, 520), label19.getPreferredSize()));

		//---- label20 ----
		label20.setText("- - - - - - - - - -");
		label20.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label20);
		label20.setBounds(new Rectangle(new Point(365, 310), label20.getPreferredSize()));

		//---- label21 ----
		label21.setText("Plazas de Garaje: ");
		label21.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label21);
		label21.setBounds(new Rectangle(new Point(250, 345), label21.getPreferredSize()));

		//---- label22 ----
		label22.setText("- - - - - - - - - -");
		label22.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label22);
		label22.setBounds(new Rectangle(new Point(370, 345), label22.getPreferredSize()));

		//---- label23 ----
		label23.setText("Identificador:");
		label23.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label23);
		label23.setBounds(new Rectangle(new Point(250, 100), label23.getPreferredSize()));

		//---- label24 ----
		label24.setText("- - - - - - - - - -");
		label24.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label24);
		label24.setBounds(new Rectangle(new Point(320, 380), label24.getPreferredSize()));

		//---- label25 ----
		label25.setText("Aire Acondicionado:");
		label25.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label25);
		label25.setBounds(new Rectangle(new Point(250, 415), label25.getPreferredSize()));

		//---- label26 ----
		label26.setText("- - - - - - - - - -");
		label26.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label26);
		label26.setBounds(new Rectangle(new Point(380, 415), label26.getPreferredSize()));

		//---- label27 ----
		label27.setText("Trastero:");
		label27.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label27);
		label27.setBounds(new Rectangle(new Point(250, 450), label27.getPreferredSize()));

		//---- label28 ----
		label28.setText("- - - - - - - - - -");
		label28.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label28);
		label28.setBounds(new Rectangle(new Point(320, 450), label28.getPreferredSize()));

		//---- label29 ----
		label29.setText("Luminosidad:");
		label29.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label29);
		label29.setBounds(new Rectangle(new Point(500, 275), label29.getPreferredSize()));

		//---- label30 ----
		label30.setText("- - - - - - - - - -");
		label30.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label30);
		label30.setBounds(new Rectangle(new Point(620, 100), label30.getPreferredSize()));

		//---- label31 ----
		label31.setText("Representatividad:");
		label31.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label31);
		label31.setBounds(new Rectangle(new Point(250, 275), label31.getPreferredSize()));

		//---- label32 ----
		label32.setText("- - - - - - - - - -");
		label32.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label32);
		label32.setBounds(new Rectangle(new Point(610, 135), label32.getPreferredSize()));

		//---- label33 ----
		label33.setText("Fachada: ");
		label33.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label33);
		label33.setBounds(new Rectangle(new Point(250, 240), label33.getPreferredSize()));

		//---- label34 ----
		label34.setText("- - - - - - - - - -");
		label34.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label34);
		label34.setBounds(new Rectangle(new Point(585, 170), label34.getPreferredSize()));

		//---- label35 ----
		label35.setText("Nº Habitaciones:");
		label35.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label35);
		label35.setBounds(new Rectangle(new Point(250, 310), label35.getPreferredSize()));

		//---- label36 ----
		label36.setText("- - - - - - - - - -");
		label36.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label36);
		label36.setBounds(new Rectangle(new Point(550, 240), label36.getPreferredSize()));

		//---- label37 ----
		label37.setText("Antigüedad:");
		label37.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label37);
		label37.setBounds(new Rectangle(new Point(500, 205), label37.getPreferredSize()));

		//---- label38 ----
		label38.setText("- - - - - - - - - -");
		label38.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label38);
		label38.setBounds(new Rectangle(new Point(580, 205), label38.getPreferredSize()));

		//---- label39 ----
		label39.setText("Ascensor:");
		label39.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label39);
		label39.setBounds(new Rectangle(new Point(250, 380), label39.getPreferredSize()));

		//---- label40 ----
		label40.setText("- - - - - - - - - -");
		label40.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label40);
		label40.setBounds(new Rectangle(new Point(630, 485), label40.getPreferredSize()));

		//---- label41 ----
		label41.setText("Zonas Comunes:");
		label41.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label41);
		label41.setBounds(new Rectangle(new Point(500, 345), label41.getPreferredSize()));

		//---- label42 ----
		label42.setText("- - - - - - - - - -");
		label42.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label42);
		label42.setBounds(new Rectangle(380, 555, 140, label42.getPreferredSize().height));

		//---- label43 ----
		label43.setText("Metros Construidos:");
		label43.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label43);
		label43.setBounds(new Rectangle(new Point(250, 485), label43.getPreferredSize()));

		//---- label44 ----
		label44.setText("- - - - - - - - - -");
		label44.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label44);
		label44.setBounds(new Rectangle(new Point(590, 275), label44.getPreferredSize()));

		//---- label45 ----
		label45.setText("Precio de Tasación:");
		label45.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label45);
		label45.setBounds(new Rectangle(new Point(250, 555), label45.getPreferredSize()));

		//---- label46 ----
		label46.setText("- - - - - - - - - -");
		label46.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label46);
		label46.setBounds(new Rectangle(new Point(610, 555), label46.getPreferredSize()));

		//---- label47 ----
		label47.setText("Precio de Venta: ");
		label47.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label47);
		label47.setBounds(new Rectangle(new Point(500, 555), label47.getPreferredSize()));

		//---- label48 ----
		label48.setText("- - - - - - - - - -");
		label48.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label48);
		label48.setBounds(new Rectangle(new Point(620, 310), label48.getPreferredSize()));

		//---- label49 ----
		label49.setText("Amueblado:");
		label49.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label49);
		label49.setBounds(new Rectangle(new Point(500, 415), label49.getPreferredSize()));

		//---- label50 ----
		label50.setText("- - - - - - - - - -");
		label50.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label50);
		label50.setBounds(new Rectangle(new Point(605, 345), label50.getPreferredSize()));

		//---- label51 ----
		label51.setText("Piscina:");
		label51.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label51);
		label51.setBounds(new Rectangle(new Point(500, 380), label51.getPreferredSize()));

		//---- label52 ----
		label52.setText("- - - - - - - - - -");
		label52.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label52);
		label52.setBounds(new Rectangle(new Point(555, 380), label52.getPreferredSize()));

		//---- label53 ----
		label53.setText("Conserje:");
		label53.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label53);
		label53.setBounds(new Rectangle(new Point(500, 450), label53.getPreferredSize()));

		//---- label54 ----
		label54.setText("- - - - - - - - - -");
		label54.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label54);
		label54.setBounds(new Rectangle(new Point(580, 415), label54.getPreferredSize()));

		//---- label55 ----
		label55.setText("Dirección:");
		label55.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label55);
		label55.setBounds(new Rectangle(new Point(250, 135), label55.getPreferredSize()));

		//---- label56 ----
		label56.setText("- - - - - - - - - -");
		label56.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label56);
		label56.setBounds(new Rectangle(new Point(570, 450), label56.getPreferredSize()));

		contentPane.setPreferredSize(new Dimension(800, 645));
	}

	public void traducirEspanol() {		
		ingles = false;
		setTitle("Valores Inmuebles");
		buttonConsulta.setText("Nueva Consulta");
		buttonSalir.setText("Salir del Programa");
		labelTitulo.setText("Ficha del Inmueble");		
		label1.setText("Tipo de Inmueble:");
		label30.setBounds(new Rectangle(new Point(620, 100), label30.getPreferredSize()));
		label3.setText("Orientacion:");
		label5.setText("Estado del Portal:");
		label5.setBounds(new Rectangle(new Point(250, 520), label5.getPreferredSize()));		
		label14.setText("- - - - - - - - - -");
		label14.setBounds(new Rectangle(new Point(370, 520), label14.getPreferredSize()));
		label7.setText("Vistas:");
		label9.setText("Nº Baños / Aseos:");
		label9.setBounds(new Rectangle(new Point(500, 310), label9.getPreferredSize()));
		label48.setBounds(new Rectangle(new Point(620, 310), label48.getPreferredSize()));
		label11.setText("Planta:");
		label11.setBounds(new Rectangle(new Point(250, 205), label11.getPreferredSize()));
		label10.setBounds(new Rectangle(new Point(300, 205), label10.getPreferredSize()));
		label13.setText("Estado General:");
		label6.setBounds(new Rectangle(new Point(360, 170), label6.getPreferredSize()));
		label15.setText("Zona / Subzona:");
		label15.setBounds(new Rectangle(new Point(500, 135), label15.getPreferredSize()));
		label32.setBounds(new Rectangle(new Point(610, 135), label32.getPreferredSize()));
		label17.setText("Metros Habitables:");
		label17.setBounds(new Rectangle(new Point(500, 485), label17.getPreferredSize()));
		label40.setBounds(new Rectangle(new Point(630, 485), label40.getPreferredSize()));
		label19.setText("Precio de Salida: ");
		label12.setBounds(615, 520, 140, label12.getPreferredSize().height);
		label21.setText("Plazas de Garaje: ");
		label22.setBounds(new Rectangle(new Point(370, 345), label22.getPreferredSize()));
		label23.setText("Identificador:");
		label2.setBounds(new Rectangle(new Point(350, 100), label2.getPreferredSize()));
		label25.setText("Aire Acondicionado:");
		label26.setBounds(new Rectangle(new Point(380, 415), label26.getPreferredSize()));
		label27.setText("Trastero:");
		label28.setBounds(new Rectangle(new Point(320, 450), label28.getPreferredSize()));
		label29.setText("Luminosidad:");
		label44.setBounds(new Rectangle(new Point(590, 275), label44.getPreferredSize()));
		label31.setText("Representatividad:");
		label31.setBounds(new Rectangle(new Point(250, 275), label31.getPreferredSize()));
		label16.setBounds(new Rectangle(new Point(380, 275), label16.getPreferredSize()));
		label33.setText("Fachada: ");
		label8.setBounds(new Rectangle(new Point(315, 240), label8.getPreferredSize()));
		label35.setText("Nº Habitaciones:");
		label35.setBounds(new Rectangle(new Point(250, 310), label35.getPreferredSize()));
		label20.setBounds(new Rectangle(new Point(365, 310), label20.getPreferredSize()));
		label37.setText("Antigüedad:");
		label38.setBounds(new Rectangle(new Point(580, 205), label38.getPreferredSize()));
		label39.setText("Ascensor:");
		label41.setText("Zonas Comunes:");
		label43.setText("Metros Construidos:");
		label43.setBounds(new Rectangle(new Point(250, 485), label43.getPreferredSize()));
		label18.setBounds(new Rectangle(new Point(385, 485), label18.getPreferredSize()));
		label45.setText("Precio de Tasación:");
		label42.setBounds(380, 555, 110, label42.getPreferredSize().height);
		label47.setText("Precio de Venta: ");
		label46.setBounds(610, 555, 110, label46.getPreferredSize().height);
		label49.setText("Amueblado:");
		label54.setBounds(new Rectangle(new Point(580, 415), label54.getPreferredSize()));
		label51.setText("Piscina:");
		label51.setBounds(new Rectangle(new Point(500, 380), label51.getPreferredSize()));
		label52.setBounds(new Rectangle(new Point(555, 380), label52.getPreferredSize()));
		label53.setText("Conserje:");
		label55.setText("Dirección:");
	}

	public void traducirIngles() {
		ingles = true;
		setTitle("Buildings Values");
		buttonConsulta.setText("New Query");
		buttonSalir.setText("Exit");
		labelTitulo.setText("Buildings");		
		label1.setText("Type of building:");
		label30.setBounds(new Rectangle(new Point(615, 100), label30.getPreferredSize()));
		label3.setText("Orientation:");
		label5.setText("State of the entrace hall:");
		label5.setBounds(250, 520, 190, label5.getPreferredSize().height);
		label14.setText("- - - - - - -");
		label14.setBounds(425, 520, 110, label14.getPreferredSize().height);
		label7.setText("Views:");
		label9.setText("Number of baths / Toilets:");
		label9.setBounds(500, 310, 205, label9.getPreferredSize().height);
		label48.setBounds(new Rectangle(new Point(680, 310), label48.getPreferredSize()));
		label11.setText("Height (Floor):");
		label11.setBounds(250, 205, 205, label11.getPreferredSize().height);
		label10.setBounds(new Rectangle(new Point(355, 205), label10.getPreferredSize()));
		label13.setText("General State:");
		label6.setBounds(new Rectangle(new Point(355, 170), label6.getPreferredSize()));
		label15.setText("Zone / Subzone:");
		label15.setBounds(500, 135, 145, label15.getPreferredSize().height);
		label32.setBounds(new Rectangle(new Point(615, 135), label32.getPreferredSize()));
		label17.setText("Inhabitable meters:");
		label17.setBounds(500, 485, 180, label17.getPreferredSize().height);
		label40.setBounds(new Rectangle(new Point(640, 485), label40.getPreferredSize()));
		label19.setText("Starting Price: ");
		label12.setBounds(605, 520, 140, label12.getPreferredSize().height);
		label21.setText("Car park: ");
		label22.setBounds(new Rectangle(new Point(315, 345), label22.getPreferredSize()));
		label23.setText("Identifier:");
		label2.setBounds(new Rectangle(new Point(330, 100), label2.getPreferredSize()));
		label25.setText("Air conditioning:");
		label26.setBounds(new Rectangle(new Point(360, 415), label26.getPreferredSize()));
		label27.setText("Boxroom:");
		label28.setBounds(new Rectangle(new Point(315, 450), label28.getPreferredSize()));
		label29.setText("Luminosity:");
		label44.setBounds(new Rectangle(new Point(580, 275), label44.getPreferredSize()));
		label31.setText("Representativeness:");
		label31.setBounds(250, 275, 145, label31.getPreferredSize().height);
		label16.setBounds(new Rectangle(new Point(390, 275), label16.getPreferredSize()));
		label33.setText("Facade: ");
		label8.setBounds(new Rectangle(new Point(305, 240), label8.getPreferredSize()));
		label35.setText("Number of Rooms:");
		label35.setBounds(250, 310, 145, label35.getPreferredSize().height);
		label20.setBounds(new Rectangle(new Point(375, 310), label20.getPreferredSize()));
		label37.setText("Age:");
		label38.setBounds(new Rectangle(new Point(535, 205), label38.getPreferredSize()));
		label39.setText("Elevator:");
		label41.setText("Common zones:");
		label43.setText("Meters Constructed:");
		label43.setBounds(250, 485, 180, label43.getPreferredSize().height);
		label18.setBounds(new Rectangle(new Point(395, 485), label18.getPreferredSize()));
		label45.setText("Assessment Price:");
		label42.setBounds(375, 555, 110, label42.getPreferredSize().height);
		label47.setText("Sale Price: ");
		label46.setBounds(575, 555, 110, label46.getPreferredSize().height);
		label49.setText("Furnished:");
		label54.setBounds(new Rectangle(new Point(575, 415), label54.getPreferredSize()));
		label51.setText("Swimming Pool:");
		label51.setBounds(500, 380, 120, label51.getPreferredSize().height);
		label52.setBounds(new Rectangle(new Point(605, 380), label52.getPreferredSize()));
		label53.setText("Doorman:");
		label55.setText("Direction:");		
	}
}
