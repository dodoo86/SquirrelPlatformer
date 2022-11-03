package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;
	protected int aniTick, aniIndex;
	protected int state;
	protected float airSpeed;
	protected boolean inAir = false;
	
	protected int maxHealth;
	protected int currentHealth;
	protected float walkSpeed = 1.0f * Game.SCALE;

	protected Rectangle2D.Float attackBox;

	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	   
	}
	
	protected void drawHitbox(Graphics g, int xLvlOffset) {
		//for debugging hitbox
		g.setColor(Color.PINK);
		g.drawRect((int) hitbox.x - xLvlOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
	}

	protected void initHitbox(float x, float y, int width, int height) {
		
		hitbox = new Rectangle2D.Float( x, y, width, height);
		
	}
	/*
	protected void updateHitbox() {
		
		hitbox.x = (int) x;
		hitbox.y = (int) y;
	}
	*/
	public Rectangle2D.Float gethitbox() {
		
		return hitbox;
	}

	public int getState() {
		return state;
	}
}