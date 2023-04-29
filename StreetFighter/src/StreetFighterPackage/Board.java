package StreetFighterPackage;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import StreetFighterPackage.sprites.Player;
import StreetFighterPackage.utils.GameConstants;

public class Board extends JPanel implements GameConstants { // JPanel is used for drawing purposes
	BufferedImage backgroundImage; // Class used to read image
	private Player player; // putting player on board
	private Timer timer; // to regulate images
	public Board() throws Exception {
		player = new Player();
		loadBackgroundImage();
		setFocusable(true); // for getting events on board
		bindEvents();// will keep all the events happening on board
		gameLoop();
	}
	private void gameLoop() {
		timer = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint(); // screen gets painted agin with new value of x
				
					player.Fall();
					player.checkPosition(player.getY());
				
					
				
			}
		});
		timer.start();
	}
	
	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() { // Adding keylistner interface
			
			 // methods of keylistner interface
				
			
			@Override
			public void keyReleased(KeyEvent e) {
				player.setSpeed(0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) { // VK = Virtual key 
					player.setSpeed(-10);
					player.move();
					  
				}else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setSpeed(10);
					
					player.move();
				}else if (e.getKeyCode()==KeyEvent.VK_K) {
					player.setCurrentMove(KICK);
					
				}else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
					player.Jump();
					
				}
				
			}
		});
	}
	private void loadBackgroundImage() {
		try {
		backgroundImage = ImageIO.read(Board.class.getResource("Moon.jpg"));
		}
		catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"OOPS Something went wrong" );
			System.out.println(ex);
			System.exit(0);
		}
	}
	@Override
	public void paintComponent(Graphics pen) { // Method used for painting
		super.paintComponent(pen); // cleans the board before painting
		printBG(pen);
		player.paintPlayer(pen);
	}
	private void printBG(Graphics pen) { // Method used to print background
		//pen.setColor(Color.RED); // Color of background
		//pen.fillRect(0, 0, GWIDTH, GHIEGHT); // 0 0 are the coordinates of screen
		pen.drawImage(backgroundImage,0,0,GWIDTH,GHIEGHT,null);
	}

}
