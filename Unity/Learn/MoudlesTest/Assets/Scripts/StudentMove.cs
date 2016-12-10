using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class StudentMove : MonoBehaviour {

    private Transform m_Transform;

	// 1次,init
	void Start () {
        m_Transform = gameObject.GetComponent<Transform>();
	}
	
	// Update is called once per frame
	void Update () {

        if (Input.GetKey(KeyCode.W)) {
            m_Transform.Translate(Vector3.forward * 0.1f, Space.Self);
        }

        if (Input.GetKey(KeyCode.S))
        {
            m_Transform.Translate(Vector3.back * 0.1f, Space.Self);
        }

        if (Input.GetKey(KeyCode.A))
        {
            m_Transform.Translate(Vector3.left * 0.1f, Space.Self);
        }

        if (Input.GetKey(KeyCode.D))
        {
            m_Transform.Translate(Vector3.right * 0.1f, Space.Self);
        }
        /*Transform.Translate()方法移动物体的位置,特点如下:
         * 1.移动的物体会"穿透"场景中的其他物体模型;
         * 2.移动的物体不会受重力影响(到达场景边缘外,不会下落)
         */
    }
}