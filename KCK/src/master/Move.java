package master;

import java.util.Stack;

public class Move {
	private Stack<Player> history;

	private static String command;
	private static String answer;
	private static String error = "Nie moge wykonac akcji.";
	
	// repaint board
	private void repaint(){
		Main.repaint(Main.game.player.x(), Main.game.player.y(), Main.game.player.direction());
	}
	
	// change player coordinates & direction
	private void movePlayer(int x, int y, int direction) {
		Main.game.player.set(x, y, direction);
		
		// add actual player position to history
		this.history.push(Main.game.player);
		
		this.repaint();
	}
	
	// change player coordinates
	private void movePlayer(int x, int y) {
		this.movePlayer(x, y, Main.game.player.direction());
	}
	
	// check if between player and element are any objects
	private boolean isPathClear(int x, int y) {
		if (Main.game.player.x() == x) {
			if (Main.game.player.x() < x) {
				for (int i = Main.game.player.x() + 1; i < x; i++) {
					if (Main.game.elementExists(i, y)) {
						return false;
					}
				}
			}
			
			else {
				for (int i = x - 1; i > Main.game.player.x(); i--) {
					if (Main.game.elementExists(i, y)) {
						return false;
					}
				}
			}
		}
		
		else {
			if (Main.game.player.y() < y) {
				for (int i = Main.game.player.y() + 1; i < y; i++) {
					if (Main.game.elementExists(x, i)) {
						return false;
					}
				}
			}
			
			else {
				for (int i = y - 1; i > Main.game.player.y(); i--) {
					if (Main.game.elementExists(x, i)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	// move to coordinates with new direction
	private void move(int x, int y, int direction) {
		int minX = 0;
		int maxX = Main.game.columnCount - 1;
		int minY = 0;
		int maxY = Main.game.rowCount - 1;
		
		if (x < minX || x > maxX || y < minY || y > maxY || Main.game.elementExists(x, y)) {
			this.answer = this.error;
		}
		
		else {
			this.movePlayer(x, y, direction);
		}
	}
	
	// move to coordinates
	private void move(int x, int y) {
		this.move(x, y, Main.game.player.direction());
	}
	
	private void reach(int x, int y, String side) {
		this.answer = error;
		return;
	}
	
	// go straight to the element
	private void reach(int x, int y) {
		if ((Main.game.player.x() != x && Main.game.player.y() != y) || !isPathClear(x, y)) {
			this.answer = error;
			return;
		}
		
		if (Main.game.player.x() == x) {
			if (Main.game.player.x() > x) {
				this.movePlayer(x - 1, y, 1);
			}
			
			else {
				this.movePlayer(x + 1, y, 3);
			}
		}
		
		else {
			if (Main.game.player.y() > y) {
				this.movePlayer(x, y - 1, 0);
			}
			
			else {
				this.movePlayer(x, y + 1, 2);
			}
		}
	}
	
//	private boolean Ex(int x, int y, boolean side) {
//		int s=1;
//		
//		if (Main.game.player.x() == x || Main.game.player.y() == y) {
//			if (Main.game.player.x() == x){
//				if (Main.game.player.y() > y){
//					for (int i = Main.game.player.y() - 1; i > y; i--) {
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
//					for (int i = Main.game.player.y() + 1; i < y; i++) {
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
//				if(Main.game.player.x() > x){
//					for (int i = Main.game.player.x() - 1; i > x; i--) {
//						if (Main.game.elementExists(i, y))
//							return false;
//						
//						move(i, y);
//						repaint();
//					}
//				}
//				
//				else {
//					for (int i = Main.game.player.x() + 1; i < x; i++) {
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
//			if (Main.game.player.x() == a || Main.game.player.y() == b) {
//				if (Main.game.player.x() == a) {
//					if (Main.game.player.y() > b) {
//						for (int i = Main.game.player.y() - 1; i > b; i--) {
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
//						for(int i=Main.game.player.y()+1;i<b;i++){
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
//					if(Main.game.player.x()>a){
//						for(int i=Main.game.player.x()-1;i>a;i--){
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
//						for(int i=Main.game.player.x()+1;i<a;i++){
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
	
	public void setCommand(String prologOutput){  
		this.command = prologOutput;
	}
	
	public String getCommand(){
		return this.command;
	}
	
	public String getAnswer() {
		switch (this.command) {
			case "move(walk, dir(straight))":
			case "move(head, dir(straight))":
			case "move(drive, dir(straight))":
			case "move(go, dir(straight))":
				this.answer = "Ide prosto.";
				
				int changeX = 0;
				int changeY = 0;
				
				switch(Main.game.player.direction()) {
					// north
					case 0:
						changeY = 1;
						break;
						
					// east
					case 1:
						changeX = 1;
						break;
						
					// south
					case 2:
						changeY = -1;
						break;
						
					// west
					case 3:
						changeX = -1;
						break;
				}
				
				this.move(Main.game.player.x() + changeX, Main.game.player.y() + changeY);
				break;
				
			case "move(walk, dir(north))":
			case "move(walk, dir(up))":
			case "move(head, dir(north))":
			case "move(head, dir(up))":
			case "move(drive, dir(north))":
			case "move(drive, dir(up))":
			case "move(go, dir(north))":
			case "move(go, dir(up))":
				this.answer = "Ide na polnoc.";
				
				this.move(Main.game.player.x(), Main.game.player.y() + 1, 0);
				break;
				
			case "move(walk, dir(south))":
			case "move(walk, dir(down))":
			case "move(head, dir(south))":
			case "move(head, dir(down))":
			case "move(drive, dir(south))":
			case "move(drive, dir(down))":
			case "move(go, dir(south))":
			case "move(go, dir(down))":
				this.answer = "Ide na poludnie.";
				
				this.move(Main.game.player.x(), Main.game.player.y() - 1, 2);
				break;
				
			case "move(walk, dir(west))":
			case "move(walk, dir(lt))":
			case "move(head, dir(west))":
			case "move(head, dir(lt))":
			case "move(drive, dir(west))":
			case "move(drive, dir(lt))":
			case "move(go, dir(west))":
			case "move(go, dir(lt))":
				this.answer = "Ide na zachod.";
				
				this.move(Main.game.player.x() - 1, Main.game.player.y(), 3);
				break;
				
			case "move(walk, dir(east))":
			case "move(walk, dir(rt))":
			case "move(head, dir(east))":
			case "move(head, dir(rt))":
			case "move(drive, dir(east))":
			case "move(drive, dir(rt))":
			case "move(go, dir(east))":
			case "move(go, dir(rt))":
				this.answer = "Ide na wschod.";
				
				this.move(Main.game.player.x() + 1, Main.game.player.y(), 1);
				break;
				
			case "move(walk, goal(hospital))":
			case "move(head, goal(hospital))":
			case "move(drive, goal(hospital))":
			case "move(go, goal(hospital))":
			case "move(reach, goal(hospital))":
				this.answer = "Ide do szpitala.";
				
				this.reach(1, 4);
				break;
				
			case "move(walk, goal(mosque))":
			case "move(head, goal(mosque))":
			case "move(drive, goal(mosque))":
			case "move(go, goal(mosque))":
			case "move(reach, goal(mosque))":
				this.answer = "Ide do meczetu.";
				
				this.reach(1, 7);
				break;
				
			case "move(walk, goal(castle))":
			case "move(head, goal(castle))":
			case "move(drive, goal(castle))":
			case "move(go, goal(castle))":
			case "move(reach, goal(castle))":
				this.answer = "Ide do zamku.";
				
				this.reach(2, 2);
				break;
				
			case "move(walk, goal(church))":
			case "move(head, goal(church))":
			case "move(drive, goal(church))":
			case "move(go, goal(church))":
			case "move(reach, goal(church))":
				this.answer = "Ide do kosciola.";
				
				this.reach(2, 6);
				break;
				
			case "move(walk, goal(monument))":
			case "move(head, goal(monument))":
			case "move(drive, goal(monument))":
			case "move(go, goal(monument))":
			case "move(reach, goal(monument))":
				this.answer = "Ide do pomnika.";
				
				this.reach(5, 2);
				break;
				
			case "move(walk, goal(restaurant))":
			case "move(head, goal(restaurant))":
			case "move(drive, goal(restaurant))":
			case "move(go, goal(restaurant))":
			case "move(reach, goal(restaurant))":
				this.answer = "Ide do restauracji";
				
				this.reach(5, 8);
				break;
				
			case "move(walk, goal(townhall))":
			case "move(head, goal(townhall))":
			case "move(drive, goal(townhall))":
			case "move(go, goal(townhall))":
			case "move(reach, goal(townhall))":
				this.answer = "Ide do ratusza.";
				
				this.reach(6, 5);
				break;
				
			case "move(walk, goal(park))":
			case "move(head, goal(park))":
			case "move(drive, goal(park))":
			case "move(go, goal(park))":
			case "move(reach, goal(park))":
				this.answer = "Ide do parku.";
				
				this.reach(8, 0);
				break;
				
			case "move(walk, goal(school))":
			case "move(head, goal(school))":
			case "move(drive, goal(school))":
			case "move(go, goal(school))":
			case "move(reach, goal(school))":
				this.answer = "Ide do szkoly.";
				
				this.reach(8, 6);
				break;
				
			case "move(walk, goal(baker))":
			case "move(head, goal(baker))":
			case "move(drive, goal(baker))":
			case "move(go, goal(baker))":
			case "move(reach, goal(baker))":
				this.answer = "Ide do piekarni.";
				
				this.reach(9, 3);
				break;
				
			default:
				this.answer = "Komenda nie zostala rozpoznana.";
		}
		
		return this.answer;
	}
//			else if(command.equals("move(reach, fountain, left)")){
//				if(Ex(5,2,true))
//				answer = "Ide do pomnika z lewej strony";
//			}
//			else if(command.equals("move(reach, fountain, right)")){
//				if(Ex(5,3,false))
//				answer = "Ide do pomnika z prawej strony";
//			}
//			else if(command.equals("move(reach, mosque, left)")){
//				if(Ex(1,7,true))
//				answer = "Ide do meczetu z lewej strony";
//			}
//			else if(command.equals("move(reach, mosque, right)")){
//				if(Ex(1,7,false))
//				answer = "Ide do meczetu z prawej strony";
//			}
//			else if(command.equals("move(reach, church, left)")){
//				if(Ex(2,6,true))
//				answer = "Ide do kosciola z lewej strony";
//			}
//			else if(command.equals("move(reach, church, right)")){
//				if(Ex(2,6,false))
//				answer = "Ide do kosciola z prawej strony";
//			}
//			else if(command.equals("move(reach, townhall, left)")){
//				if(Ex(6,5,true))
//				answer = "Ide do ratusza z lewej strony";
//			}
//			else if(command.equals("move(reach, townhall, right)")){
//				if(Ex(6,5,false))
//				answer = "Ide do ratusza z prawej strony";
//			}
//			else if(command.equals("move(reach, hospital, left)")){
//				if(Ex(1,4,true))
//				answer = "Ide do szpitala z lewej strony";
//			}
//			else if(command.equals("move(reach, hospital, right)")){
//				if(Ex(1,4,false))
//				answer = "Ide do szpitala z prawej strony";
//			}
//			else if(command.equals("move(reach, baker, left)")){
//				if(Ex(9,3,true))
//				answer = "Ide do piekarni z lewej strony";
//			}
//			else if(command.equals("move(reach, baker, right)")){
//				if(Ex(9,3,false))
//				answer = "Ide do piekarni z prawej strony";
//			}
//			else if(command.equals("move(reach, castle, left)")){
//				if(Ex(2,2,true))
//				answer = "Ide do zamku z lewej strony";
//			}
//			else if(command.equals("move(reach, castle, right)")){
//				if(Ex(2,2,false))
//				answer = "Ide do zamku z prawej strony";
//			}
//			else if(command.equals("move(reach, school, left)")){
//				if(Ex(8,6,true))
//				answer = "Ide do szkoly z lewej strony";
//			}
//			else if(command.equals("move(reach, school, right)")){
//				if(Ex(8,6,false))
//				answer = "Ide do szkoly z prawej strony";
//			}
//			else if(command.equals("move(reach, park, left)")){
//				if(Ex(8,0,true))
//				answer = "Ide do parku z lewej strony";
//			}
//			else if(command.equals("move(reach, park, right)")){
//				if(Ex(8,0,false))
//				answer = "Ide do parku z prawej strony";
//			}
//			else if(command.equals("move(reach, restaurant, left)")){
//				if(Ex(5,8,true))
//				answer = "Ide do restauracji z lewej strony";
//			}
//			else if(command.equals("move(reach, restaurant, right)")){
//				if(Ex(5,8,false))
//				answer = "Ide do restauracji z prawej strony";
//			}
//			else if(command.equals("move(turn, dir(rt))")){
//				if(Main.game.player.x()==9||Main.KCK.elementExists(Main.game.player.x()+1, Main.game.player.y()));
//				else{
//				Player.set(Main.game.player.x()+1, Main.game.player.y());
//				E();
//				return "Skrecam w prawo";}
//			}
//			else if(command.equals("move(turn, dir(lt))")){
//				if(Main.game.player.x()==0||Main.KCK.elementExists(Main.game.player.x()-1, Main.game.player.y()));
//				else{
//				Player.set(Main.game.player.x()-1, Main.game.player.y());
//				E();
//				answer = "Skrecam w lewo";}
//			}
//			else if(command.equals("move(turn, dir(south))")){
//				if(Main.game.player.y()==9||Main.KCK.elementExists(Main.game.player.x(), Main.game.player.y()+1));
//				else{
//				Player.set(Main.game.player.x(), Main.game.player.y()+1);
//				E();
//				answer = "Skrecam na poludnie";}
//			}
//			else if(command.equals("move(turn, dir(north))")){
//				if(Main.game.player.y()==0||Main.KCK.elementExists(Main.game.player.x(), Main.game.player.y()-1));
//				else{
//				Player.set(Main.game.player.x(), Main.game.player.y()-1);
//				E();
//				answer = "Skrecam na polnoc";}
//			}
//			else if(command.equals("move(turn, dir(west))")){
//				if(Main.game.player.x()==9||Main.KCK.elementExists(Main.game.player.x()+1, Main.game.player.y()));
//				else{
//				Player.set(Main.game.player.x()+1, Main.game.player.y());
//				E();
//				answer = "Skrecam na wschod";}
//			}
//			else if(command.equals("move(turn, dir(east))")){
//				if(Main.game.player.x()==0||Main.KCK.elementExists(Main.game.player.x()-1, Main.game.player.y()));
//				else{
//				Player.set(Main.game.player.x()-1, Main.game.player.y());
//				E();
//				answer = "Skrecam na zachod";}
//			}
//			else
//				answer = "Niemozliwe!";
//			return answer;
//		}		
}