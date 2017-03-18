using UnityEngine;
using System.Collections;
using Random = UnityEngine.Random;

namespace ecorealms.map {
	
	public class Chunk : MonoBehaviour{

		private int tilesX;
		private int tilesY;
		private Vector3 offset;
		private int numTiles;
		private Mesh mesh;
		private Tile[] tiles;
		private Vector3[] vertices;
		private Vector3[] normals;
		private int[] triangles;

		public void Setup(int tilesX, int tilesY, Material material, Vector3 offset){
			this.tilesX = tilesX;
			this.tilesY = tilesY;
			this.offset = offset;

			numTiles = this.tilesX * this.tilesY;

			mesh = gameObject.AddComponent<MeshFilter>().mesh;
			gameObject.AddComponent<MeshRenderer>().material = material;

			CreateTiles();
			CreateMesh();
		}

		private void CreateTiles(){
			tiles = new Tile[numTiles];
			int tileIndex = 0;

			for(int x = 0; x < tilesX; x++) {
				for(int y = 0; y < tilesY; y++) {
					tiles[tileIndex] = new Tile(x, y, offset);
					tileIndex++;
				}
			}
		}

		private void CreateMesh(){
			vertices = new Vector3[numTiles * 4];
			normals = new Vector3[numTiles * 4];
			triangles = new int[numTiles * 6];

			int index = 0;
			for(int x = 0; x < tilesX; x++) {
				for(int y = 0; y < tilesY; y++) {
					Tile tile = tiles[index];

					for(int v = 0; v < tile.vertices.Length; v++){
						vertices[(4 * index) + v] = tile.vertices[v];
					}
					for(int n = 0; n < tile.normals.Length; n++){
						normals[(4 * index) + n] = tile.normals[n];
					}
					for(int t = 0; t < tile.triangles.Length; t++){
						triangles[(6 * index) + t] = tile.triangles[t] + (4 * index);
					}

					index++;
				}
			}

			mesh.Clear();
			mesh.vertices = vertices;
			mesh.normals = normals;
			mesh.triangles = triangles;
		}
	}
}
