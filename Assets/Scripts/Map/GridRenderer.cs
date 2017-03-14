using UnityEngine;
using System.Collections;

namespace ecorealms.map {

	public class GridRenderer : MonoBehaviour {

		private const float WIDTH = 0.05f;
		private const float HEIGHT = 0.05f;

		private int linesX;
		private int linesY;

		private Material material;

		public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
			this.linesX = chunksX * tilesX;
			this.linesY = chunksY * tilesY;

			Initialize();
		}

		private void Initialize() {
			material = new Material((Shader.Find(" Diffuse")));
			material.SetColor(0, Color.black);

			for(int x = 0; x < linesX; x++){
				AddLine("Line" + x, x, 0, x, linesY);
			}
			for(int y = 0; y < linesY; y++){
				AddLine("Line" + y, 0, y, linesX, y);
			}
		}

		private void AddLine(string name, float startX, float startY, float endX, float endY){
			Vector3 start = new Vector3(startX, HEIGHT, startY);
			Vector3 end = new Vector3(endX, HEIGHT, endY);
			GameObject line = new GameObject(name);
			LineRenderer renderer = line.AddComponent<LineRenderer>();

			line.transform.SetParent(gameObject.transform);
			renderer.material = material;
			renderer.SetWidth(WIDTH, WIDTH);
			renderer.SetPosition(0, start);
			renderer.SetPosition(1, end);
		}
	}
}
