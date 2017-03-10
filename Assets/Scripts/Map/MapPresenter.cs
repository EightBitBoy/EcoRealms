using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class MapPresenter : MonoBehaviour {

		private int sizeX;
		private int sizeY;

		private GameObject rootObject;
		private Transform root;
		public Mesh mesh;
		public Material material;

		private Tile[] tiles;

		public void Setup(int sizeX, int sizeY) {
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			InitializeData();
		}

		private void InitializeData() {
			tiles = new Tile[sizeX * sizeY];
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
		}

		private void GenerateMap() {
			int tileIndex = 0;
			for(int x = 0; x < sizeX; x++) {
				for(int y = 0; y < sizeY; y++) {
					tiles[tileIndex] = new Tile(x, y);
					tileIndex++;
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
