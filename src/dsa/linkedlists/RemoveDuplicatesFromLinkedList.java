package dsa.linkedlists;/* Remove duplicates from sorted linked list */


public class RemoveDuplicatesFromLinkedList {

    Node head;
    Node tail;
    int size=0;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

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

    public void removeDuplicates(Node node) {
        while(node!=null && node.next!=null) {
            if(node.data != node.next.data) {
               node = node.next;
            } else {
                node.next = node.next.next;
            }
        }
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
        RemoveDuplicatesFromLinkedList remove = new RemoveDuplicatesFromLinkedList();
        remove.insertLast(1);
        remove.insertLast(1);
        remove.insertLast(2);
        remove.insertLast(3);
        remove.insertLast(3);
        remove.insertLast(3);
        remove.insertLast(4);
        remove.insertLast(5);
        remove.insertLast(5);
        remove.insertLast(5);
        remove.insertLast(5);
        remove.display();
        remove.removeDuplicates(remove.head);
        remove.display();


    }
}