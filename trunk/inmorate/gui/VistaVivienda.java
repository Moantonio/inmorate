package inmorate.gui;

import inmorate.controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Dec 30 16:41:24 CET 2007
 */



/**
 * @author User #3
 */
public class VistaVivienda extends JDialog {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7915590254871824663L;
	
	private Controlador controlador;
	
	public VistaVivienda(Controlador control) {
		this.controlador = control;
		initComponents();
		setSize(900,665);
		setVisible(false);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		buttonSalir.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.cerrarPrograma();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menuItem3 = new JMenuItem();
		menu2 = new JMenu();
		menuItem4 = new JMenuItem();
		menuItem5 = new JMenuItem();
		menuItem6 = new JMenuItem();
		menuItem7 = new JMenuItem();
		menuItem8 = new JMenuItem();
		menuItem9 = new JMenuItem();
		menu3 = new JMenu();
		buttonConsulta = new JButton();
		buttonSalir = new JButton();
		labelTitulo = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		scrollPaneInmueble = new JScrollPane();
		listInmuelble = new JList();
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
		scrollPane1 = new JScrollPane();
		textPane1 = new JTextPane();
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
		label57 = new JLabel();
		label58 = new JLabel();
		label59 = new JLabel();
		label60 = new JLabel();
		label61 = new JLabel();
		label62 = new JLabel();
		label63 = new JLabel();
		label64 = new JLabel();
		label65 = new JLabel();
		label66 = new JLabel();
		label67 = new JLabel();
		label68 = new JLabel();
		label69 = new JLabel();
		label70 = new JLabel();
		label71 = new JLabel();
		label72 = new JLabel();
		label73 = new JLabel();
		label74 = new JLabel();
		label75 = new JLabel();
		label76 = new JLabel();
		label77 = new JLabel();
		label78 = new JLabel();
		label79 = new JLabel();
		label80 = new JLabel();
		label81 = new JLabel();
		label82 = new JLabel();
		label83 = new JLabel();
		label84 = new JLabel();
		label85 = new JLabel();
		label86 = new JLabel();
		label87 = new JLabel();
		label88 = new JLabel();
		label89 = new JLabel();
		label90 = new JLabel();
		label91 = new JLabel();
		label92 = new JLabel();
		label93 = new JLabel();
		label94 = new JLabel();
		label95 = new JLabel();
		label96 = new JLabel();
		label97 = new JLabel();
		label98 = new JLabel();
		label99 = new JLabel();
		label100 = new JLabel();
		label101 = new JLabel();
		label102 = new JLabel();
		label103 = new JLabel();
		label104 = new JLabel();
		label105 = new JLabel();
		label106 = new JLabel();
		label107 = new JLabel();
		label108 = new JLabel();
		label109 = new JLabel();
		label110 = new JLabel();
		label111 = new JLabel();
		label113 = new JLabel();
		label114 = new JLabel();
		label115 = new JLabel();
		label116 = new JLabel();
		label117 = new JLabel();
		label118 = new JLabel();
		label119 = new JLabel();
		label120 = new JLabel();
		label121 = new JLabel();
		label122 = new JLabel();
		label123 = new JLabel();
		label124 = new JLabel();
		label127 = new JLabel();
		scrollPane2 = new JScrollPane();
		textPane2 = new JTextPane();

		//======== this ========
		setTitle("Valores Inmuebles");
		setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== menuBar1 ========
		{
			
			//======== menu1 ========
			{
				menu1.setText("Personal");
				menu1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				
				//---- menuItem1 ----
				menuItem1.setText("Clientes");
				menuItem1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu1.add(menuItem1);
				
				//---- menuItem2 ----
				menuItem2.setText("Colaborador");
				menuItem2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu1.add(menuItem2);
				
				//---- menuItem3 ----
				menuItem3.setText("Comercial");
				menuItem3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu1.add(menuItem3);
			}
			menuBar1.add(menu1);
			
			//======== menu2 ========
			{
				menu2.setText("Viviendas");
				menu2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				
				//---- menuItem4 ----
				menuItem4.setText("Finca");
				menuItem4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem4);
				
				//---- menuItem5 ----
				menuItem5.setText("Local Comercial");
				menuItem5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem5);
				
				//---- menuItem6 ----
				menuItem6.setText("Oficina");
				menuItem6.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem6);
				
