package dsa.linkedlists;/*
Reverse linked list using recursion and inplace reversal
 */


public class ReverseLinkedList {
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

    public void reverseByRecursion(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverseByRecursion(node.next);
        tail.next = node;
        tail=node;
        tail.next = null;
    }

    public Node reverseInPlace(Node node) {
        Node prevNode = null;
        Node nextNode = head.next;
        Node currentNode  = head;
       while(currentNode!=null) {
           currentNode.next = prevNode;
           prevNode = currentNode;
           currentNode = nextNode;
           if(nextNode != null) {
               nextNode = nextNode.next;
           }
       }
       head = prevNode;
       return head;
    }
    public Node reverseKNodes(int k, Node head) {
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode = null;
        int count =0;
        while(count<k &&currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        if(nextNode!=null) {
            head.next = reverseKNodes(k,nextNode);
        }
        return prevNode;
    }

    public int length() {
        if(head == null) {
            return 0;
        } else if(head.next == null) {
            return 1;
        } else {
            Node temp = head;
            int count =1;
            while(temp!=null) {
                temp=temp.next;
                count++;
            }
            return count;
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
    public void display(Node node) {
       // Node temp=node;
        while(node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(6);
        ll.display();
//        ll.reverseByRecursion(ll.head);
//        ll.display();
    //    ll.reverseInPlace(ll.head);
      //  ll.display();
        Node node = ll.reverseKNodes(2,ll.head);
        ll.display(node);

    }
}