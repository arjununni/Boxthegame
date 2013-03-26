package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Play3 extends BasicGameState{

		Image box;
		Image key;
		int boxX = -3;
		int boxY = 313;
		int lives = 3;
		Rectangle boxrect = new Rectangle(boxX, boxY, 25, 25);
		
		//Variables for collectibles
				int score = 0;
				boolean allboxescollected = false;
				Rectangle c1 = new Rectangle(72, 154, 25, 25);
				Rectangle c2 = new Rectangle(235, 106, 25, 25);
				Rectangle c3 = new Rectangle(72, 69, 25, 25);
				Rectangle c4 = new Rectangle(235, 30, 25, 25);
				Rectangle c5 = new Rectangle(598, 77, 25, 25);
				Rectangle c6 = new Rectangle(598, 106, 25, 25);
				Rectangle c7 = new Rectangle(598, 139, 25, 25);
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
				boolean drawIt6 = true;
					boolean scoreIt6 = true;
				boolean drawIt7 = true;
					boolean scoreIt7 = true;
					
		//Wall Rectangles(wX is parent and wXcX is collision child)
				Rectangle w1;
					Rectangle w1c1;
					Rectangle w1c2;
					Rectangle w1c3;
					
				Rectangle w2;
					Rectangle w2c1;
					Rectangle w2c2;
					Rectangle w2c3;
					
				Rectangle w3;
					Rectangle w3c1;
					Rectangle w3c2;
				
				Rectangle w4;
					Rectangle w4c1;
					Rectangle w4c2;
					Rectangle w4c3;
		
		//Enemy
		int enemyX = 255;
		int enemyX2 = 72;
		int enemyX3 = 255;
		Rectangle enemyrect = new Rectangle(enemyX, 153, 25, 25);
			Rectangle erc1 = new Rectangle(255, 153, 25, 25);
			Rectangle erc2 = new Rectangle(47, 153, 25, 25);
			char dir = 'l';
		Rectangle enemyrect2 = new Rectangle(enemyX2, 103, 25, 25);
			Rectangle erc3 = new Rectangle(47, 103, 25, 25);
			Rectangle erc4 = new Rectangle(255, 92, 25, 25);
			char dir2 = 'r';
		Rectangle enemyrect3 = new Rectangle(enemyX3, 67, 25, 25);
			Rectangle erc5 = new Rectangle(255, 67, 25, 25);
			Rectangle erc6 = new Rectangle(47, 55, 25, 25);
			char dir3 = 'l';
			
		Rectangle enemyrect4 = new Rectangle(433, 77, 90, 90);
			boolean drawItenemy = true;
					
		boolean quit = false;
	
		public Play3(int state){
			
			
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
			box = new Image("res/box.png");
			key = new Image("res/key.png");
			
			w1 = new Rectangle(29, 30, 44, 170);
				w1c1 = new Rectangle(29, 30, 22, 170);
				w1c2 = new Rectangle(40, 30, 22, 170);
				w1c3 = new Rectangle(29, 193, 44, 0);
			
			w2 = new Rectangle(266, 30, 44, 170);
				w2c1 = new Rectangle(266, 30, 22, 170);
				w2c2 = new Rectangle(277, 30, 22, 170);
				w2c3 = new Rectangle(246, 193, 44, 0);
			
			w3 = new Rectangle(400, 32, 250, 44);	
				w3c1 = new Rectangle(400, 32, 250, 44);
				w3c2 = new Rectangle(400, 32, 0, 44);
			
			w4 = new Rectangle(400, 175, 250, 44);
				w4c1 = new Rectangle(400, 175, 250, 22);
				w4c2 = new Rectangle(400, 196, 250, 22);
				w4c3 = new Rectangle(400, 175, 0, 44);
				
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
			g.drawString("Score: "+score, 470, 15);
			g.drawString("Level 3", 270, 10);

			//Walls
			g.setColor(Color.orange);
			g.fill(w1);
			g.fill(w2);
			g.fill(w3);
			g.fill(w4);
			g.setColor(Color.white);
			
			//Collectibles
			g.setColor(Color.magenta);
			if(drawIt1 == true){g.fill(c1);}
			if(drawIt2 == true){g.fill(c2);}
			if(drawIt3 == true){g.fill(c3);}
			if(drawIt4 == true){g.drawImage(key, 235, 30);}
			if(drawIt5 == true){g.fill(c5);}
			if(drawIt6 == true){g.fill(c6);}
			if(drawIt7 == true){g.fill(c7);}
			
			//Enemys
			g.setColor(Color.cyan);
			g.fill(enemyrect);
			g.fill(enemyrect2);
			g.fill(enemyrect3);
			if(drawItenemy == true){g.fill(enemyrect4);}
			
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
			
			if(drawItenemy == true){
				if(boxrect.intersects(enemyrect4)){
					boxX -= 1;
					boxrect.setX(boxX);
				}
			}
			
			//Collision detection for enemyrect
			if(enemyrect.intersects(erc1)){
				dir = 'l';
			}
			if(enemyrect.intersects(erc2)){
				dir = 'r';
			}
			if(dir == 'l'){
				try{
					Thread.sleep(5);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				enemyX -= 1;
				enemyrect.setX(enemyX);
			}
			if(dir == 'r'){
				try{
					Thread.sleep(5);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				enemyX += 1;
				enemyrect.setX(enemyX);
			}
			
			//Collision detection for enemyrect2
			if(enemyrect2.intersects(erc3)){
				dir2 = 'r';
			}
			if(enemyrect2.intersects(erc4)){
				dir2 = 'l';
			}
			if(dir2 == 'l'){
				enemyX2 -= 1;
				enemyrect2.setX(enemyX2);
			}
			if(dir2 == 'r'){
				enemyX2 += 1;
				enemyrect2.setX(enemyX2);
			}
			
			//Collision detection for enemyrect
			if(enemyrect3.intersects(erc5)){
				dir3 = 'l';
			}
			if(enemyrect3.intersects(erc6)){
				dir3 = 'r';
			}
			if(dir3 == 'l'){
				enemyX3 -= 1;
				enemyrect3.setX(enemyX3);
			}
			if(dir3 == 'r'){
				enemyX3 += 1;
				enemyrect3.setX(enemyX3);
			}
			
			//Collision detection for w1 and w2
			if((boxrect.intersects(w1c1)) || (boxrect.intersects(w2c1))){
				boxX -= 1;
				boxrect.setX(boxX);
			}
			if((boxrect.intersects(w1c2)) || (boxrect.intersects(w2c2))){
				boxX += 1;
				boxrect.setX(boxX);
			}
			if((boxrect.intersects(w1c3)) || (boxrect.intersects(w2c3))){
				boxY += 1;
				boxrect.setY(boxY);
			}
			
			//Callisan for w3
			if(boxrect.intersects(w3c1)){
				boxY += 1;
				boxrect.setY(boxY);
			}
			
			if(boxrect.intersects(w3c2)){
				boxX -= 1;
				boxrect.setX(boxX);
			}
			
			//Callison for w4
			if(boxrect.intersects(w4c1)){
				boxY -= 1;
				boxrect.setY(boxY);
			}
			if(boxrect.intersects(w4c2)){
				boxY += 1;
				boxrect.setY(boxY);
			}
			if(boxrect.intersects(w4c3)){
				boxX -= 1;
				boxrect.setX(boxX);
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
				drawIt4 = false;
				drawItenemy = false;
			}
			if(boxrect.intersects(c5)){
				if(scoreIt5 == true){
					score += 10;
					scoreIt5 = false;
				}
				drawIt5 = false;
			}
			if(boxrect.intersects(c6)){
				if(scoreIt6 == true){
					score += 10;
					scoreIt6 = false;
				}
				drawIt6 = false;
			}
			if(boxrect.intersects(c7)){
				if(scoreIt7 == true){
					score += 10;
					scoreIt7 = false;
				}
				drawIt7 = false;
			}
			
			if((drawIt1 == false)&&(drawIt2 == false)&&(drawIt3 == false)&&(drawIt4 == false)&&(drawIt5 == false)&&(drawIt6 == false)&&(drawIt7 == false)){
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
			
			if(boxY < 30){
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
					sbg.enterState(6);
				}
			}
			
			//MOVE EVEMY
			
			
			if((boxrect.intersects(enemyrect)) || (boxrect.intersects(enemyrect2)) || (boxrect.intersects(enemyrect3))){
				lives -= 1;
				boxX = -3;
				boxY = 313;
				boxrect.setX(boxX);
				boxrect.setY(boxY);
				int enemyX = 255;
				int enemyX2 = 72;
				int enemyX3 = 255;
				enemyrect.setX(enemyX);
				enemyrect2.setX(enemyX2);
				enemyrect3.setX(enemyX3);
			}
			
			if(lives <= 0){
				sbg.enterState(4);
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
				sbg.enterState(5);
			}
			
		}
		
		public int getID(){
			return 5;
		}

}
