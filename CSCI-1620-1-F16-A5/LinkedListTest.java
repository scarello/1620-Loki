// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 5 
// Due Date     : Nov. 17, 2016
//
// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Michael Monical
// NUID: 9263 
// EMAIL: mikemonical@gmail.com

// Partners:Patrick Cavanaugh Provided this test platform

// This is the Linked LIst test file
//

import dataStructures.LinkedList;
import exceptions.EmptyListException;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<Integer> myList = new LinkedList<Integer>("Integer List");

        printLengthAndList(myList);

        System.out.println("Populating from front");

        for(int x = 0; x < 5; x++)
        {
            myList.insertAtFront(x);
        }

        printLengthAndList(myList);

        System.out.println("Populating from back");

        for(int x = 0; x < 5; x++)
        {
            myList.insertAtBack(x);
        }

        printLengthAndList(myList);

        System.out.println("Sorting");
        myList.sort();

        printLengthAndList(myList);

        System.out.println("Removing from front, then back");

        try
        {
            myList.removeFromFront();
        }
        catch(EmptyListException ELE)
        {
            System.out.print(ELE);
        }

        try
        {
            myList.removeFromBack();
        }
        catch(EmptyListException ELE)
        {
            System.out.print(ELE);
        }

        printLengthAndList(myList);

        try
        {
            if(myList.findAndRemove(5))
            {
                System.out.println("5 removed");
            }
            else
            {
                System.out.println("5 not removed");
            }
        }
        catch(EmptyListException ELE)
        {
            System.out.println(ELE);
        }

        printLengthAndList(myList);

        try
        {
            if(myList.findAndRemove(0))
            {
                System.out.println("0 removed");
            }
            else
            {
                System.out.println("0 not removed");
            }
        }
        catch(EmptyListException ELE)
        {
            System.out.println(ELE);
        }

        printLengthAndList(myList);

        int position = myList.findItem(5);
        if(position!=-1)
        {
            System.out.printf("Value of 5 found at %d\n", position);
        }
        else
        {
            System.out.println("Value of 5 not found");
        }

        position = myList.findItem(2);
        if(position!=-1)
        {
            System.out.printf("Value of 2 found at %d\n", position);
        }
        else
        {
            System.out.println("Value of 2 not found");
        }

        System.out.printf("Value at position %d being removed\n", position);
        myList.removeItem(position);
        printLengthAndList(myList);

        System.out.println("Removing element 0");
        myList.removeItem(0);
        printLengthAndList(myList);

        System.out.println("Removing from front");
        myList.removeFromFront();
        printLengthAndList(myList);

        System.out.println("Getting value at position 2");
        Integer temp = myList.getItem(2);
        System.out.printf("Value at postion is %d\n", temp);

        System.out.println("Setting position 0 and 3 to 5");
        myList.setItem(0, 5);
        myList.setItem(3, 5);
        printLengthAndList(myList);

        System.out.println("Testing IndexOutOfBoundsException");/////////////////////////////////////////
        try
        {
            myList.getItem(4);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }

        try
        {
            myList.getItem(-1);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }


        try
        {
            myList.removeItem(4);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }

        try
        {
            myList.removeItem(-1);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }

        try
        {
            myList.setItem(-1, 5);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }

        try
        {
            myList.setItem(4, 5);
        }
        catch(IndexOutOfBoundsException IOBE)
        {
            System.out.println(IOBE);
        }

        System.out.println("End of IOBE test");

        System.out.println("Clearing if not empty");

        if(!myList.isEmpty())
        {
            myList.clear();
        }

        printLengthAndList(myList);

        System.out.println("Testing EmptyListException");

        try
        {
            myList.removeFromFront();
        }
        catch(EmptyListException ELE)
        {
            System.out.println(ELE);
        }

        try
        {
            myList.removeFromBack();
        }
        catch(EmptyListException ELE)
        {
            System.out.println(ELE);
        }

        try
        {
            myList.sort();
        }
        catch(EmptyListException ELE)
        {
            System.out.println(ELE);
        }

        System.out.println("End of EmptyListException test");
    }

    public static void printLengthAndList(LinkedList<Integer> l)
    {
        System.out.printf("Length is: %d\n", l.lengthIs());
        System.out.println(l);

    }

}
