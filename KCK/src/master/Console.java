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
					
					String command;
					command = userText.getText();
					command = command.toLowerCase();
					command = RemoveAccent(command);
					
					if(command.equals("witaj") || command.equals("hej") || command.equals("czesc")){
						consoleText.setText("Witam");
					}
					else if(command.equals("co mam robic") || command.equals("nie wiem co robic") || 
							command.equals("?") || command.equals("co robic") ||
							command.equals(" ") || command.equals("o co chodzi") ){
						consoleText.setText("Powiedz mi gdzie mam isc");
					}
					
					else if (command.equals("wyjdz") || command.equals("exit") || command.equals("koniec")||
							command.equals("wyjscie") || command.equals("wychodze") || command.equals("zakoncz gre")){
						System.exit(0);
					}
					else if (command.equals("idz") || command.equals("kieruj sie") || 
							command.equals("jedz") || command.equals("pojdz") || command.equals("dojdz")){
						consoleText.setText("Nie wiem gdzie. Napisz gdzie chcesz zebym szed³");
					}
					else if (command.equals("skrec")){
						consoleText.setText("Nie wiem jak. Napisz jak mam skrecic");
					}
					else if (command.equals("cofnij") || command.equals("wroc")){
						//Cofanie poprzedniego ruchu
					}
					else{
						System.out.println(command); 
						System.out.println(gram.getPrologText(command));
					 	consoleText.setText(move.getAnswer());
					}
					userText.setText("");

				}
			}
		});

	}
	public String RemoveAccent(String s)
	{
		return s.replace('¹', 'a')

				.replace('æ', 'c')

				.replace('ê', 'e')

				.replace('³', 'l')

				.replace('ñ', 'n')

				.replace('ó', 'o')

				.replace('œ', 's')

				.replace('Ÿ', 'z')

				.replace('¿', 'z');
	}

}