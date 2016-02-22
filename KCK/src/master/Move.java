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
			else if (command.equals("move(walk, dir(straight))") || 
					command.equals("move(head, dir(straight))") ||
					command.equals("move(drive, dir(straight))")||
					command.equals("move(go, dir(straight))")) { 
				answer = "Ide prosto";
			}
			else if (command.equals("move(walk, dir(south))")|| 
					command.equals("move(head, dir(south))") ||
					command.equals("move(drive, dir(south)")||
					command.equals("move(go, dir(south)")){
				answer = "Ide na poludnie";
			}	
			else if (command.equals("move(walk, dir(east))")|| 
					command.equals("move(head, dir(east))") ||
					command.equals("move(drive, dir(east))")||
					command.equals("move(go, dir(east))")){
				answer = "Ide na zachod";
			}	
			else if (command.equals("move(walk, dir(north))")|| 
					command.equals("move(head, dir(north))") ||
					command.equals("move(drive, dir(north))")||
					command.equals("move(go, dir(north))")){
				answer = "Ide na polnoc";
			}	
			else if (command.equals("move(walk, dir(west))")|| 
					command.equals("move(head, dir(west))") ||
					command.equals("move(drive, dir(west))")||
					command.equals("move(go, dir(west))")){
				answer = "Ide na wschod";
			}	
			else if (command.equals("move(walk, dir(rt))")|| 
					command.equals("move(head, dir(rt))") ||
					command.equals("move(drive, dir(rt))")||
					command.equals("move(go, dir(rt))")){
				answer = "Ide w prawo";
			}	
			else if (command.equals("move(walk, dir(lt))")|| 
					command.equals("move(head, dir(lt))") ||
					command.equals("move(drive, dir(lt))")||
					command.equals("move(go, dir(lt))")){
				answer = "Ide w lewo";
			}	
			else if (command.equals("move(walk, dir(up))")|| 
					command.equals("move(head, dir(up))") ||
					command.equals("move(drive, dir(up))")||
					command.equals("move(go, dir(up))")){
				answer = "Ide do gory";
			}	
			else if (command.equals("move(walk, dir(down))")|| 
					command.equals("move(head, dir(down))") ||
					command.equals("move(drive, dir(down))")||
					command.equals("move(go, dir(down))")){
				answer = "Ide na dol";
			}	
			else if (command.equals("move(walk, goal(fountain))")||
					command.equals("move(head, goal(fountain))")||
					command.equals("move(drive, goal(fountain))")||
					command.equals("move(go, goal(fountain))")||
					command.equals("move(reach, fountain)")){
				answer = "Ide do fonatnny";
			}	
			else if (command.equals("move(walk, goal(mosque))")||
					command.equals("move(head, goal(mosque))")||
					command.equals("move(drive, goal(mosque))")||
					command.equals("move(go, goal(mosque))")||
					command.equals("move(reach, mosque)")){
				answer = "Ide do meczetu";
			}	
			else if (command.equals("move(walk, goal(church))")||
					command.equals("move(head, goal(church))")||
					command.equals("move(drive, goal(church))")||
					command.equals("move(go, goal(church))")||
					command.equals("move(reach, church)")){
				answer = "Ide do kosciola";			
			}	
			else if (command.equals("move(walk, goal(townhall))")||
					command.equals("move(head, goal(townhall))")||
					command.equals("move(drive, goal(townhall))")||
					command.equals("move(go, goal(townhall))")||
					command.equals("move(reach, townhall)")){
				answer = "Ide do ratusza";			
			}	
			else if (command.equals("move(walk, goal(hospital))")||
					command.equals("move(head, goal(hospital))")||
					command.equals("move(drive, goal(hospital))")||
					command.equals("move(go, goal(hospital))")||
					command.equals("move(reach, hospital)")){
				answer = "Ide do szpitala";			
			}	
			else if (command.equals("move(walk, goal(baker))")||
					command.equals("move(head, goal(baker))")||
					command.equals("move(drive, goal(baker))")||
					command.equals("move(go, goal(baker))")||
					command.equals("move(reach, baker)")){
				answer = "Ide do pierkani";			
			}	
			else if (command.equals("move(walk, goal(castle))")||
					command.equals("move(head, goal(castle))")||
					command.equals("move(drive, goal(castle))")||
					command.equals("move(go, goal(castle))")||
					command.equals("move(reach, castle)")){
				answer = "Ide do zamku";			
			}
			else if (command.equals("move(walk, goal(school))")||
					command.equals("move(head, goal(school))")||
					command.equals("move(drive, goal(school))")||
					command.equals("move(go, goal(school))")||
					command.equals("move(reach, school)")){
				answer = "Ide do szkoly";			
			}
			else if (command.equals("move(walk, goal(park))")||
					command.equals("move(head, goal(park))")||
					command.equals("move(drive, goal(park))")||
					command.equals("move(go, goal(park))")||
					command.equals("move(reach, park)")){
				answer = "Ide do parku";			
			}
			else if (command.equals("move(walk, goal(restaurant))")||
					command.equals("move(head, goal(restaurant))")||
					command.equals("move(drive, goal(restaurant))")||
					command.equals("move(go, goal(restaurant))")||
					command.equals("move(reach, restaurant)")){
				answer = "Ide do restauracji";
			}
			else if(command.equals("move(reach, fountain, left)")){
				answer = "Ide do fontanny z lewej strony";
			}
			else if(command.equals("move(reach, fountain, right)")){
				answer = "Ide do fonatnny z prawej strony";
			}
			else if(command.equals("move(reach, mosque, left)")){
				answer = "Ide do meczetu z lewej strony";
			}
			else if(command.equals("move(reach, mosque, right)")){
				answer = "Ide do meczetu z prawej strony";
			}
			else if(command.equals("move(reach, church, left)")){
				answer = "Ide do kosciola z lewej strony";
			}
			else if(command.equals("move(reach, church, right)")){
				answer = "Ide do kosciola z prawej strony";
			}
			else if(command.equals("move(reach, townhall, left)")){
				answer = "Ide do ratusza z lewej strony";
			}
			else if(command.equals("move(reach, townhall, right)")){
				answer = "Ide do ratusza z prawej strony";
			}
			else if(command.equals("move(reach, hospital, left)")){
				answer = "Ide do szpitala z lewej strony";
			}
			else if(command.equals("move(reach, hospital, right)")){
				answer = "Ide do szpitala z prawej strony";
			}
			else if(command.equals("move(reach, baker, left)")){
				answer = "Ide do piekarni z lewej strony";
			}
			else if(command.equals("move(reach, baker, right)")){
				answer = "Ide do piekarni z prawej strony";
			}
			else if(command.equals("move(reach, castle, left)")){
				answer = "Ide do zamku z lewej strony";
			}
			else if(command.equals("move(reach, castle, right)")){
				answer = "Ide do zamku z prawej strony";
			}
			else if(command.equals("move(reach, school, left)")){
				answer = "Ide do szkoly z lewej strony";
			}
			else if(command.equals("move(reach, school, right)")){
				answer = "Ide do szkoly z prawej strony";
			}
			else if(command.equals("move(reach, park, left)")){
				answer = "Ide do parku z lewej strony";
			}
			else if(command.equals("move(reach, park, right)")){
				answer = "Ide do parku z prawej strony";
			}
			else if(command.equals("move(reach, restaurant, left)")){
				answer = "Ide do restauracji z lewej strony";
			}
			else if(command.equals("move(reach, restaurant, right)")){
				answer = "Ide do restauracji z prawej strony";
			}
			else if(command.equals("move(turn, dir(rt))")){
				answer = "Skrecam w prawo";
			}
			else if(command.equals("move(turn, dir(lt))")){
				answer = "Skrecam w lewo";
			}
			else if(command.equals("move(turn, dir(south))")){
				answer = "Skrecam na poludnie";
			}
			else if(command.equals("move(turn, dir(north))")){
				answer = "Skrecam na polnoc";
			}
			else if(command.equals("move(turn, dir(west))")){
				answer = "Skrecam na wschod";
			}
			else if(command.equals("move(turn, dir(east))")){
				answer = "Skrecam na zachod";
			}
			else
				answer = "answer";
			
			return answer;
		}
			
			
			

		
}
