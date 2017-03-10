using UnityEngine;
using System.Collections;
using ecorealms.map;

namespace ecorealms {
	[RequireComponent(typeof(MapManager))]
	public class MainManager : MonoBehaviour {

		public static MainManager instance = null;
		public MapManager mapManager;
		public int chunksX = 64;
		public int chunksY = 64;
		
		void Awake() {

			if(instance == null){
				instance = this;
			} else if (instance != null){
				Destroy(gameObject);
			}
			DontDestroyOnLoad(gameObject);
			Initialize();
		}

		void Initialize() {
			mapManager = GetComponent<MapManager>();
			mapManager.Setup(chunksX, chunksY);
		}

		void Start() {
			//TODO
		}

		void Update() {
			//TODO
		}
	}
}
