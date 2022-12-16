package dsa.linkedlists;/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 */

public class MergeTwoSortedLinkedLists {

    Node head;
    Node tail;
    int size=0;

    public void insertLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public static void display(Node node) {
        while(node!=null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedLists list1 = new MergeTwoSortedLinkedLists();
        MergeTwoSortedLinkedLists list2 = new MergeTwoSortedLinkedLists();
        list1.insertLast(1);
        list1.insertLast(5);
        list1.insertLast(9);
        list2.insertLast(3);
        list2.insertLast(6);
        list2.insertLast(8);
        list2.insertLast(10);
        list2.insertLast(12);
        Node head = mergeTwoSortedLinkedLists(list1, list2);
        display(head);
        
    }

    private static Node mergeTwoSortedLinkedLists(MergeTwoSortedLinkedLists list1, MergeTwoSortedLinkedLists list2) {
       Node first = list1.head;
       Node second = list2.head;
       MergeTwoSortedLinkedLists list = new MergeTwoSortedLinkedLists();
       while(first!= null && second!= null) {
           if(first.data > second.data) {
               list.insertLast(second.data);
               second = second.next;
           } else {
               list.insertLast(first.data);
               first = first.next;
           }
       }

       while(first != null) {
           list.insertLast(first.data);
           first = first.next;
       }
        while(second != null) {
            list.insertLast(second.data);
            second = second.next;
        }
        return list.head;
    }
}