using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RgidibodyMove : MonoBehaviour {

    private Rigidbody m_Rigidboby;
    private Transform m_Transform;

    // Use this for initialization
    void Start () {
        m_Rigidboby = gameObject.GetComponent<Rigidbody>();
        m_Transform = gameObject.GetComponent<Transform>();
    }
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKey(KeyCode.W)) {
            m_Rigidboby.MovePosition(m_Transform.position + Vector3.forward * 0.2f);
        }

        if (Input.GetKey(KeyCode.S)) {
            m_Rigidboby.MovePosition(m_Transform.position + Vector3.back * 0.2f);
        }

        if (Input.GetKey(KeyCode.A)) {
            m_Rigidboby.MovePosition(m_Transform.position + Vector3.left * 0.2f);
        }

        if (Input.GetKey(KeyCode.D)) {
            m_Rigidboby.MovePosition(m_Transform.position + Vector3.right * 0.2f);
        }
    }

}