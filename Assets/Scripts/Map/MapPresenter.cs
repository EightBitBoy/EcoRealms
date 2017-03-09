using UnityEngine;
using System.Collections;

namespace ecorealms.map {
	public class MapPresenter : MonoBehaviour {

		private int sizeX;
		private int sizeY;

		private Transform root;

		public void Setup(int sizeX, int sizeY) {
			this.sizeX = sizeX;
			this.sizeY = sizeY;

			root = new GameObject("MapRoot").transform;
		}
	}
}
