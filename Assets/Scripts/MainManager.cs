using UnityEngine;
using System.Collections;
using ecorealms.map;

namespace ecorealms {
	[RequireComponent(typeof(MapManager))]
	[RequireComponent(typeof(MapPresenter))]
	[RequireComponent(typeof(TerrainManager))]
	public class MainManager : MonoBehaviour {

		public static MainManager instance = null;
		public MapManager mapManager;
		public MapPresenter mapPresenter;
		public TerrainManager terrainManager;
		public int worldSizeX = 64;
		public int worldSizeY = 64;
		
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
			Map map = new Map(worldSizeX, worldSizeY);

			//gameObject.AddComponent<MeshFilter>().mesh = mesh;

			mapManager = GetComponent<MapManager>();
			mapPresenter = GetComponent<MapPresenter>();
			terrainManager = GetComponent<TerrainManager>();

			//mapManager.Setup(worldSizeX, worldSizeY); //disable "old" cube terrain
			mapPresenter.Setup(worldSizeX, worldSizeY);
			terrainManager.Setup();
		}

		void Start() {
		}

		void Update() {
		
		}
	}
}
