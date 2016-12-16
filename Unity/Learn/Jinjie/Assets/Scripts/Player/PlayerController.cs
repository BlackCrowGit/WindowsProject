using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour {

    private Rigidbody m_Rigidbody;
    private Transform m_Transform;

    public GameObject prefb_gold;

	void Start () {
        m_Rigidbody = gameObject.GetComponent<Rigidbody>();
        m_Transform = gameObject.GetComponent<Transform>();
	}
	
	void Update () {
        if (Input.GetKey(KeyCode.W)) {
            m_Rigidbody.MovePosition(m_Transform.position + Vector3.forward * 0.2f);
        }
        if (Input.GetKey(KeyCode.S))
        {
            m_Rigidbody.MovePosition(m_Transform.position + Vector3.back * 0.2f);
        }
        if (Input.GetKey(KeyCode.A))
        {
            m_Rigidbody.MovePosition(m_Transform.position + Vector3.left * 0.2f);
        }
        if (Input.GetKey(KeyCode.D))
        {
            m_Rigidbody.MovePosition(m_Transform.position + Vector3.right * 0.2f);
        }
    }

    private void OnCollisionEnter(Collision coll)
    {
        if (coll.gameObject.tag == "Box") {
            Vector3 position = coll.gameObject.transform.position;
            GameObject.Destroy(coll.gameObject);
            GameObject.Instantiate(prefb_gold, position + Vector3.forward, Quaternion.identity);
        }
    }

    private void OnTriggerEnter(Collider coll)
    {
        if (coll.gameObject.tag == "Gold") {
            //coll.gameObject.SendMessage("AddScore");
            coll.gameObject.GetComponent<Gold>().AddScore();
            GameObject.Destroy(coll.gameObject);
        }
    }

}
