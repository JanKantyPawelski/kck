package master;

public class Move {

		public static String answer;
		public static String command;
		
		public void setCommand(String prologOutput){  
			command = prologOutput;
		}
		
		public String getCommand(){
			return command;
		}
		
		//Funkcja wypisuj¹ca odpwiedzi agenta na tekst uzytkownika
		//Narazie to tylko przykladowe zdania
		//Chyba trzeba bedzie zmienic troche prolog bo tak to za duzo roboty
		//najlepiej zrobic tylko takie podstawowe komendy
		
		public String getAnswer(){
			
			if (command.equals("Komenda nie zostala rozpoznana.")){
				answer = "Nie wiem co mam robic, wydaj polecenie jeszcze raz";
			}	
			else if (command.equals("move(walk, dir(straight))")) { 
				answer = "Ide prosto";
			}
			else if (command.equals("move(walk, dir(south))")){
				answer = "Ide na poludnie";
			}	
			else if (command.equals("move(walk, dir(east))")){
				answer = "Ide na zachod";
			}	
			else if (command.equals("move(walk, dir(north))")){
				answer = "Ide na polnoc";
			}	
			else if (command.equals("move(walk, dir(west))")){
				answer = "Ide na wschod";
			}	
			else if (command.equals("move(walk, dir(rt))")){
				answer = "Ide w prawo";
			}	
			else if (command.equals("move(walk, dir(lt))")){
				answer = "Ide w lewo";
			}	
			else if (command.equals("move(walk, dir(up))")){
				answer = "Ide do gory";
			}	
			else if (command.equals("move(walk, dir(down))")){
				answer = "Ide na dol";
			}	
			else if (command.equals("move(walk, goal(monument))")){
				answer = "Ide do pomnika";
			}	
			else if (command.equals("move(walk, goal(mosque))")){
				answer = "Ide do meczetu";
			}	
			else if (command.equals("move(walk, goal(church))")){
				answer = "Ide do kosciola";			
			}	
			else if (command.equals("move(walk, goal(townhall))")){
				answer = "Ide do ratusza";			
			}	
			else if (command.equals("move(walk, goal(hospital))")){
				answer = "Ide do szpitala";			
			}	
			else if (command.equals("move(walk, goal(baker))")){
				answer = "Ide do pierkani";			
			}	
			else if (command.equals("move(walk, goal(castle))")){
				answer = "Ide do zamku";			
			}
			else if (command.equals("move(walk, goal(school))")){
				answer = "Ide do szkoly";			
			}
			else if (command.equals("move(walk, goal(park))")){
				answer = "Ide do parku";			
			}
			else if (command.equals("move(walk, goal(restaurant))")){
				answer = "Ide do restauracji";
			}
			else
				answer = "answer";
			
			return answer;
		}
			
			
			

		
}
