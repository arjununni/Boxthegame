package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Play2 extends BasicGameState{
	
		int timer = 0;
		Image box;
		Image coin;
		int boxX = 10;
		int boxY = 10;
		int enemyY = 0;
		int enemyY2 = 313;
		int enemyY3 = 0;
		int lives = 3;
		Rectangle r1 = new Rectangle(163, 0, 32, 360);
		Rectangle r2 = new Rectangle(211, 0, 32, 360);
		Rectangle r3 = new Rectangle(290, 0, 32, 360);
		Rectangle enemyrect = new Rectangle(157, enemyY, 32, 33);
		Rectangle enemyrect2 = new Rectangle(211, enemyY2, 32, 33);
		Rectangle enemyrect3 = new Rectangle(290, enemyY3, 32, 33);
		Rectangle boxrect = new Rectangle(boxX, boxY, 25, 25);
		
		//Variables for collectibles
				boolean allboxescollected = false;
				Rectangle c1 = new Rectangle(48, 167, 25, 25);
				Rectangle c2 = new Rectangle(156, 211, 25, 25);
				Rectangle c3 = new Rectangle(156, 45, 25, 25);
				Rectangle c4 = new Rectangle(249, 164, 25, 25);
				Rectangle c5 = new Rectangle(316, 0, 25, 25);
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
					
					
		boolean quit = false;
	
		public Play2(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			box = new Image("res/box.png");
			coin = new Image("res/coin.png");
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
			
			//Lives and score board
			g.drawRect(350, 0, 450, 30);
			g.drawString("Lives: ", 350, 10);
			int i = 1;
			int livesX = 410;
			while(i<=lives){
				g.fillRect(livesX, 15, 10, 10);
				i++;
				livesX += 20;
			}
			g.drawString("Score: "+Game.gscore, 470, 15);
			g.drawString("Level 2", 270, 20);

			
			//Collectibles
			if(drawIt1 == true){g.drawImage(coin, 48, 167);}
			if(drawIt2 == true){g.drawImage(coin, 156, 211);}
			if(drawIt3 == true){g.drawImage(coin, 156, 45);}
			if(drawIt4 == true){g.drawImage(coin, 249, 164);}
			if(drawIt5 == true){g.drawImage(coin, 316, 0);}
			
			
			g.setColor(Color.cyan);
			g.fill(enemyrect2);
			g.fill(enemyrect3);
			g.fill(enemyrect);
			g.setColor(Color.white);
			g.fillRect(560, 300, 100, 100);
			g.drawImage(box, boxX, boxY);
			g.drawString("X:"+boxX+" Y:"+boxY, 100, 10);
			
			if(quit == true){
				g.drawString("<R> to resume", 261, 136);
				g.drawString("<Q> to quit", 261, 146);
				g.drawString("<M> to go back to main menu", 261, 156);
			}
			
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
			Input input = gc.getInput();
			
			timer += delta;
			
			while(timer > 5){
				timer -= 5;
			
			if(boxrect.intersects(c1)){
				if(scoreIt1 == true){
					Game.gscore += 10;
					scoreIt1 = false;
				}
				drawIt1 = false;
			}
			if(boxrect.intersects(c2)){
				if(scoreIt2 == true){
					Game.gscore += 10;
					scoreIt2 = false;
				}
				drawIt2 = false;
			}
			if(boxrect.intersects(c3)){
				if(scoreIt3 == true){
					Game.gscore+= 10;
					scoreIt3 = false;
				}
				drawIt3 = false;
			}
			if(boxrect.intersects(c4)){
				if(scoreIt4 == true){
					Game.gscore += 10;
					scoreIt4 = false;
				}
				drawIt4 = false;
			}
			if(boxrect.intersects(c5)){
				if(scoreIt5 == true){
					Game.gscore += 10;
					scoreIt5 = false;
				}
				drawIt5 = false;
			}
			
			if((drawIt1 == false)&&(drawIt2 == false)&&(drawIt3 == false)&&(drawIt4 == false)&&(drawIt5 == false)){
				allboxescollected = true;
			}
			
			if(quit == false){
				if(Game.gconfusion == false){
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
				}
				
				if(Game.gconfusion == true){
					if(input.isKeyDown(Input.KEY_UP)){
						boxY += 1;
						boxrect.setY(boxY);
					}
					if(input.isKeyDown(Input.KEY_DOWN)){
						boxY -= 1;
						boxrect.setY(boxY);
					}
					if(input.isKeyDown(Input.KEY_LEFT)){
						boxX += 1;
						boxrect.setX(boxX);
					}
					if(input.isKeyDown(Input.KEY_RIGHT)){
						boxX -= 1;
						boxrect.setX(boxX);
					}
				}
			}
			
			
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
					sbg.enterState(5);
				}
			}
			
			//MOVE EVEMY
			
			if(boxrect.intersects(r1)){
					enemyY += 4;	
					enemyrect.setY(enemyY);
			}
			
			if(boxrect.intersects(r2)){
				enemyY2 -= 4;	
				enemyrect2.setY(enemyY2);
			}
			
			if(boxrect.intersects(r3)){
				enemyY3 += 4;	
				enemyrect3.setY(enemyY3);
			}
			
			if((boxrect.intersects(enemyrect)) || (boxrect.intersects(enemyrect2)) || (boxrect.intersects(enemyrect3))){
				lives -= 1;
				boxX = 10;
				boxY = 10;
				boxrect.setX(boxX);
				boxrect.setY(boxY);
				enemyY = 0;
				enemyY2 = 313;
				enemyY3 = 0;
				enemyrect.setY(enemyY);
				enemyrect2.setY(enemyY2);
				enemyrect3.setY(enemyY3);
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
		}
		
		public int getID(){
			return 3;
		}

}
