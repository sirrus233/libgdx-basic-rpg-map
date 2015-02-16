package cf.basicrpg.screens;

import cf.basicrpg.BasicRPG;
import cf.basicrpg.InputManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen extends AbstractScreen {
	
	public GameScreen(BasicRPG g) {
		super.game = g;
	}

	@Override
	public void update(float delta) {
		if (InputManager.keysTyped[InputManager.ESC]) Gdx.app.exit();
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.begin(ShapeType.Filled);
		renderer.end();		
	}
}
