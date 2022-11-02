package Ui;

import java.awt.image.BufferedImage;

import gamestates.Playing;
import main.Game;
import utilz.LoadSave;
import static utilz.Constants.UI.URMButtons.*;

public class LevelCompletedOverlay {

	private Playing playing;
	private UrmButtons menu, next;
	private BufferedImage img;
	private int bgX, bgY, bgW, bgH;
	
	public LevelCompletedOverlay(Playing playing) {
		this.playing = playing;
		initImg();
		initButtons();
	}

	private void initButtons() {
		
		int menuX = (int) (330 * Game.SCALE);
		int nextX = (int) (445 * Game.SCALE);
		int y = (int) (195 * Game.SCALE);
		next = new UrmButtons(nextX, y, URM_SIZE, URM_SIZE, 0);
		menu = new UrmButtons(menuX, y, URM_SIZE, URM_SIZE, 2);
		
	}

	private void initImg() {
		
		img = LoadSave.GetSpriteAtlas(LoadSave.COMPLETED_IMG);
		bgW = (int) (img.getWidth() * Game.SCALE);
		bgH = (int) (img.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int) (75 * Game.SCALE);
		
	}
	
}
