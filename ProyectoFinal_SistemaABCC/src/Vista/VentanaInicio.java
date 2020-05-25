package Vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Gui extends JFrame{
	
	public Gui() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema ABCC");

		setSize(500, 460);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
		
		
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
