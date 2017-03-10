using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class Chunk {

		private int tilesX = 64;
		private int tilesY = 64;

		private GameObject rootObject;

		public Chunk(GameObject rootObject){
			this.rootObject = rootObject;
		}
	}
}
