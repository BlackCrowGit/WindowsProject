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
* @author 庄贵东: 
* @version 创建时间：2016年11月22日 下午12:54:39  
*/
@SuppressWarnings("serial")
public class Calculator extends JFrame{
	
	private final JTextField textField;
	private String num = "0";
	private String operator = "+";
	private String result = "0";
	
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);										//设置窗体可见
	}//MainEnd
	
	public Calculator() {
		super();
		setTitle("计算器");
		setResizable(false);										//设置窗体大小不可改变
		setBounds(100, 100, 210, 244);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel viewPanel = new JPanel();						//创建显示器面板,采用默认流布局
		getContentPane().add(viewPanel, BorderLayout.NORTH);		//添加到窗体顶部
		textField = new JTextField();								//创建"显示器"
		textField.setText(num);										//设置"显示器"的默认文本
		textField.setColumns(18);									//设置"显示器"的宽度
		textField.setEditable(false);								//试着"显示器"不可编辑
		textField.setHorizontalAlignment(SwingConstants.RIGHT);		//靠右对齐
		viewPanel.add(textField);									//将"显示器"添加到"显示器"面板中
		getContentPane().add(viewPanel, BorderLayout.NORTH);		//添加到窗体顶部
		
		final JPanel clearButtonPanel = new JPanel();					//创建清除按钮面板,默认采用流布局
		getContentPane().add(clearButtonPanel, BorderLayout.CENTER);	
		String[] clearButtonNames = {"<―","CE","C"};
		for (int i = 0;i < clearButtonNames.length;i++) {
			final JButton button = new JButton(clearButtonNames[i]);	//创建清除按钮
			button.addActionListener(new ClearButtonActionListener());	//添加监听器
			clearButtonPanel.add(button);								//将清除按钮添加到清除按钮面板中
		}

		final JPanel inputButtonPanel = new JPanel();				//创建输入按钮面板
		final GridLayout gridLayout = new GridLayout(4, 0);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		inputButtonPanel.setLayout(gridLayout);						//输入按钮面板采用网格布局
		getContentPane().add(inputButtonPanel, BorderLayout.SOUTH);
		String[][] inputButtonNames = {{"1","2","3","+"},
									   {"4","5","6","-"},
									   {"7","8","9","*"},
									   {".","0","=","/"}};			//定义输入按钮名称
		for (int row = 0;row < inputButtonNames.length;row++) {
			for (int col = 0;col < inputButtonNames.length;col++) {
				final JButton button = new JButton(inputButtonNames[row][col]);
				button.setName(row + "" +col);						//输入按钮的名称由其所在的行和列的索引组成
				button.addActionListener(new InputButtonActionListener());
				inputButtonPanel.add(button);						//将按钮添加到按钮面板中
			}
		}
		
	}
	
	class InputButtonActionListener implements ActionListener {		//输入按钮时间监听器
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();				//获得触发此次事件的按钮对象
			String name = button.getName();							//获得按钮的名称
			int row = Integer.valueOf(name.substring(0, 1));		//解析其所在的行
			int col = Integer.valueOf(name.substring(1, 2));		//解析其所在的列
			if (col == 3) {											//此次输入的为运算符
				count();											//计算结果
				textField.setText(result);							//修改"显示器"文本
				operator = button.getText();						//获得输入的运算符
			} else if (row == 3) {									//此次输入的为"." "0"或"="
				if (col == 0) {										//此次输入的为"."
					if (num.indexOf(".") < 0) {						//查看是否已经输入了小数点
						num = num + button.getText();
						textField.setText(num);
					}
				} else if (col == 1) {								//此次输入的为"0"
					if (num.indexOf(".") > 0) {						//查看是否为小数
						num = num + button.getText();
						textField.setText(num);
					} else {
						if (!num.substring(0, 1).equals("0")) {		//查看第一位是否为0 
							num = num + button.getText();
							textField.setText(num);
						}
					}
				} else {											//此次输入的为"0"
					count();										//计算结果
					textField.setText(result);						//修改"显示器"文本
					operator = "+";									//获得输入的运算符
				}
			} else {												//此次输入的为数字
				if (num.equals("0"))
					num = button.getText();
				else 
					num = num + button.getText();
				textField.setText(num);
			}
		}

		private void count() {										//计算结果
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
			if (text.equals("<―")) {
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
