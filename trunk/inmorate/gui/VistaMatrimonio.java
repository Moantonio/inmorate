package inmorate.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import inmorate.controlador.Controlador;

public class VistaMatrimonio extends JFrame{

	private static final long serialVersionUID = -8353234934369181356L;
	private Controlador controlador;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JButton buttonContinuar;
	private JLabel labelTitulo;
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
	private JLabel label15;
	private JLabel label16;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private ArrayList<String> texto; 
	
	public VistaMatrimonio(Controlador c) {
		this.controlador = c;
		this.texto = new ArrayList<String>();
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
						
						// Valoramos los inmuebles
						controlador.valorarMatrimonio();
						
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
							controlador.activarVVM();
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
		label15 = new JLabel();
		label16 = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		comboBox1 = new JComboBox();
		comboBox2 = new JComboBox();
		comboBox3 = new JComboBox();

		//======== this ========
		setTitle("Matrimonio dos - tres hijos");
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

		//---- label5 ----
		label5.setText("Busqueda basada en el perfil");
		label5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(label5);
		label5.setBounds(630, 5, 370, label5.getPreferredSize().height);

		//---- label6 ----
		label6.setText("Dormitorios");
		label6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label6);
		label6.setBounds(630, 45, 145, label6.getPreferredSize().height);

		//---- label7 ----
		label7.setText("Luminosidad");
		label7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label7);
		label7.setBounds(630, 200, 150, label7.getPreferredSize().height);

		//---- label8 ----
		label8.setText("Plaza Garage");
		label8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label8);
		label8.setBounds(630, 355, 150, label8.getPreferredSize().height);

		//---- label9 ----
		label9.setText("Zonas Comunes");
		label9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label9);
		label9.setBounds(630, 510, 145, label9.getPreferredSize().height);

		//---- label10 ----
		label10.setIcon(new ImageIcon("./imagenes/fuzzy/Numero.JPG"));
		contentPane.add(label10);
		label10.setBounds(800, 45, 262, 150);

		//---- label11 ----
		label11.setIcon(new ImageIcon("./imagenes/fuzzy/Valoracion.JPG"));
		contentPane.add(label11);
		label11.setBounds(800, 200, 263, 150);

		//---- label12 ----
		label12.setIcon(new ImageIcon("./imagenes/fuzzy/Numero.JPG"));
		contentPane.add(label12);
		label12.setBounds(800, 355, 263, 150);

		//---- label13 ----
		label13.setIcon(new ImageIcon("./imagenes/fuzzy/Booleano.JPG"));
		contentPane.add(label13);
		label13.setBounds(800, 510, 261, 150);

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

		//---- label15 ----
		label15.setIcon(new ImageIcon("./imagenes/fuzzy/TipoInmueble.JPG"));
		contentPane.add(label15);
		label15.setBounds(800, 665, 261, 150);

		//---- label16 ----
		label16.setText("Tipo Inmueble");
		label16.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label16);
		label16.setBounds(630, 665, 145, label16.getPreferredSize().height);

		//---- label1 ----
		label1.setText("Estado del Portal");
		label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label1);
		label1.setBounds(95, 110, 200, label1.getPreferredSize().height);
		
		//---- label2 ----
		label2.setText("Num. Baños / Aseos");
		label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label2);
		label2.setBounds(95, 185, 200, label2.getPreferredSize().height);
		
		//---- label3 ----
		label3.setText("Altura (Planta)");
		label3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(label3);
		label3.setBounds(95, 260, 200, label3.getPreferredSize().height);
		
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
		comboBox1.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox1);
		comboBox1.setBounds(315, 105, 185, comboBox1.getPreferredSize().height);

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
		comboBox2.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox2);
		comboBox2.setBounds(315, 185, 185, comboBox2.getPreferredSize().height);

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
		comboBox3.setMaximumSize(new Dimension(130, 25));
		contentPane.add(comboBox3);
		comboBox3.setBounds(315, 260, 185, comboBox3.getPreferredSize().height);

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
		setTitle("Marriage with two - three children");
		labelTitulo.setText("Value from greater to smaller importance:");
		labelTitulo.setBounds(90, 35, 425, labelTitulo.getPreferredSize().height);
		label1.setText("State of the entrace hall");
		label2.setText("Number of baths / Toilets");
		label3.setText("Height (Floor)");
		label5.setText("Search based on the profile");
		label6.setText("Rooms");
		label7.setText("Luminosity");
		label8.setText("Car park");
		label9.setText("Common zones");		
		label16.setText("Type of building");
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
		buttonAceptar.setText("Accept");
		buttonCancelar.setText("Cancel");
	}

	public void traducirEspanol() {
		setTitle("Matrimonio con dos - tres hijos");
		labelTitulo.setText("Valore de mayor a menor importancia:");
		labelTitulo.setBounds(105, 35, 425, labelTitulo.getPreferredSize().height);
		label1.setText("Estado del Portal");
		label2.setText("Numero de Baños / Aseos");
		label3.setText("Altura (Planta)");		
		label5.setText("Busqueda basada en el perfil");
		label6.setText("Dormitorios");
		label7.setText("Luminosidad");
		label8.setText("Plaza Garage");
		label9.setText("Zonas Comunes");		
		label16.setText("Tipo Inmueble");
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