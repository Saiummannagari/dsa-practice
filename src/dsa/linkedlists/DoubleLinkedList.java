package dsa.linkedlists;

public class DoubleLinkedList {
    Node head;
    Node tail;
    int size=0;
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        size++;
        if(head == null) {
           head = tail = node;
           return;
        } else {
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            return;
        }
    }

    public void insertLast(int data) {
        Node node = new Node(data);
        size++;
        if(head == null) {
            head = tail = node;
            return;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
            return;
        }
    }

    public void insertByIndex(int index, int data) {
        if(index == 0) {
            insertFirst(data);
        } else if(index == size) {
            insertLast(data);
        } else if(index<size) {
            Node temp = getByIndex(index-1);
            Node temp2 = getByIndex(index);
            Node node = new Node(data);
            temp2.prev = node;
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
            size++;
        }
    }

    public Node getByIndex(int index) {
        Node temp = head;
        if(temp == null) {
            return null;
        }
        else if(index == 0) {
            return head;
        }
        else if(index == size-1) {
            return tail;
        } else if(index<size-1) {
            for(int i=1;i<=index;i++) {
                temp = temp.next;
            }
            return temp;
        }
        return null;
    }

    public Node getByValue(int value) {
       Node temp = head;
       if(temp == null) {
           return null;
       } else {
           while(temp!=null) {
               if(temp.data == value) {
                   return temp;
               }
               temp = temp.next;
           }
       }
       return null;
    }

    public void deleteFirst() {
        if(head == null) {
            return;
        } else {
            head = head.next;
            head.prev=null;
            size--;
        }
    }

    public void deleteLast() {
         if(head == null) {
             return;
         } else {
             tail = tail.prev;
             tail.next = null;
             size--;
         }
    }

    public void deleteByIndex(int index) {
        if(head == null) {
            return;
        } else if(index == 0) {
            deleteFirst();
        } else if(index ==  size-1) {
            deleteLast();
        } else if(index<size-1){
            Node temp = getByIndex(index-1);
            Node temp2= getByIndex(index+1);
            temp.next = temp2;
            temp2.prev = temp;
            size--;
        }

    }
    public void display() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayRev(){
        Node temp = tail;
        while(temp!=null) {
            System.out.print(temp.data+ " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertFirst(10);
        dll.insertFirst(8);
        dll.insertLast(15);
        dll.insertLast(20);
        dll.insertByIndex(2, 11);
        dll.insertByIndex(5, 9);
        dll.insertByIndex(0, 5);
        dll.display();
        System.out.println("element 5 ::" + dll.getByValue(5).data);
        System.out.println("element 5 ::" + dll.getByValue(9).data);
        System.out.println("element 5 ::" + dll.getByValue(11).data);
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteByIndex(2);
        dll.display();
        dll.displayRev();
    }
}