package com.bank.test.dsa;

import java.util.Scanner;

public class Stack {
    static int []a=new int[10];
    int top=-1;
     public void push(int item,int N){
        if(top==N-1){
            System.out.println("Stack is full no more space left have a relax and clear space...");
        }
        else {
            a[++top]=item;
        }

    }
    public void pop(){
         if(top==-1){
             System.out.println("Wtf NO more items in tack still wanting to delete ????");
         }
         else {
             System.out.println("Item Deleted from stack !! item Details: "+ a[top--]);
         }
    }
    public void displayItems(){
         for(int i=0;i<=top;i++){
             System.out.print(a[i]+" ");
         }
    }

    public static void main(String[] args) {
        Stack stack =new Stack();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\nWanted to do stack operations? \n 1.Push\n 2.Pop\n 3.Display\n 4.Exit");
            System.out.println("Enter our choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter Item to insert into stack: ");
                    int item=sc.nextInt();
                    stack.push(item,a.length);
                    break;
                case 2: stack.pop();
                        break;
                case 3: stack.displayItems();
                        break;
                case 4: System.exit(0);
            }
        }
    }
}
