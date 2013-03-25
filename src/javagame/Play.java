package javagame;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Play extends BasicGameState{
	
	//TODO list
	//-> Make 5 more levels
	//-> Add enemies(Now that's a challenge)
	//-> Add those items which you pick up
	
		Image box;
		int boxX;
		int boxY;
		Rectangle boxrect = new Rectangle(boxX, boxY, 25, 25);
		int lives = 3;
		
		//All variables for collection of blocks
		int score = 0;
		boolean allboxescollected = false;
		Rectangle c1 = new Rectangle(42, 275, 25, 25);
		Rectangle c2 = new Rectangle(141, 288, 25, 25);
		Rectangle c3 = new Rectangle(156, 105, 25, 25);
		Rectangle c4 = new Rectangle(171, 25, 25, 25);
		Rectangle c5 = new Rectangle(301, 241, 25, 25);
		boolean drawIt1 = true;
			boolean scoreIt1 = true;
		boolean drawIt2 = true;
			boolean scoreIt2 = true;
		boolean drawIt3 = true;
			boolean scoreIt3 = true;
		boolean drawIt4 = true;
			boolean scoreIt4 = true;
		boolean drawIt5 = true;
			boolean scoreIt5 = true;
		//Ermagherd
		
		boolean quit = false;
		
		public Play(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			box = new Image("res/box.png");
			boxX = 10;
			boxY = 10;
			
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
			
			
			// Level text and Lives Board
			g.drawRect(350, 0, 450, 30);
			g.drawString("Lives: ", 350, 10);
			int i = 1;
			int livesX = 410;
			while(i<=lives){
				g.fillRect(livesX, 15, 10, 10);
				i++;
				livesX += 20;
			}
			g.drawString("Score: "+score, 470, 15);
			g.drawString("Level 1", 270, 20);
			g.fillRect(560, 300, 150, 150);
			g.drawImage(box, boxX, boxY);
			g.drawString("X:"+boxX+" Y:"+boxY, 170, 10);
			
			//Walls
			g.setColor(Color.orange);
			g.fillRect(100, 0, 50, 260);
			g.fillRect(200, 100, 50, 260);
			
			//Collectibles
			g.setColor(Color.magenta);
			if(drawIt1 == true){g.fill(c1);}
			if(drawIt2 == true){g.fill(c2);}
			if(drawIt3 == true){g.fill(c3);}
			if(drawIt4 == true){g.fill(c4);}
			if(drawIt5 == true){g.fill(c5);}
			
			g.setColor(Color.white);
			
			
			//Pause menu
			if(quit == true){
				g.drawString("<R> to resume", 261, 136);
				g.drawString("<Q> to quit", 261, 146);
				g.drawString("<M> to go back to main menu", 261, 156);
			}
			
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			Input input = gc.getInput();
			
			try{
				Thread.sleep(5);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			if(boxrect.intersects(c1)){
				if(scoreIt1 == true){
					score += 10;
					scoreIt1 = false;
				}
				drawIt1 = false;
			}
			if(boxrect.intersects(c2)){
				if(scoreIt2 == true){
					score += 10;
					scoreIt2 = false;
				}
				drawIt2 = false;
			}
			if(boxrect.intersects(c3)){
				if(scoreIt3 == true){
					score += 10;
					scoreIt3 = false;
				}
				drawIt3 = false;
			}
			if(boxrect.intersects(c4)){
				if(scoreIt4 == true){
					score += 10;
					scoreIt4 = false;
				}
				drawIt4 = false;
			}
			if(boxrect.intersects(c5)){
				if(scoreIt5 == true){
					score += 10;
					scoreIt5 = false;
				}
				drawIt5 = false;
			}
			
			if((drawIt1 == false)&&(drawIt2 == false)&&(drawIt3 == false)&&(drawIt4 == false)&&(drawIt5 == false)){
				allboxescollected = true;
			}
			
			
			if(input.isKeyDown(Input.KEY_UP)){
				boxY -= 1;
				boxrect.setY(boxY);
			}
			if(input.isKeyDown(Input.KEY_DOWN)){
				boxY += 1;
				boxrect.setY(boxY);
			}
			if(input.isKeyDown(Input.KEY_LEFT)){
				boxX -= 1;
				boxrect.setX(boxX);
			}
			if(input.isKeyDown(Input.KEY_RIGHT)){
				boxX += 1;
				boxrect.setX(boxX);
			}
			
			//Wall Collision Dectection. DO NOT MESS UP.
			if(boxY < -2){
				boxY += 4;
				boxrect.setY(boxY);
			}
			if(boxY > 315){
				boxY -= 4;
				boxrect.setY(boxY);
			}
			if(boxX < -5){
				boxX += 4;
				boxrect.setX(boxX);
			}
			if(boxX > 600){
				boxX -= 4;
				boxrect.setX(boxX);
			}
			
			
			if(allboxescollected == true){
				if((boxX > 540) && (boxY > 260)){
					try{
						Thread.sleep(3000);
					}
					catch(Exception e){
						e.getStackTrace();
					}
					sbg.enterState(3);
				}
			}
			
			//Collision Detection for Box 1
			//It just werks
			if((boxX > 58 && boxY < 252) && (boxX < 140)){
				boxX = 57;
			}
			if((boxX < 142 && boxY < 250) && (boxX > 58)){
				boxX = 143;
			}
			if(boxY < 256 && boxX > 90 && boxX < 142){
				boxY += 1;
			}
			
			//Collision Detection for Box 2
			//Bloody Hell
			if((boxX > 157 && boxY > 57) && (boxX < 240)){
				boxX = 156;
			}
			if((boxX < 243 && boxY > 57) && (boxX > 157)){
				boxX = 244;
			}
			if(boxY > 55 && boxX > 159 && boxX < 240){
				boxY = 54;
			}
			
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				quit = true;
			}
			
			if(quit == true){
				if(input.isKeyDown(Input.KEY_Q)){
					System.exit(0);
				}
				if(input.isKeyDown(Input.KEY_R)){
					quit = false;
				}
				if(input.isKeyDown(Input.KEY_M)){
					sbg.enterState(0);
				}
			}
			
			if(lives == 0){
				sbg.enterState(4);
			}
			
		}
		
		public int getID(){
			return 1;
		}
		
		public int getScore(){
			return score;
		}
}
