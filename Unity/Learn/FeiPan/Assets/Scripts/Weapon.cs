using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Weapon : MonoBehaviour {

    private Ray ray;
    private RaycastHit hit;

    private Transform m_Transform;
    private Transform m_Point;              //枪口位置.
    private LineRenderer m_LineRenderer;    //线渲染器组件.

    private AudioSource m_AudioSource;      //声音源.射击声音.

	void Start () {
        m_Transform = gameObject.GetComponent <Transform>();
        m_Point = m_Transform.FindChild("Point");
        m_LineRenderer = m_Point.gameObject.GetComponent<LineRenderer>();
        m_AudioSource = gameObject.GetComponent<AudioSource>();
	}
	
	void Update () {
        
        ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        if (Physics.Raycast(ray,out hit))
        {
            //控制手臂朝向碰撞点
            m_Transform.LookAt(hit.point);
            //绘制测试线.
            Debug.DrawLine(m_Point.position, hit.point, Color.red);
            //设置LineRenderer位置
            m_LineRenderer.SetPosition(0, m_Point.position);
            m_LineRenderer.SetPosition(1, hit.point);

            //飞盘射击.
            if (hit.collider.tag == "FeiPan" && Input.GetMouseButtonDown(0))
            {
                //播放射击音效.
                m_AudioSource.Play();
                //通过碰撞到的子物体查找到该子物体的父物体.
                Transform parent =  hit.collider.gameObject.GetComponent<Transform>().parent;
                //通过父物体查找到所有子物体的Transform组件.
                Transform[] feiPans = parent.GetComponentsInChildren<Transform>();
                for (int i = 0; i < feiPans.Length; i++)
                {
                    //给子物体添加刚体组件.
                    feiPans[i].gameObject.AddComponent<Rigidbody>();
                }
                //2秒后父物体自动销毁.
                GameObject.Destroy(parent.gameObject, 2.0f);
            }
        }
	}
}
