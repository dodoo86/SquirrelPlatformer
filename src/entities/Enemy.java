package entities;

import static utilz.Constants.EnemyConstants.*;
public abstract class Enemy extends Entity {
	
	private int aniIndex, enemyState, enemyType;
	private int aniTick, aniSpeed = 25;

	public Enemy(float x, float y, int width, int height, int enemyType) {
		super(x, y, width, height);
		this.enemytype = enemyType;
		initHitbox(x, y, height, height );
		
	}

	private void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniTick ++;
			if(aniIndex >= GetSpriteAmount(enemyType, enemyState)) {
				aniIndex = 0;
			}
		}
	}
	
	public void update() {
		
		updateAnimationTick();
		
	}
	
	
	public int getAniIndex() {
		return aniIndex;
	}
	
	public int getEnemyState() {
		return enemyState;
	}
}
