package master;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Console extends JFrame {

	public void run_console() {
		
		//utworzenie nowej rami z konsol¹
		
		JFrame console_frame = new JFrame("Console JPanel");
		console_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		console_frame.setLayout(new BorderLayout());
		console_frame.pack();
		console_frame.setSize(400, 200);
		console_frame.setLocationRelativeTo(null);
		console_frame.setVisible(true);
		
		//utworzenie dwóch TextField 
		//jeden pobiera to co wpisuje u¿ytkownik
		//drugi wypisuje odpowiedz agenta poruszajacego sie po planszy
		
		JTextField userText = new JTextField();
		JTextField consoleText = new JTextField();
		Font font1 = new Font("SansSerif", Font.BOLD, 15);
		
		userText.setBounds(0, 0, 100, 100);
		userText.setSize(350, 50);
		userText.setFont(font1);
	
		consoleText.setBounds(150, 150, 100, 100);
		consoleText.setSize(350, 50);
		consoleText.setFont(font1);
		
		console_frame.add(userText);
		console_frame.add(consoleText);
		
		Gram gram = new Gram();
		Move move = new Move();
		
		userText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				consoleText.setText("");
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					System.out.println(userText.getText()); 
					System.out.println(gram.getPrologText(userText.getText()));
										
					//System.out.println(move.getCommand());  
					consoleText.setText(move.getAnswer());
					userText.setText("");

				}
			}
		});

	}

}