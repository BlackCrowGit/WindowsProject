package journal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年11月29日 下午3:16:47  
*/
@SuppressWarnings("serial")
public class ListDialog extends JDialog {
	
	private static File file = null;
	private File[] files = null;
	private File text = null;
	private JPanel allPanel;
	static {
		file = new File("D:/Journal/");
	}
	
	public ListDialog() {
		super();
		setModal(true);
		setTitle("日志列表");
		setBounds(100, 100, 500, 390);
		
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		files = file.listFiles();
		System.out.println(files.length);
		allPanel.setPreferredSize(new Dimension(450, files.length*36));
		scrollPane.setViewportView(allPanel);
		for (int i = 0;i < files.length;i++) {
			String name = "  " + files[i].getName();
			name = name.substring(0, name.length() - 4);
			
			final JPanel onePanel = new JPanel();
			allPanel.add(onePanel);
			onePanel.setBorder(new LineBorder(Color.black, 1,false));
			onePanel.setLayout(new BorderLayout());
			
			final JLabel label = new JLabel();
			label.setPreferredSize(new Dimension(330, 0));
			label.setText(name);
			onePanel.add(label, BorderLayout.WEST);
			
			final JButton delButton = new JButton();
			delButton.setText("删除");
			delButton.setName("" + i);
			delButton.addActionListener(new DelButtonActionListener());
			onePanel.add(delButton,BorderLayout.CENTER);
			
			final JButton seeButton = new JButton();
			seeButton.setText("查看");
			seeButton.setName("" + i);
			seeButton.addActionListener(new SeeButtonActionListener());
			onePanel.add(seeButton, BorderLayout.EAST);
		}
		
		final JButton returnButton = new JButton();
		returnButton.setText("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().add(returnButton, BorderLayout.SOUTH);
	}
	
	public File getText() {
		return text;
	}
	
	private class SeeButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String name = button.getName();
			text = files[Integer.valueOf(name)];
			setVisible(false);
		}
		
	}
	
	private class DelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int index = Integer.valueOf(button.getName());
			files[index].delete();
			allPanel.remove(index);
			SwingUtilities.updateComponentTreeUI(allPanel);
		}
		
	}
	
}
