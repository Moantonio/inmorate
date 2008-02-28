package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaSoltero extends JFrame {
	
	private static final long serialVersionUID = 6525934142124882561L;
	private Controlador controlador;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JLabel labelTitulo;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JComboBox comboBox4;
	
	public VistaSoltero(Controlador control) {
		this.controlador = control;
		initComponents();
		setSize(510,420);
		setLocation(300,150);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonCancelar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.volverAtras();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
	}

	private void initComponents() {
		buttonAceptar = new JButton();
		buttonCancelar = new JButton();
		labelTitulo = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		comboBox1 = new JComboBox();
		comboBox2 = new JComboBox();
		comboBox3 = new JComboBox();
		comboBox4 = new JComboBox();

		//======== this ========
		setTitle("Hombre Soltero");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- buttonAceptar ----
		buttonAceptar.setText("Aceptar");
		buttonAceptar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonAceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(buttonAceptar);
		buttonAceptar.setBounds(30, 320, 215, 40);

		//---- buttonCancelar ----
		buttonCancelar.setText("Cancelar");
		buttonCancelar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(buttonCancelar);
		buttonCancelar.setBounds(255, 320, 215, 40);

		//---- labelTitulo ----
		labelTitulo.setText("Valore de mayor a menor importancia:");
		labelTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(new Rectangle(new Point(60, 30), labelTitulo.getPreferredSize()));

		//---- label1 ----
		label1.setText("Representatividad");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(50, 90), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("Estado del Portal");
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(50, 150), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Fachada");
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(50, 210), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("Estado General");
		label4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(50, 270), label4.getPreferredSize()));

		//---- comboBox1 ----
		comboBox1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox1.setMaximumRowCount(4);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox1.setSelectedIndex(0);
		comboBox1.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox1);
		comboBox1.setBounds(270, 85, 185, comboBox1.getPreferredSize().height);

		//---- comboBox2 ----
		comboBox2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox2.setMaximumRowCount(4);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox2.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox2);
		comboBox2.setBounds(270, 145, 185, comboBox2.getPreferredSize().height);

		//---- comboBox3 ----
		comboBox3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox3.setMaximumRowCount(4);
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox3.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox3);
		comboBox3.setBounds(270, 205, 185, comboBox3.getPreferredSize().height);

		//---- comboBox4 ----
		comboBox4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox4.setMaximumRowCount(4);
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox4.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox4);
		comboBox4.setBounds(270, 265, 185, comboBox4.getPreferredSize().height);

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

