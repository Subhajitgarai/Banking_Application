package com.bank.test.dsa;

public class BinarySearch {
    private static void bsearch(int[]a, int min,int max,int item){
       int mid = (min+max)/2;
       if(a[mid] == item){
           System.out.println("Item Found at place :"+(mid+1));
       }
       else if(item < a[mid]){
           bsearch(a,0,mid,item);
       }
       else{
           bsearch(a,mid+1,max,item);
       }
    }

    public static void main(String[] args) {
        int[] a =new int[]{-1,4,3,2,1,0};
        Bsort.bubbleSort(a);
        bsearch(a,0,a.length,0);

    }
}
