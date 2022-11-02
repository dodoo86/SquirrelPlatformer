package levels;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Crabby;
import main.Game;
import static utilz.HelpMethods.GetLevelData;
import static utilz.HelpMethods.GetCrabs;

public class Level {

	private BufferedImage img;
	private int[][] lvlData;
	private ArrayList<Crabby> crabs;
	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;
	
	public Level(BufferedImage img) {
		
		this.img = img;
		createLevelData();
		createEnemyes();
		calculateLvlOffset();
	}
	
	private void calculateLvlOffset() {
		
		lvlTilesWide = img.getWidth();
		maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
		maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffset;
		
	}

	private void createEnemyes() {
		
		crabs = GetCrabs(img);
		
	}

	private void createLevelData() {
		
		lvlData = GetLevelData(img);
		
	}

	public int getSriteindex(int x, int y) {
		return lvlData[y][x];
		
	}
	
	public int[][] getLevelData() {
		
		return lvlData;
	}
	
	public int getLvlOffset() {
		
		return maxLvlOffsetX;
		
	}
	
	public ArrayList<Crabby> getCrabs() {
		
		return crabs;
		
	}
}
