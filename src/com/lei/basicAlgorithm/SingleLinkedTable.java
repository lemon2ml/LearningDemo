package com.lei.basicAlgorithm;

public class SingleLinkedTable {
    private static class Node {
        int data = 0;
        Node next = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node now = head;
        Node temp = now.next;
        now.next = null;
        while (temp != null) {
            now = temp;
            temp = temp.next;
            now.next = head;
            head = now;
        }
        return head;
    }

    // 两个单链表的值相同的节点
    static void getPublic(Node head1, Node head2) {
        Node n1 = head1, n2 = head2;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                n1 = n1.next;
            } else if (n1.data > n2.data) {
                n2 = n2.next;
            } else {
                System.out.print(n1.data + "\0");
                n1 = n1.next;
                n2 = n2.next;
            }
        }
    }

    static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedTable slt = new SingleLinkedTable();
        int len1 = 10;
        int len2 = 10;

        Node p1 = new Node(0);
        Node head1 = p1;
        Node p2 = new Node(0);
        Node head2 = p2;

        for (int i = 1; i < len1; i++) {
            p1.next = new Node((int) (Math.random() * 10));
            p1 = p1.next;
        }

        for (int i = 1; i < len2; i++) {
            p2.next = new Node((int) (Math.random() * 10));
            p2 = p2.next;
        }
        print(head1);
        head1 = reverse(head1);
        print(head1);
    }
}
