package com.bank.test.dsa;

import java.util.Scanner;

public class Queue {
    int front = -1;
    int rear = -1;

    public void insertToQueue(int[] a, int item) {
        int N = a.length;
        if (rear == N - 1) {
            System.out.println("Queue is full.....");
        } else if (front == -1 && rear == -1) {
            front = 0;
            a[++rear] = item;
        } else {
            a[++rear] = item;
        }
    }

    public void deleteFromQueue(int[] a) {
        if (front == -1) {
            System.out.println("No Elements in Queue present to delete.....");
        } else {
            System.out.println("Element Deleted from Queue is : " + a[front]);
            a[front] = 0;
            front++;
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    public void displayElements(int[] a) {
        if (front == -1) {
            System.out.println("Queue is empty.....");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println("Elements in Queue: " + a[i]);
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
                    System.out.println("Enter Item to insert into queue: ");
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
