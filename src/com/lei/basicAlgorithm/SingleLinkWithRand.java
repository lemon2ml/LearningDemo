package com.lei.basicAlgorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class SingleLinkWithRand {
    static class Node {
        int data;
        Node next;
        Node rand;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

    }

    static int size;

    static void setRand(Node head, Node node) {
        Node t = head;
        int n = (int) (Math.random() * size);
        while (--n > 0) {
            t = t.next;
            // System.out.println(node.data + "-" + n);
        }
        node.rand = t;
    }

    static Node generate() {

        int count = size;
        Node node = new Node(getData());
        Node head = node;

        while (count-- > 0) {
            node.next = new Node(getData());

            node = node.next;
        }
        node = head;
        while (count++ < size) {
            setRand(head, node);
            node = node.next;
        }
        return head;
    }

    static Node copy(Node head) {
        if (head == null) {
            return null;
        }

        int n = size;
        Node node = head;
        Node res = node;
        while (n-- > 0) {
            Node toInsert = new Node(node.data);
            toInsert.next = node.next;
            node.next = toInsert;
            node = toInsert.next;
        }

        node = res;
        while (++n < size) {
            node.next.rand = node.rand.next;
            node = node.next.next;
        }
        res = res.next;
        node = res;
        while (--n > 0) {
            node.next = node.next.next;
            node = node.next;
        }
        return res;
    }

    static Node findCircleNode(Node head) {
        if (head == null)
            return null;
        Node fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
            if (fast == slow) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        fast = head;
        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ////////////////////
        new SingleLinkWithRand().size = 10;

        Node head = generate();
        print(head);

        Node head2 = copy(head);
        print(head2);

        setCircle(head2);
        Node node = findCircleNode(head2);
        nodeInfo(0, node);
    }

    static void setCircle(Node head) {
        Node node = head;
        Node tail = node;
        if (node == null) {
            return;
        }
        while(node.next!=null) {
            node = node.next;
        }
        tail = node;
        node = head;
        int n = (int) (Math.random() * size);
        int m = n;
        while (n-- > 0 && node.next != null) {
            node = node.next;
        }
        nodeInfo(m, node);
        tail.next = node;
        return;
    }

    static void nodeInfo(int n, Node node) {
        System.out.println(String.format("%d->%d", n, node.data));
    }

    static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(String.format("%d(%d)", node.data, node.rand.data));
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    static int getData() {
        return (int) (Math.random() * 100);
    }
}
