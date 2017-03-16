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

		private GameObject mapRoot;
		public Material material;

		public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
			this.chunksX = chunksX;
			this.chunksY = chunksY;
			this.tilesX = tilesX;
			this.tilesY = tilesY;

			this.numChunks = this.chunksX * this.chunksY;

			Debug.Log("World size in chunks: " + this.chunksX + "*" + this.chunksY);

			Initialize();
		}

		private void Initialize() {
			mapRoot = new GameObject("MapRoot");
			mapRoot.AddComponent<MeshRenderer>().material = material;

			GameObject gridRoot = new GameObject("GridRoot");
			gridRoot.transform.SetParent(mapRoot.transform);
			gridRoot.AddComponent<GridRenderer>().Setup(chunksX, chunksY, tilesX, tilesY);

			GameObject highlighterRoot = new GameObject("HighlighterRoot");
			highlighterRoot.transform.SetParent(mapRoot.transform);
			highlighterRoot.AddComponent<MapHighlightManager>().Setup();

			CreateChunks();
		}

		private void CreateChunks(){
			int chunkIndex = 0;
			for(int x = 0; x < chunksX; x++){
				for(int y = 0; y < chunksY; y++){
					GameObject chunkRoot = new GameObject("Chunk" + chunkIndex);
					chunkRoot.transform.SetParent(mapRoot.transform);
					Chunk chunk = chunkRoot.AddComponent<Chunk>() as Chunk;
					chunk.Setup(tilesX, tilesY, material, new Vector3(tilesX * x, 0, tilesY * y));
					chunkIndex++;
				}
			}
		}
	}
}
