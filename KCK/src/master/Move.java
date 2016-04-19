package master;

import java.util.Stack;

public class Move {
	private static Stack<Player> history;

	private static String command;
	private static String answer;
	private static String error = "Nie moge wykonac akcji.";
	
	// repaint board
	private static void repaint() {
		Main.repaint(Game.player.x(), Game.player.y(), Game.player.direction());
	}
	
	// change player coordinates & direction
	private static void movePlayer(int x, int y, int direction) {
		Game.player.set(x, y, direction);
		
		// add actual player position to history
		// history.push(Game.player);
		
		repaint();
	}
	
	// change player coordinates
	private static void movePlayer(int x, int y) {
		movePlayer(x, y, Game.player.direction());
	}
	
	// check if between player and element are any objects
	private static boolean isPathClear(int x, int y) {
		if (Game.player.x() == x) {
			if (Game.player.x() < x) {
				for (int i = Game.player.x() + 1; i < x; i++) {
					if (Main.game.elementExists(i, y)) {
						return false;
					}
				}
			}
			
			else {
				for (int i = x - 1; i > Game.player.x(); i--) {
					if (Main.game.elementExists(i, y)) {
						return false;
					}
				}
			}
		}
		
		else {
			if (Game.player.y() < y) {
				for (int i = Game.player.y() + 1; i < y; i++) {
					if (Main.game.elementExists(x, i)) {
						return false;
					}
				}
			}
			
			else {
				for (int i = y - 1; i > Game.player.y(); i--) {
					if (Main.game.elementExists(x, i)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	// move to coordinates with new direction
	private static void move(int x, int y, int direction) {
		int minX = 0;
		int maxX = Main.game.columnCount - 1;
		int minY = 0;
		int maxY = Main.game.rowCount - 1;
		
		if (x < minX || x > maxX || y < minY || y > maxY || Main.game.elementExists(x, y)) {
			answer = error;
		}
		
		else {
			movePlayer(x, y, direction);
		}
	}
	
	// move to coordinates
	private static void move(int x, int y) {
		move(x, y, Game.player.direction());
	}
	
	private static void turn(int direction) {
		if (direction == Game.player.direction()) {
			answer = error;
			return;
		}
		
		switch(direction) {
			// north
			case 0:
				move(Game.player.x(), Game.player.y() - 1, 0);
				break;
				
			// east
			case 1:
				move(Game.player.x() + 1, Game.player.y(), 1);
				break;
				
			// south
			case 2:
				move(Game.player.x(), Game.player.y() + 1, 2);
				break;
				
			// west
			case 3:
				move(Game.player.x() - 1, Game.player.y(), 3);
				break;
		}
	}
	
	// go straight to the element
	private static void reach(int x, int y) {
		if ((Game.player.x() != x && Game.player.y() != y) || !isPathClear(x, y)) {
			answer = error;
			return;
		}
		
		if (Game.player.y() == y) {
			if (Game.player.x() < x) {
				movePlayer(x - 1, y, 1);
			}
			
			else {
				movePlayer(x + 1, y, 3);
			}
		}
		
		else {
			if (Game.player.y() < y) {
				movePlayer(x, y - 1, 0);
			}
			
			else {
				movePlayer(x, y + 1, 2);
			}
		}
	}
	
	// go straight to the element and stand on left / right side of it
	private static void reach(int x, int y, String side) {
		answer = error;
		return;
		
//		reach(x, y);
//		
//		switch(Game.player.direction()) {
//			// north
//			case 0:
//				break;
//				
//			// east
//			case 1:
//				break;
//				
//			// south
//			case 2:
//				break;
//				
//			// west
//			case 3:
//				break;
//		}
	}
	
//	private boolean Ex(int x, int y, boolean side) {
//		int s=1;
//		
//		if (Game.player.x() == x || Game.player.y() == y) {
//			if (Game.player.x() == x){
//				if (Game.player.y() > y){
//					for (int i = Game.player.y() - 1; i > y; i--) {
//						if (Main.game.elementExists(x, i))
//							return false;
//						
//						move(x, i);
//						repaint();
//					}
//					
////					if (side) {
////						if (x == 0 || Main.game.elementExists(x - 1, y + 1) || Main.game.elementExists(x - 1, y))
////							return false;
////						
////						move(x - 1, y + 1);
////						repaint();
////						move(x - 1, y);
////						repaint();
////					}
////					
////					else {
////						if (x == 9 || Main.game.elementExists(x + 1, y + 1) || Main.game.elementExists(x + 1, y))
////							return false;
////						
////						move(x + 1, y + 1);
////						repaint();
////						move(x + 1, y);
////						repaint();
////					}
//				}
//				
//				else {
//					for (int i = Game.player.y() + 1; i < y; i++) {
//						if (Main.game.elementExists(x, i))
//							return false;
//						
//						move(x, i);
//						repaint();
//					}
//				}
//			}
//			
//			else {
//				if(Game.player.x() > x){
//					for (int i = Game.player.x() - 1; i > x; i--) {
//						if (Main.game.elementExists(i, y))
//							return false;
//						
//						move(i, y);
//						repaint();
//					}
//				}
//				
//				else {
//					for (int i = Game.player.x() + 1; i < x; i++) {
//						if (Main.game.elementExists(i, y))
//							return false;
//						
//						move(i, y);
//						repaint();
//					}
//				}
//			}
//				
//		}
//		
//		else {
//			return false;
//		}
//		
//		return true;
//	}
		
//		private boolean Ex(int a, int b, boolean si){
//			int s=1;
//			
//			if (Game.player.x() == a || Game.player.y() == b) {
//				if (Game.player.x() == a) {
//					if (Game.player.y() > b) {
//						for (int i = Game.player.y() - 1; i > b; i--) {
//							if(Main.KCK.elementExists(a, i))
//								return false;
//							Player.set(a, i);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//						if(si){
//							if(a==0||Main.KCK.elementExists(a-1,b+1)||Main.KCK.elementExists(a-1,b))return false;
//							Player.set(a-1, b+1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a-1, b);
//							E();
//						}
//						else{
//							if(a==9||Main.KCK.elementExists(a+1,b+1)||Main.KCK.elementExists(a+1,b))return false;
//							Player.set(a+1, b+1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a+1, b);
//							E();
//						}
//					}
//					else{
//						for(int i=Game.player.y()+1;i<b;i++){
//							if(Main.KCK.elementExists(a, i))return false;
//							Player.set(a, i);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//						if(si){
//							if(a==9||Main.KCK.elementExists(a+1,b-1)||Main.KCK.elementExists(a+1,b))return false;
//							Player.set(a+1, b-1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a+1, b);
//							E();
//						}
//						else{
//							if(a==0||Main.KCK.elementExists(a-1,b-1)||Main.KCK.elementExists(a-1,b))return false;
//							Player.set(a-1, b-1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a-1, b);
//							E();
//						}
//					}
//				}
//				else{
//					if(Game.player.x()>a){
//						for(int i=Game.player.x()-1;i>a;i--){
//							if(Main.KCK.elementExists(i, b))return false;
//							Player.set(i, b);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//						if(si){
//							if(b==9||Main.KCK.elementExists(a+1,b+1)||Main.KCK.elementExists(a,b+1))return false;
//							Player.set(a+1, b+1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a, b+1);
//							E();
//						}
//						else{
//							if(b==0||Main.KCK.elementExists(a+1,b-1)||Main.KCK.elementExists(a,b-1))return false;
//							Player.set(a+1, b-1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a, b-1);
//							E();
//						}
//					}
//					else{
//						for(int i=Game.player.x()+1;i<a;i++){
//							if(Main.KCK.elementExists(i, b))return false;
//							Player.set(i, b);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//						if(si){
//							if(b==0||Main.KCK.elementExists(a-1,b-1)||Main.KCK.elementExists(a-1,b-1))return false;
//							Player.set(a-1, b-1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a-1, b);
//							E();
//						}
//						else{
//							if(a==9||Main.KCK.elementExists(a-1,b+1)||Main.KCK.elementExists(a-1,b))return false;
//							Player.set(a-1, b+1);
//							E();
//							try {
//								TimeUnit.SECONDS.sleep(s);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							Player.set(a-1, b);
//							E();
//						}
//					}
//				}
//					
//			}
//			else{
//				return false;
//			}
//			return true;
//		}
	
	public static void setCommand(String prologOutput){  
		command = prologOutput;
	}
	
	public static String getCommand(){
		return command;
	}
	
	public static String getAnswer() {
		switch (command) {
			case "move(walk, dir(straight))":
			case "move(head, dir(straight))":
			case "move(drive, dir(straight))":
			case "move(go, dir(straight))":
				answer = "Ide prosto.";
				
				int changeX = 0;
				int changeY = 0;
				
				switch(Game.player.direction()) {
					// north
					case 0:
						changeY = -1;
						break;
						
					// east
					case 1:
						changeX = 1;
						break;
						
					// south
					case 2:
						changeY = 1;
						break;
						
					// west
					case 3:
						changeX = -1;
						break;
				}
				
				move(Game.player.x() + changeX, Game.player.y() + changeY);
				break;
				
			case "move(walk, dir(north))":
			case "move(walk, dir(up))":
			case "move(head, dir(north))":
			case "move(head, dir(up))":
			case "move(drive, dir(north))":
			case "move(drive, dir(up))":
			case "move(go, dir(north))":
			case "move(go, dir(up))":
				answer = "Ide na polnoc.";
				
				move(Game.player.x(), Game.player.y() - 1, 0);
				break;
				
			case "move(turn, dir(north))":
			case "move(turn, dir(up))":
				answer = "Skrecam w gore.";
				
				turn(0);
				break;
				
			case "move(walk, dir(south))":
			case "move(walk, dir(down))":
			case "move(head, dir(south))":
			case "move(head, dir(down))":
			case "move(drive, dir(south))":
			case "move(drive, dir(down))":
			case "move(go, dir(south))":
			case "move(go, dir(down))":
				answer = "Ide na poludnie.";
				
				move(Game.player.x(), Game.player.y() + 1, 2);
				break;
				
			case "move(turn, dir(sounth))":
			case "move(turn, dir(down))":
				answer = "Skrecam w dol.";
				
				turn(2);
				break;
				
			case "move(walk, dir(west))":
			case "move(walk, dir(lt))":
			case "move(head, dir(west))":
			case "move(head, dir(lt))":
			case "move(drive, dir(west))":
			case "move(drive, dir(lt))":
			case "move(go, dir(west))":
			case "move(go, dir(lt))":
				answer = "Ide na zachod.";
				
				move(Game.player.x() - 1, Game.player.y(), 3);
				break;
				
			case "move(turn, dir(west))":
			case "move(turn, dir(lt))":
				answer = "Skrecam w lewo.";
				
				turn(3);
				break;
				
			case "move(walk, dir(east))":
			case "move(walk, dir(rt))":
			case "move(head, dir(east))":
			case "move(head, dir(rt))":
			case "move(drive, dir(east))":
			case "move(drive, dir(rt))":
			case "move(go, dir(east))":
			case "move(go, dir(rt))":
				answer = "Ide na wschod.";
				
				move(Game.player.x() + 1, Game.player.y(), 1);
				break;
				
			case "move(turn, dir(east))":
			case "move(turn, dir(rt))":
				answer = "Skrecam w prawo.";
				
				turn(1);
				break;
				
			case "move(walk, goal(hospital))":
			case "move(head, goal(hospital))":
			case "move(drive, goal(hospital))":
			case "move(go, goal(hospital))":
			case "move(reach, goal(hospital))":
				answer = "Ide do szpitala.";
				
				reach(1, 4);
				break;
				
			case "move(reach, hospital, left)":
				answer = "Ide do szpitala. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, hospital, right)":
				answer = "Ide do szpitala. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(mosque))":
			case "move(head, goal(mosque))":
			case "move(drive, goal(mosque))":
			case "move(go, goal(mosque))":
			case "move(reach, goal(mosque))":
				answer = "Ide do meczetu.";
				
				reach(1, 7);
				break;
				
			case "move(reach, mosque, left)":
				answer = "Ide do meczetu. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, mosque, right)":
				answer = "Ide do meczetu. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(castle))":
			case "move(head, goal(castle))":
			case "move(drive, goal(castle))":
			case "move(go, goal(castle))":
			case "move(reach, goal(castle))":
				answer = "Ide do zamku.";
				
				reach(2, 2);
				break;
				
			case "move(reach, castle, left)":
				answer = "Ide do zamku. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, castle, right)":
				answer = "Ide do zamku. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(church))":
			case "move(head, goal(church))":
			case "move(drive, goal(church))":
			case "move(go, goal(church))":
			case "move(reach, goal(church))":
				answer = "Ide do kosciola.";
				
				reach(2, 6);
				break;
				
			case "move(reach, church, left)":
				answer = "Ide do kosciola. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, church, right)":
				answer = "Ide do kosciola. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(monument))":
			case "move(head, goal(monument))":
			case "move(drive, goal(monument))":
			case "move(go, goal(monument))":
			case "move(reach, goal(monument))":
				answer = "Ide do pomnika.";
				
				reach(5, 2);
				break;
				
			case "move(reach, monument, left)":
				answer = "Ide do pomnika. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, monument, right)":
				answer = "Ide do pomnika. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(restaurant))":
			case "move(head, goal(restaurant))":
			case "move(drive, goal(restaurant))":
			case "move(go, goal(restaurant))":
			case "move(reach, goal(restaurant))":
				answer = "Ide do restauracji";
				
				reach(5, 8);
				break;
				
			case "move(reach, restaurant, left)":
				answer = "Ide do restauracji. Obchodzê ja z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, restaurant, right)":
				answer = "Ide do restauracji. Obchodzê ja z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(townhall))":
			case "move(head, goal(townhall))":
			case "move(drive, goal(townhall))":
			case "move(go, goal(townhall))":
			case "move(reach, goal(townhall))":
				answer = "Ide do ratusza.";
				
				reach(6, 5);
				break;
				
			case "move(reach, townhall, left)":
				answer = "Ide do ratusza. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, townhall, right)":
				answer = "Ide do ratusza. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(park))":
			case "move(head, goal(park))":
			case "move(drive, goal(park))":
			case "move(go, goal(park))":
			case "move(reach, goal(park))":
				answer = "Ide do parku.";
				
				reach(8, 0);
				break;
				
			case "move(reach, park, left)":
				answer = "Ide do parku. Obchodzê go z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, park, right)":
				answer = "Ide do parku. Obchodzê go z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(school))":
			case "move(head, goal(school))":
			case "move(drive, goal(school))":
			case "move(go, goal(school))":
			case "move(reach, goal(school))":
				answer = "Ide do szkoly.";
				
				reach(8, 6);
				break;
				
			case "move(reach, school, left)":
				answer = "Ide do szkoly. Obchodzê ja z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, school, right)":
				answer = "Ide do szkoly. Obchodzê ja z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			case "move(walk, goal(baker))":
			case "move(head, goal(baker))":
			case "move(drive, goal(baker))":
			case "move(go, goal(baker))":
			case "move(reach, goal(baker))":
				answer = "Ide do piekarni.";
				
				reach(9, 3);
				break;
				
			case "move(reach, baker, left)":
				answer = "Ide do piekarni. Obchodzê ja z lewej strony.";
				
				reach(1, 4, "left");
				break;
				
			case "move(reach, baker, right)":
				answer = "Ide do piekarni. Obchodzê ja z prawej strony.";
				
				reach(1, 4, "right");
				break;
				
			default:
				answer = "Komenda nie zostala rozpoznana.";
		}
		
		return answer;
	}
}