using UnityEngine;
using System.Collections;

namespace ecorealms.camera {
	public class CameraMovement : MonoBehaviour {

		private Vector3 startPosition = new Vector3(0.0f, 10.0f, -5.0f);
		private Transform cameraTransform;
		private Quaternion startRotation;

		void Start () {
			cameraTransform = Camera.main.transform;
			cameraTransform.position = startPosition;
		}

		void LateUpdate() {

		}
	}
}
