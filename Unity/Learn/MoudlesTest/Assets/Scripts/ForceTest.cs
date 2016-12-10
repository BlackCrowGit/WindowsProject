using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ForceTest : MonoBehaviour {

    private Rigidbody m_Rigidbody;

	// Use this for initialization
	void Start () {
        m_Rigidbody = gameObject.GetComponent<Rigidbody>();
	}
	
	// Update is called once per frame
	void Update () {
        // m_Rigidbody.AddForce(Vector3.forward * 10, ForceMode.Force);
                
    }

    void FixedUpdate()
    {
        if (Input.GetKeyDown(KeyCode.Z))
        {
            m_Rigidbody.AddRelativeForce(Vector3.forward * 1000, ForceMode.Force);
        }
    }

}
