using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CreateBoxs : MonoBehaviour {

    public GameObject goPrefab;

	void Start () {
        //Invoke("CreateMoreBox",5.0f);
        InvokeRepeating("CreateMoreBox", 5.0f, 3.0f);
	}
	
	void Update () {
        if (Input.GetKeyDown(KeyCode.Space)) {
            CreateMoreBox();
        }

        if (Input.GetKeyDown(KeyCode.Z)) {
            CancelInvoke();
        }
	}

    void CreateMoreBox() {
        for (int i = 0; i < 5; i++) {
            Vector3 postion = new Vector3(Random.Range(-9.0f, 9.0f), 10, Random.Range(-9.0f, 9.0f));
            GameObject.Instantiate(goPrefab, postion, Quaternion.identity);
        }
    }

}
