package com.myeclipse;

import java.awt.event.*;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年12月4日 上午1:08:19  
*/
public class Test {
	public static void main(String[] args) {
		FileWindow win = new FileWindow();
		win.pack();
		win.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		win.setBounds(200, 180, 550, 360);
		win.setVisible(true);
	}
}
