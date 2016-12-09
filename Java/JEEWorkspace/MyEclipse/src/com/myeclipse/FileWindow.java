package com.myeclipse;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** 
* @author 庄贵东: 
* @version 创建时间：2016年12月4日 上午12:55:03  
*/
@SuppressWarnings("serial")
public class FileWindow extends JFrame implements ActionListener,Runnable {

	Thread compiler = null;
	Thread runProm = null;
	boolean bn = true;
	CardLayout mycard;
	File fileSaved = null;
	
	JButton buttonInputTxt,
			buttonCompilerText,
			buttonCompiler,
			buttonRunProm,
			buttonSeeDoswin;
	
	JPanel p = new JPanel();
	JTextArea inputText = new JTextArea();
	JTextArea compilerText = new JTextArea();
	JTextArea dosOutText = new JTextArea();
	
	JTextField inputFileNameText = new JTextField();
	JTextField runFileNameText = new JTextField();
	
	public FileWindow() {
		super("Java Editer");
		mycard = new CardLayout();
		compiler = new Thread(this);
		runProm = new Thread(this);
		buttonInputTxt = new JButton("InputArea(white)");
		buttonCompilerText = new JButton("BianyijieguoArea(pink)");
		buttonSeeDoswin = new JButton("YunxingjieguoArea(blue)");
		buttonCompiler = new JButton("Bianyi");
		buttonRunProm = new JButton("RunProm");
		
		p.setLayout(mycard);
		p.add("input",inputText);
		p.add("compiler", compilerText);
		p.add("dos", dosOutText);
		add(p, "Center");
		
		compilerText.setBackground(Color.pink);
		dosOutText.setBackground(Color.cyan);
		JPanel p1 = new JPanel();
		
		p1.add(buttonInputTxt);
		p1.add(buttonCompilerText);
		p1.add(buttonSeeDoswin);
		p1.add(new JLabel("InputFileName(.java):"));
		p1.add(inputFileNameText);
		p1.add(buttonCompiler);
		p1.add(new JLabel("InputClassName"));
		p1.add(runFileNameText);
		p1.add(buttonRunProm);
		add(p1,"North");
		
		buttonInputTxt.addActionListener(this);
		buttonCompiler.addActionListener(this);
		buttonCompilerText.addActionListener(this);
		buttonRunProm.addActionListener(this);
		buttonSeeDoswin.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonInputTxt) {
			mycard.show(p, "input");
		}
		else if (e.getSource() == buttonCompilerText) {
			mycard.show(p, "compiler");
		}
		else if (e.getSource() == buttonSeeDoswin) {
			mycard.show(p, "dos");
		}
		else if (e.getSource() == buttonCompiler) {
			if (!(compiler.isAlive())) {
				compiler = new Thread(this);
			}
			try {
				compiler.start();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			mycard.show(p, "compiler");
		}
		else if (e.getSource() == buttonRunProm) {
			if (!(runProm.isAlive())) {
				runProm = new Thread(this);
			}
			try {
				runProm.start();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			mycard.show(p, "dos");
		}		
	}
	
	public void run() {
		if (Thread.currentThread() == compiler) {
			compilerText.setText(null);
			String temp = inputText.getText().trim();
			byte [] buffer = temp.getBytes();
			int b = buffer.length;
			String fileName = null;
			fileName = inputFileNameText.getText().trim();
			
			try {
				fileSaved = new File(fileName);
				FileOutputStream writefile = null;
				writefile = new FileOutputStream(fileSaved);
				writefile.write(buffer, 0, b);
				writefile.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ERROR");
			}
			try {
				Runtime rt=Runtime.getRuntime();
				InputStream in=rt.exec("javac "+fileName).getErrorStream(); //??Runtime??javac???????javac ???????????????
				BufferedInputStream bufIn=new BufferedInputStream(in);
				byte[] shuzu=new byte[100];
			    int n=0;
			    boolean flag=true;

			    while((n=bufIn.read(shuzu, 0,shuzu.length))!=-1) {
			    	String s=null;
			    	s=new String(shuzu,0,n);
			    	compilerText.append(s);
			    	if(s!=null) {
			    		flag=false;
			    	}
			    }
			    if(flag) {
			    	compilerText.append("Compile Succeed!");
			    }
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else if (Thread.currentThread() == runProm) {
			dosOutText.setText(null);
			try {
				Runtime rt = Runtime.getRuntime();
				String path = runFileNameText.getText().trim();
				Process stream = rt.exec("java" + path);
				InputStream in = stream.getInputStream();
				BufferedInputStream bisErr = new BufferedInputStream(stream.getErrorStream());
				BufferedInputStream bisIn = new BufferedInputStream(in);
				byte[] buf = new byte[150];
				byte[] errBuf = new byte[150];
				@SuppressWarnings("unused")
				int m = 0;
				@SuppressWarnings("unused")
				int i = 0;
				String s = null;
				@SuppressWarnings("unused")
				String err = null;
				
				while ((m = bisIn.read(buf,0,150)) != -1) {
					s = new String(buf,0,150);
					dosOutText.append(s);
				}
				while ((i = bisErr.read(errBuf)) != -1) {
					err = new String(errBuf,0,150);
					dosOutText.append("err");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


}
