package cf.basicrpg.world;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class Building {
	private final int MAX_HEIGHT = 50;
	private final int MAX_WIDTH = 50;
	private final int MIN_HEIGHT = 10;
	private final int MIN_WIDTH = 10;
	
	private int height;
	private int width;
	private Color color;
	
	public Building(Random rng) {
		height = MIN_HEIGHT + rng.nextInt(MAX_HEIGHT-MIN_HEIGHT);
		width = MIN_WIDTH + rng.nextInt(MAX_WIDTH-MIN_WIDTH);
		//color = new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat(), 1f);
		color = Color.MAROON;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public Color getColor() {
		return color;
	}
}
