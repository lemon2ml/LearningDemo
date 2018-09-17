package com.lei.oj.baidu0;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 char[] rangeFrequent(String str, int pair, int[][] rangeLR) 
 {
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ;i<pair;i++){
        int a = rangeLR[i][0];
        int b = rangeLR[i][1];
        String temp = str.substring(a-1,b);
        char c = getChar(temp);
        sb.append(c);
    }
    return sb.toString().toCharArray();
    
 }
 char getChar(String str){
     int[] arr = new int[26];
     for(char c : str.toCharArray()){
         arr[c-'a']++;
     }
     int temp = 0;
     int max = 0;
     for(int i=0 ;i<arr.length;i++){
         if(arr[i]>max){
             max = arr[i];
             temp = i;
         }
     }
     return (char)('a'+temp);
 }
 // METHOD SIGNATURE ENDS
}
