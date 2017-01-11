using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour {

    public float speed = 10f;
    private void FixedUpdate()
    {
        float h = Input.GetAxis("Horizontai");
        float v = Input.GetAxis("Vertical");

        Vector3 move = new Vector3(h, 0f, v);
    }

}
