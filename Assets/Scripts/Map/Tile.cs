using UnityEngine;

namespace ecorealms.map {
	public class Tile {
		public Vector3[] vertices = new Vector3[4];
		public Vector3[] normals = new Vector3[4];
		public int[] triangles = new int[6];

		public Tile(int x, int y, Vector3 offset) {
			vertices[0] = new Vector3((float)(x + 0), 0.0f, (float)(y + 0)) + offset; 
			vertices[1] = new Vector3((float)(x + 0), 0.0f, (float)(y + 1)) + offset; 
			vertices[2] = new Vector3((float)(x + 1), 0.0f, (float)(y + 1)) + offset; 
			vertices[3] = new Vector3((float)(x + 1), 0.0f, (float)(y + 0)) + offset;

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
		}
	}
}
