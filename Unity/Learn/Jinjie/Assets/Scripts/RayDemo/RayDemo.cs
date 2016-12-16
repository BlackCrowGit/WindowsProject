using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RayDemo : MonoBehaviour {

    private int x = 10;
    private int y = 5;
    private Ray ray;
    private RaycastHit hit;

    public GameObject prefabBrick;
    public GameObject prefabBullet;

    private Transform m_Transform;

	void Start () {
        m_Transform = gameObject.GetComponent<Transform>();
        CreateWall();
	}
	
	void Update () {
        SendBullet();
	}

    /// <summary>
    /// for循环生成墙壁
    /// </summary>
    void CreateWall() {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                GameObject go = GameObject.Instantiate(prefabBrick, new Vector3(i - 4.5f, j, 0), Quaternion.identity) as GameObject;
                go.GetComponent<MeshRenderer>().material.color = new Color(Random.Range(0.0f, 1.0f), Random.Range(0.0f, 1.0f), Random.Range(0.0f, 1.0f));
            }
        }
    }

    /// <summary>
    /// 发射子弹.
    /// </summary>
     void SendBullet()
    {
        if (Input.GetMouseButtonDown(0))
        {
            ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if (Physics.Raycast(ray, out hit))
            {
                //实例化子弹.
                GameObject go = GameObject.Instantiate(prefabBullet, m_Transform.position, Quaternion.identity) as GameObject;
                //计算方向.
                Vector3 dir = hit.point - m_Transform.position;
                //Debug绘制射线.Debug仅能在Scene窗口看到.
                Debug.DrawRay(m_Transform.position, dir, Color.red);
                //发射子弹.
                go.GetComponent<Rigidbody>().AddForce(dir * 150);
            }
        }
    }
}
