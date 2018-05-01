package com.lei1;

public class ReverseLink{
	public static void main(String[] args) {
		
	}
	
	public static Node reverse(Node head) {
		Node reHead = null;
		Node pre = head;
		Node cur = head.getNext();
		
		while(cur != null) {
			Node tmp = cur.getNext();
			cur.setNext(pre);
			
			pre = cur;
			cur = tmp;
		}
		head.setNext(null);
		reHead = pre;		
		return reHead;
	}
}