package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner console = new Scanner(System.in);
        int value;
        System.out.println ("Enter quantity elements:");
        int n = console.nextInt();
        MyList <Integer> myList = new MyList();
        System.out.println ("Enter " + n + " elements:");
        value = console.nextInt();

        myList.addFirst(value);
        for (int i = 1; i < n; i++) {
            value = console.nextInt();
            myList.add(value);
        }

        //myList.print_list();
        int a;

        do
        {
            System.out.println("Choose:");
            System.out.println("1.add to the beginning");
            System.out.println("2.add to the end");
            System.out.println("3.add after the element with the specified number");
            System.out.println("4.search");
            System.out.println("5.get the element with the specified number");
            System.out.println("6.delete the element");
            System.out.println("0.exit");

            a = console.nextInt();

            switch (a)
            {
                case (1):
                    System.out.println ("Enter element to add:");
                    value = console.nextInt();
                    System.out.println(value);
                    myList.addFirst(value);
                    //myList.print_list();
                    break;

                case (2):
                    System.out.println ("Enter element to add:");
                    value = console.nextInt();
                    myList.add(value);
                    //myList.print_list();
                    break;

                case (3):
                    System.out.println("enter number of item to be added:");
                    n = console.nextInt();
                    if(myList.getSize()>=n)
                    {
                        System.out.println ("Enter element to add:");
                        value = console.nextInt();
                        myList.setElement(value,n);
                    } else System.out.println("impossible");
                    //myList.print_list();
                    break;

                case (4):
                    System.out.println ("Enter item to search:");
                    n = console.nextInt();
                    int result=myList.search(n);
                    if(result!=-1) System.out.println("number of desired element: "+result);
                    else System.out.println("element wasn't found");
                    //myList.print_list();
                    break;

                case (5):
                    System.out.println ("Enter item nunber:");
                    n = console.nextInt();
                    if(myList.getSize()>n)
                    {
                        System.out.println(myList.getElement(n));
                    } else System.out.println("impossible");
                    //myList.print_list();
                    break;

                case (6):
                    System.out.println ("Enter item to be deleted:");
                    value = console.nextInt();
                    if(!myList.remove(value))
                    {
                        System.out.println("impossible");
                    }
                    //myList.print_list();
                    break;

            }
        }while(a>0 && a<7);
    }
}
