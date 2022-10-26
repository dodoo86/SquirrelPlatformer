package Ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class PauseOverlay {
	
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgW, bgH;

	public PauseOverlay() {
		
		loadBackgroud();
		
	}
	
	private void loadBackgroud() {
		
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
		bgW = (int) (backgroundImg.getWidth() * Game.SCALE);
		bgH = (int) (backgroundImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int) (25 * Game.SCALE);
		
	}

	public void update() {
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);
		
	}
	
	public void mouseDragged() {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		
	}

	public void mouseReleased(MouseEvent e) {
		
		
	}

	public void mouseMoved(MouseEvent e) {
		
		
	}
}

