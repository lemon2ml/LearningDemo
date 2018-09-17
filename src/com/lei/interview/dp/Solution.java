package com.lei.interview.dp;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    char[] rangeFrequent(String str, int pair, int[][] rangeLR) {
        char[] ans = new char[pair];
        for(int i = 0; i<pair; i++) {
            ans[i] = func(str,rangeLR[i][0], rangeLR[i][1]);
        }
        return ans;
    }

    // METHOD SIGNATURE ENDS
    static int min(char[] cs) {
        char min = 'z';
        int idx = 0;
        for(int i =0;i<cs.length;i++) {
            if(cs[i] < min) {
                min = cs[i];
                idx = i;
            }
        }
        return idx;
    }
    //"1234"
    static char func(String str, int l, int r) {
        str = str.substring(l-1, r);
        char[] cs = str.toCharArray();
        int count = 0;
        int index = 0;
        for(int i=0; i<cs.length;i++) {
            int cnt = 0;
            int idx = 0;
            for(int j=i+1; j<cs.length;j++) {
                if(cs[i] == cs[j]) {
                    cnt++;
                    idx = j;
                }
            }
            if(cnt > count) {
                count = cnt;
                index =idx;
            }
        }
        if(index == 0) {
            index = min(cs);
        }
        return cs[index];
    }
    public static void main(String[] args) {
        String str = "cabcac";
        char c = func(str, 1, 3);
        System.out.println(c);
    }
}
