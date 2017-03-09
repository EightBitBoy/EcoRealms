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
			rootObject.AddComponent<MeshFilter>().mesh = mesh;
			rootObject.AddComponent<MeshRenderer>().material = material;
			root = rootObject.transform;
			
			StartCoroutine(DelayedFunction()); //TODO do something awesome
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
		private Vector3[] vertices;

		public Tile(int x, int y) {
			vertices = new Vector3[4];

			vertices[0] = new Vector3((float)(x + 0), 0.0f, (float)(y + 0)); 
			vertices[1] = new Vector3((float)(x + 0), 0.0f, (float)(y + 1)); 
			vertices[2] = new Vector3((float)(x + 1), 0.0f, (float)(y + 1)); 
			vertices[3] = new Vector3((float)(x + 1), 0.0f, (float)(y + 0)); 
		}
	}
}
