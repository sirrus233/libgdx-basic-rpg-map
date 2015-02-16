package cf.basicrpg.screens;

import cf.basicrpg.InputManager;
import cf.basicrpg.BasicRPG;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class AbstractScreen extends ScreenAdapter {
	BasicRPG game;
	ShapeRenderer renderer = new ShapeRenderer();
	
	public void render(float delta) {
		update(delta);
		draw(renderer);
		InputManager.clear();
	}
	
	public abstract void update(float delta);
	
	public abstract void draw(ShapeRenderer renderer);
}
