package javagame;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
	
	public static final String gamename = "The Box";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int help = 2;
	public static final int play2 = 3;
	public static final int gOver = 4;
	public static final int play3 = 5;
	public static final int play4 = 6;
	public static int gscore = 0;
	public static boolean gconfusion = false;
	
	public Game(String gamename){
		
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Help(help));
		this.addState(new Play2(play2));
		this.addState(new GameOver(gOver));
		this.addState(new Play3(play3));
		this.addState(new Play4(play4));
		
	}
	
	

	public void initStatesList(GameContainer gc) throws SlickException {
		
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(help).init(gc, this);
		this.getState(play2).init(gc, this);
		this.getState(gOver).init(gc, this);
		this.getState(play3).init(gc,this);
		this.getState(play4).init(gc,this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(640, 360, false);
			Display.setResizable(true);
			appgc.start();
			appgc.setTargetFrameRate(60);
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
