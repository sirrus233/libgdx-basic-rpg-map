package cf.basicrpg;

import cf.basicrpg.InputManager;
import cf.basicrpg.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class BasicRPG extends Game {
	
	public InputManager im;
	private GameScreen gameScreen;
	
	@Override
	public void create() {
		im = new InputManager();
		Gdx.input.setInputProcessor(im);
		
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}
}
