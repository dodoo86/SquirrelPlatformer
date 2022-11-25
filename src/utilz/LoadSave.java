package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Crabby;
import main.Game;
import static utilz.Constants.EnemyConstants.CRABBY;

public class LoadSave {
	
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static final String MENU_BUTTONS = "button_atlas.png";
	public static final String MENU_BACKGROUND = "menu_background.png";
	public static final String PAUSE_BACKGROUND = "pause_menu.png";
	public static final String SOUND_BUTTONS = "sound_button.png";
	public static final String URM_BUTTONS = "urm_buttons.png";
	public static final String VOLUME_BUTTONS = "volume_buttons.png";
	public static final String MENU_BACKGROUND_IMG = "background_menu.png";
	public static final String PLAYING_BG_IMG = "playing_bg_img.png";
	public static final String BIG_CLOUDS = "big_clouds.png";
	public static final String SMALL_CLOUDS = "small_clouds.png";
	public static final String CRABBY_SPRITE = "crabby_sprite.png";
	public static final String STATUS_BAR = "health_power_bar.png";
	public static final String COMPLETED_IMG = "completed_sprite.png";
	public static final String POTION_ATLAS = "potions_sprites.png";
	public static final String CONTAINER_ATLAS = "objects_sprites.png";
	public static final String TRAP_ATLAS = "trap_atlas.png";
	public static final String LVL_ONE = "lvl_one.png";
	public static final String LVL_TWO = "lvl_two.png";
	public static final String LVL_THREE = "lvl_three.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		
		try {
			img = ImageIO.read(is);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public static BufferedImage[] GetAllLevels() {
		
		BufferedImage lvlOne =  GetSpriteAtlas(LVL_ONE);
		BufferedImage lvlTwo = GetSpriteAtlas(LVL_TWO);
		BufferedImage lvlThree = GetSpriteAtlas(LVL_THREE);
		
		BufferedImage[] imgs = new BufferedImage[3];
		
		imgs[0] = lvlOne;
		imgs[1] = lvlTwo;
		imgs[2] = lvlThree;

		return imgs;
		
	}
}
