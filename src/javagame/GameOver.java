package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameOver extends BasicGameState{
	
		Image gOver;
		
		public GameOver(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			gOver = new Image("res/gover.png");
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
			
			g.drawImage(gOver, 160, 30);
			
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			
			
		}
		
		public int getID(){
			return 4;
		}

}
