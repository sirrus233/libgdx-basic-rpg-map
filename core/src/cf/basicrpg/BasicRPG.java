package cf.basicrpg;

import java.util.Random;

import cf.basicrpg.InputManager;
import cf.basicrpg.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class BasicRPG extends Game {
	private final long RANDOM_SEED = 233;
	
	private GameScreen gameScreen;
	
	public InputManager im;
	public Random rng;
	
	@Override
	public void create() {
		rng = new Random(RANDOM_SEED);
		
		im = new InputManager();
		Gdx.input.setInputProcessor(im);
		
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
}
