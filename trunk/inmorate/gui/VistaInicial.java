package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;


public class VistaInicial extends JFrame {
	
	private static final long serialVersionUID = 1L;	
	private Controlador controlador;
	private JLabel label1;
	private JLabel label2;
	private JButton buttonPareja;
	private JButton buttonMatrimonio;
	private JButton buttonSoltero;
	private JButton buttonSoltera;
	
	public VistaInicial(Controlador control) {
		this.controlador = control;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(610,580);
		setLocation(270,100);
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
		label1 = new JLabel();
		buttonPareja = new JButton();
		buttonMatrimonio = new JButton();
		buttonSoltero = new JButton();
		buttonSoltera = new JButton();
		label2 = new JLabel();

		//======== this ========
		setTitle("Perfiles");
		setName("vistaPrincipal");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Perfiles:");
		label1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
		label1.setMaximumSize(new Dimension(150, 20));
		label1.setMinimumSize(new Dimension(150, 20));
		label1.setPreferredSize(new Dimension(150, 20));
		contentPane.add(label1);
		label1.setBounds(120, 45, 120, 35);

		//---- buttonPareja ----
		buttonPareja.setText("Pareja joven sin hijos");
		buttonPareja.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonPareja.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonPareja);
		buttonPareja.setBounds(35, 130, 245, 175);

		//---- buttonMatrimonio ----
		buttonMatrimonio.setText("Matrimonio con 2-3 hijos");
		buttonMatrimonio.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonMatrimonio.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonMatrimonio);
		buttonMatrimonio.setBounds(320, 130, 245, 175);

		//---- buttonSoltero ----
		buttonSoltero.setText("Hombre Soltero");
		buttonSoltero.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltero.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonSoltero);
		buttonSoltero.setBounds(35, 335, 245, 175);

		//---- buttonSoltera ----
		buttonSoltera.setText("Mujer Soltera");
		buttonSoltera.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltera.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonSoltera);
		buttonSoltera.setBounds(320, 335, 245, 175);

		//---- label2 ----
		label2.setIcon(new ImageIcon("./casa.gif"));
		contentPane.add(label2);
		label2.setBounds(380, 15, 105, 100);

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
	}
}
