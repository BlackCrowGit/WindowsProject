using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TextureByMouse : MonoBehaviour {

    private GUITexture m_GUITexture;

	void Start () {
        m_GUITexture = gameObject.GetComponent<GUITexture>();
	}

    private void OnMouseEnter()
    {
        m_GUITexture.color = Color.red;
    }

    private void OnMouseExit()
    {
        m_GUITexture.color = Color.green;
    }

    private void OnMouseDown()
    {
        m_GUITexture.color = Color.blue;
    }

}
