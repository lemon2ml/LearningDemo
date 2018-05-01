package test;

import java.util.ArrayList;
public class Test11 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		ArrayList<Integer> al = new ArrayList();
		
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
        ListNode pre = head;
        for(int i=0;i<k-1;i++){
            if(pre.next != null){
                pre = pre.next;
            }else{
                return null;
            }
        }
        while(pre.next != null){
            pre = pre.next;
            head = head.next;            
        }
        return head;
    }

}

class ListNode{
	int val;
	ListNode next = null;

	ListNode(int v){
		this.val = v;
	}
}
