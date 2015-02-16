package cf.basicrpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputManager implements InputProcessor {
	//Constants for buttons
	public static final char LEFT_CLICK = 0;
	public static final char RIGHT_CLICK = 1;
	public static final char CENTER_CLICK = 2;
	
	//Unicode char constants, for comparison in keyTyped method
	public static final char ESC = '\u001B';
	
	//Mouse vectors
	private static Vector2 mouse = new Vector2();
	private static Vector2 mouseDelta = new Vector2();
	
	//Array of keyboard inputs, available for rest of program to query
	public static boolean[] keysTyped = new boolean[128];
	public static boolean[] keys = new boolean[256];
	
	//Arrays relating to mouse/touch inputs
	public static boolean[] buttonsDown = new boolean[8];
	public static boolean[] buttonsClicked = new boolean[8];
	public static int mouseScrollDirection = 0;
	
	public static Vector2 getMouse() {
		return new Vector2(mouse);
	}
	
	public static Vector2 getMouseDelta() {
		return new Vector2(mouseDelta);
	}
	
	public static void clear() {
		//The mouseDelta vectors need to be reset on clear, since this is the only way to "auto-clear" them
		//in the event that no input is received
		mouseDelta.set(0, 0);
		mouseScrollDirection = 0;
		
		for (int i = 0; i < keysTyped.length; i++) {
			keysTyped[i] = false;
		}
		
		for (int i = 0; i < buttonsClicked.length; i++) {
			buttonsClicked[i] = false;
		}
	}
	
	public void updateMouse(int screenX, int screenY) {
		//mouseDelta is based on the previous mouse position, so must be calculated before
		//the mouse vector is changed
		mouseDelta.set(screenX - getMouse().x, Gdx.graphics.getHeight() - screenY - getMouse().y);
		mouse.set(screenX, Gdx.graphics.getHeight() - screenY);
	}
	
	@Override
	public boolean keyTyped(char character) {
		keysTyped[character] = true;
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		buttonsDown[button] = true;		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//If the mouse button is currently down, set it as released, and set the bit in 
		//the buttonsClicked array to show we have registered a click
		if (buttonsDown[button]) {
			buttonsClicked[button] = true;
			buttonsDown[button] = false;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		updateMouse(screenX, screenY);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		updateMouse(screenX, screenY);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		mouseScrollDirection = amount;
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		keys[keycode] = true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		keys[keycode] = false;
		return false;
	}

}
