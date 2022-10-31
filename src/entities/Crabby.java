package entities;

import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.EnemyConstants.*;
import static utilz.HelpMethods.CanMovehere;
import static utilz.HelpMethods.GetEntityYPosUnderRoofOrAboveFloor;
import static utilz.HelpMethods.IsEntityOnFloor;
import static utilz.HelpMethods.IsFloor;

import main.Game;

public class Crabby extends Enemy {

	public Crabby(float x, float y) {
		super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
		initHitbox(x, y, (int) (22 * Game.SCALE), (int) (19 * Game.SCALE));

	}

	public void update(int[][] lvlData) {
		updateMove(lvlData);
		updateAnimationTick();

	}
	
	private void updateMove(int[][] lvlData) {
		
		if (firstUpdate) 
			firstUpdateCheck(lvlData);

		if (inAir) 
			updateInAir(lvlData);
		 else {
			switch (enemyState) {
			case IDLE:
				newState(RUNNING);
				break;
			case RUNNING:
				move(lvlData);
				break;
			}
		}

	}
	
}
