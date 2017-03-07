using UnityEngine;
using System.Collections;
using ecorealms.map;

namespace ecorealms{
	public class MainManager : MonoBehaviour {

		[Range(64,512)]
		public int worldSizeX = 64;
		[Range(64,512)]
		public int worldSizeY = 64;
		void Start () {
			Debug.Log("MainManager Start!");
			Map map = new Map();
		}
		
		void Update () {
		
		}
	}
}
