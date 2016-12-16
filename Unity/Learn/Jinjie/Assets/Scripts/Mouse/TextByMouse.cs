using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TextByMouse : MonoBehaviour {

    private GUIText m_GUIText;

    void Start()
    {
        m_GUIText = gameObject.GetComponent<GUIText>();
    }

    private void OnMouseEnter()
    {
        m_GUIText.color = Color.red;
    }

    private void OnMouseExit()
    {
        m_GUIText.color = Color.blue;
    }

    private void OnMouseDown()
    {
        m_GUIText.color = Color.green;
    }

}
