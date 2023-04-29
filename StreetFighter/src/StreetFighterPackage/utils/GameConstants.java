package StreetFighterPackage.utils;

public interface GameConstants {
	String TITLE = ConfigReader.getValue("game.title");
	int GWIDTH = Integer.parseInt(ConfigReader.getValue("game.width"));
	int GHIEGHT = Integer.parseInt(ConfigReader.getValue("game.hieght"));
	int FLOOR = Integer.parseInt(ConfigReader.getValue("game.hieght")) -320;
	int KICK = 2;
	int WALK =1;
	int GRAVITY = 10;
	
	

}
