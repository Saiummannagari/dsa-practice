package dsa.linkedlists;/*
wap that returns a linked list alternating nodes(separating odd indexes at the end)
ex: 1 2 3 4 5
o/p: 1 3 5 4 5
 */



public class RotateAndAppendLinkedList {
    Node head;
    Node tail;
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = tail =node;
        }
        tail.next=node;
        tail=node;
    }

    public  Node reverse() {
       if(head == null) {
           return null;
       }
       if(head.next == null) {
           return head;
       }
       Node odd = head;
       Node even = head.next;
       Node evenFirst = even;
       while(1==1) {
           //for even length
           if(odd== null || even == null || even.next ==null) {
               odd.next = evenFirst;
               break;
           }
           odd.next = even.next;
           odd = odd.next;
           //for odd length
           if(odd.next == null) {
               even.next =null;
               odd.next = evenFirst;
               break;
           }
           even.next = odd.next;
           even = even.next;
       }
       return head;
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
        RotateAndAppendLinkedList ll = new RotateAndAppendLinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(6);
        ll.display();
        ll.reverse();
        ll.display();
    }
}