package com.lei.bookAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();//持续时长
            int k = sc.nextInt();//唤醒时长
            int[] score = new int[n];
            int[] state = new int[n];
            List<Integer> index = new ArrayList<>();
            int res = 0;
            for (int i=0;i<n;i++){
                score[i] = sc.nextInt();
            }
            for (int i=0;i<n;i++){
                int temp = sc.nextInt();
                state[i] = temp;
                if (temp==0){
                    index.add(i);
                }else {
                    res+=score[i];
                }
            }
            int max = 0;
            if (index==null||index.size()==0){
                System.out.println(res);
            }else {
                for (int i=0;i<index.size();i++){
                    int temp = index.get(i);
                    max = Math.max(max,getSum(score,state,temp,k));
                }
                System.out.println(max+res);
            }
        }
        sc.close();
    }

    private static int getSum(int[] sc,int[] state,int index,int k){
        int sum = 0;
        //首先计算前面部分
        while (index<sc.length&&k>0){
            if (state[index]==0){
                sum += sc[index];
            }
            k--;
            index++;
        }
        return sum;
    }
}
