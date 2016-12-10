using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CollisionCube : MonoBehaviour {

    void OnCollisionEnter(Collision coll)
    {
        if (coll.gameObject.name != "Ground")
            Debug.Log("Enter " + coll.gameObject.name);
    }

    void OnCollisionExit(Collision coll)
    {
        if (coll.gameObject.name != "Ground")
            Debug.Log("Exit " + coll.gameObject.name);
    }

 //   void OnCollisionStay(Collision coll)
  //  {
  ///          Debug.Log("Stay " + coll.gameObject.name);
  //  }

}
