package de.eightbitboy.ecorealms.tilemap;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/*
 * Obviously, this is not a real test. This is for testing if implementing a map like this
 * works like expected.
 */
public class TileMapTest {
	private static final int WIDTH = 4;
	private static final int HEIGHT = 4;
	private static final int TILE_WIDTH = 1;
	private static final int TILE_HEIGHT = 1;

	private TiledMap map;

	public TileMapTest() {
		this.map = new TiledMap();

		MapLayers layers = map.getLayers();
		TiledMapTileLayer layer =
	}

	public TiledMap getMap() {
		return map;
	}
}
