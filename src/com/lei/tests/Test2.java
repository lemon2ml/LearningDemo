package com.lei.tests;

import java.awt.*;
import javax.swing.*;

/**
 * @
 */
public class Test2 extends JFrame {
	
	public static void main(String args[]) {
		new AppFrame();
	}	
}

class AppFrame extends JFrame {
	JTextField in = new JTextField(10);
	JButton btn = new JButton("��ƽ��");
	JLabel out = new JLabel("��ʾ����ı�ǩ");
	
	public AppFrame() {
		setLayout(new FlowLayout());
		
		getContentPane().add(in);
		getContentPane().add(btn);
		getContentPane().add(out);
		btn.addActionListener(e -> {
			String string   = in.getText();
			double d =  Double.parseDouble(string);
			double sq = d*d;
			out.setText(d + "��ƽ���ǣ�" + sq);
		});
		setSize(400,100);
		setTitle("��ƽ��");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}































