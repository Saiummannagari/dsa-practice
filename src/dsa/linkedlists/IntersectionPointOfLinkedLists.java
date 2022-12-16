package dsa.linkedlists;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.

Example:

List1:   3->5->7->9->10
List2:  8->7-9->10
Output: 7
 */
class scratch_1 {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /*function to get the intersection point of two linked
    lists head1 and head2 */
    int getNode()
    {
        int count1 = getCount(head1);
        int count2 = getCount(head2);
        int distance;

        if (count1 > count2) {
            distance = count1 - count2;
            return findIntersection(distance, head1, head2);
        }
        else {
            distance = count2 - count1;
            return findIntersection(distance, head2, head1);
        }
    }

    /* function to get the intersection point of two linked
     lists head1 and head2 where head1 has d more nodes than
     head2 */
    int findIntersection(int distance, Node node1, Node node2)
    {
        while(distance-- > 0) {
            node1=node1.next;
        }

        while(node1!=null && node2!=null) {
            if(node1.data == node2.data) {
                break;
            }
            node1=node1.next;
            node2=node2.next;
        }

        return node1.data;
        //write Your code here
        // return -1;
    }

    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(Node node)
    {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args)
    {
        scratch_1 list = new scratch_1();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.getNode());
    }
}

/*

    test_getIntersectionNode1():
      headA = ListNode(4)
      headB = ListNode(5)
      headA.next = ListNode(7)
      headA.next.next = ListNode(9)
      headB.next = ListNode(7)

      ob1 = new Main()
      actual = ob1.findIntersection(headA, headB)
      expected = 7


    test_getIntersectionNode2():
      headA = ListNode(4)
      headB = ListNode(5)
      headA.next = ListNode(7)
      headA.next.next = ListNode(9)
      headB.next = ListNode(17)
      headB.next.next = ListNode(18)

      ob1 = new Main()
      actual = ob1.findIntersection(headA, headB)
      expected = -1

*/