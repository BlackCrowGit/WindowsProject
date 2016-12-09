package com.journal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年11月24日 下午12:59:56  
*/
@SuppressWarnings("serial")
public class TipWizardFrame extends JFrame{
	
	private JTextField titleTextField ;
	private JTextField dateTextField;
	private JTextArea textArea;
	private final static String urlStr = "D: /Journal/";
	private final static String todayDate = String.format("%tF", new Date());
	static {
		File file = new File(urlStr);
		if (!file.exists())
			file.mkdirs();
	}
	
	public static void main(String[] args) {
		TipWizardFrame frame = new TipWizardFrame();
		frame.setVisible(true);
	}//MainEnd

	public TipWizardFrame() {
		super();
		setTitle("日志簿");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel softLabel = new JLabel();
		softLabel.setForeground(new Color(255, 0, 0));
		softLabel.setFont(new Font("", Font.BOLD, 22));
		softLabel.setHorizontalAlignment(SwingConstants.CENTER);
		softLabel.setText("日  志  簿");
		getContentPane().add(softLabel, BorderLayout.NORTH);
		
		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		final JPanel infoPanel = new JPanel();
		contentPanel.add(infoPanel, BorderLayout.CENTER);
		
		final JLabel titleLabel = new JLabel();
		titleLabel.setText("标  题: ");
		infoPanel.add(titleLabel);
		titleTextField = new JTextField();
		titleTextField.setColumns(30);
		titleTextField.setText("请输入标题");
		titleTextField.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				titleTextField.setText("");
			}
			
			public void focusGained(FocusEvent e) {
				String date = titleTextField.getText().trim();
				if (date.length() == 0)
					titleTextField.setText("请输入标题");
			}
		});
		infoPanel.add(titleTextField);
		
		final JLabel dateLabel = new JLabel();
		dateLabel.setText("日  期: ");
		infoPanel.add(dateLabel);
		dateTextField = new JTextField();
		dateTextField.setColumns(30);
		dateTextField.setText(todayDate);
		dateTextField.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				dateTextField.setText("");
			}
			
			public void focusGained(FocusEvent e) {
				String date = dateTextField.getText().trim();
				if (date.length() != 10)
					dateTextField.setText(todayDate);
			}
		});
		infoPanel.add(dateTextField);
		
		final JButton seeButton = new JButton();
		
	}
}
