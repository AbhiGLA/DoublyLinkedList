package doubly;

public class DoublyLinkedList {
    private static class Node
    {
        private int data;
        private Node prev = null, next = null;
        public Node(int data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next =next;
        }
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


    private int size = 0;
    private Node head = null;
    private Node tail = null;


    @Override
    public String toString(){
        StringBuilder response = new StringBuilder();
        if(size == 0) {
            response.append("[]");
        } else {
        response.append("[ null <== ");

        Node temp = this.head;
        while(temp != null){
            response.append(temp.data);
            if(temp.next != null){
                response.append(" ==> ");
            }
            temp = temp.next;
        }

        response.append(" ==> null ]");
        }
        return response.toString();
    }

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if( head == null) {
            insertHead(data);
        } else {
            Node temp = head;
            while ( temp.next != null){
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private void insertHead(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public int delete() {
        int response = -1;
        if(head != null){
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            response = temp.data;
            temp = temp.prev;
            temp.next = null;
            size--;
        }
        return response;
    }

    private int removeHead() {
        int response = -1;
        if(head != null){
            response = head.data;
            Node temp = head.next;
            temp.prev = null;
            head = temp;
            size--;
        }
        return response;
    }

    /*public int removeAfter(Node node)
    {
        int response = -1;


        return response;
    }*/


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        System.out.println(doublyLinkedList);
        for (int i = 0; i < 5; i++) {
            doublyLinkedList.insert(i+1);
        }
        System.out.println(doublyLinkedList);
        int deleted = doublyLinkedList.delete();
        System.out.println(deleted + " was deleted");
        System.out.println(doublyLinkedList);
    }


}
