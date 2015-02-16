package cf.basicrpg;

import cf.basicrpg.InputManager;
import cf.basicrpg.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class BasicRPG extends Game {

	private GameScreen gameScreen;
	
	@Override
	public void create() {
		gameScreen = new GameScreen(this);
		
		Gdx.input.setInputProcessor(new InputManager());
		setScreen(gameScreen);
	}
}
