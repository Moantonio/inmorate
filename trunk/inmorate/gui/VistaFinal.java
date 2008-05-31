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
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaFinal extends JFrame {

	private static final long serialVersionUID = -1712066431759792801L;
	private Controlador controlador;
	private Inmueble inmueble;
	private String valoracionGeneral;
	private boolean pulsado;
	private boolean ingles;
	private InmuebleValorado[] resultado;
	private int posicion;
	private int perfil; // 0 pareja, 1 matrimonio, 2 soltero, 3 soltera
	private boolean ordenado;
	private JScrollPane scrollPane1;
	private JList listInmueble;
	private JScrollPane scrollPane2;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
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
	
	public VistaFinal(Controlador control) throws MalformedURLException {
		controlador = control;
		inmueble = new Inmueble();
		valoracionGeneral = "";
		pulsado = false;
		resultado = null;
		posicion = -1;
		perfil = -1;
		ordenado = false;
		initComponents();
		ocultar();
		setSize(1152, 864);
		setLocation(0, 0);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Boton consulta
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				pulsado = false;
				ocultar();
				controlador.volverAtras();
			}
		} // ActionListener
				); // buttonConsulta.addActionListener

		// Boton salir
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				try {
					controlador.cerrarPrograma();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // ActionListener
				); // buttonCancelar.addActionListener

		// Botón mostrar ordenados
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ordenado) {
					controlador.ordenarIdent(perfil);
					if (!ingles)
						button3.setText("Ordenar por Valoración");
					else 
						button3.setText("Order for Valuation");
					
				} else {
					controlador.ordenarInmuebles(perfil);
					if (!ingles)
						button3.setText("Ordenar por Identif.");
					else
						button3.setText("Order for Identifier");
				}
				ordenado = !ordenado;
				mostrarResultados();
			}
		});

		// Evento para escribir los datos
		listInmueble.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				pulsado = true;
				ocultar();
				posicion = listInmueble.getSelectedIndex();
				// Coger Inmueble de valores y escribirlo
				inmueble = resultado[posicion].getInmueble();
				valoracionGeneral = String.valueOf(resultado[posicion].getValoracionGeneral().getValor());
				mostrarFuzzy();
				try {
					mostrar();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				pulsado = true;
				ocultar();
				posicion = listInmueble.getSelectedIndex();
				// Coger Inmueble de valores y escribirlo
				inmueble = resultado[posicion].getInmueble();
				valoracionGeneral = String.valueOf(resultado[posicion]
						.getValoracionGeneral().getValor());
				try {
					mostrar();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}

			public void mouseReleased(MouseEvent e) {
				pulsado = true;
				ocultar();
				posicion = listInmueble.getSelectedIndex();
				// Coger Inmueble de valores y escribirlo
				inmueble = resultado[posicion].getInmueble();
				valoracionGeneral = String.valueOf(resultado[posicion]
						.getValoracionGeneral().getValor());
				try {
					mostrar();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}

		} // ActionListener
				); // listInmueble.addActionListener

	}

	private void initComponents() {
		scrollPane1 = new JScrollPane();
		listInmueble = new JList();
		scrollPane2 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
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

		// ======== this ========
		setTitle("Valoración de los Inmuebles");
		setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== scrollPane1 ========
		{

			// ---- listInmueble ----
			listInmueble.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			listInmueble.setModel(new AbstractListModel() {
				private static final long serialVersionUID = -5032226955498747371L;

				String[] values = { "1", "2", "3", "4", "5", "6", "7", "8",
						"9", "10" };

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int i) {
					return values[i];
				}
			});
			scrollPane1.setViewportView(listInmueble);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(60, 35, 190, 255);

		// ======== scrollPane2 ========
		{
			scrollPane2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

			// ---- table1 ----
			table1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			table1.setModel(new DefaultTableModel(
					new Object[][] { { "Valoracion General", "" },
							{ "Valoracion Usuario", null },
							{ "Valoracion Experto", null },
							{ "Tipo de Inmueble", null },
							{ "Luminosidad", null }, 
							{ "Orientacion", null },
							{ "Representatividad", null },
							{ "Estado del Portal", null }, 
							{ "Fachada", null },
							{ "Vistas", null },
							{ "Numero Habitaciones", null },
							{ "Numero de Baños", null },
							{ "Antigüedad", null }, 
							{ "Altura", null },
							{ "Ascensor", null }, 
							{ "Plaza de Garaje", null },
							{ "Estado General", null },
							{ "Zonas Comunes", null },
							{ "Zona / Subzona", null },
							{ "Metros Construidos", null },
							{ "Metros Habitables", null },
							{ "Precio de Tasacion", null },
							{ "Precio de Salida", null },
							{ "Precio de Venta", null }, }, new String[] {
							"Caracteristicas", "Valor Fuzzy" }) {
				private static final long serialVersionUID = -8530411004681837159L;
			});
			table1.setRowHeight(29);
			scrollPane2.setViewportView(table1);
		}
		contentPane.add(scrollPane2);
		scrollPane2.setBounds(785, 55, 295, 715);

		// ---- button1 ----
		button1.setText("Nueva Consulta");
		button1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(button1);
		button1.setBounds(60, 300, 190, 30);

		// ---- button2 ----
		button2.setText("Salir del Programa");
		button2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(button2);
		button2.setBounds(60, 380, 190, 30);

		// ---- button3 ----
		button3.setText("Ordenar por Valoración");
		button3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(button3);
		button3.setBounds(60, 340, 190, 30);

		// ---- label1 ----
		label1.setText("Valoración");
		label1.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(350, 70), label1.getPreferredSize()));

		// ---- label28 ----
		label28.setText("de los");
		label28.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label28);
		label28.setBounds(new Rectangle(new Point(400, 170), label28.getPreferredSize()));

		// ---- label29 ----
		label29.setText("Inmuebles");
		label29.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		contentPane.add(label29);
		label29.setBounds(new Rectangle(new Point(350, 270), label29.getPreferredSize()));

		// ---- label30 ----
		label30.setText("(Pinche en su identificador para ver el Inmueble)");
		label30.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		contentPane.add(label30);
		label30.setBounds(new Rectangle(new Point(345, 350), label30
				.getPreferredSize()));

		// ---- label2 ----
		label2.setText("Tipo de Inmueble:");
		label2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label2);
		label2.setBounds(315, 60, 260, label2.getPreferredSize().height);

		// ---- label3 ----
		label3.setText("Zona:");
		label3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label3);
		label3.setBounds(315, 95, 335, label3.getPreferredSize().height);

		// ---- label4 ----
		label4.setText("Dirección:");
		label4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label4);
		label4.setBounds(315, 130, 255, label4.getPreferredSize().height);

		// ---- label5 ----
		label5.setText("Planta:");
		label5.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label5);
		label5.setBounds(315, 165, 215, label5.getPreferredSize().height);

		// ---- label6 ----
		label6.setText("Antigüedad:");
		label6.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label6);
		label6.setBounds(315, 200, 330, label6.getPreferredSize().height);

		// ---- label7 ----
		label7.setText("Metros Habitables:");
		label7.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label7);
		label7.setBounds(315, 235, 330, label7.getPreferredSize().height);

		// ---- label8 ----
		label8.setText("Precio:");
		label8.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label8);
		label8.setBounds(315, 270, 330, label8.getPreferredSize().height);

		// ---- label9 ----
		label9.setText("Valoración General:");
		label9.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(label9);
		label9.setBounds(315, 305, 330, label9.getPreferredSize().height);

		// ---- label10 ----
		label10.setText("- - - - - - - - - - - - -");
		label10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label10);
		label10.setBounds(445, 60, 265, label10.getPreferredSize().height);

		// ---- label11 ----
		label11.setText("- - - - - - - - - - - - -");
		label11.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label11);
		label11.setBounds(360, 95, 255, label11.getPreferredSize().height);

		// ---- label12 ----
		label12.setText("- - - - - - - - - - - - -");
		label12.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label12);
		label12.setBounds(390, 130, 330, label12.getPreferredSize().height);

		// ---- label13 ----
		label13.setText("- - - - - - - - - - - - -");
		label13.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label13);
		label13.setBounds(365, 165, 265, label13.getPreferredSize().height);

		// ---- label14 ----
		label14.setText("- - - - - - - - - - - - -");
		label14.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label14);
		label14.setBounds(400, 200, 260, label14.getPreferredSize().height);

		// ---- label15 ----
		label15.setText("- - - - - - - - - - - - -");
		label15.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label15);
		label15.setBounds(450, 235, 245, label15.getPreferredSize().height);

		// ---- label16 ----
		label16.setText("- - - - - - - - - - - - -");
		label16.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label16);
		label16.setBounds(365, 270, 315, label16.getPreferredSize().height);

		// ---- label17 ----
		label17.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label17);
		label17.setBounds(315, 335, 40, 53);

		// ---- label18 ----
		label18.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label18);
		label18.setBounds(355, 335, 40, 53);

		// ---- label19 ----
		label19.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label19);
		label19.setBounds(395, 335, 40, 53);

		// ---- label20 ----
		label20.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label20);
		label20.setBounds(435, 335, 40, 53);

		// ---- label21 ----
		label21.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label21);
		label21.setBounds(475, 335, 40, 53);

		// ---- label22 ----
		label22.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label22);
		label22.setBounds(515, 335, 40, 53);

		// ---- label23 ----
		label23.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label23);
		label23.setBounds(555, 335, 40, 53);

		// ---- label24 ----
		label24.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label24);
		label24.setBounds(595, 335, 40, 53);

		// ---- label25 ----
		label25.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label25);
		label25.setBounds(635, 335, 40, 53);

		// ---- label26 ----
		label26.setIcon(new ImageIcon("./imagenes/casas/0.0.jpg"));
		contentPane.add(label26);
		label26.setBounds(675, 335, 40, 53);

		// ---- label27 ----
		label27.setText("- - - - - - - - - - - -");
		label27.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label27);
		label27.setBounds(450, 305, 240, label27.getPreferredSize().height);

		// ---- label32 ----
		label32.setText("Busqueda basada en el perfil");
		label32.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(label32);
		label32.setBounds(60, 435, 710, label32.getPreferredSize().height);

		// ---- label33 ----
		label33.setText("Dormitorios");
		label33.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label33);
		label33.setBounds(60, 480, 135, label33.getPreferredSize().height);

		// ---- label34 ----
		label34.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.jpg"));
		contentPane.add(label34);
		label34.setBounds(195, 480, 173, 100);

		// ---- label35 ----
		label35.setText("Plaza de Garage");
		label35.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label35);
		label35.setBounds(60, 595, 125, label35.getPreferredSize().height);

		// ---- label36 ----
		label36.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		contentPane.add(label36);
		label36.setBounds(195, 595, 173, 100);

		// ---- label37 ----
		label37.setText("Luminosidad");
		label37.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label37);
		label37.setBounds(430, 480, 115, label37.getPreferredSize().height);

		// ---- label38 ----
		label38.setIcon(new ImageIcon("./imagenes/fuzzy/ValoracionP.JPG"));
		contentPane.add(label38);
		label38.setBounds(565, 480, 173, 100);

		// ---- label39 ----
		label39.setText("Zonas Comunes");
		label39.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label39);
		label39.setBounds(430, 595, 115, label39.getPreferredSize().height);

		// ---- label40 ----
		label40.setIcon(new ImageIcon("./imagenes/fuzzy/BooleanoP.JPG"));
		contentPane.add(label40);
		label40.setBounds(565, 595, 173, 100);

		// ---- label41 ----
		label41.setText("Tipo de Inmueble");
		label41.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label41);
		label41.setBounds(255, 710, 130, label41.getPreferredSize().height);

		// ---- label42 ----
		label42.setIcon(new ImageIcon("./imagenes/fuzzy/TipoInmuebleP.JPG"));
		contentPane.add(label42);
		label42.setBounds(390, 710, 173, 100);

		contentPane.setPreferredSize(new Dimension(1150, 865));
	}

	private void mostrarFuzzy() {
		table1.setModel(new DefaultTableModel(
				new Object[][] {
						{
								"Valoracion General",
								resultado[posicion].getValoracionGeneral()
										.fuzzy() },
						{
								"Valoracion Usuario",
								resultado[posicion].getValoracionUsuario()
										.fuzzy() },
						{
								"Valoracion Experto",
								resultado[posicion].getValoracionExperto()
										.fuzzy() },
						{
								"Tipo de Inmueble",
								resultado[posicion].getValoraciones()[0]
										.fuzzy() },
						{
								"Luminosidad",
								resultado[posicion].getValoraciones()[1]
										.fuzzy() },
						{
								"Orientacion",
								resultado[posicion].getValoraciones()[2]
										.fuzzy() },
						{
								"Representatividad",
								resultado[posicion].getValoraciones()[3]
										.fuzzy() },
						{
								"Estado del Portal",
								resultado[posicion].getValoraciones()[4]
										.fuzzy() },
						{
								"Fachada",
								resultado[posicion].getValoraciones()[5]
										.fuzzy() },
						{
								"Vistas",
								resultado[posicion].getValoraciones()[6]
										.fuzzy() },
						{
								"Numero Habitaciones",
								resultado[posicion].getValoraciones()[7]
										.fuzzy() },
						{
								"Numero de Baños",
								resultado[posicion].getValoraciones()[8]
										.fuzzy() },
						{
								"Antigüedad",
								resultado[posicion].getValoraciones()[9]
										.fuzzy() },
						{
								"Altura",
								resultado[posicion].getValoraciones()[10]
										.fuzzy() },
						{
								"Ascensor",
								resultado[posicion].getValoraciones()[11]
										.fuzzy() },
						{
								"Plaza de Garaje",
								resultado[posicion].getValoraciones()[12]
										.fuzzy() },
						{
								"Estado General",
								resultado[posicion].getValoraciones()[13]
										.fuzzy() },
						{
								"Zonas Comunes",
								resultado[posicion].getValoraciones()[14]
										.fuzzy() },
						{
								"Zona / Subzona",
								resultado[posicion].getValoraciones()[15]
										.fuzzy() },
						{
								"Metros Construidos",
								resultado[posicion].getValoraciones()[16]
										.fuzzy() },
						{
								"Metros Habitables",
								resultado[posicion].getValoraciones()[17]
										.fuzzy() },
						{
								"Precio de Tasacion",
								resultado[posicion].getValoraciones()[18]
										.fuzzy() },
						{
								"Precio de Salida",
								resultado[posicion].getValoraciones()[19]
										.fuzzy() },
						{
								"Precio de Venta",
								resultado[posicion].getValoraciones()[20]
										.fuzzy() }, }, new String[] {
						"Caracteristicas", "Valor Fuzzy" }) {
			private static final long serialVersionUID = -8530411004681837159L;
		});
	}

	private void mostrar() throws MalformedURLException {
		label10.setText(inmueble.getTipoDeInmueble());
		label11.setText(inmueble.getZona());
		label12.setText(inmueble.getDireccion());
		label13.setText(String.valueOf(inmueble.getAltura()) + "º");
		if (!ingles)
			label14.setText(String.valueOf(inmueble.getAntiguedad()) + " años");
		else
			label14
					.setText(String.valueOf(inmueble.getAntiguedad())
							+ " years");
		if (!ingles)
			label15.setText(String.valueOf(inmueble.getMetrosHabitables())
					+ " metros");
		else
			label15.setText(String.valueOf(inmueble.getMetrosHabitables())
					+ " metres");
		label16.setText(inmueble.getPrecioSalida() + " €");
		label27.setText(valoracionGeneral.substring(0, 6));
		mostrarEstrellas();
	}

	private void ocultar() {
		if (pulsado) {
			label1.setVisible(false);
			label2.setVisible(true);
			label3.setVisible(true);
			label4.setVisible(true);
			label5.setVisible(true);
			label6.setVisible(true);
			label7.setVisible(true);
			label8.setVisible(true);
			label9.setVisible(true);
			label10.setVisible(true);
			label11.setVisible(true);
			label12.setVisible(true);
			label13.setVisible(true);
			label14.setVisible(true);
			label15.setVisible(true);
			label16.setVisible(true);
			label17.setVisible(true);
			label18.setVisible(true);
			label19.setVisible(true);
			label20.setVisible(true);
			label21.setVisible(true);
			label22.setVisible(true);
			label23.setVisible(true);
			label24.setVisible(true);
			label25.setVisible(true);
			label26.setVisible(true);
			label27.setVisible(true);
			label28.setVisible(false);
			label29.setVisible(false);
			label30.setVisible(false);
		} else {
			label1.setVisible(true);
			label2.setVisible(false);
			label3.setVisible(false);
			label4.setVisible(false);
			label5.setVisible(false);
			label6.setVisible(false);
			label7.setVisible(false);
			label8.setVisible(false);
			label9.setVisible(false);
			label10.setVisible(false);
			label11.setVisible(false);
			label12.setVisible(false);
			label13.setVisible(false);
			label14.setVisible(false);
			label15.setVisible(false);
			label16.setVisible(false);
			label17.setVisible(false);
			label18.setVisible(false);
			label19.setVisible(false);
			label20.setVisible(false);
			label21.setVisible(false);
			label22.setVisible(false);
			label23.setVisible(false);
			label24.setVisible(false);
			label25.setVisible(false);
			label26.setVisible(false);
			label27.setVisible(false);
			label28.setVisible(true);
			label29.setVisible(true);
			label30.setVisible(true);
		}
	}

	private void mostrarEstrellas() throws MalformedURLException {
		String primera = valoracionGeneral.substring(0, 1);
		int primero = Integer.valueOf(primera);
		String segunda = valoracionGeneral.substring(2, 3);
		int segundo = Integer.valueOf(segunda);
		String punto = valoracionGeneral.substring(1, 2);
		if (punto.equals(".")) {
			switch (primero) {
			case 0:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label17.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 1:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label18.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 2:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label19.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 3:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label20.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 4:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label21.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 5:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label22.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 6:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label23.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 7:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label24.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 8:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label25.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			case 9:
				label17.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label18.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label19.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label20.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label21.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label22.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label23.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label24.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label25.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/1.0.jpg")));
				label26.setIcon(new ImageIcon(new URL(
						"file:./imagenes/casas/0.0.jpg")));
				switch (segundo) {
				case 0:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.0.jpg")));
					break;
				case 1:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.1.jpg")));
					break;
				case 2:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.2.jpg")));
					break;
				case 3:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.3.jpg")));
					break;
				case 4:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.4.jpg")));
					break;
				case 5:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.5.jpg")));
					break;
				case 6:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.6.jpg")));
					break;
				case 7:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.7.jpg")));
					break;
				case 8:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.8.jpg")));
					break;
				case 9:
					label26.setIcon(new ImageIcon(new URL(
							"file:./imagenes/casas/0.9.jpg")));
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		} else {
			label17.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label18.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label19.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label20.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label21.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label22.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label23.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label24.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label25.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
			label26.setIcon(new ImageIcon(new URL("file:./imagenes/casas/1.0.jpg")));
		}
	}

	public void traducirEspanol() {
		ingles = false;
		setTitle("Valoración de los Inmuebles");
		button1.setText("Nueva Consulta");
		button2.setText("Salir del Programa");
		button3.setText("Ordenar por Valoración");
		label1.setText("Valoración");
		label1.setBounds(new Rectangle(new Point(350, 70), label1.getPreferredSize()));
		label28.setText("de los");
		label28.setBounds(new Rectangle(new Point(400, 170), label28.getPreferredSize()));
		label28.setVisible(true);
		label29.setText("Inmuebles");
		label29.setBounds(new Rectangle(new Point(350, 270), label29.getPreferredSize()));
		label30.setText("(Pinche en su identificador para ver el Inmueble)");
		label30.setBounds(new Rectangle(new Point(345, 350), label30.getPreferredSize()));
		label2.setText("Tipo de Inmueble:");
		label10.setBounds(445, 60, 265, label10.getPreferredSize().height);
		label3.setText("Zona:");
		label4.setText("Dirección:");
		label5.setText("Planta:");
		label13.setBounds(365, 165, 265, label13.getPreferredSize().height);
		label6.setText("Antigüedad:");
		label14.setBounds(400, 200, 260, label14.getPreferredSize().height);
		label7.setText("Metros Habitables:");
		label15.setBounds(450, 235, 245, label15.getPreferredSize().height);
		label8.setText("Precio:");
		label16.setBounds(365, 270, 315, label16.getPreferredSize().height);
		label9.setText("Valoración General:");
		label27.setBounds(450, 305, 240, label27.getPreferredSize().height);
		table1.setModel(new DefaultTableModel(new Object[][] {
				{ "Valoracion General", "" }, 
				{ "Valoracion Usuario", null },
				{ "Valoracion Experto", null }, 
				{ "Tipo de Inmueble", null },
				{ "Luminosidad", null }, 
				{ "Orientacion", null },
				{ "Representatividad", null }, 
				{ "Estado del Portal", null },
				{ "Fachada", null }, 
				{ "Vistas", null },
				{ "Numero Habitaciones", null }, 
				{ "Numero de Baños", null },
				{ "Antigüedad", null }, 
				{ "Altura", null },
				{ "Ascensor", null }, 
				{ "Plaza de Garaje", null },
				{ "Estado General", null }, 
				{ "Zonas Comunes", null },
				{ "Zona / Subzona", null }, 
				{ "Metros Construidos", null },
				{ "Metros Habitables", null }, 
				{ "Precio de Tasacion", null },
				{ "Precio de Salida", null }, 
				{ "Precio de Venta", null }, },
				new String[] { "Caracteristicas", "Valor Fuzzy" }) {
			private static final long serialVersionUID = -8530411004681837159L;
		});
	}

	public void traducirIngles() {
		ingles = true;
		setTitle("Buildings Valuation");

		button1.setText("New Query");
		button2.setText("Exit");
		button3.setText("Order for Valuation");

		label1.setText("Buildings");
		label1.setBounds(new Rectangle(new Point(350, 120), label1.getPreferredSize()));
		label28.setVisible(false);
		label29.setText("Valuation");
		label29.setBounds(new Rectangle(new Point(350, 220), label29.getPreferredSize()));
		label30.setText("  (Click on your identifier to see the building) ");
		label30.setBounds(new Rectangle(new Point(345, 300), label30.getPreferredSize()));

		label2.setText("Type of building:");
		label10.setBounds(434, 60, 265, label10.getPreferredSize().height);
		label3.setText("Zone:");
		label4.setText("Direction:");
		label5.setText("Height (Floor):");
		label13.setBounds(422, 165, 265, label13.getPreferredSize().height);
		label6.setText("Age:");
		label14.setBounds(350, 200, 260, label14.getPreferredSize().height);
		label7.setText("Inhabitable meters:");
		label15.setBounds(455, 235, 245, label15.getPreferredSize().height);
		label8.setText("Price:");
		label16.setBounds(358, 270, 315, label16.getPreferredSize().height);
		label9.setText("General Valuation:");
		label27.setBounds(445, 305, 240, label27.getPreferredSize().height);
		table1.setModel(new DefaultTableModel(new Object[][] {
				{ "General Valuation", "" }, 
				{ "User Valuation", null },
				{ "Expert Valuation", null }, 
				{ "Type of building", null },
				{ "Luminosity", null }, 
				{ "Orientation", null },
				{ "Representativeness", null }, 
				{ "State of the entrace hall", null },
				{ "Facade", null }, 
				{ "Views", null },
				{ "Number of rooms", null }, 
				{ "Number of baths", null },
				{ "Age", null }, 
				{ "Height (Floor)", null },
				{ "Elevator", null }, 
				{ "Car park", null },
				{ "General State", null }, 
				{ "Common zones", null },
				{ "Zone / Subzone", null }, 
				{ "Meters Constructed", null },
				{ "Inhabitable meters", null }, 
				{ "Assessment Price", null },
				{ "Starting Price", null }, 
				{ "Sale Price", null }, },
				new String[] { "Characteristics", "Value Fuzzy" }) {
			private static final long serialVersionUID = -8530411004681837159L;
		});
	}

	public void mostrarResultados() {
		resultado = controlador.getResultado();
		String array[] = new String[resultado.length];
		for (int i = 0; i < resultado.length; i++) {
			array[i] = "   " + resultado[i].getInmueble().getDMXX();
		}
		listInmueble.setListData(array);
	}

	public void pareja() {
		perfil = 0;
		ordenado = false;
		button3.setText("Ordenar por Valoración");
		label32.setText("Busqueda basada en el perfil pareja joven sin hijos");
		label32.setBounds(60, 455, 710, label32.getPreferredSize().height);
		label33.setText("Zona");
		label33.setBounds(60, 530, 135, label33.getPreferredSize().height);
		label34.setIcon(new ImageIcon("./imagenes/fuzzy/ValoracionP.jpg"));
		label34.setBounds(195, 530, 173, 100);
		label35.setText("Dormitorios");
		label35.setBounds(60, 685, 125, label35.getPreferredSize().height);
		label36.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		label36.setBounds(195, 685, 173, 100);
		label37.setText("Plaza de Garage");
		label37.setBounds(430, 530, 115, label37.getPreferredSize().height);
		label38.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		label38.setBounds(565, 530, 173, 100);
		label39.setText("Precio");
		label39.setBounds(430, 685, 115, label39.getPreferredSize().height);
		label40.setIcon(new ImageIcon("./imagenes/fuzzy/PrecioP.JPG"));
		label40.setBounds(565, 685, 173, 100);
		label41.setVisible(false);
		label42.setVisible(false);
		if (ingles) {
			button3.setText("Order for Valuation");
			label32.setText("Search based on the profile young couple with no children");
			label33.setText("Zone");
			label35.setText("Rooms");
			label37.setText("Car park");
			label39.setText("Price");
			label28.setVisible(false);
		}
	}

	public void matrimonio() {
		perfil = 1;
		ordenado = false;
		button3.setText("Ordenar por Valoración");
		label32.setText("Busqueda basada en el perfil matrimonio con dos / tres hijos");
		label32.setBounds(60, 435, 710, label32.getPreferredSize().height);
		label33.setText("Dormitorios");
		label33.setBounds(60, 480, 135, label33.getPreferredSize().height);
		label34.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.jpg"));
		label34.setBounds(195, 480, 173, 100);
		label35.setText("Plaza de Garage");
		label35.setBounds(60, 595, 125, label35.getPreferredSize().height);
		label36.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		label36.setBounds(195, 595, 173, 100);
		label37.setText("Luminosidad");
		label37.setBounds(430, 480, 115, label37.getPreferredSize().height);
		label38.setIcon(new ImageIcon("./imagenes/fuzzy/ValoracionP.JPG"));
		label38.setBounds(565, 480, 173, 100);
		label39.setText("Zonas Comunes");
		label39.setBounds(430, 595, 115, label39.getPreferredSize().height);
		label40.setIcon(new ImageIcon("./imagenes/fuzzy/BooleanoP.JPG"));
		label40.setBounds(565, 595, 173, 100);
		label41.setVisible(true);
		label42.setVisible(true);
		if (ingles) {
			button3.setText("Order for Valuation");
			label32.setText("Search based on the profile marriage with two / three children");
			label33.setText("Rooms");
			label37.setText("Luminosity");
			label35.setText("Car park");
			label39.setText("Common zones");
			label41.setText("Type of building");
			label28.setVisible(false);
		}
	}

	public void soltero() {
		perfil = 2;
		ordenado = false;
		button3.setText("Ordenar por Valoración");
		label32.setText("Busqueda basada en el perfil soltero");
		label32.setBounds(60, 455, 710, label32.getPreferredSize().height);
		label33.setText("Tipo de Inmueble");
		label33.setBounds(60, 530, 135, label33.getPreferredSize().height);
		label34.setIcon(new ImageIcon("./imagenes/fuzzy/TipoInmuebleP.jpg"));
		label34.setBounds(195, 530, 173, 100);
		label35.setText("Plaza de Garaje");
		label35.setBounds(60, 685, 125, label35.getPreferredSize().height);
		label36.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		label36.setBounds(195, 685, 173, 100);
		label37.setText("Zona");
		label37.setBounds(430, 530, 115, label37.getPreferredSize().height);
		label38.setIcon(new ImageIcon("./imagenes/fuzzy/ValoracionP.JPG"));
		label38.setBounds(565, 530, 173, 100);
		label39.setText("Precio");
		label39.setBounds(430, 685, 115, label39.getPreferredSize().height);
		label40.setIcon(new ImageIcon("./imagenes/fuzzy/PrecioP.JPG"));
		label40.setBounds(565, 685, 173, 100);
		label41.setVisible(false);
		label42.setVisible(false);
		if (ingles) {
			button3.setText("Order for Valuation");
			label32.setText("Search based on the profile single man");
			label33.setText("Type of building");
			label35.setText("Car park");
			label37.setText("Zone");
			label39.setText("Price");
			label28.setVisible(false);
		}
	}

	public void soltera() {
		perfil = 3;
		ordenado = false;
		button3.setText("Ordenar por Valoración");
		label32.setText("Busqueda basada en el perfil soltera");
		label32.setBounds(60, 455, 710, label32.getPreferredSize().height);
		label33.setText("Dormitorios");
		label33.setBounds(60, 530, 135, label33.getPreferredSize().height);
		label34.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.jpg"));
		label34.setBounds(195, 530, 173, 100);
		label35.setText("Plaza de Garaje");
		label35.setBounds(60, 685, 125, label35.getPreferredSize().height);
		label36.setIcon(new ImageIcon("./imagenes/fuzzy/NumeroP.JPG"));
		label36.setBounds(195, 685, 173, 100);
		label37.setText("Luminosidad");
		label37.setBounds(430, 530, 115, label37.getPreferredSize().height);
		label38.setIcon(new ImageIcon("./imagenes/fuzzy/ValoracionP.JPG"));
		label38.setBounds(565, 530, 173, 100);
		label39.setText("Ascensor");
		label39.setBounds(430, 685, 115, label39.getPreferredSize().height);
		label40.setIcon(new ImageIcon("./imagenes/fuzzy/BooleanoP.JPG"));
		label40.setBounds(565, 685, 173, 100);
		label41.setVisible(false);
		label42.setVisible(false);
		if (ingles) {
			button3.setText("Order for Valuation");
			label32.setText("Search based on the profile single woman");
			label33.setText("Rooms");
			label37.setText("Luminosity");
			label35.setText("Car park");
			label39.setText("Elevator");
			label28.setVisible(false);
		}
	}
}