				//---- menuItem7 ----
				menuItem7.setText("Otros");
				menuItem7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem7);
				
				//---- menuItem8 ----
				menuItem8.setText("Vivienda");
				menuItem8.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem8);
				
				//---- menuItem9 ----
				menuItem9.setText("Todas");
				menuItem9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
				menu2.add(menuItem9);
			}
			menuBar1.add(menu2);
			
			//======== menu3 ========
			{
				menu3.setText("Relaciones");
				menu3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
			}
			menuBar1.add(menu3);
		}
		contentPane.add(menuBar1);
		menuBar1.setBounds(new Rectangle(new Point(0, 0), menuBar1.getPreferredSize()));

		//---- buttonConsulta ----
		buttonConsulta.setText("Nueva Consulta");
		buttonConsulta.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonConsulta.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonConsulta);
		buttonConsulta.setBounds(40, 490, 160, 40);

		//---- buttonSalir ----
		buttonSalir.setText("Salir del Programa");
		buttonSalir.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonSalir.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonSalir);
		buttonSalir.setBounds(40, 560, 160, 40);

		//---- labelTitulo ----
		labelTitulo.setText("Ficha del Inmueble");
		labelTitulo.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(new Rectangle(new Point(365, 45), labelTitulo.getPreferredSize()));

		//---- label1 ----
		label1.setText("DM-XX:");
		label1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(230, 105), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("- - - - - -");
		label2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(280, 105), label2.getPreferredSize()));

		//======== scrollPaneInmueble ========
		{
			
			//---- listInmuelble ----
			listInmuelble.setVisibleRowCount(1000000);
			listInmuelble.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
			scrollPaneInmueble.setViewportView(listInmuelble);
		}
		contentPane.add(scrollPaneInmueble);
		scrollPaneInmueble.setBounds(40, 75, 160, 385);

		//---- label3 ----
		label3.setText("Descripci\u00f3n:");
		label3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(460, 100), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("Tipo de Inmueble:");
		label4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(230, 125), label4.getPreferredSize()));

		//---- label5 ----
		label5.setText("Comercial Responsable:");
		label5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(230, 145), label5.getPreferredSize()));

		//---- label6 ----
		label6.setText("Precio de Salida:");
		label6.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label6);
		label6.setBounds(new Rectangle(new Point(230, 245), label6.getPreferredSize()));

		//---- label7 ----
		label7.setText("Fecha de Entrada:");
		label7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label7);
		label7.setBounds(new Rectangle(new Point(230, 205), label7.getPreferredSize()));

		//---- label8 ----
		label8.setText("Vendido:");
		label8.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label8);
		label8.setBounds(new Rectangle(new Point(230, 165), label8.getPreferredSize()));

		//---- label9 ----
		label9.setText("Fecha de Venta:");
		label9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label9);
		label9.setBounds(new Rectangle(new Point(460, 245), label9.getPreferredSize()));

		//---- label10 ----
		label10.setText("Precio de Venta:");
		label10.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label10);
		label10.setBounds(new Rectangle(new Point(675, 245), label10.getPreferredSize()));

		//---- label11 ----
		label11.setText("Mts. construidos:");
		label11.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label11);
		label11.setBounds(new Rectangle(new Point(230, 265), label11.getPreferredSize()));

		//---- label12 ----
		label12.setText("Mts. habitables:");
		label12.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label12);
		label12.setBounds(new Rectangle(new Point(460, 265), label12.getPreferredSize()));

		//---- label13 ----
		label13.setText("Mts. hall entrada:");
		label13.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label13);
		label13.setBounds(new Rectangle(new Point(675, 265), label13.getPreferredSize()));

		//---- label14 ----
		label14.setText("Amueblado:");
		label14.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label14);
		label14.setBounds(new Rectangle(new Point(230, 285), label14.getPreferredSize()));

		//---- label15 ----
		label15.setText("Terraza / Jard\u00edn / Patio:");
		label15.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label15);
		label15.setBounds(new Rectangle(new Point(230, 365), label15.getPreferredSize()));

		//---- label16 ----
		label16.setText("Metros Sal\u00f3n:");
		label16.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label16);
		label16.setBounds(new Rectangle(new Point(460, 285), label16.getPreferredSize()));

		//---- label17 ----
		label17.setText("Sal\u00f3n Independiente:");
		label17.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label17);
		label17.setBounds(new Rectangle(new Point(675, 285), label17.getPreferredSize()));

		//---- label18 ----
		label18.setText("N\u00ba Dormitorios:");
		label18.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label18);
		label18.setBounds(new Rectangle(new Point(230, 305), label18.getPreferredSize()));

		//---- label19 ----
		label19.setText("N\u00ba Armarios Empotrados:");
		label19.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label19);
		label19.setBounds(new Rectangle(new Point(675, 345), label19.getPreferredSize()));

		//---- label20 ----
		label20.setText("Mts. Dormitorio Principal:");
		label20.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label20);
		label20.setBounds(new Rectangle(new Point(460, 305), label20.getPreferredSize()));

		//---- label21 ----
		label21.setText("Obs. Dormitorio Principal:");
		label21.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label21);
		label21.setBounds(new Rectangle(new Point(675, 305), label21.getPreferredSize()));

		//---- label22 ----
		label22.setText("Mts. Segundo Dormitorio:");
		label22.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label22);
		label22.setBounds(new Rectangle(new Point(230, 325), label22.getPreferredSize()));

		//======== scrollPane1 ========
		{
			
			//---- textPane1 ----
			textPane1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
			textPane1.setEditable(false);
			scrollPane1.setViewportView(textPane1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(540, 100, 310, 65);

		//---- label23 ----
		label23.setText("Mts. Tercer Dormitorio:");
		label23.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label23);
		label23.setBounds(new Rectangle(new Point(460, 325), label23.getPreferredSize()));

		//---- label24 ----
		label24.setText("Mts. Cuarto Dormitorio:");
		label24.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label24);
		label24.setBounds(new Rectangle(new Point(675, 325), label24.getPreferredSize()));

		//---- label25 ----
		label25.setText("Mts. Dormitorio de Servicio:");
		label25.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label25);
		label25.setBounds(new Rectangle(new Point(230, 345), label25.getPreferredSize()));

		//---- label26 ----
		label26.setText("- - - - - -");
		label26.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label26);
		label26.setBounds(new Rectangle(new Point(340, 125), label26.getPreferredSize()));

		//---- label27 ----
		label27.setText("- - - - - -");
		label27.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label27);
		label27.setBounds(new Rectangle(new Point(375, 145), label27.getPreferredSize()));

		//---- label28 ----
		label28.setText("- - - - - -");
		label28.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label28);
		label28.setBounds(new Rectangle(new Point(335, 245), label28.getPreferredSize()));

		//---- label29 ----
		label29.setText("- - - - - -");
		label29.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label29);
		label29.setBounds(new Rectangle(new Point(345, 205), label29.getPreferredSize()));

		//---- label30 ----
		label30.setText("- - - - - -");
		label30.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label30);
		label30.setBounds(new Rectangle(new Point(290, 165), label30.getPreferredSize()));

		//---- label31 ----
		label31.setText("- - - - - -");
		label31.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label31);
		label31.setBounds(new Rectangle(new Point(560, 245), label31.getPreferredSize()));

		//---- label32 ----
		label32.setText("- - - - - -");
		label32.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label32);
		label32.setBounds(new Rectangle(new Point(775, 245), label32.getPreferredSize()));

		//---- label33 ----
		label33.setText("- - - - - -");
		label33.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label33);
		label33.setBounds(new Rectangle(new Point(330, 265), label33.getPreferredSize()));

		//---- label34 ----
		label34.setText("- - - - - -");
		label34.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label34);
		label34.setBounds(new Rectangle(new Point(555, 265), label34.getPreferredSize()));

		//---- label35 ----
		label35.setText("- - - - - -");
		label35.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label35);
		label35.setBounds(new Rectangle(new Point(775, 265), label35.getPreferredSize()));

		//---- label36 ----
		label36.setText("- - - - - -");
		label36.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label36);
		label36.setBounds(new Rectangle(new Point(305, 285), label36.getPreferredSize()));

		//---- label37 ----
		label37.setText("- - - - - -");
		label37.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label37);
		label37.setBounds(new Rectangle(new Point(365, 365), label37.getPreferredSize()));

		//---- label38 ----
		label38.setText("- - - - - -");
		label38.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label38);
		label38.setBounds(new Rectangle(new Point(545, 285), label38.getPreferredSize()));

		//---- label39 ----
		label39.setText("- - - - - -");
		label39.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label39);
		label39.setBounds(new Rectangle(new Point(800, 285), label39.getPreferredSize()));

		//---- label40 ----
		label40.setText("- - - - - -");
		label40.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label40);
		label40.setBounds(new Rectangle(new Point(325, 305), label40.getPreferredSize()));

		//---- label41 ----
		label41.setText("- - - - - -");
		label41.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label41);
		label41.setBounds(new Rectangle(new Point(825, 345), label41.getPreferredSize()));

		//---- label42 ----
		label42.setText("- - - - - -");
		label42.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label42);
		label42.setBounds(new Rectangle(new Point(605, 305), label42.getPreferredSize()));

		//---- label43 ----
		label43.setText("- - - - - -");
		label43.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label43);
		label43.setBounds(new Rectangle(new Point(825, 305), label43.getPreferredSize()));

		//---- label44 ----
		label44.setText("- - - - - -");
		label44.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label44);
		label44.setBounds(new Rectangle(new Point(375, 325), label44.getPreferredSize()));

		//---- label45 ----
		label45.setText("- - - - - -");
		label45.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label45);
		label45.setBounds(new Rectangle(new Point(595, 325), label45.getPreferredSize()));

		//---- label46 ----
		label46.setText("- - - - - -");
		label46.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label46);
		label46.setBounds(new Rectangle(new Point(810, 325), label46.getPreferredSize()));

		//---- label47 ----
		label47.setText("- - - - - -");
		label47.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label47);
		label47.setBounds(new Rectangle(new Point(390, 345), label47.getPreferredSize()));

		//---- label48 ----
		label48.setText("Obs. Dormitorios:");
		label48.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label48);
		label48.setBounds(new Rectangle(new Point(460, 345), label48.getPreferredSize()));

		//---- label49 ----
		label49.setText("- - - - - -");
		label49.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label49);
		label49.setBounds(new Rectangle(new Point(565, 345), label49.getPreferredSize()));

		//---- label50 ----
		label50.setText("Cocina Amueblada:");
		label50.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label50);
		label50.setBounds(new Rectangle(new Point(460, 365), label50.getPreferredSize()));

		//---- label51 ----
		label51.setText("Tendedero:");
		label51.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label51);
		label51.setBounds(new Rectangle(new Point(230, 385), label51.getPreferredSize()));

		//---- label52 ----
		label52.setText("Mts. Ba\u00f1o Principal:");
		label52.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label52);
		label52.setBounds(new Rectangle(new Point(675, 385), label52.getPreferredSize()));

		//---- label53 ----
		label53.setText("Mts. Ba\u00f1o 3:");
		label53.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label53);
		label53.setBounds(new Rectangle(new Point(460, 405), label53.getPreferredSize()));

		//---- label54 ----
		label54.setText("Jard\u00edn Comunitario:");
		label54.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label54);
		label54.setBounds(new Rectangle(new Point(230, 425), label54.getPreferredSize()));

		//---- label55 ----
		label55.setText("Piscina Propia:");
		label55.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label55);
		label55.setBounds(new Rectangle(new Point(675, 425), label55.getPreferredSize()));

		//---- label56 ----
		label56.setText("Agua Caliente:");
		label56.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label56);
		label56.setBounds(new Rectangle(new Point(460, 445), label56.getPreferredSize()));

		//---- label57 ----
		label57.setText("Aire Acondicionado:");
		label57.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label57);
		label57.setBounds(new Rectangle(new Point(230, 465), label57.getPreferredSize()));

		//---- label58 ----
		label58.setText("Portero Autom\u00e1tico:");
		label58.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label58);
		label58.setBounds(new Rectangle(new Point(675, 465), label58.getPreferredSize()));

		//---- label59 ----
		label59.setText("Ascensor:");
		label59.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label59);
		label59.setBounds(new Rectangle(new Point(460, 485), label59.getPreferredSize()));

		//---- label60 ----
		label60.setText("Trastero:");
		label60.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label60);
		label60.setBounds(new Rectangle(new Point(230, 505), label60.getPreferredSize()));

		//---- label61 ----
		label61.setText("Carpinter\u00eda Interior:");
		label61.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label61);
		label61.setBounds(new Rectangle(new Point(675, 505), label61.getPreferredSize()));

		//---- label62 ----
		label62.setText("Equipamiento Cocina:");
		label62.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label62);
		label62.setBounds(new Rectangle(new Point(675, 365), label62.getPreferredSize()));

		//---- label63 ----
		label63.setText("N\u00ba Ba\u00f1os:");
		label63.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label63);
		label63.setBounds(new Rectangle(new Point(460, 385), label63.getPreferredSize()));

		//---- label64 ----
		label64.setText("Mts. Ba\u00f1o 2:");
		label64.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label64);
		label64.setBounds(new Rectangle(new Point(230, 405), label64.getPreferredSize()));

		//---- label65 ----
		label65.setText("Aseo:");
		label65.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label65);
		label65.setBounds(new Rectangle(new Point(675, 405), label65.getPreferredSize()));

		//---- label66 ----
		label66.setText("Piscina Comunitaria:");
		label66.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label66);
		label66.setBounds(new Rectangle(new Point(460, 425), label66.getPreferredSize()));

		//---- label67 ----
		label67.setText("Tipo Calefacci\u00f3n:");
		label67.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label67);
		label67.setBounds(new Rectangle(new Point(230, 445), label67.getPreferredSize()));

		//---- label68 ----
		label68.setText("Radiadores:");
		label68.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label68);
		label68.setBounds(new Rectangle(new Point(675, 445), label68.getPreferredSize()));

		//---- label69 ----
		label69.setText("Parab\u00f3lica:");
		label69.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label69);
		label69.setBounds(new Rectangle(new Point(460, 465), label69.getPreferredSize()));

		//---- label70 ----
		label70.setText("Conserje:");
		label70.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label70);
		label70.setBounds(new Rectangle(new Point(230, 485), label70.getPreferredSize()));

		//---- label71 ----
		label71.setText("N\u00ba Plazas Garaje:");
		label71.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label71);
		label71.setBounds(new Rectangle(new Point(675, 485), label71.getPreferredSize()));

		//---- label72 ----
		label72.setText("Carpinter\u00eda Exterior:");
		label72.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label72);
		label72.setBounds(new Rectangle(new Point(460, 505), label72.getPreferredSize()));

		//---- label73 ----
		label73.setText("Suelos:");
		label73.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label73);
		label73.setBounds(new Rectangle(new Point(230, 525), label73.getPreferredSize()));

		//---- label74 ----
		label74.setText("- - - - - -");
		label74.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label74);
		label74.setBounds(new Rectangle(new Point(580, 365), label74.getPreferredSize()));

		//---- label75 ----
		label75.setText("- - - - - -");
		label75.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label75);
		label75.setBounds(new Rectangle(new Point(305, 385), label75.getPreferredSize()));

		//---- label76 ----
		label76.setText("- - - - - -");
		label76.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label76);
		label76.setBounds(new Rectangle(new Point(795, 385), label76.getPreferredSize()));

		//---- label77 ----
		label77.setText("- - - - - -");
		label77.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label77);
		label77.setBounds(new Rectangle(new Point(540, 405), label77.getPreferredSize()));

		//---- label78 ----
		label78.setText("- - - - - -");
		label78.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label78);
		label78.setBounds(new Rectangle(new Point(350, 425), label78.getPreferredSize()));

		//---- label79 ----
		label79.setText("- - - - - -");
		label79.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label79);
		label79.setBounds(new Rectangle(new Point(770, 425), label79.getPreferredSize()));

		//---- label80 ----
		label80.setText("- - - - - -");
		label80.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label80);
		label80.setBounds(new Rectangle(new Point(555, 445), label80.getPreferredSize()));

		//---- label81 ----
		label81.setText("- - - - - -");
		label81.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label81);
		label81.setBounds(new Rectangle(new Point(350, 465), label81.getPreferredSize()));

		//---- label82 ----
		label82.setText("- - - - - -");
		label82.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label82);
		label82.setBounds(new Rectangle(new Point(795, 465), label82.getPreferredSize()));

		//---- label83 ----
		label83.setText("- - - - - -");
		label83.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label83);
		label83.setBounds(new Rectangle(new Point(525, 485), label83.getPreferredSize()));

		//---- label84 ----
		label84.setText("- - - - - -");
		label84.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label84);
		label84.setBounds(new Rectangle(new Point(290, 505), label84.getPreferredSize()));

		//---- label85 ----
		label85.setText("- - - - - -");
		label85.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label85);
		label85.setBounds(new Rectangle(new Point(790, 505), label85.getPreferredSize()));

		//---- label86 ----
		label86.setText("- - - - - -");
		label86.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label86);
		label86.setBounds(new Rectangle(new Point(810, 365), label86.getPreferredSize()));

		//---- label87 ----
		label87.setText("- - - - - -");
		label87.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label87);
		label87.setBounds(new Rectangle(new Point(525, 385), label87.getPreferredSize()));

		//---- label88 ----
		label88.setText("- - - - - -");
		label88.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label88);
		label88.setBounds(new Rectangle(new Point(310, 405), label88.getPreferredSize()));

		//---- label89 ----
		label89.setText("- - - - - -");
		label89.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label89);
		label89.setBounds(new Rectangle(new Point(715, 405), label89.getPreferredSize()));

		//---- label90 ----
		label90.setText("- - - - - -");
		label90.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label90);
		label90.setBounds(new Rectangle(new Point(585, 425), label90.getPreferredSize()));

		//---- label91 ----
		label91.setText("- - - - - -");
		label91.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label91);
		label91.setBounds(new Rectangle(new Point(335, 445), label91.getPreferredSize()));

		//---- label92 ----
		label92.setText("- - - - - -");
		label92.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label92);
		label92.setBounds(new Rectangle(new Point(750, 445), label92.getPreferredSize()));

		//---- label93 ----
		label93.setText("- - - - - -");
		label93.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label93);
		label93.setBounds(new Rectangle(new Point(535, 465), label93.getPreferredSize()));

		//---- label94 ----
		label94.setText("- - - - - -");
		label94.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label94);
		label94.setBounds(new Rectangle(new Point(295, 485), label94.getPreferredSize()));

		//---- label95 ----
		label95.setText("- - - - - -");
		label95.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label95);
		label95.setBounds(new Rectangle(new Point(780, 485), label95.getPreferredSize()));

		//---- label96 ----
		label96.setText("- - - - - -");
		label96.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label96);
		label96.setBounds(new Rectangle(new Point(575, 505), label96.getPreferredSize()));

		//---- label97 ----
		label97.setText("- - - - - -");
		label97.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label97);
		label97.setBounds(new Rectangle(new Point(285, 525), label97.getPreferredSize()));

		//---- label98 ----
		label98.setText("Gastos Comunidad:");
		label98.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label98);
		label98.setBounds(new Rectangle(new Point(460, 525), label98.getPreferredSize()));

		//---- label99 ----
		label99.setText("N\u00ba Plantas Edificio:");
		label99.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label99);
		label99.setBounds(new Rectangle(new Point(460, 545), label99.getPreferredSize()));

		//---- label100 ----
		label100.setText("Conservaci\u00f3n:");
		label100.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label100);
		label100.setBounds(new Rectangle(new Point(460, 565), label100.getPreferredSize()));

		//---- label101 ----
		label101.setText("Sauna:");
		label101.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label101);
		label101.setBounds(new Rectangle(new Point(460, 585), label101.getPreferredSize()));

		//---- label102 ----
		label102.setText("Direcci\u00f3n:");
		label102.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label102);
		label102.setBounds(new Rectangle(new Point(230, 185), label102.getPreferredSize()));

		//---- label103 ----
		label103.setText("Puera Blindada:");
		label103.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label103);
		label103.setBounds(new Rectangle(new Point(675, 525), label103.getPreferredSize()));

		//---- label104 ----
		label104.setText("Puertas por Planta:");
		label104.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label104);
		label104.setBounds(new Rectangle(new Point(675, 545), label104.getPreferredSize()));

		//---- label105 ----
		label105.setText("Estado de la Finca:");
		label105.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label105);
		label105.setBounds(new Rectangle(new Point(675, 565), label105.getPreferredSize()));

		//---- label106 ----
		label106.setText("Gimnasio:");
		label106.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label106);
		label106.setBounds(new Rectangle(new Point(675, 585), label106.getPreferredSize()));

		//---- label107 ----
		label107.setText("Planta sobre Rasante:");
		label107.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label107);
		label107.setBounds(new Rectangle(new Point(230, 225), label107.getPreferredSize()));

		//---- label108 ----
		label108.setText("Antiguedad:");
		label108.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label108);
		label108.setBounds(new Rectangle(new Point(230, 545), label108.getPreferredSize()));

		//---- label109 ----
		label109.setText("Orientaci\u00f3n:");
		label109.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label109);
		label109.setBounds(new Rectangle(new Point(230, 565), label109.getPreferredSize()));

		//---- label110 ----
		label110.setText("Fecha de disponibilidad:");
		label110.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label110);
		label110.setBounds(new Rectangle(new Point(230, 585), label110.getPreferredSize()));

		//---- label111 ----
		label111.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		label111.setText("Otros Comentarios:");
		contentPane.add(label111);
		label111.setBounds(new Rectangle(new Point(460, 175), label111.getPreferredSize()));

		//---- label113 ----
		label113.setText("- - - - - -");
		label113.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label113);
		label113.setBounds(new Rectangle(new Point(580, 525), label113.getPreferredSize()));

		//---- label114 ----
		label114.setText("- - - - - -");
		label114.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label114);
		label114.setBounds(new Rectangle(new Point(570, 545), label114.getPreferredSize()));

		//---- label115 ----
		label115.setText("- - - - - -");
		label115.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label115);
		label115.setBounds(new Rectangle(new Point(550, 565), label115.getPreferredSize()));

		//---- label116 ----
		label116.setText("- - - - - -");
		label116.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label116);
		label116.setBounds(new Rectangle(new Point(510, 585), label116.getPreferredSize()));

		//---- label117 ----
		label117.setText("- - - - - -");
		label117.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label117);
		label117.setBounds(new Rectangle(new Point(295, 185), label117.getPreferredSize()));

		//---- label118 ----
		label118.setText("- - - - - -");
		label118.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label118);
		label118.setBounds(new Rectangle(new Point(775, 525), label118.getPreferredSize()));

		//---- label119 ----
		label119.setText("- - - - - -");
		label119.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label119);
		label119.setBounds(new Rectangle(new Point(790, 545), label119.getPreferredSize()));

		//---- label120 ----
		label120.setText("- - - - - -");
		label120.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label120);
		label120.setBounds(new Rectangle(new Point(790, 565), label120.getPreferredSize()));

		//---- label121 ----
		label121.setText("- - - - - -");
		label121.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label121);
		label121.setBounds(new Rectangle(new Point(740, 585), label121.getPreferredSize()));

		//---- label122 ----
		label122.setText("- - - - - -");
		label122.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label122);
		label122.setBounds(new Rectangle(new Point(360, 225), label122.getPreferredSize()));

		//---- label123 ----
		label123.setText("- - - - - -");
		label123.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label123);
		label123.setBounds(new Rectangle(new Point(310, 545), label123.getPreferredSize()));

		//---- label124 ----
		label124.setText("- - - - - -");
		label124.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label124);
		label124.setBounds(new Rectangle(new Point(305, 565), label124.getPreferredSize()));

		//---- label127 ----
		label127.setText("- - - - - -");
		label127.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		contentPane.add(label127);
		label127.setBounds(new Rectangle(new Point(375, 585), label127.getPreferredSize()));

		//======== scrollPane2 ========
		{
			scrollPane2.setViewportView(textPane2);
		}
		contentPane.add(scrollPane2);
		scrollPane2.setBounds(575, 175, 275, 65);

		contentPane.setPreferredSize(new Dimension(900, 665));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JMenu menu2;
	private JMenuItem menuItem4;
	private JMenuItem menuItem5;
	private JMenuItem menuItem6;
	private JMenuItem menuItem7;
	private JMenuItem menuItem8;
	private JMenuItem menuItem9;
	private JMenu menu3;
	private JButton buttonConsulta;
	private JButton buttonSalir;
	private JLabel labelTitulo;
	private JLabel label1;
	private JLabel label2;
	private JScrollPane scrollPaneInmueble;
	private JList listInmuelble;
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
	private JScrollPane scrollPane1;
	private JTextPane textPane1;
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
	private JLabel label57;
	private JLabel label58;
	private JLabel label59;
	private JLabel label60;
	private JLabel label61;
	private JLabel label62;
	private JLabel label63;
	private JLabel label64;
	private JLabel label65;
	private JLabel label66;
	private JLabel label67;
	private JLabel label68;
	private JLabel label69;
	private JLabel label70;
	private JLabel label71;
	private JLabel label72;
	private JLabel label73;
	private JLabel label74;
	private JLabel label75;
	private JLabel label76;
	private JLabel label77;
	private JLabel label78;
	private JLabel label79;
	private JLabel label80;
	private JLabel label81;
	private JLabel label82;
	private JLabel label83;
	private JLabel label84;
	private JLabel label85;
	private JLabel label86;
	private JLabel label87;
	private JLabel label88;
	private JLabel label89;
	private JLabel label90;
	private JLabel label91;
	private JLabel label92;
	private JLabel label93;
	private JLabel label94;
	private JLabel label95;
	private JLabel label96;
	private JLabel label97;
	private JLabel label98;
	private JLabel label99;
	private JLabel label100;
	private JLabel label101;
	private JLabel label102;
	private JLabel label103;
	private JLabel label104;
	private JLabel label105;
	private JLabel label106;
	private JLabel label107;
	private JLabel label108;
	private JLabel label109;
	private JLabel label110;
	private JLabel label111;
	private JLabel label113;
	private JLabel label114;
	private JLabel label115;
	private JLabel label116;
	private JLabel label117;
	private JLabel label118;
	private JLabel label119;
	private JLabel label120;
	private JLabel label121;
	private JLabel label122;
	private JLabel label123;
	private JLabel label124;
	private JLabel label127;
	private JScrollPane scrollPane2;
	private JTextPane textPane2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
