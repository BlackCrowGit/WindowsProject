using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RayTest : MonoBehaviour {

    private Ray ray;        //射线
    private RaycastHit hit; //射线检查

	void Start () {
		
	}
	
	void Update () {
        CameraSendRay();
	}

    /// <summary>
    /// 主摄像机发射射线
    /// </summary>
    void CameraSendRay() {
        //按下鼠标左键发射射线.
        if (Input.GetMouseButtonDown(0))
        {
            //使用主摄像机创建一根射线,方向是我们鼠标点击的位置.
            ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            //使用物理类检测射线的碰撞.
            if (Physics.Raycast(ray, out hit))
            {
                //将碰撞到的物体销毁点.
                GameObject.Destroy(hit.collider.gameObject);
            }
        }
    }
}
