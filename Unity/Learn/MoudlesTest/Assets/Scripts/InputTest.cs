using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class InputTest : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        //Key
        if (Input.GetKey(KeyCode.A)) {
            Debug.Log("GetKey:A...");
        }

        if (Input.GetKeyDown(KeyCode.A)) {
            Debug.Log("GetKeyDownL:A Down");
        }

        if (Input.GetKeyUp(KeyCode.A)) {
            Debug.Log("GetKeyUp:A Up");
        }

        //Mouse
        if (Input.GetMouseButton(0)) {
            Debug.Log("Mouse Left");
        }

        if (Input.GetMouseButtonDown(0)) {
            Debug.Log("Mouse Left Down");
        }

        if (Input.GetMouseButtonUp(0))
        {
            Debug.Log("Mouse Left Up");
        }
    }
}
