package com.bank.test.dsa;

import java.util.Scanner;

public class Queue {
    int font =-1;
    int rare =-1;
    public void insertToQueue(int []a,int item){
        int N =a.length;
        if(rare==N-1){
            System.out.println("Stack is full.....");
        }
        else if(font==-1 && rare==-1){
            font=0;
            a[++rare]=item;
        }
        else{
            a[++rare]=item;
        }
    }
    public void deleteFromQueue(int []a){
        if(font ==-1){
            System.out.println("No Elements in Queue present to delete.....");
        }
        else{
            System.out.println("Element Deleted from Queue is : "+ a[font++]);
        }
    }
    public void displayElements(int []a){
        for (int i=font;i<=rare;i++){
            System.out.println("Elements in Queue: "+a[i]);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc=new Scanner(System.in);
        int a[]=new int[10];
        while (true){
            System.out.println("\nWanted to do Queue operations? \n 1.Enqueue\n 2.Dequeue\n 3.Display\n 4.Exit");
            System.out.println("Enter our choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter Item to insert into stack: ");
                    int item=sc.nextInt();
                    queue.insertToQueue(a,item);
                    break;
                case 2: queue.deleteFromQueue(a);
                    break;
                case 3: queue.displayElements(a);
                    break;
                case 4: System.exit(0);
            }
        }
    }
}
