package com.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** 
* @author ׯ��: 
* @version ����ʱ�䣺2016��11��22�� ����12:54:39  
*/
@SuppressWarnings("serial")
public class Calculator extends JFrame{
	
	private final JTextField textField;
	private String num = "0";
	private String operator = "+";
	private String result = "0";
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);										//���ô���ɼ�
	}//MainEnd
	
	public Calculator() {
		super();
		setTitle("������");
		setResizable(false);										//���ô����С���ɸı�
		setBounds(100, 100, 210, 244);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel viewPanel = new JPanel();						//������ʾ�����,����Ĭ��������
		getContentPane().add(viewPanel, BorderLayout.NORTH);		//��ӵ����嶥��
		textField = new JTextField();								//����"��ʾ��"
		textField.setText(num);										//����"��ʾ��"��Ĭ���ı�
		textField.setColumns(18);									//����"��ʾ��"�Ŀ��
		textField.setEditable(false);								//����"��ʾ��"���ɱ༭
		textField.setHorizontalAlignment(SwingConstants.RIGHT);		//���Ҷ���
		viewPanel.add(textField);									//��"��ʾ��"��ӵ�"��ʾ��"�����
		getContentPane().add(viewPanel, BorderLayout.NORTH);		//��ӵ����嶥��
		
		final JPanel clearButtonPanel = new JPanel();					//���������ť���,Ĭ�ϲ���������
		getContentPane().add(clearButtonPanel, BorderLayout.CENTER);	
		String[] clearButtonNames = {"<�D","CE","C"};
		for (int i = 0;i < clearButtonNames.length;i++) {
			final JButton button = new JButton(clearButtonNames[i]);	//���������ť
			button.addActionListener(new ClearButtonActionListener());	//��Ӽ�����
			clearButtonPanel.add(button);								//�������ť��ӵ������ť�����
		}

		final JPanel inputButtonPanel = new JPanel();				//�������밴ť���
		final GridLayout gridLayout = new GridLayout(4, 0);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		inputButtonPanel.setLayout(gridLayout);						//���밴ť���������񲼾�
		getContentPane().add(inputButtonPanel, BorderLayout.SOUTH);
		String[][] inputButtonNames = {{"1","2","3","+"},
									   {"4","5","6","-"},
									   {"7","8","9","*"},
									   {".","0","=","/"}};			//�������밴ť����
		for (int row = 0;row < inputButtonNames.length;row++) {
			for (int col = 0;col < inputButtonNames.length;col++) {
				final JButton button = new JButton(inputButtonNames[row][col]);
				button.setName(row + "" +col);						//���밴ť�������������ڵ��к��е��������
				button.addActionListener(new InputButtonActionListener());
				inputButtonPanel.add(button);						//����ť��ӵ���ť�����
			}
		}
		
	}
	
	class InputButtonActionListener implements ActionListener {		//���밴ťʱ�������
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();				//��ô����˴��¼��İ�ť����
			String name = button.getName();							//��ð�ť������
			int row = Integer.valueOf(name.substring(0, 1));		//���������ڵ���
			int col = Integer.valueOf(name.substring(1, 2));		//���������ڵ���
			if (col == 3) {											//�˴������Ϊ�����
				count();											//������
				textField.setText(result);							//�޸�"��ʾ��"�ı�
				operator = button.getText();						//�������������
			} else if (row == 3) {									//�˴������Ϊ"." "0"��"="
				if (col == 0) {										//�˴������Ϊ"."
					if (num.indexOf(".") < 0) {						//�鿴�Ƿ��Ѿ�������С����
						num = num + button.getText();
						textField.setText(num);
					}
				} else if (col == 1) {								//�˴������Ϊ"0"
					if (num.indexOf(".") > 0) {						//�鿴�Ƿ�ΪС��
						num = num + button.getText();
						textField.setText(num);
					} else {
						if (!num.substring(0, 1).equals("0")) {		//�鿴��һλ�Ƿ�Ϊ0 
							num = num + button.getText();
							textField.setText(num);
						}
					}
				} else {											//�˴������Ϊ"0"
					count();										//������
					textField.setText(result);						//�޸�"��ʾ��"�ı�
					operator = "+";									//�������������
				}
			} else {												//�˴������Ϊ����
				if (num.equals("0"))
					num = button.getText();
				else 
					num = num + button.getText();
				textField.setText(num);
			}
		}

		private void count() {										//������
			float n = Float.valueOf(num);
			float r = Float.valueOf(result);
			if (r == 0) {
				result = num;
				num = "0";
			} else {
				if (operator.equals("+")) {
					r = r + n;
				} else if (operator.equals("-")) {
					r = r - n;
				} else if (operator.equals("*")) {
					r = r * n;
				} else {
					r = r / n;
				}
				num = "0";
				result = r + "";
			}
		}
	}

	class ClearButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String text = button.getText().trim();
			if (text.equals("<�D")) {
				int length = num.length();
				if (length == 1)
					num = "0";
				else 
					num = num.substring(0, length - 1);
			} else if (text.equals("CE")) {
				num = "0";
			} else {
				num = "0";
				operator = "+";
				result = "0";
			}
			textField.setText(num);;
		}
	}
}//ClassEnd
