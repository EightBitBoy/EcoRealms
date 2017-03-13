using UnityEngine;
using System.Collections;

namespace ecorealms.map {

	public class GridRenderer : MonoBehaviour {

		private int linesX;
		private int linesY;

		public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
			this.linesX = chunksX * tilesX;
			this.linesY = chunksY * tilesY;

			Initialize();
		}

		private void Initialize() {
			for(int x = 0; x < linesX; x++){
				GameObject line = new GameObject("LineX" + x);
				line.transform.SetParent(gameObject.transform);

				LineRenderer renderer = line.AddComponent<LineRenderer>();
				renderer.SetWidth(0.2f, 0.2f);
				Vector3 start = new Vector3(0, 1, 0);
				Vector3 end = new Vector3(0, 1, 8);
				renderer.SetPosition(0, start);
				renderer.SetPosition(1, end);
			}
			for(int y = 0; y < linesY; y++){

			}
		}
	}
}
