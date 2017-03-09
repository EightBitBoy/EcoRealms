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

		public void Setup(int sizeX, int sizeY) {
			this.sizeX = sizeX;
			this.sizeY = sizeY;

			rootObject = new GameObject("MapRoot");
			root = rootObject.transform;
			rootObject.AddComponent<MeshFilter>().mesh = mesh;
			rootObject.AddComponent<MeshRenderer>().material = material;
		}
	}
}
