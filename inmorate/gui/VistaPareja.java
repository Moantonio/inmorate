package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaPareja extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8076513176113987845L;
	
	private Controlador controlador;
	
	public VistaPareja(Controlador control) {
		this.controlador = control;
		initComponents();
		setSize(400,330);
		setVisible(false);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		buttonAceptar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.activarVVP();
					}
				} // ActionListener			
		); // buttonAceptar.addActionListener
		
		buttonCancelar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.cerrarPrograma();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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
		setTitle("Pareja Joven sin Hijos");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- buttonAceptar ----
		buttonAceptar.setText("Aceptar");
		buttonAceptar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonAceptar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonAceptar);
		buttonAceptar.setBounds(20, 250, 165, 30);

		//---- buttonCancelar ----
		buttonCancelar.setText("Cancelar");
		buttonCancelar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonCancelar.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(buttonCancelar);
		buttonCancelar.setBounds(205, 250, 165, 30);

		//---- labelTitulo ----
		labelTitulo.setText("Valores de mayor a menor importancia:");
		labelTitulo.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(new Rectangle(new Point(10, 15), labelTitulo.getPreferredSize()));

		//---- label1 ----
		label1.setText("Tipo de Inmueble");
		label1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(new Rectangle(new Point(35, 65), label1.getPreferredSize()));

		//---- label2 ----
		label2.setText("Representatividad");
		label2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(35, 110), label2.getPreferredSize()));

		//---- label3 ----
		label3.setText("Estado del Portal");
		label3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(35, 155), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("Metros Habitables");
		label4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(35, 200), label4.getPreferredSize()));

//		---- comboBox1 ----
		comboBox1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
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
		comboBox1.setBounds(205, 60, 165, comboBox1.getPreferredSize().height);

		//---- comboBox2 ----
		comboBox2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		comboBox2.setMaximumRowCount(4);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox2.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox2);
		comboBox2.setBounds(205, 105, 165, comboBox2.getPreferredSize().height);

		//---- comboBox3 ----
		comboBox3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		comboBox3.setMaximumRowCount(4);
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox3.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox3);
		comboBox3.setBounds(205, 150, 165, comboBox3.getPreferredSize().height);

		//---- comboBox4 ----
		comboBox4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		comboBox4.setMaximumRowCount(4);
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox4.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox4);
		comboBox4.setBounds(205, 195, 165, comboBox4.getPreferredSize().height);

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
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
