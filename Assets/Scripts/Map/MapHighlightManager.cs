using UnityEngine;
using System.Collections;

namespace ecorealms.map {

	public class MapHighlightManager : MonoBehaviour {
		private int sizeX;
		private int sizeY;
		private float HEIGHT = 0.2f;
		private Mesh mesh;
		private float mouseX = 0.0f;
		private float mouseY = 0.0f;

		public void Setup(int chunksX, int chunksY, int tilesX, int tilesY) {
			this.sizeX = chunksX * tilesX;
			this.sizeY = chunksY * tilesY;

			mesh = gameObject.AddComponent<MeshFilter>().mesh;
			gameObject.AddComponent<MeshRenderer>();
			gameObject.layer = LayerMask.NameToLayer("IgnoreCamera");
			
			AddOverlayQuad();
		}

		void AddOverlayQuad() {
			Vector3[] vertices = new Vector3[4];
			Vector3[] normals = new Vector3[4];
			int[] triangles = new int[6];

			vertices[0] = new Vector3(0, HEIGHT, 0); 
			vertices[1] = new Vector3(0, HEIGHT, sizeY); 
			vertices[2] = new Vector3(sizeX, HEIGHT, sizeY); 
			vertices[3] = new Vector3(sizeX, HEIGHT, 0);

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

			mesh.Clear();
			mesh.vertices = vertices;
			mesh.normals = normals;
			mesh.triangles = triangles;
		}

		void LateUpdate(){
			if(Input.GetMouseButtonDown(0)){
				Vector3 mousePosition = Input.mousePosition;
				Vector3 mousePositionGame;
				Debug.Log("MousePos: " + mousePosition);

				Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);

				Plane plane = new Plane(Vector3.up, new Vector3(0, HEIGHT, 0));
				float distance;
				if(plane.Raycast(ray, out distance)){
					mousePositionGame = ray.GetPoint(distance);
					Debug.Log("Tile: " + Mathf.FloorToInt(mousePositionGame.x) + " " + Mathf.FloorToInt(mousePositionGame.z));
				}
			}
		}
	}
}
