using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class MapManager : MonoBehaviour {

		private int chunksX;
		private int chunksY;
		private int numTiles;

		private GameObject rootObject;
		private Transform root;
		public Mesh mesh;
		public Material material;

		private Tile[] tiles;
		private Vector3[] vertices;
		private Vector3[] normals;
		private int[] triangles;

		public void Setup(int chunksX, int chunksY) {
			this.chunksX = chunksX;
			this.chunksY = chunksY;
			this.numTiles = this.chunksX * this.chunksY;

			Debug.Log("World size: " + this.chunksX + "*" + this.chunksY);
			Debug.Log("Tiles: " + this.numTiles);

			InitializeData();
		}

		private void InitializeData() {
			rootObject = new GameObject("MapRoot");
			//TODO instantiate new mesh without relying on setting one in the editor
			rootObject.AddComponent<MeshFilter>().mesh = mesh;
			rootObject.AddComponent<MeshRenderer>().material = material;
			root = rootObject.transform;
			
			StartCoroutine(DelayedFunction()); //TODO do something awesome

			Tile t = new Tile(0,0);
			mesh.Clear();
			mesh.vertices = t.vertices;
			mesh.normals = t.normals;
			mesh.triangles = t.triangles;

			tiles = new Tile[numTiles];
			vertices = new Vector3[numTiles * 4];
			normals = new Vector3[numTiles * 4];
			triangles = new int[numTiles * 6];

			GenerateTiles();
			MergeTiles();

			mesh.Clear();
			mesh.vertices = vertices;
			mesh.normals = normals;
			mesh.triangles = triangles;

			//GameObject instance = Instantiate(groundTile, new Vector3(x, -0.1f * Random.Range(1,4), y), Quaternion.identity) as GameObject;
			//instance.transform.SetParent(mapHolder);

			for(int i = 0; i < 4; i++){
				GameObject chunk = new GameObject("Chunk" + i);
				chunk.transform.SetParent(rootObject.transform);
			}
		}

		private void GenerateTiles() {
			int tileIndex = 0;
			for(int x = 0; x < chunksX; x++) {
				for(int y = 0; y < chunksY; y++) {
					tiles[tileIndex] = new Tile(x, y);
					tileIndex++;
				}
			}
		}

		private void MergeTiles(){
			int index = 0;
			for(int x = 0; x < chunksX; x++) {
				for(int y = 0; y < chunksY; y++) {
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
		}

		private IEnumerator DelayedFunction() {
			//TDOD do something
			yield return new WaitForSeconds(0.5f);
		}
	}

	public class Tile {
		public Vector3[] vertices = new Vector3[4];
		public Vector3[] normals = new Vector3[4];
		public int[] triangles = new int[6];

		public Tile(int x, int y) {
			vertices[0] = new Vector3((float)(x + 0), 0.0f, (float)(y + 0)); 
			vertices[1] = new Vector3((float)(x + 0), 0.0f, (float)(y + 1)); 
			vertices[2] = new Vector3((float)(x + 1), 0.0f, (float)(y + 1)); 
			vertices[3] = new Vector3((float)(x + 1), 0.0f, (float)(y + 0));

			normals[0] = Vector3.up;
			normals[1] = Vector3.up;
			normals[2] = Vector3.up;
			normals[3] = Vector3.up;

			triangles[0] = 0;
			triangles[1] = 1;
			triangles[2] = 3;

			triangles[3] = 1;
			triangles[4] = 2;
			triangles[5] = 3;
		}
	}
}
