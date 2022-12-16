package dsa.linkedlists;

/*
You are given a double Link List with one reference of each node pointing to the next node just like in a single link list. The second reference however can point to any node in the list and not just the previous node.Write a program in O(n) time which will create a copy of this list
 */
public class CloneDll {
    
    public static class Node {
        int data;
        Node random;
        Node next;
        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            Integer nextData = this.next!=null ? this.next.data : null;
            Integer randomData = this.random!=null ? this.random.data : null;
            return "Node{" +
                    "data=" + data +
                    ", random=" + randomData +
                    ", next=" + nextData +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        
        //3 points to 5
        head.random = head.next.next;
        
        //4 points to 3
        head.next.random = head;
        
        //5 and 6 points to 7
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;
        
        //7 points to 4
        head.next.next.next.next.random = head.next;
        createClonedLinkedList(head);
      
    }

    private static void createClonedLinkedList(Node head) {
        if(head == null) {
            return;
        }
        System.out.println("original list:: ");
        printRandomList(head);
        Node clone = new Node(-1);
        Node str = head;
        Node nextNode = head;
        Node dummy = clone;
        while(str!=null) {
            Node newNode = new Node(str.data);
            nextNode = str.next;
            newNode.random = str;
            dummy.next = newNode;
            dummy = dummy.next;
            str.next = dummy;
            str=nextNode;
        }
        clone = clone.next;
        Node temp = clone;
        while(temp!=null) {
            temp.random = temp.random.random.next;
            temp = temp.next;
        }
        System.out.println("Cloned list :: ");
        printRandomList(clone);
    }

    private static void printRandomList(Node temp) {
        if(temp == null) {
            return;
        }
        while(temp!=null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
}