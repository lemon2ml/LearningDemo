package com.lei.oj.baidu1;

import java.util.List;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int minRoutes(int numOfPickupLoc, List<Integer> baseCoor, List<List<Integer>> pickupLocCoor) {
        int min = 0;
        // WRITE YOUR CODE HERE
        int basex = baseCoor.get(0);
        int basey = baseCoor.get(1);
        int[] shang = new int[numOfPickupLoc];
        int[] yu = new int[numOfPickupLoc];
        int[] visited = new int[numOfPickupLoc];
        for (int i = 0; i < numOfPickupLoc; i++) {
            List<Integer> list = pickupLocCoor.get(i);
            int x = list.get(0);
            int y = list.get(1);
            visited[i] = 0;
            if (x - basex == 0) {
                shang[i] = Integer.MAX_VALUE;
                yu[i] = 1;
            } else if (y - basey == 0) {
                shang[i] = Integer.MIN_VALUE;
                yu[i] = 1;
            } else {
                shang[i] = (y - basey) / (x - basex);
                yu[i] = (y - basey) % (x - basex);
            }
        }
        for (int i = 0; i < numOfPickupLoc; i++) {
            if (visited[i] == 1) {
                continue;
            } else {
                int x = shang[i];
                visited[i] = 1;
                for (int j = i + 1; j < numOfPickupLoc; j++) {
                    int y = shang[j];
                    if (x == y && visited[j] == 0) {
                        if (yu[i] == yu[j]) {
                            visited[j] = 1;
                        }
                    }
                }
                min++;
            }

        }
        return min;
    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args) {
        int x = 2, y =3;
        int x2 = 2, y2 = 3;
        double k = Double.valueOf(y)/x;
        double k2 = Double.valueOf(y2)/x2;
        System.out.println(k);
        System.out.println(k2);
        System.out.println(k == k2);
    }
}
