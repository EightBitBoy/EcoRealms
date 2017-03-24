using UnityEngine;
using System.Collections;
using ecorealms.world;

namespace ecorealms {

	[RequireComponent(typeof(WorldManager))]
	public class MainManager : MonoBehaviour {

		private static MainManager instance = null;
		private WorldManager mapManager;
		public int chunksX = 2;
		public int chunksY = 2;
		public int tilesX = 64;
		public int tilesY = 64;
		
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
			mapManager = GetComponent<WorldManager>();
			mapManager.Setup(chunksX, chunksY, tilesX, tilesY);
		}

		void Start() {
		}

		void Update() {
		}
	}
}
