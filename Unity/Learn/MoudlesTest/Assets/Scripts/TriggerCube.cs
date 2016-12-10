using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TriggerCube : MonoBehaviour {

    private void OnTriggerEnter(Collider coll)
    {
        Debug.Log("Student Enter" + coll.gameObject.name);
    }

    void OnTriggerExit(Collider coll)
    {
        Debug.Log("Student Exit:" + coll.gameObject.name);
    }

    void OnTriggerStay(Collider coll)
    {
        Debug.Log("Student Stay:" + coll.gameObject.name);
    }

}
