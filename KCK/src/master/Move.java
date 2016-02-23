package master;

import java.util.concurrent.TimeUnit;

public class Move {

		public static String answer;
		public static String command;
		
		public void setCommand(String prologOutput){  
			command = prologOutput;
		}
		private void E(){
			Main.KCK.Panel();
			System.out.println("Tutaj");
		}
		private boolean Ex(int a, int b){
			int s=1;
			if(Game.player.x()==a||Game.player.y()==b){
				if(Game.player.x()==a){
					if(Game.player.y()>b){
						for(int i=Game.player.y()-1;i>b;i--){
							if(Main.KCK.elementExists(a, i))return false;
							Player.set(a, i);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						for(int i=Game.player.y()+1;i<b;i++){
							if(Main.KCK.elementExists(a, i))return false;
							Player.set(a, i);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				else{
					if(Game.player.x()>a){
						for(int i=Game.player.x()-1;i>a;i--){
							if(Main.KCK.elementExists(i, b))return false;
							Player.set(i, b);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else{
						for(int i=Game.player.x()+1;i<a;i++){
							if(Main.KCK.elementExists(i, b))return false;
							Player.set(i, b);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
					
			}
			else{
				return false;
			}
			return true;
		}
		private boolean Ex(int a, int b, boolean si){
			int s=1;
			if(Game.player.x()==a||Game.player.y()==b){
				if(Game.player.x()==a){
					if(Game.player.y()>b){
						for(int i=Game.player.y()-1;i>b;i--){
							if(Main.KCK.elementExists(a, i))return false;
							Player.set(a, i);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(si){
							if(a==0||Main.KCK.elementExists(a-1,b+1)||Main.KCK.elementExists(a-1,b))return false;
							Player.set(a-1, b+1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a-1, b);
							E();
						}
						else{
							if(a==9||Main.KCK.elementExists(a+1,b+1)||Main.KCK.elementExists(a+1,b))return false;
							Player.set(a+1, b+1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a+1, b);
							E();
						}
					}
					else{
						for(int i=Game.player.y()+1;i<b;i++){
							if(Main.KCK.elementExists(a, i))return false;
							Player.set(a, i);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(si){
							if(a==9||Main.KCK.elementExists(a+1,b-1)||Main.KCK.elementExists(a+1,b))return false;
							Player.set(a+1, b-1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a+1, b);
							E();
						}
						else{
							if(a==0||Main.KCK.elementExists(a-1,b-1)||Main.KCK.elementExists(a-1,b))return false;
							Player.set(a-1, b-1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a-1, b);
							E();
						}
					}
				}
				else{
					if(Game.player.x()>a){
						for(int i=Game.player.x()-1;i>a;i--){
							if(Main.KCK.elementExists(i, b))return false;
							Player.set(i, b);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(si){
							if(b==9||Main.KCK.elementExists(a+1,b+1)||Main.KCK.elementExists(a,b+1))return false;
							Player.set(a+1, b+1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a, b+1);
							E();
						}
						else{
							if(b==0||Main.KCK.elementExists(a+1,b-1)||Main.KCK.elementExists(a,b-1))return false;
							Player.set(a+1, b-1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a, b-1);
							E();
						}
					}
					else{
						for(int i=Game.player.x()+1;i<a;i++){
							if(Main.KCK.elementExists(i, b))return false;
							Player.set(i, b);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(si){
							if(b==0||Main.KCK.elementExists(a-1,b-1)||Main.KCK.elementExists(a-1,b-1))return false;
							Player.set(a-1, b-1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a-1, b);
							E();
						}
						else{
							if(a==9||Main.KCK.elementExists(a-1,b+1)||Main.KCK.elementExists(a-1,b))return false;
							Player.set(a-1, b+1);
							E();
							try {
								TimeUnit.SECONDS.sleep(s);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Player.set(a-1, b);
							E();
						}
					}
				}
					
			}
			else{
				return false;
			}
			return true;
		}
		public String getCommand(){
			return command;
		}
		
		//Funkcja wypisuj¹ca odpwiedzi agenta na tekst uzytkownika
		//Narazie to tylko przykladowe zdania
		//Chyba trzeba bedzie zmienic troche prolog bo tak to za duzo roboty
		//najlepiej zrobic tylko takie podstawowe komendy
		
		public String getAnswer(){
			answer="Niemozliwe!";
			if (command.equals("Komenda nie zostala rozpoznana.")){
				answer = "Nie wiem co mam robic, wydaj polecenie jeszcze raz";
			}	
			else if (command.equals("move(walk, dir(straight))") || 
					command.equals("move(head, dir(straight))") ||
					command.equals("move(drive, dir(straight))")||
					command.equals("move(go, dir(straight))")) { 
				if(Game.player.y()==0||Main.KCK.elementExists(Game.player.x(), Game.player.y()-1));
				else{
				Player.set(Game.player.x(), Game.player.y()-1);
				E();
				answer = "Ide prosto";}
			}
			else if (command.equals("move(walk, dir(south))")|| 
					command.equals("move(head, dir(south))") ||
					command.equals("move(drive, dir(south)")||
					command.equals("move(go, dir(south)")){
				if(Game.player.y()==9||Main.KCK.elementExists(Game.player.x(), Game.player.y()+1));
				else{
				Player.set(Game.player.x(), Game.player.y()+1);
				E();
				answer = "Ide na poludnie";}
			}	
			else if (command.equals("move(walk, dir(east))")|| 
					command.equals("move(head, dir(east))") ||
					command.equals("move(drive, dir(east))")||
					command.equals("move(go, dir(east))")){
				if(Game.player.x()==0||Main.KCK.elementExists(Game.player.x()-1, Game.player.y()));
				else{
				Player.set(Game.player.x()-1, Game.player.y());
				E();
				answer = "Ide na zachod";}
			}	
			else if (command.equals("move(walk, dir(north))")|| 
					command.equals("move(head, dir(north))") ||
					command.equals("move(drive, dir(north))")||
					command.equals("move(go, dir(north))")){
				if(Game.player.y()==0||Main.KCK.elementExists(Game.player.x(), Game.player.y()-1));
				else{
				Player.set(Game.player.x(), Game.player.y()-1);
				E();
				answer = "Ide na polnoc";}
			}	
			else if (command.equals("move(walk, dir(west))")|| 
					command.equals("move(head, dir(west))") ||
					command.equals("move(drive, dir(west))")||
					command.equals("move(go, dir(west))")){
				if(Game.player.x()==9||Main.KCK.elementExists(Game.player.x()+1, Game.player.y()));
				else{
				Player.set(Game.player.x()+1, Game.player.y());
				E();
				answer = "Ide na wschod";}
			}	
			else if (command.equals("move(walk, dir(rt))")|| 
					command.equals("move(head, dir(rt))") ||
					command.equals("move(drive, dir(rt))")||
					command.equals("move(go, dir(rt))")){
				if(Game.player.x()==9||Main.KCK.elementExists(Game.player.x()+1, Game.player.y()));
				else{
				Player.set(Game.player.x()+1, Game.player.y());
				E();
				answer = "Ide w prawo";}
			}	
			else if (command.equals("move(walk, dir(lt))")|| 
					command.equals("move(head, dir(lt))") ||
					command.equals("move(drive, dir(lt))")||
					command.equals("move(go, dir(lt))")){
				if(Game.player.x()==0||Main.KCK.elementExists(Game.player.x()-1, Game.player.y()));
				else{
				Player.set(Game.player.x()-1, Game.player.y());
				E();
				answer = "Ide w lewo";}
			}	
			else if (command.equals("move(walk, dir(up))")|| 
					command.equals("move(head, dir(up))") ||
					command.equals("move(drive, dir(up))")||
					command.equals("move(go, dir(up))")){
				if(Game.player.y()==0||Main.KCK.elementExists(Game.player.x(), Game.player.y()-1));
				else{
				Player.set(Game.player.x(), Game.player.y()-1);
				E();
				answer = "Ide do gory";}
			}	
			else if (command.equals("move(walk, dir(down))")|| 
					command.equals("move(head, dir(down))") ||
					command.equals("move(drive, dir(down))")||
					command.equals("move(go, dir(down))")){
				if(Game.player.y()==9||Main.KCK.elementExists(Game.player.x(), Game.player.y()+1));
				else{
				Player.set(Game.player.x(), Game.player.y()+1);
				E();
				answer = "Ide na dol";}
			}	
			else if (command.equals("move(walk, goal(monument))")||
					command.equals("move(head, goal(monument))")||
					command.equals("move(drive, goal(monument))")||
					command.equals("move(go, goal(monument))")||
					command.equals("move(reach, monument)")){
				if(Ex(5,2))
				answer = "Ide do pomnika";
			}	
			else if (command.equals("move(walk, goal(mosque))")||
					command.equals("move(head, goal(mosque))")||
					command.equals("move(drive, goal(mosque))")||
					command.equals("move(go, goal(mosque))")||
					command.equals("move(reach, mosque)")){
				if(Ex(1,7))
				answer = "Ide do meczetu";
			}	
			else if (command.equals("move(walk, goal(church))")||
					command.equals("move(head, goal(church))")||
					command.equals("move(drive, goal(church))")||
					command.equals("move(go, goal(church))")||
					command.equals("move(reach, church)")){
				if(Ex(2,6))
				answer = "Ide do kosciola";
			}	
			else if (command.equals("move(walk, goal(townhall))")||
					command.equals("move(head, goal(townhall))")||
					command.equals("move(drive, goal(townhall))")||
					command.equals("move(go, goal(townhall))")||
					command.equals("move(reach, townhall)")){
				if(Ex(6,5))
				answer = "Ide do ratusza";
			}	
			else if (command.equals("move(walk, goal(hospital))")||
					command.equals("move(head, goal(hospital))")||
					command.equals("move(drive, goal(hospital))")||
					command.equals("move(go, goal(hospital))")||
					command.equals("move(reach, hospital)")){
				if(Ex(1,4))
				answer = "Ide do szpitala";	
			}	
			else if (command.equals("move(walk, goal(baker))")||
					command.equals("move(head, goal(baker))")||
					command.equals("move(drive, goal(baker))")||
					command.equals("move(go, goal(baker))")||
					command.equals("move(reach, baker)")){
				if(Ex(9,3))
				answer = "Ide do pierkani";
			}	
			else if (command.equals("move(walk, goal(castle))")||
					command.equals("move(head, goal(castle))")||
					command.equals("move(drive, goal(castle))")||
					command.equals("move(go, goal(castle))")||
					command.equals("move(reach, castle)")){
				if(Ex(2,2))
				answer = "Ide do zamku";			
			}
			else if (command.equals("move(walk, goal(school))")||
					command.equals("move(head, goal(school))")||
					command.equals("move(drive, goal(school))")||
					command.equals("move(go, goal(school))")||
					command.equals("move(reach, school)")){
				if(Ex(8,6))
				answer = "Ide do szkoly";	
			}
			else if (command.equals("move(walk, goal(park))")||
					command.equals("move(head, goal(park))")||
					command.equals("move(drive, goal(park))")||
					command.equals("move(go, goal(park))")||
					command.equals("move(reach, park)")){
				if(Ex(8,0))
				answer = "Ide do parku";			
			}
			else if (command.equals("move(walk, goal(restaurant))")||
					command.equals("move(head, goal(restaurant))")||
					command.equals("move(drive, goal(restaurant))")||
					command.equals("move(go, goal(restaurant))")||
					command.equals("move(reach, restaurant)")){
				if(Ex(5,8))
				answer = "Ide do restauracji";
			}
			else if(command.equals("move(reach, fountain, left)")){
				if(Ex(5,2,true))
				answer = "Ide do pomnika z lewej strony";
			}
			else if(command.equals("move(reach, fountain, right)")){
				if(Ex(5,3,false))
				answer = "Ide do pomnika z prawej strony";
			}
			else if(command.equals("move(reach, mosque, left)")){
				if(Ex(1,7,true))
				answer = "Ide do meczetu z lewej strony";
			}
			else if(command.equals("move(reach, mosque, right)")){
				if(Ex(1,7,false))
				answer = "Ide do meczetu z prawej strony";
			}
			else if(command.equals("move(reach, church, left)")){
				if(Ex(2,6,true))
				answer = "Ide do kosciola z lewej strony";
			}
			else if(command.equals("move(reach, church, right)")){
				if(Ex(2,6,false))
				answer = "Ide do kosciola z prawej strony";
			}
			else if(command.equals("move(reach, townhall, left)")){
				if(Ex(6,5,true))
				answer = "Ide do ratusza z lewej strony";
			}
			else if(command.equals("move(reach, townhall, right)")){
				if(Ex(6,5,false))
				answer = "Ide do ratusza z prawej strony";
			}
			else if(command.equals("move(reach, hospital, left)")){
				if(Ex(1,4,true))
				answer = "Ide do szpitala z lewej strony";
			}
			else if(command.equals("move(reach, hospital, right)")){
				if(Ex(1,4,false))
				answer = "Ide do szpitala z prawej strony";
			}
			else if(command.equals("move(reach, baker, left)")){
				if(Ex(9,3,true))
				answer = "Ide do piekarni z lewej strony";
			}
			else if(command.equals("move(reach, baker, right)")){
				if(Ex(9,3,false))
				answer = "Ide do piekarni z prawej strony";
			}
			else if(command.equals("move(reach, castle, left)")){
				if(Ex(2,2,true))
				answer = "Ide do zamku z lewej strony";
			}
			else if(command.equals("move(reach, castle, right)")){
				if(Ex(2,2,false))
				answer = "Ide do zamku z prawej strony";
			}
			else if(command.equals("move(reach, school, left)")){
				if(Ex(8,6,true))
				answer = "Ide do szkoly z lewej strony";
			}
			else if(command.equals("move(reach, school, right)")){
				if(Ex(8,6,false))
				answer = "Ide do szkoly z prawej strony";
			}
			else if(command.equals("move(reach, park, left)")){
				if(Ex(8,0,true))
				answer = "Ide do parku z lewej strony";
			}
			else if(command.equals("move(reach, park, right)")){
				if(Ex(8,0,false))
				answer = "Ide do parku z prawej strony";
			}
			else if(command.equals("move(reach, restaurant, left)")){
				if(Ex(5,8,true))
				answer = "Ide do restauracji z lewej strony";
			}
			else if(command.equals("move(reach, restaurant, right)")){
				if(Ex(5,8,false))
				answer = "Ide do restauracji z prawej strony";
			}
			else if(command.equals("move(turn, dir(rt))")){
				if(Game.player.x()==9||Main.KCK.elementExists(Game.player.x()+1, Game.player.y()));
				else{
				Player.set(Game.player.x()+1, Game.player.y());
				E();
				return "Skrecam w prawo";}
			}
			else if(command.equals("move(turn, dir(lt))")){
				if(Game.player.x()==0||Main.KCK.elementExists(Game.player.x()-1, Game.player.y()));
				else{
				Player.set(Game.player.x()-1, Game.player.y());
				E();
				answer = "Skrecam w lewo";}
			}
			else if(command.equals("move(turn, dir(south))")){
				if(Game.player.y()==9||Main.KCK.elementExists(Game.player.x(), Game.player.y()+1));
				else{
				Player.set(Game.player.x(), Game.player.y()+1);
				E();
				answer = "Skrecam na poludnie";}
			}
			else if(command.equals("move(turn, dir(north))")){
				if(Game.player.y()==0||Main.KCK.elementExists(Game.player.x(), Game.player.y()-1));
				else{
				Player.set(Game.player.x(), Game.player.y()-1);
				E();
				answer = "Skrecam na polnoc";}
			}
			else if(command.equals("move(turn, dir(west))")){
				if(Game.player.x()==9||Main.KCK.elementExists(Game.player.x()+1, Game.player.y()));
				else{
				Player.set(Game.player.x()+1, Game.player.y());
				E();
				answer = "Skrecam na wschod";}
			}
			else if(command.equals("move(turn, dir(east))")){
				if(Game.player.x()==0||Main.KCK.elementExists(Game.player.x()-1, Game.player.y()));
				else{
				Player.set(Game.player.x()-1, Game.player.y());
				E();
				answer = "Skrecam na zachod";}
			}
			else
				answer = "Niemozliwe!";
			return answer;
		}
			
			
			

		
}
