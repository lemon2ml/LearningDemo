package com.lei.hilocoder;

import java.util.Arrays;

public class Triee {
    TrieNode root = new TrieNode();

    Triee() {
    }

    void add(String str) {
        byte[] bs = str.getBytes();
        int i;
        TrieNode cur = root;
        for (i = 0; i < bs.length; i++) {
            boolean flag = false;
            int j;
            for (j = 0; j < cur.children.length; j++) {
                if (cur.children[j].c == bs[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            cur = cur.children[j];
        }
        if (i < bs.length - 1) {
            for (int k = i; k < bs.length; k++) {
            }
        }
    }

    private static class TrieNode {
        byte c;
        int cnt = 0;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
        }

        TrieNode(byte c) {
            this.c = c;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) {
        byte c = 'A';
        System.out.println(c);
    }
}
