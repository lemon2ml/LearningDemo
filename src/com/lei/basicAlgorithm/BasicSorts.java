package com.lei.basicAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BasicSorts {
    private static int max;

    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    public static void selectSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }

            swap(a, i, index);
        }
    }

    private static int partition(int[] a, int left, int right) {
        if (a == null || left < 0 || right < 0 || left > right) {
            return Integer.MIN_VALUE;
        }
        int i = left, j = right, pivot = a[left];
        while (i < j) {
            while (i < j && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < pivot) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = pivot;
        return i;
    }

    // 交换：冒泡，快排
    // 选择：选择， 堆
    // 插入： 插入， 希尔
    // 归并， 基数
    public static void quickSort(int[] a) {
        int left = 0, right = a.length - 1;
        quickSort(a, left, right);
    }

    public static void quickSortNonRecursive(int[] a, int left, int right) {
        if (a == null || left < 0 || right < 0 || left > right) {
            return;
        }
        int i = left, j = right;
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(i);
        stack.push(j);
        
        while(!stack.isEmpty()) {
            j = stack.pop();
            i = stack.pop();
            
            if(i < j) {
                int k = partition(a, i, j);
                if(k > i) {
                    stack.push(i);
                    stack.push(k-1);
                }
                if(k < j) {
                    stack.push(k+1);
                    stack.push(j);
                }
            }
            
        }
        
    }

    private static void quickSort(int[] a, int left, int right) {

        if (left < right) {
            int i = left, j = right;
            int x = a[left];
            while (i < j && a[j] > x) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < x) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    private static int getMax() {
        return max;
    }

    private static void setMax(int max) {
        BasicSorts.max = max;
    }

    public static void countingSort(int[] a) {
        int max = getMax();
        countingSort(a, max);
    }

    public static void countingSort(int[] a, int k) {
        int[] temp = new int[k + 1];
        for (int i = 0; i < a.length; i++) {
            temp[a[i]]++;
        }
        int x = 0;
        for (int i = 0; i <= k; i++) {
            while (temp[i]-- > 0) {
                a[x++] = i;
            }
        }
    }

    public static void bucketSort(int[] a, int m) {
        List<Integer>[] buckets = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < a.length; i++) {
            buckets[(a[i] % m)].add(a[i]);
        }

        for (int i = 0; i < m; i++) {
            int[] temp = new int[buckets[i].size()];
            temp = buckets[i].stream().mapToInt(Integer::intValue).toArray();
            quickSort(temp);
            int size = buckets[i].size();
            buckets[i].clear();
            for (int j = 0; j < size; j++) {
                buckets[i].add(temp[j]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            int index = 0, j;
            for (j = 0; j < m; j++) {
                if (buckets[j].size() > 0 && buckets[j].get(0) < buckets[index].get(0)) {
                    index = j;
                }
            }
            a[i] = buckets[index].get(0);
            buckets[index].remove(0);
        }

    }

    public static void bucketSort1(int[] a, int m) {
        int[][] buckets = new int[m][a.length];// 每个桶应该用可变大小的数据结构，自定义，或者用List，目前将就着吧。。。所以用初始化一下作为判断

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < a.length; j++) {
                buckets[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < a.length; i++) {
            int x = 0;
            while (buckets[a[i] / m][x++] != Integer.MIN_VALUE) {
            }
            buckets[a[i] / m][x - 1] = a[i];
        }

        for (int i = 0; i < buckets.length; i++) {
            quickSort(buckets[i]);
        }

        for (int j = 0; j < a.length; j++) {
            int min = Integer.MIN_VALUE;
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i].length > j + 1 && min > buckets[i][j]) {
                    min = buckets[i][j];
                }
            }
            a[j] = min;
        }

    }

    private static class Bucket {
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        Node head;
        Node cur;

        Bucket() {
            this.head = new Node(Integer.MIN_VALUE);
        }

        void add(int data) {
            cur.next = new Node(data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 5, 2, 3, 33, 11, 9, 7, 6, 29, 22, 12 };
        print(a);
        quickSortNonRecursive(a, 0, a.length - 1);
        // bucketSort(a, 3);
        // bubbleSort(a);
        // insertSort(a);
        // selectSort(a);
        // quickSort(a);
        // setMax(33);
        // countingSort(a);
        print(a);
    }
}
