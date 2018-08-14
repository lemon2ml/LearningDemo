package com.lei.tests;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Circle99Frame extends JFrame{
	
	public static void main(String[] args) {
		Circle99Frame cf = new Circle99Frame();

	}
	
	public Circle99Frame() {
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("ͬ��Բ");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Circle 99", 20, 60);
		
		int x = this.getWidth()/2;
		int y = this.getHeight()/2;
		
		for(int r = 0; r<this.getHeight()/2;r+=10) {
			g.setColor(getRandomColor());
			g.drawOval(x-r, y-r, r*2, r*2);
		}
	}
	Color getRandomColor() {
		return new Color(
				(int)(Math.random()*255),
				(int)(Math.random()*255),
				(int)(Math.random()*255)
				);
	}

}
















