package cf.basicrpg.world;

import java.util.Random;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class City {
	private final int SCALE = 1;
	private final int CITY_WIDTH = 500;
	private final int CITY_HEIGHT = 500;
	private final int NUM_BUILDINGS = 60;
	
	private Building[][] cityGrid; 

	public City(Random rng) {
		cityGrid = new Building[CITY_WIDTH][CITY_HEIGHT];

		for (int i = 0; i < NUM_BUILDINGS; i++) {
			Building b = new Building(rng);
	
			int offsetX = rng.nextInt(CITY_WIDTH);
			int offsetY = rng.nextInt(CITY_HEIGHT);
			for (int x = 0; x < b.getWidth(); x++) {
				for (int y = 0; y < b.getHeight(); y++) {
					if (isInBounds(offsetX+x,offsetY+y)) {
						cityGrid[offsetX+x][offsetY+y] = b;
					}
				}
			}
		}
	}
	
	private boolean isInBounds(int x, int y) {
		return (x >= 0) && (x < CITY_WIDTH) && (y >= 0) && (y < CITY_HEIGHT);
	}
	
	
	public void draw(ShapeRenderer renderer) {
		for (int x = 0; x < CITY_WIDTH; x++) {
			for (int y = 0; y < CITY_HEIGHT; y++) {
				if (cityGrid[x][y] != null) {
					renderer.setColor(cityGrid[x][y].getColor());
					renderer.rect(x*SCALE, y*SCALE, SCALE, SCALE);
				}
			}
		}
	}
}
