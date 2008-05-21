package inmorate.gui;

import inmorate.controlador.Controlador;
import inmorate.modelo.inmueble.Inmueble;
import inmorate.modelo.inmueble.InmuebleValorado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class VistaFinal extends JFrame {

	private static final long serialVersionUID = 5063830114616405947L;
	private Controlador controlador;	
	private Inmueble inmueble;	
	private String valoracionGeneral;
	private boolean pulsado;
	private boolean ingles;
	
	private JScrollPane scrollPane1;
	private JList listInmueble;
	private JButton button1;
	private JButton button2;
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
	
	public VistaFinal(Controlador control) throws MalformedURLException {
		controlador = control;
		inmueble = new Inmueble();
		valoracionGeneral = "";
		pulsado = false;
		initComponents();
		ocultar();
		setSize(630,415);
		setLocation(260,180);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Boton consulta
		button1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						pulsado = false;
						ocultar();
						controlador.volverAtras();
					}
				} // ActionListener			
		); // buttonConsulta.addActionListener		
		
		// Boton salir
		button2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.cerrarPrograma();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
		
		// Evento para escribir los datos
		listInmueble.addMouseListener(
				new MouseListener() {
					public void mouseClicked(MouseEvent e) {
						pulsado = true;
						ocultar();
						int posicion = listInmueble.getSelectedIndex();
						// Coger Inmueble de valores y escribirlo
						InmuebleValorado[] resultado = controlador.getResultado();
						inmueble = resultado[posicion].getInmueble();
						valoracionGeneral = String.valueOf(resultado[posicion].getValoracionGeneral().getValor());
						try {
							mostrar();
						} catch (MalformedURLException e1) {
							// TODO Bloque catch generado automáticamente
							e1.printStackTrace();
						}
					}

					public void mouseEntered(MouseEvent e) {}

					public void mouseExited(MouseEvent e) {}

					public void mousePressed(MouseEvent e) {}

					public void mouseReleased(MouseEvent e) {}
					
				} // ActionListener			
		); // listInmueble.addActionListener
	}

	private void initComponents() throws MalformedURLException {
		scrollPane1 = new JScrollPane();
		listInmueble = new JList();
		button1 = new JButton();
		button2 = new JButton();
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

		//======== this ========
		setTitle("Valoración de los Inmuebles");
		setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== scrollPane1 ========
		{
			
			//---- list1 ----
			listInmueble.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			scrollPane1.setViewportView(listInmueble);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(20, 20, 160, 255);
		
		//---- button1 ----
		button1.setText("Nueva Consulta");
		button1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(button1);
		button1.setBounds(20, 290, 160, 30);
		
		//---- button2 ----
		button2.setText("Salir del Programa");
		button2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(button2);
		button2.setBounds(20, 335, 160, 30);

		//---- label1 ----
		label1.setText("Valoración");
		label1.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(280, 30), label1.getPreferredSize()));
		
		//---- label28 ----
		label28.setText("de los");
		label28.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label28);
		label28.setBounds(new Rectangle(new Point(330, 130), label28.getPreferredSize()));
		
		//---- label29 ----
		label29.setText("Inmuebles");
		label29.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label29);
		label29.setBounds(new Rectangle(new Point(280, 230), label29.getPreferredSize()));

		//---- label30 ----
		label30.setText("(Pinche en su identificador para ver el Inmueble)");
		label30.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		contentPane.add(label30);
		label30.setBounds(new Rectangle(new Point(280, 310), label30.getPreferredSize()));
		
		//---- label31 ----
		label31.setText("           (Ordenado de Mayor a Menor)           ");
		label31.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		contentPane.add(label31);
		label31.setBounds(new Rectangle(new Point(280, 325), label31.getPreferredSize()));

		//---- label2 ----
		label2.setText("Tipo de Inmueble:");
		label2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label2);
		label2.setBounds(205, 30, 260, label2.getPreferredSize().height);

		//---- label3 ----
		label3.setText("Zona:");
		label3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label3);
		label3.setBounds(205, 65, 335, label3.getPreferredSize().height);

		//---- label4 ----
		label4.setText("Dirección:");
		label4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label4);
		label4.setBounds(205, 100, 255, label4.getPreferredSize().height);

		//---- label5 ----
		label5.setText("Planta:");
		label5.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label5);
		label5.setBounds(205, 135, 215, label5.getPreferredSize().height);

		//---- label6 ----
		label6.setText("Antigüedad:");
		label6.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label6);
		label6.setBounds(205, 170, 330, label6.getPreferredSize().height);

		//---- label7 ----
		label7.setText("Metros Habitables:");
		label7.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label7);
		label7.setBounds(205, 205, 330, label7.getPreferredSize().height);

		//---- label8 ----
		label8.setText("Precio:");
		label8.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label8);
		label8.setBounds(205, 240, 330, label8.getPreferredSize().height);

		//---- label9 ----
		label9.setText("Valoración General:");
		label9.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label9);
		label9.setBounds(205, 275, 330, label9.getPreferredSize().height);

		//---- label10 ----
		label10.setText("- - - - - - - - - - - - -");
		label10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label10);
		label10.setBounds(335, 30, 265, label10.getPreferredSize().height);

		//---- label11 ----
		label11.setText("- - - - - - - - - - - - -");
		label11.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label11);
		label11.setBounds(250, 65, 255, label11.getPreferredSize().height);

		//---- label12 ----
		label12.setText("- - - - - - - - - - - - -");
		label12.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label12);
		label12.setBounds(280, 100, 330, label12.getPreferredSize().height);

		//---- label13 ----
		label13.setText("- - - - - - - - - - - - -");
		label13.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label13);
		label13.setBounds(255, 135, 265, label13.getPreferredSize().height);
		
		//---- label14 ----
		label14.setText("- - - - - - - - - - - - -");
		label14.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label14);
		label14.setBounds(290, 170, 260, label14.getPreferredSize().height);

		//---- label15 ----
		label15.setText("- - - - - - - - - - - - -");
		label15.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label15);
		label15.setBounds(340, 205, 245, label15.getPreferredSize().height);

		//---- label16 ----
		label16.setText("- - - - - - - - - - - - -");
		label16.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label16);
		label16.setBounds(255, 240, 315, label16.getPreferredSize().height);

		//---- label17 ----
		label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label17);
		label17.setBounds(205, 305, 40, 53);

		//---- label18 ----
		label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label18);
		label18.setBounds(245, 305, 40, 53);

		//---- label19 ----
		label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label19);
		label19.setBounds(285, 305, 40, 53);

		//---- label20 ----
		label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label20);
		label20.setBounds(325, 305, 40, 53);

		//---- label21 ----
		label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label21);
		label21.setBounds(365, 305, 40, 53);

		//---- label22 ----
		label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label22);
		label22.setBounds(405, 305, 40, 53);

		//---- label23 ----
		label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label23);
		label23.setBounds(445, 305, 40, 53);

		//---- label24 ----
		label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label24);
		label24.setBounds(485, 305, 40, 53);

		//---- label25 ----
		label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label25);
		label25.setBounds(525, 305, 40, 53);

		//---- label26 ----
		label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		contentPane.add(label26);
		label26.setBounds(565, 305, 40, 53);

		//---- label27 ----
		label27.setText("- - - - - - - - - - - -");
		label27.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label27);
		label27.setBounds(340, 275, 240, label27.getPreferredSize().height);

		contentPane.setPreferredSize(new Dimension(630, 415));
	}

	
	public void mostrarResultados() {
		InmuebleValorado[] viviendas = controlador.getResultado();
		String array[] = new String[viviendas.length];
		for (int i = 0; i < viviendas.length; i++) {
			if (i<9)
				array[i] = "0" + (i+1) + "º.  " + viviendas[i].getInmueble().getDMXX();				
			else
				array[i] = (i+1) + "º.  " + viviendas[i].getInmueble().getDMXX();
		}
		listInmueble.setListData(array);
	}

	private void mostrar() throws MalformedURLException {
		label10.setText(inmueble.getTipoDeInmueble());
		label11.setText(inmueble.getZona());
		label12.setText(inmueble.getDireccion());
		label13.setText(String.valueOf(inmueble.getAltura())+"º");
		if (!ingles)
			label14.setText(String.valueOf(inmueble.getAntiguedad())+" años");
		else
			label14.setText(String.valueOf(inmueble.getAntiguedad())+" years");
		if (!ingles)
			label15.setText(String.valueOf(inmueble.getMetrosHabitables())+" metros");
		else 
			label15.setText(String.valueOf(inmueble.getMetrosHabitables())+" metres");
		label16.setText(inmueble.getPrecioSalida()+" €");
		label27.setText(valoracionGeneral.substring(0,6));
		mostrarEstrellas();
	}
	
	private void ocultar() {
		if (pulsado) {
			label1.setVisible(false);label2.setVisible(true);
			label3.setVisible(true);label4.setVisible(true);
			label5.setVisible(true);label6.setVisible(true);
			label7.setVisible(true);label8.setVisible(true);
			label9.setVisible(true);label10.setVisible(true);
			label11.setVisible(true);label12.setVisible(true);
			label13.setVisible(true);label14.setVisible(true);
			label15.setVisible(true);label16.setVisible(true);
			label17.setVisible(true);label18.setVisible(true);
			label19.setVisible(true);label20.setVisible(true);
			label21.setVisible(true);label22.setVisible(true);
			label23.setVisible(true);label24.setVisible(true);
			label25.setVisible(true);label26.setVisible(true);
			label27.setVisible(true);label28.setVisible(false);
			label29.setVisible(false);label30.setVisible(false);
			label31.setVisible(false);
		}
		else {
			label1.setVisible(true);label2.setVisible(false);
			label3.setVisible(false);label4.setVisible(false);
			label5.setVisible(false);label6.setVisible(false);
			label7.setVisible(false);label8.setVisible(false);
			label9.setVisible(false);label10.setVisible(false);
			label11.setVisible(false);label12.setVisible(false);
			label13.setVisible(false);label14.setVisible(false);
			label15.setVisible(false);label16.setVisible(false);
			label17.setVisible(false);label18.setVisible(false);
			label19.setVisible(false);label20.setVisible(false);
			label21.setVisible(false);label22.setVisible(false);
			label23.setVisible(false);label24.setVisible(false);
			label25.setVisible(false);label26.setVisible(false);
			label27.setVisible(false);label28.setVisible(true);
			label29.setVisible(true);label30.setVisible(true);
			label31.setVisible(true);
		}
	}

	private void mostrarEstrellas() throws MalformedURLException {
		String primera = valoracionGeneral.substring(0,1);
		int primero = Integer.valueOf(primera);
		String segunda = valoracionGeneral.substring(2,3);
		int segundo = Integer.valueOf(segunda);
		String punto = valoracionGeneral.substring(1,2);
		if (punto.equals(".")) {
			switch(primero) {
			case 0:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 1: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 2: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 3: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 4: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 5: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 6: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 7:	label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 8: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			case 9: label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));
				switch(segundo) {
				case 0:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.0.jpg")));break;
				case 1:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.1.jpg")));break;
				case 2:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.2.jpg")));break;
				case 3:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.3.jpg")));break;
				case 4:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.4.jpg")));break;
				case 5:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.5.jpg")));break;
				case 6:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.6.jpg")));break;
				case 7:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.7.jpg")));break;
				case 8:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.8.jpg")));break;
				case 9:label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\0.9.jpg")));break;
				default: break;
				}
				break;
			default: break;
			}
		}
		else {
			label17.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:.\\estrellas\\1.0.jpg")));
		}
	}

	public void traducirEspanol() {
		ingles = false;
		setTitle("Valoración de los Inmuebles");		
		button1.setText("Nueva Consulta");
		button1.setBounds(20, 290, 160, 30);
		button2.setText("Salir del Programa");
		button2.setBounds(20, 335, 160, 30);
		label1.setText("Valoración");
		label1.setBounds(new Rectangle(new Point(280, 30), label1.getPreferredSize()));
		label28.setText("de los");
		label28.setBounds(new Rectangle(new Point(330, 130), label28.getPreferredSize()));
		label29.setText("Inmuebles");
		label29.setBounds(new Rectangle(new Point(280, 230), label29.getPreferredSize()));
		label30.setText("(Pinche en su identificador para ver el Inmueble)");
		label30.setBounds(new Rectangle(new Point(280, 310), label30.getPreferredSize()));
		label31.setText("           (Ordenado de Mayor a Menor)           ");
		label31.setBounds(new Rectangle(new Point(280, 325), label31.getPreferredSize()));
		label2.setText("Tipo de Inmueble:");
		label10.setBounds(335, 30, 265, label10.getPreferredSize().height);
		label3.setText("Zona:");
		label4.setText("Dirección:");
		label5.setText("Planta:");
		label13.setBounds(255, 135, 265, label13.getPreferredSize().height);
		label6.setText("Antigüedad:");
		label14.setBounds(290, 170, 260, label14.getPreferredSize().height);
		label7.setText("Metros Habitables:");
		label15.setBounds(340, 205, 245, label15.getPreferredSize().height);
		label8.setText("Precio:");
		label16.setBounds(255, 240, 315, label16.getPreferredSize().height);
		label9.setText("Valoración General:");
		label27.setBounds(340, 275, 240, label27.getPreferredSize().height);
	}

	public void traducirIngles() {
		ingles = true;
		setTitle("Buildings Valuation");
		
		button1.setText("New Query");
		button1.setBounds(20, 290, 160, 30);
		button2.setText("Exit");
		button2.setBounds(20, 335, 160, 30);	
		
		label1.setText("Buildings");
		label1.setBounds(new Rectangle(new Point(280, 80), label1.getPreferredSize()));
		label28.setVisible(false);
		label29.setText("Valuation");
		label29.setBounds(new Rectangle(new Point(280, 180), label29.getPreferredSize()));
		label30.setText("  (Click on your identifier to see the building) ");
		label30.setBounds(new Rectangle(new Point(280, 260), label30.getPreferredSize()));
		label31.setText("              (From major to minor)              ");
		label31.setBounds(new Rectangle(new Point(280, 275), label31.getPreferredSize()));
		
		label2.setText("Type of building:");
		label10.setBounds(325, 30, 265, label10.getPreferredSize().height);
		label3.setText("Zone:");
		label4.setText("Direction:");
		label5.setText("Height (Floor):");
		label13.setBounds(311, 135, 265, label13.getPreferredSize().height);
		label6.setText("Age:");
		label14.setBounds(240, 170, 260, label14.getPreferredSize().height);
		label7.setText("Inhabitable meters:");
		label15.setBounds(350, 205, 245, label15.getPreferredSize().height);
		label8.setText("Price:");
		label16.setBounds(250, 240, 315, label16.getPreferredSize().height);
		label9.setText("General Valuation:");
		label27.setBounds(335, 275, 240, label27.getPreferredSize().height);
	}
}
