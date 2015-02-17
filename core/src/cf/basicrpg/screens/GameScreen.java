package cf.basicrpg.screens;

import cf.basicrpg.BasicRPG;
import cf.basicrpg.InputManager;
import cf.basicrpg.world.City;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen extends AbstractScreen {
	private City city;
	
	public GameScreen(BasicRPG g) {
		super.game = g;
		city = new City(g.rng);
	}

	@Override
	public void update(float delta) {
		if (game.im.keysTyped['q']) city = new City(super.game.rng);
		if (game.im.keysTyped[InputManager.ESC]) Gdx.app.exit();
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		Gdx.gl.glClearColor(0f, 0f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.begin(ShapeType.Filled);
		city.draw(renderer);
		renderer.end();		
	}
}
