package com.lei.basicAlgorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QueueS<E> {
    Deque<E> stack1 = new ArrayDeque<>();
    Deque<E> stack2 = new ArrayDeque<>();

    public boolean offer(E item) {
        stack1.offerFirst(item);
        return true;
    }

    public E poll() {
        E item = stack2.pollFirst();
        if (item == null) {
            E i = null;
            while((i = stack1.pollFirst()) !=null) {
                stack2.offerFirst(i);
            }
            return stack2.pollFirst();
        } else {
            return item;
        }
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueS<Integer> queue = new QueueS<>();
        int[] arr = new int[] { 1, 23, 3, 4, 7, 99, 21 };
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
