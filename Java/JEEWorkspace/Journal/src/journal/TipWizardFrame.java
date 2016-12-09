package journal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年11月29日 下午3:13:40  
*/
@SuppressWarnings("serial")
public class TipWizardFrame extends JFrame {
	
	private JTextField titleTextField ;
	private JTextField dateTextField;
	private JTextArea textArea;
	private final static String urlStr = "D:/Journal/";
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
		setBounds(100, 100, 500, 390);
		setResizable(false);
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
			//	titleTextField.setText("");
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
			//	dateTextField.setText("");
			}
			public void focusGained(FocusEvent e) {
				String date = dateTextField.getText().trim();
				if (date.length() != 10)
					dateTextField.setText(todayDate);
			}
		});
		infoPanel.add(dateTextField);
		
		final JButton seeButton = new JButton();
		seeButton.setText("查看日志");
		seeButton.addActionListener(new SeeButtonActionListener());
		contentPanel.add(seeButton,BorderLayout.EAST);
		
		final JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.SOUTH);
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(12);
		scrollPane.setViewportView(textArea);
		
		final JPanel buttonPanel = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(20);
		buttonPanel.setLayout(flowLayout);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		final JButton saveButon = new JButton();
		saveButon.setText("保存");
		saveButon.addActionListener(new SaveButtonActionListener());
		buttonPanel.add(saveButon);
		
		final JButton clearButton = new JButton();
		clearButton.setText("清空");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleTextField.setText("请输入标题");
				dateTextField.setText(todayDate);
				textArea.setText("");
			}
		});
		buttonPanel.add(clearButton);
		
		final JButton exitButton = new JButton();
		exitButton.setText("退出");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(exitButton);
	}
	
	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String title = titleTextField.getText();
			String date = dateTextField.getText();
			String name = title + "(" + date + ").txt";
			File file = new File(urlStr + name);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(textArea.getText());
				fileWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class SeeButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ListDialog listFrame = new ListDialog();
			listFrame.setVisible(true);
			File text = listFrame.getText();
			listFrame.dispose();
			if (text != null) {
				String[] infos = text.getName().split("(|)");
				titleTextField.setText(infos[0]);
				dateTextField.setText(infos[1]);
				
				try {
					FileReader fileReader = new FileReader(text);
					char[] cbuf = new char[(int) text.length()];
					fileReader.read(cbuf);
					fileReader.close();
					textArea.setText(String.valueOf(cbuf));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
