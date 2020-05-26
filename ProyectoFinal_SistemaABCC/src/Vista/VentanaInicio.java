package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Controlador.*;

class Gui extends JFrame {

	JTable tabla;
	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas, menuCambio, menuBajas, menuConsultas;
	JInternalFrame panels, panelcambios, IF_Bajas, IF_Consultas;

	public Gui() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema ABCC");

		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);

		menuBar = new JMenuBar();
		menuInicio = new JMenu("Ver");

		menuAltas = new JMenuItem("Altas");
		menuCambio = new JMenuItem("Cambio");
		menuBajas = new JMenuItem("Bajas");
		menuConsultas = new JMenuItem("Consultas");

		menuInicio.add(menuAltas);
		menuInicio.add(menuCambio);
		menuInicio.add(menuBajas);
		menuInicio.add(menuConsultas);
		menuBar.add(menuInicio);
		setJMenuBar(menuBar);

		JPanel panelaltas = new JPanel();
		panelaltas.setLayout(null);
		panelaltas.setBounds(0, 0, 700, 500);
		add(panelaltas);

		JPanel panelcambios = new JPanel();
		panelcambios.setLayout(null);
		panelcambios.setBounds(0, 0, 700, 500);
		add(panelcambios);

		JPanel panelbajas = new JPanel();
		panelbajas.setLayout(null);
		panelbajas.setBounds(0, 0, 700, 500);
		add(panelbajas);

		JPanel panelconsultas = new JPanel();
		panelconsultas.setLayout(null);
		panelconsultas.setBounds(0, 0, 700, 500);
		add(panelconsultas);

		menuAltas.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				panelaltas.setVisible(true);
				panelcambios.setVisible(false);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(false);
			}
		});

		menuCambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelaltas.setVisible(false);
				panelcambios.setVisible(true);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(false);

			}
		});

		menuBajas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				panelaltas.setVisible(false);
				panelcambios.setVisible(false);
				panelbajas.setVisible(true);
				panelconsultas.setVisible(false);

			}
		});

		menuConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelaltas.setVisible(false);
				panelcambios.setVisible(false);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(true);

			}
		});

		/*
		 * JPanel panel = new JPanel(); panel.setLayout(new BorderLayout()); panel
		 * .setBounds(10,10, 100,100); add(panel);
		 */

		// internal frames

		// panelsc.setVisible(true);

		// agregar InternalFrame al DesktopPane

		// agreagr desktopPane al JFrame principal

		JLabel lb0 = new JLabel("Ingrese los datos del alumno");
		lb0.setBounds(10, 10, 130, 20);
		panelaltas.add(lb0);

		JLabel lb1 = new JLabel("Numero de Control");
		lb1.setBounds(10, 40, 130, 20);
		panelaltas.add(lb1);

		JTextField t1 = new JTextField();
		t1.setBounds(10, 70, 100, 20);
		panelaltas.add(t1);

		JLabel lb2 = new JLabel("Nombre");
		lb2.setBounds(10, 100, 130, 20);
		panelaltas.add(lb2);

		JTextField t2 = new JTextField();
		t2.setBounds(10, 130, 100, 20);
		panelaltas.add(t2);

		JLabel lb3 = new JLabel("Primer ap");
		lb3.setBounds(10, 160, 130, 20);
		panelaltas.add(lb3);

		JTextField t3 = new JTextField();
		t3.setBounds(10, 190, 100, 20);
		panelaltas.add(t3);

		JLabel lb4 = new JLabel("Segundo ap");
		lb4.setBounds(10, 220, 130, 20);
		panelaltas.add(lb4);

		JTextField t4 = new JTextField();
		t4.setBounds(10, 250, 100, 20);
		panelaltas.add(t4);
		// Num_Control | Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno |
		// Edad_Alumno | Semestre | Carrera
		JLabel lb5 = new JLabel("Edad");
		lb5.setBounds(10, 280, 130, 20);
		panelaltas.add(lb5);

		JTextField t5 = new JTextField();
		t5.setBounds(10, 310, 100, 20);
		panelaltas.add(t5);

		JLabel lb6 = new JLabel("Semestre");
		lb6.setBounds(150, 40, 130, 20);
		panelaltas.add(lb6);

		JTextField t6 = new JTextField();

		t6.setBounds(150, 70, 100, 20);
		panelaltas.add(t6);

		JLabel lb7 = new JLabel("Carrera");
		lb7.setText("carrera");
		lb7.setBounds(150, 100, 130, 20);
		panelaltas.add(lb7);

		JTextField t7 = new JTextField();
		t7.setBounds(150, 130, 100, 20);
		panelaltas.add(t7);

		add(panelaltas, BorderLayout.CENTER);
		panelaltas.setVisible(false);

		// componentes cambio

		JLabel blb0 = new JLabel("Ingrese los datos del alumno");
		blb0.setBounds(10, 10, 130, 20);
		panelcambios.add(blb0);

		JLabel b1 = new JLabel("Numero de Control");
		b1.setBounds(10, 40, 130, 20);
		panelcambios.add(b1);

		JTextField bt1 = new JTextField();
		bt1.setBounds(10, 70, 100, 20);
		panelcambios.add(bt1);

		JLabel b2 = new JLabel("Nombre");
		b2.setBounds(10, 100, 130, 20);
		panelcambios.add(b2);

		JTextField bt2 = new JTextField();
		bt2.setBounds(10, 130, 100, 20);
		panelcambios.add(bt2);

		JLabel b3 = new JLabel("Primer ap");
		b3.setBounds(10, 160, 130, 20);
		panelcambios.add(b3);

		JTextField bt3 = new JTextField();
		bt3.setBounds(10, 190, 100, 20);
		panelcambios.add(bt3);

		JLabel b4 = new JLabel("Segundo ap");
		b4.setBounds(10, 220, 130, 20);
		panelcambios.add(b4);

		JTextField bt4 = new JTextField();
		bt4.setBounds(10, 250, 100, 20);
		panelcambios.add(bt4);
		// Num_Control | Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno |
		// Edad_Alumno | Semestre | Carrera
		JLabel b5 = new JLabel("Edad");
		b5.setBounds(10, 280, 130, 20);
		panelcambios.add(b5);

		JTextField bt5 = new JTextField();
		bt5.setBounds(10, 310, 100, 20);
		panelcambios.add(bt5);

		JLabel b6 = new JLabel("Semestre");
		b6.setBounds(150, 40, 130, 20);
		panelcambios.add(b6);

		JTextField bt6 = new JTextField();
		bt6.setBounds(150, 70, 100, 20);
		panelcambios.add(bt6);

		JLabel b7 = new JLabel("Carrera");
		b7.setBounds(150, 100, 130, 20);
		panelcambios.add(b7);

		JTextField bt7 = new JTextField();
		bt7.setBounds(150, 130, 100, 20);
		panelcambios.add(bt7);

		/*
		 * 
		 * JButton b1 = new JButton(); b1.setBounds(10,120, 30,15); panelsc.add(b1);
		 * 
		 * b1.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * 
		 * tabla = new Controlador().retornarTabla("Ayuntamiento");
		 * 
		 * 
		 * JScrollPane paneltabla = new JScrollPane(tabla);
		 * paneltabla.setBounds(10,10,400, 200); panelsc.add(paneltabla);
		 * 
		 * 
		 * 
		 * } });
		 */
	}

}

public class VentanaInicio {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Gui();

			}
		});

	}

}
