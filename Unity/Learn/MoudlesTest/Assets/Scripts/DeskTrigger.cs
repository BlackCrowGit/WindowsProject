using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DeskTrigger : MonoBehaviour {

    private GameObject[] m_Desk;

    void Start()
    {
        m_Desk = GameObject.FindGameObjectsWithTag("Desks");
    }

    public void DesksUp()
    {
        for (int i = 0; i < m_Desk.Length; i++)
        {
            m_Desk[i].GetComponent<Transform>().Translate(Vector3.up * 2, Space.Self);
        }
    }

    void DesksDown()
    {
        for (int i = 0; i < m_Desk.Length; i++)
        {
            m_Desk[i].GetComponent<Transform>().Translate(Vector3.up * -2, Space.Self);
        }
    }

    void OnTriggerEnter(Collider coll)
    {
        if (coll.gameObject.name == "Student")
        {
            DesksUp();
        }
    }

    void OnTriggerExit(Collider coll)
    {
        if (coll.gameObject.name == "Student")
        {
            DesksDown();
        }
    }

}
