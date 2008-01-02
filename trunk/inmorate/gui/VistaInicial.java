package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaInicial extends JFrame {

	private static final long serialVersionUID = -6200813600882358015L;
	
	private Controlador controlador;
	
	public VistaInicial(final Controlador control) {
		this.controlador = control;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,330);
		setVisible(true);
		
		buttonPareja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.activarVP();
			}
		});
		
		buttonMatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.activarVM();
			}
		});
		
		buttonSoltero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.activarVSO();
			}
		});
		
		buttonSoltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.activarVSA();
			}
		});

	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		buttonPareja = new JButton();
		buttonMatrimonio = new JButton();
		buttonSoltero = new JButton();
		buttonSoltera = new JButton();

		//======== this ========
		setTitle("Tipo de Comprador");
		setName("vistaPrincipal");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Tipo de Comprador:");
		label1.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		label1.setMaximumSize(new Dimension(150, 20));
		label1.setMinimumSize(new Dimension(150, 20));
		label1.setPreferredSize(new Dimension(150, 20));
		contentPane.add(label1);
		label1.setBounds(100, 15, 200, 25);

		//---- buttonPareja ----
		buttonPareja.setText("Pareja joven sin hijos");
		buttonPareja.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonPareja.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonPareja);
		buttonPareja.setBounds(20, 60, 170, 100);

		//---- buttonMatrimonio ----
		buttonMatrimonio.setText("Matrimonio con 2-3 hijos");
		buttonMatrimonio.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonMatrimonio.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonMatrimonio);
		buttonMatrimonio.setBounds(200, 60, 170, 100);

		//---- buttonSoltero ----
		buttonSoltero.setText("Hombre Soltero");
		buttonSoltero.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltero.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonSoltero);
		buttonSoltero.setBounds(20, 175, 170, 100);

		//---- buttonSoltera ----
		buttonSoltera.setText("Mujer Soltera");
		buttonSoltera.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltera.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonSoltera);
		buttonSoltera.setBounds(200, 175, 170, 100);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setPreferredSize( preferredSize );
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JButton buttonPareja;
	private JButton buttonMatrimonio;
	private JButton buttonSoltero;
	private JButton buttonSoltera;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
