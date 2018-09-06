package com.lei1;

class Bullet{
	int x = 0;
	int y = 0;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}


class Tank{
	int x = 0;
	int y = 0;
	int speed = 0;
	int dire = 0;
	
	
	
	public void move(int dire) {
		switch(dire) {
		case 0:
			y-=speed;
			break;
		case 1:
			x+=speed;
			break;
			
		case 2:
			y+=speed;
			break;
			
		case 3:
			x-=speed;
			break;

		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDire() {
		return dire;
	}
	public void setDire(int dire) {
		this.dire = dire;
	}
	
}


