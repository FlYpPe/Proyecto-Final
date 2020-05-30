package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
	JButton bAcambio, bPcambio,bScambio;
	JTable tabla;
	JMenuBar menuBar;
	JMenu menuInicio, menuTools;
	JMenuItem menuAltas, menuCambio, menuBajas, menuConsultas, menuReestablecer;
	JPanel panActual;
	String opReg;

	public Gui() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema ABCC");

		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);

		menuBar = new JMenuBar();
		menuInicio = new JMenu("Ver");
		menuTools = new JMenu("Tools");
		menuReestablecer = new JMenuItem("Reestablecer Componentes");

		menuTools.add(menuReestablecer);
		menuAltas = new JMenuItem("Altas");
		menuCambio = new JMenuItem("Cambio");
		menuBajas = new JMenuItem("Bajas");
		menuConsultas = new JMenuItem("Consultas");

		menuInicio.add(menuAltas);
		menuInicio.add(menuCambio);
		menuInicio.add(menuBajas);
		menuInicio.add(menuConsultas);
		menuBar.add(menuInicio);
		menuBar.add(menuTools);
		setJMenuBar(menuBar);

		JPanel panelaltas = new JPanel();
		panelaltas.setLayout(null);
		panelaltas.setBounds(100, 0, 600, 500);
		add(panelaltas);
		panActual = panelaltas;
		JPanel panelcambios = new JPanel();
		panelcambios.setLayout(null);
		panelcambios.setBounds(0, 0, 700, 500);
		add(panelcambios);
		panelcambios.setVisible(false);
		JPanel panelbajas = new JPanel();
		panelbajas.setLayout(null);
		panelbajas.setBounds(0, 0, 700, 500);
		add(panelbajas);
		panelbajas.setVisible(false);
		JPanel panelconsultas = new JPanel();
		panelconsultas.setLayout(null);
		panelconsultas.setBounds(0, 0, 700, 500);
		add(panelconsultas);
		panelconsultas.setVisible(false);

		menuReestablecer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				restablecerComponentes(panActual.getComponents());

			}
		});

		menuAltas.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				panelaltas.setVisible(true);
				panelcambios.setVisible(false);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(false);
				panActual = panelaltas;
				
				bAcambio.setVisible(true);
				bPcambio.setVisible(true);
				bScambio.setVisible(true);
				
			}
		});

		menuCambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelaltas.setVisible(false);
				panelcambios.setVisible(true);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(false);
				panActual = panelcambios;
				
				bAcambio.setVisible(false);
				bPcambio.setVisible(false);
				bScambio.setVisible(false);
			}
		});

		menuBajas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				panelaltas.setVisible(false);
				panelcambios.setVisible(false);
				panelbajas.setVisible(true);
				panelconsultas.setVisible(false);
				panActual = panelbajas;
				
				bAcambio.setVisible(false);
				bPcambio.setVisible(false);
				bScambio.setVisible(false);
			}
		});

		menuConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelaltas.setVisible(false);
				panelcambios.setVisible(false);
				panelbajas.setVisible(false);
				panelconsultas.setVisible(true);
				panActual = panelconsultas;
				
				bAcambio.setVisible(false);
				bPcambio.setVisible(false);
				bScambio.setVisible(false);
			}
		});

		JLabel lb0 = new JLabel("Ingrese los datos para ingresar al ayuntamiento");
		lb0.setBounds(10, 10, 250, 20);
		panelaltas.add(lb0);

		JLabel lb1 = new JLabel("Departamento");
		lb1.setBounds(10, 40, 130, 20);
		panelaltas.add(lb1);

		JTextField t1 = new JTextField();
		t1.setBounds(10, 70, 100, 20);
		panelaltas.add(t1);
		JTextField t1b = new JTextField();
		t1b.setBounds(10, 70, 100, 20);

		JTextField t1c = new JTextField();
		t1c.setBounds(10, 70, 100, 20);

