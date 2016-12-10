using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Door : MonoBehaviour {

    private Transform m_Transform;

	// Use this for initialization
	void Start () {
        m_Transform = gameObject.GetComponent<Transform>();
	}
	
	// Update is called once per frame
	    
    public void OpenDoor() {
        m_Transform.Rotate(Vector3.up, 90);
    }

    public void CloseDoor()
    {
        m_Transform.Rotate(Vector3.up, -90);
    }
}
