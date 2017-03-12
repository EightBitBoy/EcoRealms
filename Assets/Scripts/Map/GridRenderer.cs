using UnityEngine;
using System.Collections;

public class GridRenderer : MonoBehaviour {

	private int linesX;
	private int linesY;

	public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
		this.linesX = chunksX * tilesX;
		this.linesY = chunksY * tilesY;

		Initialize();
	}

	private void Initialize() {

	}
}
