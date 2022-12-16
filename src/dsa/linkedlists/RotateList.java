package dsa.linkedlists;/*
Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 */

public class RotateList {

    Node rotatedHead;
    Node head;
    Node tail;
   
    
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void rotateByKTimes(int k, Node head) {

        int length = 1;
        Node temp = head;

        while(temp.next!= null) {
            temp = temp.next;
            length++;
        }
        temp.next = head;
        k = k%length;
        Node tempHead = head;
        while(--k>0) {
            tempHead = tempHead.next;
        }
        head = tempHead.next;
        tempHead.next = null;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = tail =node;
        }
        tail.next=node;
        tail=node;
        tail.next = null;
    }
    
    public void display() {
       Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        RotateList list = new RotateList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.display();
        list.rotateByKTimes(2,list.head);
        list.display();

    }
}