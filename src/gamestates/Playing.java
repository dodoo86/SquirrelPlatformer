package gamestates;

import entities.Player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Levels.LevelManager;
import Ui.PauseOverlay;
import main.Game;

public class Playing extends State implements Statemethods{
	
	private Player player;
	private LevelManager levelManager;
	private PauseOverlay pauseOverlay;
	private boolean paused = true;
	
	public Playing(Game game) {
		super(game);
		initClasses();
	}	
	
	private void initClasses() {
		
		levelManager = new LevelManager(game);
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		pauseOverlay = new PauseOverlay();
		
	}

	@Override
	public void update() {
		
		levelManager.update();
		player.update();
		pauseOverlay.update();
		
	}

	@Override
	public void draw(Graphics g) {
		
		levelManager.draw(g);
		player.render(g);
		
		pauseOverlay.draw(g);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			player.setAttacking(true);
		}

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(paused)
			pauseOverlay.mousePressed(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(paused)
			pauseOverlay.mouseReleased(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(paused)
			pauseOverlay.mouseMoved(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			player.setJump(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_S:
			player.setDown(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(true);
			break;
		case KeyEvent.VK_BACK_SPACE :
			Gamestate.state = Gamestate.MENU;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setJump(false);
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_S:
			player.setDown(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(false);
			break;
		}
		
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}
}
