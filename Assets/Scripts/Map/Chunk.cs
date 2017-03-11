using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class Chunk : MonoBehaviour{

		private int tilesX = 64;
		private int tilesY = 64;

		public void Setup(){
			gameObject.AddComponent<MeshFilter>();
		}
	}
}
