package com.lei.oj.baidu4;

import java.util.Collections;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;

//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> findCommonElements(int numCustomer, int numProduct, List<List<Integer>> productList) {
        // WRITE YOUR CODE HERE
        if (productList == null || productList.size() == 0) {
            return null;
        }
        List<Integer> result = productList.get(0);
        productList.remove(0);
        List<Integer> t;
        while (productList.size() > 0) {
            t = productList.get(0);
            productList.remove(0);
            result.retainAll(t);
            t.clear();
        }
        Collections.sort(result);
        return result;
    }
    // METHOD SIGNATURE ENDS
}
