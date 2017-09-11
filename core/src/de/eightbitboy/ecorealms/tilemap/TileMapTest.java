package de.eightbitboy.ecorealms.tilemap;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
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
		TiledMapTileLayer layer = new TiledMapTileLayer(WIDTH, HEIGHT, TILE_WIDTH, TILE_HEIGHT);

		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();

				RectangleMapObject rect = new RectangleMapObject();

				layer.setCell(x, y, cell);
			}
		}

		layers.add(layer);
	}

	public TiledMap getMap() {
		return map;
	}
}
