package StreetFighterPackage;

import javax.swing.JFrame;

import StreetFighterPackage.utils.GameConstants;

public class StreetFight extends JFrame implements GameConstants {
	public StreetFight() throws Exception {
		setTitle(TITLE);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GWIDTH,GHIEGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		add(board);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			StreetFight frame = new StreetFight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
