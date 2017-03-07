using UnityEngine;
using System.Collections;

namespace ecorealms.camera {
	public class CameraMovement : MonoBehaviour {

		private Transform cameraTransform;
		private Vector3 startPosition = new Vector3(0.0f, 10.0f, -5.0f);
		private Quaternion startRotation = Quaternion.Euler(45.0f, 45.0f, 0.0f);

		void Start () {
			cameraTransform = Camera.main.transform;
			cameraTransform.position = startPosition;
			cameraTransform.rotation = startRotation;
		}

		void LateUpdate() {

		}
	}
}
