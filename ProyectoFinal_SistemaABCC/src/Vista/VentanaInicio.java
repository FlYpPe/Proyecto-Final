package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;	
import Controlador.*;

class Gui extends JFrame{
	
	JTable tabla;
	
	public Gui() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema ABCC");

		setSize(500, 460);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
		/*
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel .setBounds(10,10, 100,100);
		add(panel);
		*/
		JButton b1 = new JButton();
		b1.setBounds(10,120, 30,15);
		add(b1);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				tabla =  new Controlador().retornarTabla("Ayuntamiento");
				
				
				JScrollPane panelsc = new JScrollPane(tabla);
				panelsc.setBounds(10,10,400, 200);
				add(panelsc);
				
				
				
			}
		});
		
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
