package com.lei1;

public class ReverseLinkx {
	public static Node Reverse(Node head) {
		Node reHead = null;
		if(head==null || head.getNext()==null) {
			return head;
		}
		reHead = Reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
				
		return reHead;
	}
	
	public static void main(String[] args) {
		Node[] nodes = new Node[10];
		for(int i=0;i<10;i++) {
//			System.out.println(i);
			nodes[i] = new Node(i);
		}
		for(int j =0;j<9;j++) {
			nodes[j].setNext(nodes[j+1]);
		}
		Node head = nodes[0];
		while(head != null) {
			System.out.print(head.getValue()+" ");
			head = head.getNext();
		}
		
		System.out.println("\n********************");
		Node head1 = nodes[0];
		head1 = ReverseLink.reverse(head1);
		while(head1 != null) {
			System.out.print(head1.getValue()+" ");
			head1 = head1.getNext();
		}
		
	}
}

class Node{
	private int value;
	private Node next;
	Node(int value){
		this.value = value;
	}
	
	int getValue() {
		return this.value;
	}
	void setValue(int v){
		this.value = v;
	}
	Node getNext() {
		return this.next;
	}
	void setNext(Node next) {
		this.next = next;
	}
}












