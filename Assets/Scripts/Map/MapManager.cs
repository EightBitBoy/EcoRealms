using UnityEngine;
using System.Collections.Generic;

namespace ecorealms.map {
	public class MapManager : MonoBehaviour {

		public GameObject groundTile;
		public GameObject seaTile;

		private Transform mapHolder;
		private List<Vector3> positions = new List<Vector3>();

		void GenerateMap (int sizeX, int sizeY) {
			for(int x = 0; x < sizeX; x++){
				for(int y = 0; y < sizeY; y++){
					positions.Add(new Vector3(x, 0, y));
				}
			}

			mapHolder = new GameObject("Map").transform;
			for(int x = 0; x < sizeX; x++){
				for(int y = 0; y < sizeY; y++){
					GameObject instance = Instantiate(groundTile, new Vector3(x, 0, y), Quaternion.identity) as GameObject;
					instance.transform.SetParent(mapHolder);
				}
			}
		}
		
		public void Setup (int sizeX, int sizeY) {
			GenerateMap(sizeX, sizeY);
		}
	}
}
