package dsa.linkedlists;

public class SingleLinkedList {
    Node head;
    Node tail;
    int size;

    public SingleLinkedList() {
        this.size=0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        //if there are no elements
        size++;
        if(head == null) {
           head = tail =node;
           return;
        }
        node.next=head;
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if(head == null) {
            insertFirst(val);
            return;
        }
        size++;
        tail.next=node;
        tail=node;
    }

    public void insertAtIndex(int index, int val) {
        if(index>size) {
            System.out.println("element does not exists");
        }
        else if(index==0) {
          insertFirst(val);
        }
        else if(index==size) {
            Node node = new Node(val);
            tail.next = node;
            tail= node;
            size++;
        } else {
            Node temp = findByIndex(index-1);
            Node node = new Node(val);
            node.next= temp.next;
            temp.next = node;
            size++;
        }
        return;
    }

    public void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public Node findByIndex(int index) {
        if(index>size-1){
            System.out.println("there are no elements within the index");
        }
        else if(index ==0) {
           return head;
        }
        else if(index == size-1) {
            return tail;
        } else {
            Node temp = head.next;
            for(int i=1;i<index;i++) {
                temp = temp.next;
            }
            return temp;
        }
       return null;
    }

    public Node findByValue(int val) {
       if(head == null) {
           return null;
       } else if(head==tail){
           if(head.data == val) {
               return head;
           }
           return null;
       } else {
           Node temp = head;
           while(temp!=null) {
               if(temp.data == val) {
                   return temp;
               }
               temp =temp.next;
           }
       }
       return null;
    }

    public void deleteByIndex(int index) {
        if(head == null) {
            return;
        }
        if(index>size-1) {
            System.out.println("element does not exists");
        }
        else if(index==0) {
            head=head.next;
            size--;
            return;
        }
        else if(index==size-1) {
            Node temp = findByIndex(size-2);
            temp.next = null;
            tail= temp;
            size--;
        } else {
            Node temp = findByIndex(index-1);
            temp.next = temp.next.next;
            size--;
        }
        return;
    }

    private class Node {
        int data;
        Node next;

        public Node(int val) {
            this.data = val;
        }

        public Node(int val, Node next) {
            this.data=val;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.insertFirst(9);
        linkedList.insertFirst(8);
        linkedList.insertLast(10);
        linkedList.insertLast(11);
        linkedList.display();
        System.out.println();
        System.out.println("first element by index::" +linkedList.findByIndex(0).data);
        System.out.println("last element by index::" +linkedList.findByIndex(3).data);
        System.out.println("2nd index element by index::" +linkedList.findByIndex(2).data);
        System.out.println("value not present in index::" +linkedList.findByIndex(4));
        System.out.println("first element by value::" +linkedList.findByValue(8).data);
        System.out.println("last element by value::" +linkedList.findByValue(11).data);
        System.out.println("2nd index element by value::" +linkedList.findByValue(10).data);
        System.out.println("value not present in value::" +linkedList.findByValue(6));
        linkedList.insertLast(12);
        linkedList.insertLast(13);
        linkedList.insertLast(14);
        linkedList.insertLast(15);
        linkedList.display();
        linkedList.deleteByIndex(0);
        linkedList.display();
        linkedList.deleteByIndex(7);
        linkedList.display();
        linkedList.deleteByIndex(2);
        linkedList.display();
        System.out.println("inserting by indexes");
        linkedList.insertAtIndex(0, 7);
        linkedList.display();
        linkedList.insertAtIndex(1, 20);
        linkedList.display();
        linkedList.insertAtIndex(8, 25);
        linkedList.display();
        linkedList.insertAtIndex(10,46);
        linkedList.display();
    }
}
