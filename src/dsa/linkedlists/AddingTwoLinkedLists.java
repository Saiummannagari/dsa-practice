package dsa.linkedlists;

import java.util.concurrent.atomic.AtomicInteger;

public class AddingTwoLinkedLists {

    Node head1,head2;
     static class  Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    static int findLength(Node head) {
        int count =1;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }

    static void  findSum(Node fhead, Node shead) {
        if(fhead == null) {
            return;
        }
        if(shead == null) {
            return;
        }
        int rem=0;
        AtomicInteger count1 = new AtomicInteger(0);
        AtomicInteger count2 = new AtomicInteger(0);
        fhead = reverse(fhead,count1);
        shead = reverse(shead,count2);
        Node res=null;
        Node temp=null;
        int carry =0;
        int sum =0;
        Node current = null;
        while(fhead!=null || shead!=null) {
            sum = carry + (fhead!=null ? fhead.data : 0) + (shead!=null ? shead.data : 0);
            carry = sum/10;
            sum = sum%10;
            temp = new Node(sum);
            if(res==null) {
                res=temp;
                current = res;
            } else {
                current.next = temp;
                current=temp;
            }
            if(fhead!=null) {
                fhead = fhead.next;
            }
            if(shead!=null) {
                shead = shead.next;
            }
        }

        while(carry>0) {
            rem = carry%10;
            carry=carry/10;
            temp = new Node(rem);
            current.next = temp;
        }
          Node finalres = reverse(res, new AtomicInteger(0));
          display(finalres);

    }

    public static void display(Node res) {
        Node temp=res;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node reverse(Node temp, AtomicInteger count) {
        int length =0;
        Node nextNode=null;
        Node prev=null;
        Node curr=temp;
      
        while(curr!=null) {
            nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            length++;
        }
        count.set(length);
        return prev;
    }

    public static void main(String[] args) {
        AddingTwoLinkedLists ll = new AddingTwoLinkedLists();
        ll.head1 = new Node(9);
        ll.head1.next = new Node(9);
        ll.head1.next.next = new Node(1);
//        ll.head1.next.next.next = new Node(8);
//        ll.head1.next.next.next.next = new Node(9);

        ll.head2 = new Node(9);
        ll.head2.next = new Node(1);
     //p   ll.head2.next.next = new Node(7);
        findSum(ll.head1, ll.head2);
    }
}