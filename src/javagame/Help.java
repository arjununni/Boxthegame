package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Help extends BasicGameState{

		Image face;
	
		public Help(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			face = new Image("res/box.png");
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
			g.drawString("This is you.", 150,70);
			g.drawImage(face, 250, 45);
			g.drawString("You should reach here.", 100, 120);
			g.fillRect(300, 120, 25, 25);
			g.drawString("aand you should collect these.", 150, 200);
			g.setColor(Color.magenta);
			g.fillRect(450, 200,25, 25);
			g.setColor(Color.white);
			g.drawString("Easy right? Press Enter to play", 241, 314);
			
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			Input input = gc.getInput();
			
			if(input.isKeyDown(Input.KEY_ENTER)){
				sbg.enterState(1);
			}
		}
		
		public int getID(){
			return 2;
		}

}
