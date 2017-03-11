using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class Chunk : MonoBehaviour{

		private int tilesX;
		private int tilesY;
		private int numTiles;
		private Mesh mesh;
		private Tile[] tiles;

		public void Setup(int tilesX, int tilesY, Material material){
			this.tilesX = tilesX;
			this.tilesY = tilesY;

			numTiles = this.tilesX * this.tilesY;

			mesh = gameObject.AddComponent<MeshFilter>().mesh;
			mesh.Clear();

			gameObject.AddComponent<MeshRenderer>().material = material;

			CreateTiles();
			CreateMesh();
		}

		private void CreateTiles(){
			tiles = new Tile[numTiles];
			int tileIndex = 0;
			for(int x = 0; x < tilesX; x++) {
				for(int y = 0; y < tilesY; y++) {
					tiles[tileIndex] = new Tile(x, y);
					tileIndex++;
				}
			}
		}

		private void CreateMesh(){

		}
	}
}
