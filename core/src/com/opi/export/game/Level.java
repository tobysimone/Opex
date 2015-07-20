package com.opi.export.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.opi.export.Drawable;
import com.opi.export.Export;
import com.opi.export.GameScreen;
import com.opi.export.Tickable;

public class Level implements Drawable, Tickable {
	
	public static final int DISTANCE_BETWEEN_LEVELS = (int) Tile.SIZE * 2;

	private GameScreen screen;
	private Tile[][] tiles;
	private float mx;
	private float my;
	
	public Level(GameScreen screen) {
	}
	
	@Override
	public void tick() {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].tick();
			}
		}
	}

	public void draw(SpriteBatch batch) {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].draw(batch, mx + (x * Tile.SIZE), my + (y * Tile.SIZE));
			}
		}
	}

	public void setPosition(float mx, float my) {
		this.mx = mx;
		this.my = my;
	}
	
	public GameScreen getGameScreen() {
		return screen;
	}
	
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public int getLevelWidth() {
		return tiles.length;
	}
	
	public int getLevelHeight() {
		return tiles[0].length;
	}
	
	public Vector2 getPosition() {
		float x = (Export.WIDTH / 2) - ((getLevelWidth() * Tile.SIZE) / 2);
		float y = (Export.HEIGHT / 2) - ((getLevelHeight() * Tile.SIZE) / 2);
		
		return new Vector2(x, y);
	}
}