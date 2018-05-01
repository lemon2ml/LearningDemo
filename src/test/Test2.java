package test;

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
	JButton btn = new JButton("求平方");
	JLabel out = new JLabel("显示结果的标签");
	
	public AppFrame() {
		setLayout(new FlowLayout());
		
		getContentPane().add(in);
		getContentPane().add(btn);
		getContentPane().add(out);
		btn.addActionListener(e -> {
			String string   = in.getText();
			double d =  Double.parseDouble(string);
			double sq = d*d;
			out.setText(d + "的平方是：" + sq);
		});
		setSize(400,100);
		setTitle("求平方");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}































