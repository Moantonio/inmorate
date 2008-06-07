package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	private JLabel label1;
	private JButton buttonPareja;
	private JButton buttonMatrimonio;
	private JButton buttonSoltero;
	private JButton buttonSoltera;
	private JLabel label2;
	private JButton espanol;
	private JButton ingles;
	private JLabel label3;
	private JLabel label4;
	
	public VistaInicial(Controlador control) throws MalformedURLException {
		this.controlador = control;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,640);
		setLocation(75,110);
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
		
		espanol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.traducirEspanol();
			}
		});
		
		ingles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlador.traducirIngles();
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
		espanol = new JButton();
		ingles = new JButton();
		label3 = new JLabel();
		label4 = new JLabel();

		//======== this ========
		setTitle("Sistema de Valoracion de Inmuebles");
		setName("vistaInicial");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Por favor, elija las características que más se adaptan a su perfil");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		label1.setMaximumSize(new Dimension(150, 20));
		label1.setMinimumSize(new Dimension(150, 20));
		label1.setPreferredSize(new Dimension(150, 20));
		contentPane.add(label1);
		label1.setBounds(400, 110, 600, 35);

		//---- buttonPareja ----
		buttonPareja.setText("Pareja joven sin hijos");
		buttonPareja.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonPareja.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonPareja);
		buttonPareja.setBounds(400, 175, 245, 175);

		//---- buttonMatrimonio ----
		buttonMatrimonio.setText("Matrimonio con 2-3 hijos");
		buttonMatrimonio.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonMatrimonio.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonMatrimonio);
		buttonMatrimonio.setBounds(685, 175, 245, 175);

		//---- buttonSoltero ----
		buttonSoltero.setText("Hombre Soltero");
		buttonSoltero.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltero.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonSoltero);
		buttonSoltero.setBounds(400, 380, 245, 175);

		//---- buttonSoltera ----
		buttonSoltera.setText("Mujer Soltera");
		buttonSoltera.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonSoltera.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		contentPane.add(buttonSoltera);
		buttonSoltera.setBounds(685, 380, 245, 175);

		//---- label2 ----
		label2.setIcon(new ImageIcon("./imagenes/Casa2.jpg"));
		contentPane.add(label2);
		label2.setBounds(60, 115, 300, 220);

		//---- espanol ----
		espanol.setIcon(new ImageIcon("./imagenes/Espana.gif"));
		contentPane.add(espanol);
		espanol.setBounds(810, 40, 60, 36);

		//---- ingles ----
		ingles.setIcon(new ImageIcon("./imagenes/ReinoUnido.gif"));
		contentPane.add(ingles);
		ingles.setBounds(870, 40, 60, 36);

		//---- label3 ----
		label3.setText("Sistema de Valoración de Inmuebles");
		label3.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		contentPane.add(label3);
		label3.setBounds(200, 40, 580, label3.getPreferredSize().height);

		//---- label4 ----
		label4.setIcon(new ImageIcon("./imagenes/Casa1.jpg"));
		contentPane.add(label4);
		label4.setBounds(60, 335, 300, 220);

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

	public void traducirIngles() {
		setTitle("System of valuation of buildings");
		label1.setText("Please, select the more suitable features for your profile");
		label3.setText("System of valuation of buildings");
		buttonPareja.setText("Young couple with no children");
		buttonMatrimonio.setText("Marriage with 2-3 children");
		buttonSoltero.setText("Single Man");
		buttonSoltera.setText("Single Woman");
	}

	public void traducirEspanol() {
		setTitle("Sistema de Valoracion de Inmuebles");
		label1.setText("Por favor, elija las características que más se adaptan a su perfil");
		label3.setText("Sistema de Valoración de Inmuebles");
		buttonPareja.setText("Pareja joven sin hijos");
		buttonMatrimonio.setText("Matrimonio con 2-3 hijos");
		buttonSoltero.setText("Hombre Soltero");
		buttonSoltera.setText("Mujer Soltera");
	}
}