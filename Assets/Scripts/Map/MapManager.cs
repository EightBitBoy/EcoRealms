using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	[RequireComponent(typeof(Chunk))]
	public class MapManager : MonoBehaviour {

		private int chunksX;
		private int chunksY;
		private int tilesX;
		private int tilesY;

		private int numChunks;

		private GameObject rootObject;
		private Transform root;
		private Mesh mesh;
		public Material material;

		private Tile[] tiles;
		private Vector3[] vertices;
		private Vector3[] normals;
		private int[] triangles;

		public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
			this.chunksX = chunksX;
			this.chunksY = chunksY;
			this.tilesX = tilesX;
			this.tilesY = tilesY;

			this.numChunks = this.chunksX * this.chunksY;

			Debug.Log("World size in chunks: " + this.chunksX + "*" + this.chunksY);

			InitializeData();
		}

		private void InitializeData() {
			rootObject = new GameObject("MapRoot");
			rootObject.AddComponent<MeshRenderer>().material = material;
			mesh = rootObject.AddComponent<MeshFilter>().mesh;
			root = rootObject.transform;

			CreateChunks();
			
			StartCoroutine(DelayedFunction()); //TODO do something awesome

			tiles = new Tile[numChunks];
			vertices = new Vector3[numChunks * 4];
			normals = new Vector3[numChunks * 4];
			triangles = new int[numChunks * 6];

			GenerateTiles();
			MergeTiles();

			mesh.Clear();
			mesh.vertices = vertices;
			mesh.normals = normals;
			mesh.triangles = triangles;
		}

		private void CreateChunks(){
			int chunkIndex = 0;
			for(int x = 0; x < chunksX; x++){
				for(int y = 0; y < chunksY; y++){
					GameObject chunkRoot = new GameObject("Chunk" + chunkIndex);
					chunkRoot.transform.SetParent(rootObject.transform);
					Chunk chunk = chunkRoot.AddComponent<Chunk>() as Chunk;
					chunk.Setup(tilesX, tilesY, material);
					chunkIndex++;
				}
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
}
