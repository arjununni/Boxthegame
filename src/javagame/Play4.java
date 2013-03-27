package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Play4 extends BasicGameState{
	
		int timer = 0;
		Image box;
		Image coin;
		int boxX = 2;
		int boxY = 157;
		int lives = 3;
		Rectangle boxrect = new Rectangle(boxX, boxY, 25, 25);
		
		//Variables for collectibles
				boolean allboxescollected = false;
				Rectangle c1 = new Rectangle(133, 313, 25, 25);
				Rectangle c2 = new Rectangle(183, 33, 25, 25);
				Rectangle c3 = new Rectangle(213, 313, 25, 25);
				Rectangle c4 = new Rectangle(253, 33, 25, 25);
				Rectangle c5 = new Rectangle(293, 313, 25, 25);
				Rectangle c6 = new Rectangle(333, 33, 25, 25);
				Rectangle c7 = new Rectangle(373, 313, 25, 25);
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
				
					//Enemy
					int enemyY = 33;
					int enemyY2 = 314;
					int enemyY3 = 33;
					int enemyY4 = 314;
					int enemyY5 = 33;
					int enemyY6 = 314;
					int enemyY7 = 33;
					Rectangle enemyrect = new Rectangle(133, enemyY, 25, 25);
						Rectangle erc1 = new Rectangle(133, 33, 25, 25);
						Rectangle erc2 = new Rectangle(133, 315, 25, 25);
						char dir = 'd';
					Rectangle enemyrect2 = new Rectangle(183, enemyY2, 25, 25);
						Rectangle erc3 = new Rectangle(183, 315, 25, 25);
						Rectangle erc4 = new Rectangle(183, 30, 25, 25);
						char dir2 = 'u';
					Rectangle enemyrect3 = new Rectangle(213, enemyY3, 25, 25);
						Rectangle erc5 = new Rectangle(213, 30, 25, 25);
						Rectangle erc6 = new Rectangle(213, 315, 25, 25);
						char dir3 = 'd';
					Rectangle enemyrect4 = new Rectangle(253, enemyY4, 25, 25);
						Rectangle erc7 = new Rectangle(253, 315, 25, 25);
						Rectangle erc8 = new Rectangle(253, 30, 25, 25);
						char dir4 = 'd';
					Rectangle enemyrect5 = new Rectangle(293, enemyY5, 25, 25);
						Rectangle erc9 = new Rectangle(293, 30, 25, 25);
						Rectangle erc10 = new Rectangle(293, 315, 25, 25);
						char dir5 = 'd';
					Rectangle enemyrect6 = new Rectangle(333, enemyY6, 25, 25);
						Rectangle erc11 = new Rectangle(333, 315, 25, 25);
						Rectangle erc12 = new Rectangle(333, 30, 25, 25);
						char dir6 = 'd';
					Rectangle enemyrect7 = new Rectangle(373, enemyY7, 25, 25);
						Rectangle erc13 = new Rectangle(373, 30, 25, 25);
						Rectangle erc14 = new Rectangle(373, 315, 25, 25);
						char dir7 = 'd';
					
		boolean quit = false;
	
		public Play4(int state){
			
			
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
			g.drawString("Level 3", 270, 10);

			//Enemy
			g.setColor(Color.cyan);
			g.fill(enemyrect);
			g.fill(enemyrect2);
			g.fill(enemyrect3);
			g.fill(enemyrect4);
			g.fill(enemyrect5);
			g.fill(enemyrect6);
			g.fill(enemyrect7);
			
			//Collectibles
			g.setColor(Color.magenta);
			if(drawIt1 == true){g.drawImage(coin, 133, 313);}
			if(drawIt2 == true){g.drawImage(coin, 183, 33);}
			if(drawIt3 == true){g.drawImage(coin, 213, 313);}
			if(drawIt4 == true){g.drawImage(coin, 253, 33);}
			if(drawIt5 == true){g.drawImage(coin, 293, 313);}
			if(drawIt6 == true){g.drawImage(coin, 333, 33);}
			if(drawIt7 == true){g.drawImage(coin, 373, 313);}
			
			
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
			
			//ENEMYS GOING DOWN
			
			//Collision detection for enemyrect
			if(enemyrect.intersects(erc1)){
				dir = 'd';
			}
			if(enemyrect.intersects(erc2)){
				dir = 'u';
			}
			if(dir == 'd'){
				enemyY += 1;
				enemyrect.setY(enemyY);
			}
			if(dir == 'u'){
				enemyY -= 1;
				enemyrect.setY(enemyY);
			}
			
			//enemyrect3
			if(enemyrect3.intersects(erc5)){
				dir3 = 'd';
			}
			if(enemyrect3.intersects(erc6)){
				dir3 = 'u';
			}
			if(dir3 == 'd'){
				enemyY3 += 1;
				enemyrect3.setY(enemyY3);
			}
			if(dir3 == 'u'){
				enemyY3 -= 1;
				enemyrect3.setY(enemyY3);
			}
			
			//enemyrect5
			if(enemyrect5.intersects(erc9)){
				dir5 = 'd';
			}
			if(enemyrect5.intersects(erc10)){
				dir5 = 'u';
			}
			if(dir5 == 'd'){
				enemyY5 += 1;
				enemyrect5.setY(enemyY5);
			}
			if(dir5 == 'u'){
				enemyY5 -= 1;
				enemyrect5.setY(enemyY5);
			}
			
			//enemyrect7
			if(enemyrect7.intersects(erc13)){
				dir7 = 'd';
			}
			if(enemyrect7.intersects(erc14)){
				dir7 = 'u';
			}
			if(dir7 == 'd'){
				enemyY7 += 1;
				enemyrect7.setY(enemyY7);
			}
			if(dir7 == 'u'){
				enemyY7 -= 1;
				enemyrect7.setY(enemyY7);
			}
			
			//ENEMYS GOING UP
			
			//CDectection for enemyrect2
			if(enemyrect2.intersects(erc3)){
				dir2 = 'u';
			}
			if(enemyrect2.intersects(erc4)){
				dir2 = 'd';
			}
			if(dir2 == 'd'){
				enemyY2 += 1;
				enemyrect2.setY(enemyY2);
			}
			if(dir2 == 'u'){
				enemyY2 -= 1;
				enemyrect2.setY(enemyY2);
			}
			
			//CDectection for enemyrect4
			if(enemyrect4.intersects(erc7)){
				dir4 = 'u';
			}
			if(enemyrect4.intersects(erc8)){
				dir4 = 'd';
			}
			if(dir4 == 'd'){
				enemyY4 += 1;
				enemyrect4.setY(enemyY4);
			}
			if(dir4 == 'u'){
				enemyY4 -= 1;
				enemyrect4.setY(enemyY4);
			}
			
			//CDectection for enemyrect6
			if(enemyrect6.intersects(erc11)){
				dir6 = 'u';
			}
			if(enemyrect6.intersects(erc12)){
				dir6= 'd';
			}
			if(dir6 == 'd'){
				enemyY6 += 1;
				enemyrect6.setY(enemyY6);
			}
			if(dir6 == 'u'){
				enemyY6 -= 1;
				enemyrect6.setY(enemyY6);
			}
			
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
					Game.gscore += 10;
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
			if(boxrect.intersects(c6)){
				if(scoreIt6 == true){
					Game.gscore += 10;
					scoreIt6 = false;
				}
				drawIt6 = false;
			}
			if(boxrect.intersects(c7)){
				if(scoreIt7 == true){
					Game.gscore += 10;
					scoreIt7 = false;
				}
				drawIt7 = false;
			}
			
			if((drawIt1 == false)&&(drawIt2 == false)&&(drawIt3 == false)&&(drawIt4 == false)&&(drawIt5 == false)&&(drawIt6 == false)&&(drawIt7 == false)){
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
					sbg.enterState(0);
				}
			}
			
			//MOVE EVEMY
			
			
			if((boxrect.intersects(enemyrect)) || (boxrect.intersects(enemyrect2)) || (boxrect.intersects(enemyrect3)) || (boxrect.intersects(enemyrect4))|| (boxrect.intersects(enemyrect5))|| (boxrect.intersects(enemyrect6))|| (boxrect.intersects(enemyrect7))){
				lives -= 1;
				boxX = -3;
				boxY = 313;
				boxrect.setX(boxX);
				boxrect.setY(boxY);
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
			return 6;
		}

}