///////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lb2 = new JLabel("Estado de funcionamiento");
		lb2.setBounds(10, 100, 130, 20);
		panelaltas.add(lb2);

		JTextField t2 = new JTextField();
		t2.setBounds(10, 130, 100, 20);
		panelaltas.add(t2);
		JTextField t2b = new JTextField();
		t2b.setBounds(10, 130, 100, 20);
		String items[] = { "500", "1000", "1500", "2000", "2500" };
		JComboBox<String> combo0 = new JComboBox<String>(items);
		combo0.setBounds(10, 130, 100, 20);
		combo0.setBackground(Color.WHITE);

///////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lb3 = new JLabel("Cantidad de personal en la area");
		lb3.setBounds(10, 160, 200, 20);
		panelaltas.add(lb3);

		JComboBox<String> combo2 = new JComboBox<String>(items);
		combo2.setBounds(10, 190, 100, 20);
		panelaltas.add(combo2);
		combo2.setBackground(Color.WHITE);

		JComboBox<String> comboB2 = new JComboBox<String>(items);
		comboB2.setBounds(10, 190, 100, 20);
		comboB2.setBackground(Color.WHITE);

		JComboBox<String> comboC2 = new JComboBox<String>(items);
		comboC2.setBounds(10, 190, 100, 20);
		comboC2.setBackground(Color.WHITE);

///////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lb4 = new JLabel("Nombre del encargado");
		lb4.setBounds(10, 220, 300, 20);
		panelaltas.add(lb4);

		JTextField t4 = new JTextField();
		t4.setBounds(10, 250, 100, 20);
		panelaltas.add(t4);

		JComboBox<String> combo3 = new JComboBox<String>(items);
		combo3.setBounds(10, 250, 100, 20);
		combo3.setBackground(Color.WHITE);

		JTextField t4b = new JTextField();
		t4b.setBounds(10, 250, 100, 20);

		add(panelaltas, BorderLayout.CENTER);
		panelaltas.setBackground(Color.white);

