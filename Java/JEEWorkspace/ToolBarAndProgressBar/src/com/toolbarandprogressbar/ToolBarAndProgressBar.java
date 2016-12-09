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
* @author ׯ��: 
* @version ����ʱ�䣺2016��12��1�� ����4:04:20  
*/
@SuppressWarnings("serial")
public class ToolBarAndProgressBar extends JFrame{

	final JProgressBar progressBar = new JProgressBar();	//��ΪҪ��"����"���������������,���Դ�������������������Ϊȫ��
	
	public static void main(String[] args) {
		ToolBarAndProgressBar frame = new ToolBarAndProgressBar();
		frame.setVisible(true);
	}
	
	public ToolBarAndProgressBar() {
		super();
		setTitle("��������������");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//����������
		final JToolBar toolBar = new JToolBar("������");
		toolBar.setFloatable(false); 						//���ò����ƶ�
		getContentPane().add(toolBar, BorderLayout.NORTH);	//��ӵ��Ϸ�
		final JButton newButton = new JButton("�½�");		//����"�½�"��ť
		toolBar.add(newButton);
		toolBar.addSeparator();
		final JButton saveButton = new JButton("����");		//����"����"��ť
		saveButton.addActionListener(new SaveButtonActionListener());	//���"����"����������
		toolBar.add(saveButton);
		toolBar.addSeparator(new Dimension(20, 0));
		final JButton exitButton = new JButton("�˳�");		//����"�˳�"��ť
		exitButton.addActionListener(new ActionListener() {	//��Ӷ���������
			public void actionPerformed(ActionEvent e) {
				System.exit(0);								//����System���˳�
			}
		});
		toolBar.add(exitButton);
		
		//��ӽ�����
		final JPanel progressBarPanel = new JPanel();		//�������������
		final GridLayout gridLayout = new GridLayout(4, 4);	//�������񲼾�
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		progressBarPanel.setLayout(gridLayout);				//���ý��������Ĳ��ַ�ʽ
		getContentPane().add(progressBarPanel, BorderLayout.SOUTH);	//��ӵ��·�
		progressBar.setVisible(false);						//���ÿ�ʼ����ʾ
		progressBar.setValue(28);							//���ý���
		progressBar.setStringPainted(true);
		progressBarPanel.add(progressBar);					//�ѽ�����������ӵ����������
	}
	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			progressBar.setVisible(true);					//�����������ֵ��"����"����ʱ,���ý�����Ϊ�ɼ�
		}
	}
	
}
