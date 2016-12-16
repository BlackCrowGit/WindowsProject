using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Brick : MonoBehaviour {

    private Transform m_Transform;

	void Start () {
        m_Transform = gameObject.GetComponent<Transform>();
	}
	
	void Update () {
        if (m_Transform.position.y < -15)
        {
            GameObject.Destroy(gameObject);
        }
	}
}
