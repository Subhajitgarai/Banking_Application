package com.bank.test.dsa;

import java.util.Arrays;

public class Bsort {
     public static void bubbleSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            for(int j=0; j<n-1-i;j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a =new int[]{-1,4,3,2,1,0};
        bubbleSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
