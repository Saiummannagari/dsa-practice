package dsa.linkedlists;/*
Given a Linked List and a number n, write a function that returns the value at the n’th node from the end of the Linked List.

Example:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Hint: Rather  than recursion think of traversing with a gap of n
 */

class Main {
    Node head;


    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    void printNthFromLast(int n)
    {
        //Write your code here
        Node fast=head;
        Node slow=head;
        while(n-->0 && fast!=null) {
            fast= fast.next;
        }
        while(fast!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println(slow.data);

    }


    public void insert(int new_data)
    {

        Node new_node = new Node(new_data);


        new_node.next = head;


        head = new_node;
    }


    public static void main(String[] args)
    {
        Main llist = new Main();
        llist.insert(20);
        llist.insert(4);
        llist.insert(15);
        llist.insert(18);
        llist.insert(35);
        llist.insert(40);
        Node temp = llist.head;
        while(temp!=null) {
            System.out.print(temp.data
                    +" ");
            temp=temp.next;
        }
        System.out.println();

        llist.printNthFromLast(4);
    }
}
