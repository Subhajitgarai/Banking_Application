package com.bank.test.dsa;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int []a, int min,int mid,int max){
        int i,j,k;
        int []b=new int[a.length];
        for(i=min;i<=max; i++){
            b[i]=a[i];
        }
        i=min;
        j=mid+1;
        k=min;
        while (i<=mid && j<=max){
            if(b[i]<b[j]){
                a[k]=b[i];
                i++;
            }
            else{
                a[k]=b[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            a[k]=b[i];
            i++;
            k++;
        }
        while (j<=max){
            a[k]=b[j];
            j++;
            k++;
        }
    }
    public static void mSort(int []a, int min,int max){
        int mid=0;
        if(max>min){
            mid=(min+max)/2;
            mSort(a,min,mid);
            mSort(a,mid+1,max);
            merge(a,min,mid,max);
        }

    }

    public static void main(String[] args) {
        int[] a =new int[]{-1,4,3,2,1,0};
        mSort(a,0,a.length-1);
        Arrays.stream(a).forEach(System.out::println);
    }
}
