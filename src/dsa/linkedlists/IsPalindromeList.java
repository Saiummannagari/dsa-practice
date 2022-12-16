package dsa.linkedlists;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class IsPalindrome {
    public static void main(String args[])
    {
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
      //  Node four = new Node(5);
        Node five = new Node(4);
        Node six = new Node(3);
        Node seven = new Node(2);
//        one.ptr = two;
//        two.ptr = three;
//        three.ptr = four;
//        four.ptr = five;
//        five.ptr = six;
//        six.ptr = seven;
        one.ptr = two;
        two.ptr = three;
        three.ptr = five;
        five.ptr = six;
        six.ptr = seven;

        boolean condition = isPalindrome(one);
        System.out.println("Check Palindrome :" + condition);
    }
    static boolean isPalindrome(Node head)
    {
        //Write your Code here
        if(head == null) {
            return false;
        }
        AtomicBoolean odd = new AtomicBoolean(false);
        Node middleNode = middleNode(head,odd);

        if(odd.get()) {
          middleNode = middleNode.ptr;
        }
       Node shead = reverse(middleNode);
       while(head!=null && shead!=null) {
           if(head.data == shead.data) {
               head = head.ptr;
               shead = shead.ptr;
           } else {
               return false;
           }
       }
        return true;
    }

    static Node reverse(Node temp) {
        Node prev=null;
        Node curr=temp;
        Node next=null;
        while(curr!=null) {
            next = curr.ptr;
            curr.ptr=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    static Node middleNode(Node head,AtomicBoolean odd) {
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while(fast!=null && fast.ptr!=null) {
            prev = slow;
            slow= slow.ptr;
            if(fast.ptr!=null) {
                fast = fast.ptr.ptr;
            }
        }
        if(fast!=null) {
            odd.set(true);
        }
        prev.ptr = null;
        return slow;
    }
}

class Node {
    int data;
    Node ptr;
    Node(int d)
    {
        ptr = null;
        data = d;
    }
}