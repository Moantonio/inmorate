package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaMatrimonio extends JFrame {
	
	private static final long serialVersionUID = -5133213368903256893L;	
	private Controlador controlador;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JLabel labelTitulo;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;

	public VistaMatrimonio(Controlador control) {
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
		comboBox1 = new JComboBox();
		comboBox2 = new JComboBox();
		comboBox3 = new JComboBox();

		//======== this ========
		setTitle("Matrimonio con 2 - 3 Hijos");
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
		label1.setText("Estado del Portal");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(50, 100), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("Num. Ba\u00f1os / Aseos");
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(50, 175), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Altura (Planta)");
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(50, 250), label3.getPreferredSize()));

		//---- comboBox1 ----
		comboBox1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox1.setMaximumRowCount(3);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante"
		}));
		comboBox1.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox1);
		comboBox1.setBounds(270, 95, 185, comboBox1.getPreferredSize().height);

		//---- comboBox2 ----
		comboBox2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox2.setMaximumRowCount(3);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante"
		}));
		comboBox2.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox2);
		comboBox2.setBounds(270, 170, 185, comboBox2.getPreferredSize().height);

		//---- comboBox3 ----
		comboBox3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox3.setMaximumRowCount(3);
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante"
		}));
		comboBox3.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox3);
		comboBox3.setBounds(270, 245, 185, comboBox3.getPreferredSize().height);

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