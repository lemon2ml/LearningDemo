package com.lei.basicAlgorithm;

public class DoubleLinkedTable {
    private class Node {
        int data;
        Node next;
        Node previous;

        public Node() {
        }

        public Node(int data, Node next, Node previous) {
            super();
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
}
