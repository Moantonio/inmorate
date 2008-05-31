package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaSoltera extends JFrame {

	private static final long serialVersionUID = -4251218013553503961L;
	private Controlador controlador;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JButton buttonContinuar;
	private JLabel labelTitulo;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JComboBox comboBox4;
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
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private ArrayList<String> texto; 
	
	public VistaSoltera(Controlador control) {
		this.texto = new ArrayList<String>();	
		this.controlador = control;
		initComponents();
		setSize(1152,864);
		setLocation(0,0);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonAceptar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.getComboBox().add(""+comboBox1.getSelectedItem());
						controlador.getComboBox().add(""+comboBox2.getSelectedItem());
						controlador.getComboBox().add(""+comboBox3.getSelectedItem());
						controlador.getComboBox().add(""+comboBox4.getSelectedItem());
						
						// Valoramos los inmuebles
						controlador.valorarSoltera();
						
						mostrarDespacio();
						
						buttonContinuar.setEnabled(true);
					}
				} // ActionListener			
		); // buttonAceptar.addActionListener

		buttonCancelar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						controlador.volverAtras();
					}
				} // ActionListener			
		); // buttonCancelar.addActionListener
		
		buttonContinuar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {												
						try {
							controlador.activarVVSA();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} // ActionListener			
		); // buttonContinuar.addActionListener
	}

	private void initComponents() {
		buttonAceptar = new JButton();
		buttonCancelar = new JButton();
		buttonContinuar = new JButton();
		labelTitulo = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		comboBox1 = new JComboBox();
		comboBox2 = new JComboBox();
		comboBox3 = new JComboBox();
		comboBox4 = new JComboBox();
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
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();

		//======== this ========
		setTitle("Soltera");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- buttonAceptar ----
		buttonAceptar.setText("Valorar");
		buttonAceptar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonAceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(buttonAceptar);
		buttonAceptar.setBounds(75, 325, 130, 40);

		//---- buttonCancelar ----
		buttonCancelar.setText("Cancelar");
		buttonCancelar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(buttonCancelar);
		buttonCancelar.setBounds(230, 325, 130, 40);
		
		//---- buttonContinuar ----
		buttonContinuar.setText("Continuar...");
		buttonContinuar.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.darkGray, null));
		buttonContinuar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonContinuar.setEnabled(false);
		contentPane.add(buttonContinuar);
		buttonContinuar.setBounds(385, 325, 130, 40);

		//---- labelTitulo ----
		labelTitulo.setText("Valore de mayor a menor importancia:");
		labelTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(labelTitulo);
		labelTitulo.setBounds(105, 35, 425, labelTitulo.getPreferredSize().height);

		//---- label1 ----
		label1.setText("Representatividad");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(95, 95, 190, label1.getPreferredSize().height);

		//---- label2 ----
		label2.setText("Estado del Portal");
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(95, 155, 205, label2.getPreferredSize().height);

		//---- label3 ----
		label3.setText("Fachada");
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(95, 215, 190, label3.getPreferredSize().height);

		//---- label4 ----
		label4.setText("Estado General");
		label4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label4);
		label4.setBounds(95, 275, 190, label4.getPreferredSize().height);

		//---- comboBox1 ----
		comboBox1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox1.setMaximumRowCount(5);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Bastante Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox1.setSelectedIndex(0);
		comboBox1.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox1);
		comboBox1.setBounds(315, 90, 185, comboBox1.getPreferredSize().height);

		//---- comboBox2 ----
		comboBox2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox2.setMaximumRowCount(5);
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Bastante Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox2.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox2);
		comboBox2.setBounds(315, 150, 185, comboBox2.getPreferredSize().height);

		//---- comboBox3 ----
		comboBox3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox3.setMaximumRowCount(5);
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Bastante Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox3.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox3);
		comboBox3.setBounds(315, 210, 185, comboBox3.getPreferredSize().height);

		//---- comboBox4 ----
		comboBox4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		comboBox4.setMaximumRowCount(5);
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {
			"Muy Importante",
			"Bastante Importante",
			"Importante",
			"Poco Importante",
			"Nada Importante"
		}));
		comboBox4.setMaximumSize(new Dimension(132, 25));
		contentPane.add(comboBox4);
		comboBox4.setBounds(315, 270, 185, comboBox4.getPreferredSize().height);

		//---- label5 ----
		label5.setText("Busqueda basada en el perfil");
		label5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(630, 35), label5.getPreferredSize()));

		//---- label6 ----
		label6.setText("Dormitorios");
		label6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label6);
		label6.setBounds(630, 90, 145, label6.getPreferredSize().height);

		//---- label7 ----
		label7.setText("Luminosidad");
		label7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label7);
		label7.setBounds(630, 275, 150, label7.getPreferredSize().height);

		//---- label8 ----
		label8.setText("Plaza Garage");
		label8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label8);
		label8.setBounds(630, 460, 150, label8.getPreferredSize().height);

		//---- label9 ----
		label9.setText("Ascensor");
		label9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label9);
		label9.setBounds(630, 645, 145, label9.getPreferredSize().height);

		//---- label10 ----
		label10.setIcon(new ImageIcon("./imagenes/fuzzy/Numero.JPG"));
		contentPane.add(label10);
		label10.setBounds(800, 90, 262, 150);

		//---- label11 ----
		label11.setIcon(new ImageIcon("./imagenes/fuzzy/Valoracion.JPG"));
		contentPane.add(label11);
		label11.setBounds(800, 275, 263, 150);

		//---- label12 ----
		label12.setIcon(new ImageIcon("./imagenes/fuzzy/Numero.JPG"));
		contentPane.add(label12);
		label12.setBounds(800, 460, 263, 150);

		//---- label13 ----
		label13.setIcon(new ImageIcon("./imagenes/fuzzy/Booleano.JPG"));
		contentPane.add(label13);
		label13.setBounds(800, 645, 261, 150);

		//---- label14 ----
		label14.setIcon(new ImageIcon("./imagenes/xfuzzy.gif"));
		contentPane.add(label14);
		label14.setBounds(80, 405, 218, 65);

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(textArea1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(75, 495, 440, 300);

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
		setTitle("Single Woman");
		labelTitulo.setText("Value from greater to smaller importance:");
		labelTitulo.setBounds(90, 35, 425, labelTitulo.getPreferredSize().height);
		label1.setText("Type of building");
		label2.setText("Orientation");
		label3.setText("Representativeness");
		label4.setText("Views");
		label5.setText("Search based on the profile");
		label6.setText("Rooms");
		label7.setText("Luminosity");
		label8.setText("Car park");
		label9.setText("Elevator");		
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
				"Very Important",
				"Quite Important",
				"Important",
				"A little Important",
				"No Important"
			}));
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
				"Very Important",
				"Quite Important",
				"Important",
				"A little Important",
				"No Important"
			}));
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
				"Very Important",
				"Quite Important",
				"Important",
				"A little Important",
				"No Important"
			}));
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {
				"Very Important",
				"Quite Important",
				"Important",
				"A little Important",
				"No Important"
			}));
		buttonAceptar.setText("Accept");
		buttonCancelar.setText("Cancel");
	}

	public void traducirEspanol() {
		setTitle("Mujer Soltera");
		labelTitulo.setText("Valore de mayor a menor importancia:");
		labelTitulo.setBounds(105, 35, 425, labelTitulo.getPreferredSize().height);
		label1.setText("Tipo de Inmueble");
		label2.setText("Orientación");
		label3.setText("Representatividad");
		label4.setText("Vistas");			
		label5.setText("Busqueda basada en el perfil");
		label6.setText("Dormitorios");
		label7.setText("Luminosidad");
		label8.setText("Plaza Garage");
		label9.setText("Ascensor");		
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
				"Muy Importante",
				"Bastante Importante",
				"Importante",
				"Poco Importante",
				"Nada Importante"
			}));
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {
				"Muy Importante",
				"Bastante Importante",
				"Importante",
				"Poco Importante",
				"Nada Importante"
			}));
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {
				"Muy Importante",
				"Bastante Importante",
				"Importante",
				"Poco Importante",
				"Nada Importante"
			}));
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {
				"Muy Importante",
				"Bastante Importante",
				"Importante",
				"Poco Importante",
				"Nada Importante"
			}));
		buttonAceptar.setText("Aceptar");
		buttonCancelar.setText("Cancelar");
	}

	public void escribir(String string) {
		//textArea1.append(string + "\n");
		//textArea1.setText(string);
		texto.add(string);
	}
	
	public void mostrarDespacio() {	
		for (int i=0; i<texto.size(); i++) {
			textArea1.append(texto.get(i));
		}
	}

	public void inicializar() {
		texto = new ArrayList<String>();
		buttonContinuar.setEnabled(false);
		textArea1.setText("");		
	}
}