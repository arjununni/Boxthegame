package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Music;

public class Menu extends BasicGameState{

		Image logo;
		Music bgMusic;
		
		public Menu(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			
			bgMusic = new Music("res/bgMusic.ogg");
			logo = new Image("res/logo.png");
			bgMusic.loop();
			
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
			
			g.drawImage(logo, 200, 40);
			g.drawString("'Enter' to start", 210, 170);
			g.drawString("'Q' to quit", 210, 220);
			g.drawString("'H' for help", 210, 270);
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			
			Input input = gc.getInput();
				
			if(input.isKeyDown(Input.KEY_ENTER)){
				sbg.enterState(1);
				bgMusic.stop();
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
			if(input.isKeyDown(Input.KEY_H)){
				sbg.enterState(2);
			}
			if(input.isKeyDown(Input.KEY_O)){
				sbg.enterState(6);
			}
			if(input.isKeyDown(Input.KEY_PAUSE)){
				bgMusic.pause();
			}
		}
		
		public int getID(){
			return 0;
		}

}
