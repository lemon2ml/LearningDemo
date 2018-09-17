package com.lei.oj.baidu3;

import java.util.ArrayList;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;

//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> findCommonElements(int numCustomer, int numProduct, List<List<Integer>> productList) {
        List<Integer> list = new ArrayList();
        int[] is = new int[numCustomer];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < productList.size(); i++) {
            max = max < max(productList.get(i)) ? max(productList.get(i)) : max;
        }
        int[] bs = new int[max];
        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < productList.get(0).size(); j++) {
                bs[productList.get(i).get(j)-1]++;
            }
        }
        for (int i = 0; i < bs.length; i++) {
            if (bs[i] >= numCustomer) {
                int x = (int) Math.pow(2, i);
                list.add(x);
            }
        }
        return list;
    }

    static int max(int[] is) {
        int max = is[0];
        for (int i = 1; i < is.length; i++) {
            max = max < is[i] ? is[i] : max;
        }
        return max;
    }

    static int max(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            max = max < list.get(i) ? list.get(i) : max;
        }
        return max;
    }

    // METHOD SIGNATURE ENDS
}