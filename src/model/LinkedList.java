package model;

public class LinkedList <T> {
    private Node<T> head;
    private int size;
    
    public LinkedList() {
        this.head=null;
        this.size=0;
    
    }

    public void appendToTail(T value){
       if (head == null) {
        head = new Node<>(value);
        size++;
        return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<>(value));
        size++;

    }
    public T findByValue(T value){
        if (head==null) {
            return null;
        }
        Node<T> current=head;
        while (current.getNext()!=null) {
            if (current.getValue().equals(value)) {
                return current.getValue();
            }
            current=current.getNext();
        }
        return null;
    }
    public void deleteNode(T value) {
        if (head == null)
            return;

        if (head.getValue().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }
    public void print() {
        if (head == null) {
            System.out.println("END");
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getValue()+ " -> END");
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
