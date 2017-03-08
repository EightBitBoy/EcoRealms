using UnityEngine;
using System.Collections;

namespace ecorealms.camera {
	public class CameraMovement : MonoBehaviour {

		public float moveSensitivity = 0.5f;
		public float scrollSensitivity = 5.0f;

		private Transform cameraTransform;
		private Vector3 startPosition = new Vector3(0.0f, 10.0f, -5.0f);
		private Quaternion startRotation = Quaternion.Euler(45.0f, 45.0f, 0.0f);

		void Start () {
			cameraTransform = Camera.main.transform;
			cameraTransform.position = startPosition;
			cameraTransform.rotation = startRotation;
		}

		void LateUpdate() {
			if (Input.GetKey(KeyCode.W)){
				cameraTransform.position += new Vector3(moveSensitivity, 0.0f, moveSensitivity);
			}
			if (Input.GetKey(KeyCode.S)){
				cameraTransform.position += new Vector3(-moveSensitivity, 0.0f, -moveSensitivity);
			}
			if (Input.GetKey(KeyCode.A)){
				cameraTransform.position += new Vector3(-moveSensitivity, 0.0f, moveSensitivity);
			}
			if (Input.GetKey(KeyCode.D)){
				cameraTransform.position += new Vector3(moveSensitivity, 0.0f, -moveSensitivity);
			}
			if (Input.GetAxis("Mouse ScrollWheel") > 0f ){
				cameraTransform.position += new Vector3(0.0f, -scrollSensitivity, 0.0f);
			}
			if (Input.GetAxis("Mouse ScrollWheel") < 0f ){
				cameraTransform.position += new Vector3(0.0f, scrollSensitivity, 0.0f);
			}
		}
	}
}
