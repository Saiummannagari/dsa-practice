package dsa.linkedlists;

/*
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.

Example:

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL
Hint: Think of separating the list into two lists of even and odd by traversing list Once
 */
class Node
{
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Main
{

    public static Node rearrangeEvenOdd(Node head)
    {
        //Write your code here
        Node even = null;
        Node odd = null;
        Node evenFirst = null;
        Node oddFirst = null;
        while(head!=null) {
            if(head.data%2 == 0){
                if(even == null) {
                    even=evenFirst =head;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if(odd == null) {
                    odd = oddFirst =head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            head = head.next;
        }
        if(evenFirst == null) {
            return oddFirst;
        }
        if(oddFirst == null) {
            return evenFirst;
        }
        even.next = oddFirst;
        odd.next = null;

        return evenFirst;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 2,4,6,8,2 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrangeEvenOdd(head);
        while(head!=null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}