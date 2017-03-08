using UnityEngine;
using System.Collections;
using ecorealms.map;

namespace ecorealms {
	public class MainManager : MonoBehaviour {

		public MapManager mapManager;

		public int worldSizeX = 64;
		public int worldSizeY = 64;
		
		void Awake() {
			Map map = new Map(); //TODO Does nothing yet!

			mapManager = GetComponent<MapManager>();
			mapManager.Setup(worldSizeX, worldSizeY);
		}

		void Start () {
		}

		void Update() {
		
		}
	}
}
