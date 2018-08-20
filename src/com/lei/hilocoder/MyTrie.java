package com.lei.hilocoder;

import java.util.Scanner;

public class MyTrie {
    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            myTrie.insert(word);
        }
        int m = Integer.valueOf(sc.nextLine());
        for (int j = 0; j < m; j++) {
            System.out.println(myTrie.getCount(sc.nextLine()));
        }

    }

    class TrieNode {
        int count;
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.count = 1;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }

    TrieNode root;

    MyTrie() {
        this.root = new TrieNode();
    }

    int getCount(String prefix) {
        TrieNode cur = this.root;
        char[] chs = prefix.toCharArray();
        for(int i=0;i<chs.length;i++) {
            int index = chs[i] -'a';
            if(cur.children[index] == null) {
                return 0;
            }
            if(i == chs.length-1) {
                return cur.children[index].count;
            }
            cur = cur.children[index];
        }
        return -1;
    }

    void insert(String key) {
        TrieNode cur = this.root;
        char[] chs = key.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            } else {
                cur.children[index].count++;
            }
            if (i == chs.length - 1) {
                cur.children[index].isEnd = true;
            }
            cur = cur.children[index];
        }
        System.out.println("Successfully insert '" + key + "'");
    }

}
