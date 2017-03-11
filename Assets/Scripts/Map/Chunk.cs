using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class Chunk : MonoBehaviour{

		private int tilesX;
		private int tilesY;
		private Mesh mesh;

		public void Setup(int tilesX, int tilesY, Material material){
			this.tilesX = tilesX;
			this.tilesY = tilesY;

			mesh = gameObject.AddComponent<MeshFilter>().mesh;
			mesh.Clear();

			gameObject.AddComponent<MeshRenderer>().material = material;

			CreateTiles();
			CreateMesh();
		}

		private void CreateTiles(){

		}

		private void CreateMesh(){

		}
	}
}
