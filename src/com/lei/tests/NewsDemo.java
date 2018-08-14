package com.lei.tests;

/**
 *  һ���򵥵������¼�������ʾ����
 * @author tds
 * @author �޸��ߣ�
 */

public class NewsDemo {
	public static void main(String[] args) {
		
		//ģ����һ��������
		NewsAgency bbc = new NewsAgency("BBC");
		//���ĸ��������
		bbc.addListener(new MyListener());
		
		//TODO ���������ټ���һ��Listener
		bbc.addListener(new Listener() {
			public void newsArrived(NewsEvent e) {
				System.out.println("��ע�⣺"+e.text+" ������");
			}
		});
		
		bbc.addListener(e->{System.out.println("Please note, " + e.text + "happed!\nFrom: " + e.source.toString());});
		
		
		//�����������乤������
		NewsEvent event = new NewsEvent("Mr. Joan", "Bombing", 9 );
		bbc.start(event);				
	}
}


/**
 * �¼���Ϣ
 */
class NewsEvent{
	Object source;  //�¼���Դ
	String text;    //�¼�����
	int level;      //�¼�����
	NewsEvent(Object source, String text, int level){
		this.source=source;
		this.text = text;
		this.level = level;		
	}
}

interface Listener{
	void newsArrived(NewsEvent e);
}

/**
 * ���Ż���
 */
class NewsAgency {
	String name; //������
	public NewsAgency(String name) {
		this.name = name;		
	}
	Listener[] listeners = new  Listener[100]; //�����ߣ������ߣ�
	int listenerCnt = 0; //���еĶ�����
	
	//����һ��������
	void addListener(Listener oneListener){
		if(listenerCnt<listeners.length){
			listeners[listenerCnt] = oneListener;
			listenerCnt++;
		}		
	}
	
	//ģ��һ���¼���������֪ͨ���еĶ�����
	void start(NewsEvent event){
		
		
		for(int i=0; i<listenerCnt; i++) {
			listeners[i].newsArrived(event);
		}
		
	}
}

/**
 * ʵ��һ��������
 */
class MyListener implements Listener{
	//�����յ���Ϣ�󣬽���һЩ��ʾ
	public void newsArrived(NewsEvent e){
		if( e.level>5) System.out.println("warning :");
		System.out.println("please note," + e.text + " happed!");
	}
}



