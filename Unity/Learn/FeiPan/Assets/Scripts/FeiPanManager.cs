using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FeiPanManager : MonoBehaviour {

    public GameObject prefab_FeiPan;

    private Transform m_Transform;
    
	void Start () {
        //每隔2秒生成一批飞盘.
        InvokeRepeating("CreateFeiPan", 2.0f, 2.0f);
        m_Transform = gameObject.GetComponent<Transform>();
	}
	
	void Update () {
		
	}

    /// <summary>
    /// 创建飞盘.
    /// </summary>
    void CreateFeiPan() {
        for (int i = 0; i < 3; i++)
        {
            //飞盘生成位置
            Vector3 pos = new Vector3(Random.Range(-6.0f, 5.0f), Random.Range(0.5f, 3.0f), Random.Range(5.0f, 9.0f));
            //实例化飞盘.
            GameObject go = GameObject.Instantiate(prefab_FeiPan, pos, Quaternion.identity);
            //生成的飞盘自动添加为FeiPanParent的子物体
            go.GetComponent<Transform>().SetParent(m_Transform);
        }
    }
}
