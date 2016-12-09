package com.toolbarandprogressbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年12月1日 下午4:04:20  
*/
@SuppressWarnings("serial")
public class ToolBarAndProgressBar extends JFrame{

	final JProgressBar progressBar = new JProgressBar();	//因为要在"保存"动作监视器里调用,所以创建进度条对象作用域为全局
	
	public static void main(String[] args) {
		ToolBarAndProgressBar frame = new ToolBarAndProgressBar();
		frame.setVisible(true);
	}
	
	public ToolBarAndProgressBar() {
		super();
		setTitle("工具栏及进度条");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//创建工具栏
		final JToolBar toolBar = new JToolBar("工具栏");
		toolBar.setFloatable(false); 						//设置不可移动
		getContentPane().add(toolBar, BorderLayout.NORTH);	//添加到上方
		final JButton newButton = new JButton("新建");		//创建"新建"按钮
		toolBar.add(newButton);
		toolBar.addSeparator();
		final JButton saveButton = new JButton("保存");		//创建"保存"按钮
		saveButton.addActionListener(new SaveButtonActionListener());	//添加"保存"动作监视器
		toolBar.add(saveButton);
		toolBar.addSeparator(new Dimension(20, 0));
		final JButton exitButton = new JButton("退出");		//创建"退出"按钮
		exitButton.addActionListener(new ActionListener() {	//添加动作监视器
			public void actionPerformed(ActionEvent e) {
				System.exit(0);								//利用System的退出
			}
		});
		toolBar.add(exitButton);
		
		//添加进度条
		final JPanel progressBarPanel = new JPanel();		//创建进度条面板
		final GridLayout gridLayout = new GridLayout(4, 4);	//创建网格布局
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		progressBarPanel.setLayout(gridLayout);				//设置进度条面板的布局方式
		getContentPane().add(progressBarPanel, BorderLayout.SOUTH);	//添加到下方
		progressBar.setVisible(false);						//设置开始不显示
		progressBar.setValue(28);							//设置进度
		progressBar.setStringPainted(true);
		progressBarPanel.add(progressBar);					//把进度条对象添加到进度条面板
	}
	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			progressBar.setVisible(true);					//当监视器发现点击"保存"动作时,设置进度条为可见
		}
	}
	
}
