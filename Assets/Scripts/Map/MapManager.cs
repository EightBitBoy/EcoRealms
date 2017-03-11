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
		public Material material;

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
			root = rootObject.transform;

			CreateChunks();
			
			StartCoroutine(DelayedFunction()); //TODO do something awesome
		}

		private void CreateChunks(){
			int chunkIndex = 0;
			for(int x = 0; x < chunksX; x++){
				for(int y = 0; y < chunksY; y++){
					GameObject chunkRoot = new GameObject("Chunk" + chunkIndex);
					chunkRoot.transform.SetParent(rootObject.transform);
					Chunk chunk = chunkRoot.AddComponent<Chunk>() as Chunk;
					chunk.Setup(tilesX, tilesY, material, new Vector3(tilesX * x, 0, tilesY * y));
					chunkIndex++;
				}
			}
		}

		private IEnumerator DelayedFunction() {
			yield return new WaitForSeconds(0.5f);
		}
	}
}
