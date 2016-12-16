using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour {
    
	void Start () {
        GameObject.Destroy(gameObject,2);
	}

}
