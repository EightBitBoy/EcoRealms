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

			tiles = new Tile[sizeX * sizeY];

			rootObject = new GameObject("MapRoot");
			rootObject.AddComponent<MeshFilter>().mesh = mesh;
			rootObject.AddComponent<MeshRenderer>().material = material;

			root = rootObject.transform;

			StartCoroutine(DelayedFunction());
		}

		private IEnumerator DelayedFunction () {
			//TDOD do something
			yield return new WaitForSeconds(0.5f);
		}

		private void CreateQuad(){
			//Vector3.one;
		}
	}

	public class Tile {

	}
}
