package dsa.linkedlists;

//find if there is a cycle in linked list and also find length of circular linked list
// and also find the index where the cycle starts
public class FindCycleAndCycleLengthInLinkedList {
    Node head;
    Node tail;
    int size;

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

    public void insertCircularAtIndex(int index) {
        if(head == null || index >= size-1) {
            System.out.println("cannot point to the index");
        } else {
            Node temp = getNode(index);
            tail.next = temp;
        }
    }

    public int findIndexWhereCycleStarts() {
        int length = 0;
        int cycleLength = circularLinkedListLength()-1;
        Node temp=head, temp2 = head;
        do {
            temp = temp.next;
            length++;
        } while(length < cycleLength);
        int count =0;
        while(temp2 != temp) {
            temp2=temp2.next;
            temp=temp.next;
            count ++;
        }
        return count;
    }

    public int circularLinkedListLength() {
        if(head != null) {
            Node fast = head;
            Node slow = head;
            while(fast!=null && slow!=null) {
                fast = fast.next.next;
                slow = slow.next;
                /* another approach */
//                if(slow == fast) {
//                    int count=2;
//                    slow = slow.next;
//                    while(slow!=fast) {
//                        slow=slow.next;
//                        count++;
//                    }
//                    return count;
//                }
                if(slow == fast) {
                    Node temp =slow;
                    int length = 1;
                    do {
                        temp= temp.next;
                        length++;
                    } while(temp!=slow);
                    return length;
                }
            }
        }
        return -1;
    }

    public Node getNode(int index) {
        Node temp = head;
        int current = 1;
        while(temp!= null && current <=index) {
            temp = temp.next;
            current++;
        }
        return temp;
    }

    public boolean isCircular() {
        if (head != null) {
            Node fast = head;
            Node slow = head;

            while(fast!= null && slow!=null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        FindCycleAndCycleLengthInLinkedList ll = new FindCycleAndCycleLengthInLinkedList();
        //create a circular linked list
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(6);
        ll.insertCircularAtIndex(3);
        System.out.println("cycle starts at :: " +ll.findIndexWhereCycleStarts());
        System.out.println("The linked list is circular(yes/no) ? :: "+ ll.isCircular());
        System.out.println("length of circular linked list :: " + ll.circularLinkedListLength());
    }
}