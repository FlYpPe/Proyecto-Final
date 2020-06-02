package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;

import Controlador.*;
import Modelo.ModeloAyunta;

class Gui extends JFrame {

	JButton bAcambio, bPcambio, bScambio, bChecar, bCambiar, bAltas;
	JTable tabla;
	JMenuBar menuBar;
	JMenu menuInicio, menuTools;
	JMenuItem menuAltas, menuCambio, menuBajas, menuConsultas, menuReestablecer;
	JPanel panActual;
	String opReg, opBaja;
	JScrollPane paneltabla;
	ImageIcon imagen;
	Icon icono;

	public Gui() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema ABCC");
		setResizable(false);
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
		panelcambios.setBounds(100, 0, 600, 500);
		add(panelcambios);
		panelcambios.setVisible(false);
		JPanel panelbajas = new JPanel();
		panelbajas.setLayout(null);
		panelbajas.setBounds(700, 0, 700, 500);
		panelbajas.setBackground(Color.WHITE);
		add(panelbajas);
		JPanel panelconsultas = new JPanel();
		panelconsultas.setLayout(null);
		panelconsultas.setBounds(700, 0, 700, 500);
		panelconsultas.setBackground(Color.white);
		add(panelconsultas);

		menuReestablecer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				restablecerComponentes(panActual.getComponents());

			}
		});

		menuAltas.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				
				panelaltas.setBounds(100, 0, 600, 500);
				panelbajas.setBounds(700, 0, 700, 500);
				panelconsultas.setBounds(700, 0, 700, 500);
				panActual = panelaltas;

				bAcambio.setBounds(0, 0, 100, 60);
				bPcambio.setBounds(0, 60, 100, 60);
				bScambio.setBounds(0, 120, 100, 60);
				bChecar.setBounds(700, 200, 90, 90);

				bAltas.setBounds(200, 200, 100, 100);
				bCambiar.setBounds(700, 200, 100, 35);
				bCambiar.setEnabled(false);
			}
		});

		menuCambio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelaltas.setBounds(100, 0, 600, 500);
				panelbajas.setBounds(700, 0, 700, 500);
				panelconsultas.setBounds(700, 0, 700, 500);
				panActual = panelaltas;

				bAcambio.setBounds(0, 0, 100, 60);
				bPcambio.setBounds(0, 60, 100, 60);
				bScambio.setBounds(0, 120, 100, 60);
				bChecar.setBounds(200, 100, 90, 90);

				bAltas.setBounds(700, 200, 100, 35);
				bCambiar.setBounds(200, 200, 100, 35);
				bCambiar.setEnabled(false);
			}
		});

		menuBajas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				panelaltas.setBounds(700, 0, 600, 500);
				panelbajas.setBounds(0, 0, 700, 500);
				panelconsultas.setBounds(700, 0, 700, 500);
				panActual = panelbajas;

				bAcambio.setBounds(700, 0, 100, 60);
				bPcambio.setBounds(700, 60, 100, 60);
				bScambio.setBounds(700, 120, 100, 60);
				bChecar.setBounds(700, 200, 90, 90);
				bCambiar.setEnabled(false);
			}
		});

		menuConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelaltas.setBounds(700, 0, 600, 500);
				panelbajas.setBounds(700, 0, 700, 500);
				panelconsultas.setBounds(0, 0, 700, 500);
				panActual = panelconsultas;

				bAcambio.setBounds(700, 0, 100, 60);
				bPcambio.setBounds(700, 60, 100, 60);
				bScambio.setBounds(700, 120, 100, 60);
				bChecar.setBounds(700, 200, 90, 90);
				bCambiar.setEnabled(false);
			}
		});

		JLabel lb0 = new JLabel("Ingrese los datos");
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

		bAltas = new JButton("Dar de alta");
		bAltas.setBounds(200, 200, 100, 100);
		imagen = new ImageIcon("src/Imagenes/list_add_user.png");
		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(bAltas.getWidth(), bAltas.getHeight(), Image.SCALE_DEFAULT));
		bAltas.setIcon(icono);
		
		
		bAltas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (opReg.equals("Ay")) {

					if (t1.getText().equals("") || t2.getText().equals("") || t4.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					} else {
						String sql = "Departamento = '" + t1.getText() + "'";
						if (new Controlador().revisar("Ayuntamiento", sql)) {
							JOptionPane.showMessageDialog(getParent(), "No se registro, informacion duplicada");
						}else {
						
						sql = "";
						sql = "Values( \'" + t1.getText() + "\' , \'" + t2.getText() + "\' ,"
								+ Integer.parseInt((String) combo2.getSelectedItem()) + ", \'" + t4.getText()
								+ " \'); ";
						JOptionPane.showMessageDialog(getParent(), "Registrado correctamente");

						new Controlador().agregarRegistro("Ayuntamiento", sql);
						
						}
						try {

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}					
///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Pe")) {

					if (t1b.getText().equals("") || t2b.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");
					} else {
						String sql = "Nombre = '" + t1b.getText() + "'";
						if (new Controlador().revisar("Personal", sql)) {
							JOptionPane.showMessageDialog(getParent(), "No se registro, informacion duplicada");
						}else {
						sql = "";
						sql = "Values( \'" + t1b.getText() + "\' , \'" + t2b.getText() + "\' ,"
								+ Integer.parseInt((String) comboB2.getSelectedItem()) + ", "
								+ Integer.parseInt((String) combo3.getSelectedItem()) + " ); ";
						new Controlador().agregarRegistro("Personal", sql);
						JOptionPane.showMessageDialog(getParent(), "Registrado correctamente");
						}
						try {

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Si")) {

					// 1 t1 t2 combo2 t4
					// 2 t1b t2b comboB2 combo3
					// 3 t1c combo0 comboC2 t4b

					if (t1c.getText().equals("") || t4b.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					} else {
						String sql = "Estrategia = '" + t1c.getText() + "'";
						if (new Controlador().revisar("SistemaRecoleccion", sql)) {
							JOptionPane.showMessageDialog(getParent(), "No se registro, informacion duplicada");
						}else {
						sql = "";
						sql = "Values( \'" + t1c.getText() + "\' , "
								+ Integer.parseInt((String) combo0.getSelectedItem()) + " ,"
								+ Integer.parseInt((String) comboC2.getSelectedItem()) + ", \'" + t4b.getText()
								+ "\'); ";
						JOptionPane.showMessageDialog(getParent(), "Registrado correctamente");
						

						new Controlador().agregarRegistro("SistemaRecoleccion", sql);
						}
						try {

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}

					/*
					 * panelaltas.add(t1c); panelaltas.add(combo0); panelaltas.add(comboC2);
					 * panelaltas.add(t4b);
					 */

				}
			}
		});

		bAltas.setBackground(Color.WHITE);

		panelaltas.add(bAltas);

		bAcambio = new JButton("Ayuntamiento");
		bAcambio.setBounds(0, 0, 100, 60);
		bAcambio.setBackground(Color.white);
		imagen = new ImageIcon("src/Imagenes/Ayuntamiento.png");
		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(bAcambio.getWidth(), bAcambio.getHeight(), Image.SCALE_DEFAULT));
		bAcambio.setIcon(icono);
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		bChecar = new JButton("Revisar");
		bChecar.setBounds(200, 700, 90, 90);
		imagen = new ImageIcon("src/Imagenes/Buscar.png");
		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		bChecar.setIcon(icono);
		bChecar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// 1 t1 t2 combo2 t4
				// 2 t1b t2b comboB2 combo3
				// 3 t1c combo0 comboC2 t4b

				// System.out.println(new Controlador().revisar("dsf"));
				// new Controlador().actualizar(new ModeloAyunta("qwe", "qwe", 10, "actu"));
				

				if (opReg.equals("Ay")) {

					if (!t1.getText().equals("")) {

						String sql = "Departamento = '" + t1.getText() + "'";
						
						bCambiar.setEnabled(new Controlador().revisar("Ayuntamiento", sql));
						
					}

					// sql = "Departamento = '" + a.getDepartamento() + "', Estado = '" +
					// a.getEstado() + "' , CantPersonal = " + a.getCantidadPersonal() + ",
					// Encargado = '" + a.getDepartamento()+ "' where encargado = '" +
					// a.getEncargado() + "'";

///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Pe")) {

					if (!t1b.getText().equals("")) {
						String sql = "Nombre = '" + t1b.getText() + "'";
						bCambiar.setEnabled(new Controlador().revisar("Personal", sql));
					}

					/*
					 * panelaltas.add(t1b); panelaltas.add(t2b); panelaltas.add(comboB2);
					 * panelaltas.add(combo3);
					 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Si")) {

					if (!t1c.getText().equals("")) {

						String sql = "Estrategia = '" + t1c.getText() + "'";
						bCambiar.setEnabled(new Controlador().revisar("SistemaRecoleccion", sql));

					}

				}

			}
		});
		
		
		bChecar.setBackground(Color.WHITE);
		panelaltas.add(bChecar);

		bCambiar = new JButton("Modificar");
		bCambiar.setBounds(700, 200, 100, 35);
		bCambiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (opReg.equals("Ay")) {

					if (t1.getText().equals("") || t2.getText().equals("") || t4.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					} else {

						String sql = "";
						try {
							sql = "Departamento = '" + t1.getText() + "', Estado = '" + t2.getText()
									+ "', CantPersonal = " + Integer.parseInt((String) combo2.getSelectedItem())
									+ " , Encargado = '" + t4.getText() + "'" + "WHERE Departamento = '" + t1.getText()
									+ "'";

							new Controlador().actualizar("Ayuntamiento", sql);
							JOptionPane.showMessageDialog(getParent(), "Cambiado correctamente");
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Pe")) {

					if (t1b.getText().equals("") || t2b.getText().equals("")) {

						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					} else {

						String sql = "";

						sql = "Nombre = '" + t1b.getText() + "', Area = '" + t2b.getText() + "', Sueldo = "
								+ Integer.parseInt((String) comboB2.getSelectedItem()) + " , horasDiarias = "
								+ Integer.parseInt((String) combo3.getSelectedItem()) + " WHERE Nombre = '" + t1b.getText() + "'";
						
						new Controlador().actualizar("Personal", sql);
						JOptionPane.showMessageDialog(getParent(), "Cambiado correctamente");
						try {

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}

					// 1 t1 t2 combo2 t4
					// 2 t1b t2b comboB2 combo3
					// 3 t1c combo0 comboC2 t4b
///////////////////////////////////////////////////////////////////////////////////////////////////////////
				} else if (opReg.equals("Si")) {

					// 1 t1 t2 combo2 t4
					// 2 t1b t2b comboB2 combo3
					// 3 t1c combo0 comboC2 t4b

					if (t1c.getText().equals("") || t4b.getText().equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Checar los datos");

					} else {

						String sql = "";
						
						try {
						
						sql = "Estrategia = '" + t1c.getText() + "', Vehiculos = " + Integer.parseInt((String) combo0.getSelectedItem()) + ", CantidadEmpleados = "
								+ Integer.parseInt((String) comboC2.getSelectedItem()) + " , Estado = '"
								+ t4b.getText() + "' WHERE Estrategia = '" + t1c.getText() + "'";
						
						new Controlador().actualizar("SistemaRecoleccion", sql);
						JOptionPane.showMessageDialog(getParent(), "Cambiado correctamente");

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "Checar los datos");

						}
					}


				}

			}
		});
		bCambiar.setBackground(Color.WHITE);
		bCambiar.setEnabled(false);
		panelaltas.add(bCambiar);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lbB1 = new JLabel("Ingrese la seccion a usar");
		lbB1.setBounds(200, 20, 150, 20);
		panelbajas.add(lbB1);
		String secc[] = { "Selecciona", "Ayuntamiento", "Personal", "Sistema Recoleccion" };
		JComboBox<String> cm = new JComboBox<String>(secc);
		cm.setBounds(200, 55, 140, 25);
		panelbajas.add(cm);

		
		
		JLabel lbB2 = new JLabel("Ingrese la seccion a usar");
		lbB2.setBounds(200, 90, 150, 20);
		panelbajas.add(lbB2);
		opBaja = "Ayuntamiento";
		cm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				opBaja = (String) cm.getSelectedItem();

				if (opBaja.equals("Ayuntamiento")) {
					lbB2.setText("Ingrese departamento");
				} else if (opBaja.equals("Personal")) {
					lbB2.setText("Ingrese Nombre");
				} else if (opBaja.equals("Sistema Recoleccion")) {
					lbB2.setText("Ingrese Estrategia");
				}

			}
		});

		JTextField tborr = new JTextField();
		tborr.setBounds(200, 120, 140, 25);
		panelbajas.add(tborr);

		JButton borrar = new JButton();
		borrar.setBounds(200, 155, 80, 30);
		imagen = new ImageIcon("src/Imagenes/edit_remove.png");
		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(80, 30, Image.SCALE_DEFAULT));
		borrar.setBackground(Color.white);
		borrar.setIcon(icono);
		borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!(tborr.getText().equals("") || cm.getSelectedItem().equals("Selecciona"))) {

					String sql;
					if (opBaja.equals("Ayuntamiento")) {
						sql = "Departamento = '" + tborr.getText() + "'";
						
						if (new Controlador().revisar("Ayuntamiento", sql)) {
							new Controlador().eliminarRegistro("Ayuntamiento", sql);
							JOptionPane.showMessageDialog(getParent(), "Registro eliminado correctamente");
						} else {
							JOptionPane.showMessageDialog(getParent(), "No coicide la entrada con ningun registro");
						}

					} else if (opBaja.equals("Personal")) {

						sql = "Nombre = '" + tborr.getText() + "'";
						if (new Controlador().revisar("Personal", sql)) {
							new Controlador().eliminarRegistro("Personal", sql);
							JOptionPane.showMessageDialog(getParent(), "Registro eliminado correctamente");
						} else {
							JOptionPane.showMessageDialog(getParent(), "No coicide la entrada con ningun registro");
						}

					} else if (opBaja.equals("Sistema Recoleccion")) {

						sql = "Estrategia = '" + tborr.getText() + "'";
						if (new Controlador().revisar("SistemaRecoleccion", sql)) {
							new Controlador().eliminarRegistro("SistemaRecoleccion", sql);
							JOptionPane.showMessageDialog(getParent(), "Registro eliminado correctamente");
						} else {
							JOptionPane.showMessageDialog(getParent(), "No coicide la entrada con ningun registro");
						}

					}

				} else {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");
				}
				// String sql =
				// num_control = '" + numControl + "'"

			}
		});

		panelbajas.add(borrar);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lbC1 = new JLabel("Ingrese la seccion a usar");
		lbC1.setBounds(200, 20, 150, 20);
		panelconsultas.add(lbC1);
		String sec[] = { "Selecciona", "Ayuntamiento", "Personal", "Sistema Recoleccion" };
		JComboBox<String> co = new JComboBox<String>(sec);
		co.setBounds(200, 55, 140, 25);
		JLabel lbC2 = new JLabel("Ingrese la seccion a usar");
		lbC2.setBounds(200, 90, 150, 20);
		panelconsultas.add(lbC2);
		panelconsultas.add(co);
		co.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				opBaja = (String) co.getSelectedItem();

				if (opBaja.equals("Ayuntamiento")) {
					lbC2.setText("Ingrese departamento");
				} else if (opBaja.equals("Personal")) {
					lbC2.setText("Ingrese Nombre");
				} else if (opBaja.equals("Sistema Recoleccion")) {
					lbC2.setText("Ingrese Estrategia");
				}

			}
		});

		JTextField tco = new JTextField();
		tco.setBounds(110, 120, 140, 25);
		panelconsultas.add(tco);

		JButton consultar = new JButton("Generar");
		consultar.setBounds(220, 150, 50, 50);
		consultar.setBackground(Color.white);
		imagen = new ImageIcon("src/Imagenes/crea.png");
		icono = new ImageIcon(
				imagen.getImage().getScaledInstance(consultar.getWidth(), consultar.getHeight(), Image.SCALE_DEFAULT));
		consultar.setIcon(icono);
		
		panelconsultas.add(consultar);

		JLabel lbC3 = new JLabel(" o ");
		lbC3.setBounds(260, 120, 30, 20);
		panelconsultas.add(lbC3);

		JCheckBox cb = new JCheckBox("Mostrar tabla completa");
		cb.setBounds(285, 120, 180, 20);
		cb.setBackground(Color.white);
		panelconsultas.add(cb);

		consultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if ((tco.getText().equals("") && !cb.isSelected()) || co.getSelectedItem().equals("Selecciona")) {

					JOptionPane.showMessageDialog(getParent(), "Checar los datos");

				} else {

					try {
						paneltabla.removeAll();
					} catch (Exception e2) {
						// TODO: handle exception
					}

					String sql;
					if (opBaja.equals("Ayuntamiento")) {

						if (cb.isSelected()) {
							tabla = new Controlador().retornarTabla("Ayuntamiento");
						} else {

							tabla = new Controlador()
									.retornarTabla("Ayuntamiento Where Departamento = '" + tco.getText() + "'");

						}
						paneltabla = new JScrollPane(tabla);

						paneltabla.setBounds(150, 210, 400, 200);
						add(paneltabla);

					} else if (opBaja.equals("Personal")) {

						if (cb.isSelected()) {
							tabla = new Controlador().retornarTabla("Personal");
						} else {
							tabla = new Controlador().retornarTabla("Personal Where Nombre = '" + tco.getText() + "'");
						}
						paneltabla = new JScrollPane(tabla);
						paneltabla.setBounds(150, 210, 400, 200);
						add(paneltabla);

					} else if (opBaja.equals("Sistema Recoleccion")) {
						if (cb.isSelected()) {
							tabla = new Controlador().retornarTabla("SistemaRecoleccion");
						} else {
							tabla = new Controlador()
									.retornarTabla("SistemaRecoleccion Where Estrategia = '" + tco.getText() + "'");
						}
						paneltabla = new JScrollPane(tabla);

						paneltabla.setBounds(150, 210, 400, 200);
						add(paneltabla);

					}

				}
				// String sql =
				// num_control = '" + numControl + "'"

			}
		});
		/*
		 * JButton bot = new JButton("aqui"); bot.setBounds(300, 220, 30, 15); add(bot);
		 * 
		 * bot.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * 
		 * tabla = new Controlador().retornarTabla("Ayuntamiento");
		 * 
		 * JScrollPane paneltabla = new JScrollPane(tabla); paneltabla.setBounds(10, 10,
		 * 400, 200); add(paneltabla);
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

class Login extends JFrame implements KeyListener{
	byte contador;
	String pass = "";
	JTextField t2;

	public Login() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		// setResizable(false);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setBorder(BorderFactory.createTitledBorder("Loggin"));
		panel.setBounds(75, 75, 500, 300);
		panel.setBackground(Color.white);
		add(panel);

		JLabel lb1 = new JLabel("Usuario");
		lb1.setBounds(170, 30, 100, 20);
		panel.add(lb1);

		JTextField t1 = new JTextField();
		t1.setBounds(170, 60, 150, 25);
		panel.add(t1);

		JLabel lb2 = new JLabel("Contraseña");
		lb2.setBounds(170, 95, 100, 20);
		panel.add(lb2);

		t2 = new JTextField();
		t2.setBounds(170, 115, 150, 25);
		t2.addKeyListener(this);
		panel.add(t2);
		
		JButton b1 = new JButton("Ingresar");
		b1.setBounds(190, 155, 100, 25);
		panel.add(b1);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((t1.getText().equals("") || t2.getText().equals(""))) {
					JOptionPane.showMessageDialog(getParent(), "Checar los datos");

				} else {
					if (new Controlador().revisar("paswords", t1.getText(), pass)) {
						new Gui();
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(getParent(), "Contrasena y usuario incorrecto");
					}

				}

			}
		});

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==8) {
			try {
				t2.setText(t2.getText().substring(0,t2.getText().length()-1));
				pass.substring(0, pass.length()-1);
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else {
			if (rootPaneCheckingEnabled) {
				
			}
			
			pass = pass + e.getKeyChar();
			try {
				
			t2.setText(t2.getText().substring(0,t2.getText().length()-1) + "*");
			}catch (Exception f) {
				// TODO: handle exception
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

		
		
	}

}

public class VentanaInicio {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				new Login();
				

			}
		});

	}

}
