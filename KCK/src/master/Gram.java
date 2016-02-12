package master;

import java.util.Hashtable;
import java.util.Scanner;

import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

public class Gram {

	private Term prologText;

	//Konstruktor sprawdza czy plik gram.pl istnieje 
	
	public Gram() {
		
		String t1 = "consult('gram.pl')";
		Query q1 = new Query(t1);
		System.out.println(t1 + " " + (q1.hasSolution() ? "succeeded" : "failed"));
		
		
	}

	public String getPrologText(String input) {

		input = input.toLowerCase();
		String sentence = input;
		String stringPrologText = null;
		prologText = null;
		Move move = new Move();
		
		if (sentence != null && !sentence.isEmpty()) {
			String[] words = sentence.split(" ");
			//zmiana wprowadzonego tekstu na tekst do prologu
			sentence = "zdanie(X, [" + String.join(", ", words) + "], [])";
			
			
			if (Query.hasSolution(sentence)) {
				//pobranie tekstu z prologu
				prologText = Query.oneSolution(sentence).get("X");
				stringPrologText = prologText.toString();
				//ustawienie komendy w move na ta pobrana z prologa
				move.setCommand(stringPrologText);
				
			} else {
				stringPrologText = "Komenda nie zostala rozpoznana.";
				move.setCommand(stringPrologText);
			}
		}
		return stringPrologText;
	}

}
