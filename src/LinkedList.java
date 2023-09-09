import java.util.NoSuchElementException;

public class LinkedList {

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;


    public void addFirst(int item) {
        var node = new Node(item);

        if(first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);

        if(first == null)
            first = last = node;
        else {
            last.next = node;
            last = last.next;
        }
        size++;
    }

    public void deleteFirst() {
        if(first == null) return;

        var node = first.next;
        first.next = null;
        first = node;
    }

    public void deleteLast() {
        if (first == null) return;
        var previousNode = findPreviousNode();
        previousNode.next = null;
        last = previousNode;
    }

    public boolean contains(int item) {
        if (first == null) return false;

        var node = first;
        while(node != null) {
            if (node.value == item) return true;
            node = node.next;
        }
        return false;
    }

    public int indexOf(int item) {
        if (first == null) return -1;

        var node = first;
        int index = 0;
        while(node != null) {
            if (node.value == item) return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    private Node findPreviousNode() {
        var node = first;
        Node previousNode = null;
        while(node != null) {
            if(node.next == last) {
                previousNode = node;
                return previousNode;
            }
            node = node.next;
        }

        throw new NoSuchElementException();
    }

}
