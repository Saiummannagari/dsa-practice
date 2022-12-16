package dsa.linkedlists;/*Rearrange a Single Linked List in Time Complexity O(n) and Space Complexity O(1) such one node selected from start next node from end Asked in : Amazon, Google

        Example:

        Input : [1->2->3->4->5]
        Rearrange the Input linkedList in the below format
        Output : [1->5->2->4->3]

 */

public class RearrangeLinkedList {

    Node head;
    Node tail;
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = tail = node;
            head.next = null;
        } else {
            tail.next = node;
            tail=node;
        }
    }

    public void display() {
        Node temp = head;
        while(temp!= null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int middle() {
        if (head == null || head.next == null) {
            return 0;
        } else {
            int middle = 1;
            Node slow = head;
            Node fast = head;
            Node prev = null;
            while(slow!=null && fast!=null) {
                prev = slow;
                slow = slow.next;
                if(fast.next != null){
                    fast = fast.next.next;
                } else {
                    break;
                }
                middle++;
            }
            Node shead =slow;
            prev.next = null;
            Node thead = reverse(shead);
            rearrange(head, thead);
            display();
            return middle;
        }
    }

    public void rearrange(Node fhead, Node shead) {
        Node head = fhead;
        Node fnext =fhead.next;
        Node snext =shead.next;
        while(fhead!=null && shead!=null) {
            fhead.next = shead;
            shead.next = fnext;
            fhead = fnext;
            shead = snext;
            if(fnext!=null) {
                fnext = fnext.next;
            } if(snext!=null) {
                snext = snext.next;
            }
        }
        head = fhead;
    }

   public Node reverse(Node secondHead) {
        Node prev = null;
        Node curr = secondHead;
        Node next = null;
        while(curr!= null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
   }

    public static void main(String[] args) {
        RearrangeLinkedList ll = new RearrangeLinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
  //      ll.insert(6);
        ll.display();
        ll.middle();
        ll.display();
    }
}