package inmorate.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun Dec 30 16:41:24 CET 2007
 */



/**
 * @author User #3
 */
public class VistaVivienda extends JDialog {
	public VistaVivienda(Frame owner) {
		super(owner);
		initComponents();
	}

	public VistaVivienda(Dialog owner) {
		super(owner);
		initComponents();
	}

	public VistaVivienda() {
		// TODO Apéndice de constructor generado automáticamente
		initComponents();
		setSize(700,700);
		setVisible(true);
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
		scrollPaneInmuebles = new JScrollPane();
		textPaneInmuebles = new JTextPane();
		buttonConsulta = new JButton();
		buttonSalir = new JButton();
		labelTitulo = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();

		//======== this ========
		setTitle("Valores Inmuebles");
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

		//======== scrollPaneInmuebles ========
		{
			
			//---- textPaneInmuebles ----
			textPaneInmuebles.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
			scrollPaneInmuebles.setViewportView(textPaneInmuebles);
		}
		contentPane.add(scrollPaneInmuebles);
		scrollPaneInmuebles.setBounds(40, 100, 295, 400);

		//---- buttonConsulta ----
		buttonConsulta.setText("Nueva Consulta");
		buttonConsulta.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonConsulta.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonConsulta);
		buttonConsulta.setBounds(40, 525, 295, 40);

		//---- buttonSalir ----
		buttonSalir.setText("Salir del Programa");
		buttonSalir.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		buttonSalir.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		contentPane.add(buttonSalir);
		buttonSalir.setBounds(40, 595, 295, 40);

		//---- labelTitulo ----
		labelTitulo.setText("Ficha del Inmueble");
		labelTitulo.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(new Rectangle(new Point(245, 40), labelTitulo.getPreferredSize()));

		//---- label1 ----
		label1.setText("DM-XX:");
		label1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(365, 100), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("VALOR");
		label2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(500, 100), label2.getPreferredSize()));

		contentPane.setPreferredSize(new Dimension(700, 700));
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
	private JScrollPane scrollPaneInmuebles;
	private JTextPane textPaneInmuebles;
	private JButton buttonConsulta;
	private JButton buttonSalir;
	private JLabel labelTitulo;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
