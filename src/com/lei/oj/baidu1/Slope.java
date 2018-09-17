package com.lei.oj.baidu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Slope {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int minRoutes(int numOfPickupLoc, List<Integer> baseCoor, List<List<Integer>> pickupLocCoor) {
        Set<Double> set = new HashSet<>();
        int bx = baseCoor.get(0);
        int by = baseCoor.get(1);
        for (int i = 0; i < numOfPickupLoc; i++) {
            int x = pickupLocCoor.get(i).get(0);
            int y = pickupLocCoor.get(i).get(1);
            double k = Double.valueOf((by - y)) / (bx - x);
            set.add(k);
        }
        return set.size();
    }

    // METHOD SIGNATURE ENDS
    public static void main(String[] args) {
        int numOfPickupLoc = 9;
        List<Integer> baseCoor = Arrays.asList(0,0);
        List<List<Integer>> pickupLocCoor = new ArrayList<>();
        int[][] plc = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 4, 8 },{5,109},{7,122} ,{9, 216},{1, 1000000002},{2, 2000000004}};
        pickupLocCoor = Arrays.stream(plc).map(arr -> Arrays.stream(arr).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        int size = minRoutes(numOfPickupLoc, baseCoor, pickupLocCoor);
        System.out.println(size);
        
    }
}
