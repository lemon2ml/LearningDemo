package com.lei.tests;

public class Test5 implements Runnable{
	String flagStr;

	public Test5(String flagStr) {
		this.flagStr = flagStr;
	}
	public static void main(String[] args) {
		//start()�������߳��Ŷӣ���cpu����ʱ�����̣߳�ǰ������֮�����˳���ϡ�
//		new Thread(new Test5("Thread 11111111111111111 running state...")).start();
//		new Thread(new Test5("Thread 22222222222222222 running state...")).start();
		//ֱ�ӵ���run()�������൱����ͨ������˳��ִ����ǰһ�����ú��ִ�еڶ�����
		new Test5("Thread 11111111111111111 running state...").run();
		new Test5("Thread 22222222222222222 running state...").run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10000000;i++) {
			System.out.println(flagStr);
		}

		
	}

}
