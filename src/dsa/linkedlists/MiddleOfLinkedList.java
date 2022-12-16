package dsa.linkedlists;//using fast and slow approach


public class MiddleOfLinkedList {
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

    public int findMiddleIndex() {
        Node fast = head;
        Node slow = head;
        int index=0;
        do {
            fast = fast.next.next;
            slow = slow.next;
            index++;
        }while(fast!=null && fast.next!=null);
        return index;
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
        while(--k>0)
            tempHead = tempHead.next;
        head = tempHead.next;
        tempHead.next = null;

    }

    public static void main(String[] args) {
        MiddleOfLinkedList ll = new MiddleOfLinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        System.out.println("middle index :: "+ll.findMiddleIndex());
        ll.insertLast(7);
        System.out.println("middle index :: "+ll.findMiddleIndex());
        ll.insertLast(8);
        System.out.println("middle index :: "+ll.findMiddleIndex());
    }
}