///////////////////////////////////////////////////////////////////////////////////////////////////////////

		opReg = "Ay";
		
		JButton bAltas = new JButton("Dar de alta");
		bAltas.setBounds(200, 200, 100, 35);
		bAltas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (opReg.equals("Ay")) {
					
				
				
				if (t1.getText().equals("") || t2.getText().equals("") || t4.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");

				} else {
					
					String sql = "";
					sql = "Values( \'" + t1.getText() + "\' , \'" + t2.getText() + "\' ," + Integer.parseInt((String) combo2.getSelectedItem())+ ", \'" + t4.getText() + " \'); ";					
					System.out.println(sql);
					
					new Controlador().agregarRegistro("Ayuntamiento", sql);
					
					
					try {

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					}
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			}else if (opReg.equals("Pe")) {
				
				if (t1b.getText().equals("") || t2b.getText().equals("")) {
					
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");

				} else {
					
					String sql = "";
					sql = "Values( \'" + t2b.getText() + "\' , \'" + t2b.getText() + "\' ," + Integer.parseInt((String) comboB2.getSelectedItem())+ ", " + Integer.parseInt((String) combo3.getSelectedItem()) + " ); ";
					new Controlador().agregarRegistro("Personal", sql);
					try {

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					}
				}
				
				
				/*
				panelaltas.add(t1b);
				panelaltas.add(t2b);
				panelaltas.add(comboB2);
				panelaltas.add(combo3);
				*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			}else if (opReg.equals("Si")) {
				
				if (t1c.getText().equals("") || t4b.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");

				} else {
					
					
					String sql = "";
					sql = "Values( \'" + t1c.getText() + "\' , " + Integer.parseInt((String) combo0.getSelectedItem()) + " ," + Integer.parseInt((String) comboC2.getSelectedItem()) + ", \'" + t4b.getText() + "\'); ";					
					System.out.println(sql);
					
					new Controlador().agregarRegistro("SistemaRecoleccion", sql);
					

					try {

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					}
				}
				
				
				
				/*
				panelaltas.add(t1c);
				panelaltas.add(combo0);
				panelaltas.add(comboC2);
				panelaltas.add(t4b);
				*/
				
			}
}
		});
		
		
		bAltas.setBackground(Color.WHITE);
		panelaltas.add(bAltas);
		
		
		
		bAcambio = new JButton("Ayuntamiento");
		bAcambio.setBounds(0, 0, 100, 60);
		bAcambio.setBackground(Color.white);
		add(bAcambio);

		bAcambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				opReg = "Ay";
				panelaltas.remove(t1);
				panelaltas.remove(t2);
				panelaltas.remove(combo2);
				panelaltas.remove(t4);

				panelaltas.remove(t1b);
				panelaltas.remove(t2b);
				panelaltas.remove(comboB2);
				panelaltas.remove(combo3);

				panelaltas.remove(t1c);
				panelaltas.remove(combo0);
				panelaltas.remove(comboC2);
				panelaltas.remove(t4b);

				panelaltas.add(t1);
				panelaltas.add(t2);
				panelaltas.add(combo2);
				panelaltas.add(t4);

				lb1.setText("Departamento");
				lb2.setText("Estado de funcionamiento");
				lb3.setText("Cantidad de personal en la area");
				lb4.setText("Nombre del encargado");

				panelaltas.setVisible(false);
				panelaltas.setVisible(true);
				
				
			}
		});
		
		add(bAcambio);

		bPcambio = new JButton("Personal");
		bPcambio.setBounds(0, 60, 100, 60);
		bPcambio.setBackground(Color.white);

		bPcambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				opReg = "Pe";
				panelaltas.remove(t1);
				panelaltas.remove(t2);
				panelaltas.remove(combo2);
				panelaltas.remove(t4);

				panelaltas.remove(t1b);
				panelaltas.remove(t2b);
				panelaltas.remove(comboB2);
				panelaltas.remove(combo3);

				panelaltas.remove(t1c);
				panelaltas.remove(combo0);
				panelaltas.remove(comboC2);
				panelaltas.remove(t4b);

				panelaltas.add(t1b);
				panelaltas.add(t2b);
				panelaltas.add(comboB2);
				panelaltas.add(combo3);

				lb1.setText("Nombre");
				lb2.setText("Area");
				lb3.setText("Sueldo");
				lb4.setText("Horas Diarias");

				panelaltas.setVisible(false);
				panelaltas.setVisible(true);
				
				
			}
		});
		add(bPcambio);

		bScambio = new JButton("Sistema");
		bScambio.setBounds(0, 120, 100, 60);
		bScambio.setBackground(Color.white);

		bScambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				opReg = "Si";
				panelaltas.remove(t1c);
				panelaltas.remove(combo0);
				panelaltas.remove(comboC2);
				panelaltas.remove(t4b);

				panelaltas.remove(t1);
				panelaltas.remove(t2);
				panelaltas.remove(combo2);
				panelaltas.remove(t4);

				panelaltas.remove(t1b);
				panelaltas.remove(t2b);
				panelaltas.remove(comboB2);
				panelaltas.remove(combo3);

				panelaltas.add(t1c);
				panelaltas.add(combo0);
				panelaltas.add(comboC2);
				panelaltas.add(t4b);

				lb1.setText("Estrategia");
				lb2.setText("Vehiculos");
				lb3.setText("Cantidad Empleados");
				lb4.setText("Estado");

				panelaltas.setVisible(false);
				panelaltas.setVisible(true);
				
			}
		});

		add(bScambio);



		JLabel blb0 = new JLabel("Ingrese los datos del alumno");
		blb0.setBounds(10, 10, 200, 20);
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
		panelcambios.setVisible(false);

		/*
		 * JButton bot = new JButton("aqui"); bot.setBounds(300,220, 30,15); add(bot);
		 * 
		 * bot.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * 
		 * tabla = new Controlador().retornarTabla("Ayuntamiento");
		 * 
		 * 
		 * JScrollPane paneltabla = new JScrollPane(tabla);
		 * paneltabla.setBounds(10,10,400, 200); add(paneltabla);
		 * 
		 * 
		 * 
		 * } });
		 */

	}

	public void restablecerComponentes(Component... component) {

		for (Component c : component) {
			// Comparison con getClass

			if (c instanceof JTextField)
				((JTextField) c).setText("");
			else if (c instanceof JComboBox)
				((JComboBox) c).setSelectedIndex(0);
		}

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
