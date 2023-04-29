package StreetFighterPackage.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import StreetFighterPackage.utils.GameConstants;

public class Player implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage bi;
	private int speed;
	private BufferedImage[] walkImages = new BufferedImage[4];
	private BufferedImage[] KickImages = new BufferedImage[3];
	private int currentMove; // current move (walk,kick,jump)
	private int index;
	private int force;
	private boolean isJump = false; // jump completion check
	public Player() throws Exception {
		x = 100;
		
		w = 100;
		h = 200;
		y = FLOOR;
		
		speed = 0;
		force = 0;
		currentMove = WALK;
		bi = ImageIO.read(Player.class.getResource("character.png"));
		loadWalkImage();
		loadPlayerKick();
	}
	
	private void loadPlayerKick() {
		KickImages[0] = bi.getSubimage(732, 725, 119, 146);// gets the character from sprite sheet
	KickImages[2] = bi.getSubimage(354, 409, 86, 122);
		KickImages[1] = bi.getSubimage(572, 907, 185, 116);// gets the character from sprite sheet
		
	}
	private void loadWalkImage() {
		walkImages[0] = bi.getSubimage(4, 1, 89, 127);// gets the character from sprite sheet
		walkImages[1] = bi.getSubimage(306, 277, 88, 118);
		//walkImages[2] = bi.getSubimage(221, 11, 100, 118);
		//walkImages[3] = bi.getSubimage(339, 15, 95, 115);
	}
	
	

	

	public int getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
		index = 0;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void Jump() {
		if (!isJump) {
			force = -25;
			y=y+force;
			isJump = true;
		}
		
	}
	public void Fall() {
		
		if(y>= (FLOOR)) {
			isJump = false; 
			return ;
		}
		
		force = force +GRAVITY;
		y = y+force;
		
	}
	
	public int getY() {
		return y;
	}

	
	public void checkPosition(int pos) {
		if (y>= FLOOR) {
			y = FLOOR;
		}
		
	}
	
	
	public void move() {
		x = x+speed;
	}
	private BufferedImage showPlayerKick() {
		if (index > 2) {
			index =0; // for repetation
			currentMove = WALK;
		}
	BufferedImage img = KickImages[index];
	index++;
	return img;
	}
	private BufferedImage showWalkPlayer() {
		if (index > 1) {
			index =0; // for repetation
			
		}
	BufferedImage img = walkImages[index];
	index++;
	return img;
	}
	public void paintPlayer(Graphics pen) {
		if (currentMove == WALK) {
			pen.drawImage(showWalkPlayer(), x, y, w, h,  null);	
		}else if (currentMove == KICK) {
			pen.drawImage(showPlayerKick(), x, y, w, h,  null);
		}
		
	}

}
