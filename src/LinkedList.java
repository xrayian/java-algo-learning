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

        if (first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);

        if (first == null)
            first = last = node;
        else {
            last.next = node;
            last = last.next;
        }
        size++;
    }

    public void deleteFirst() {
        if (first == null) return;

        var node = first.next;
        first.next = null;
        first = node;
        size--;
    }

    public void deleteLast() {
        if (first == null) return;

        var previousNode = findPreviousNode();
        previousNode.next = null;
        last = previousNode;
        size--;
    }

    public int indexOf(int item) {
        if (first == null) return -1;

        var node = first;
        int index = 0;
        while (node != null) {
            if (node.value == item) return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var convertedArray = new int[size];

        Node current = first;
        int index = 0;
        while (current != null) {

            convertedArray[index++] = current.value;
            current = current.next;
        }
        return convertedArray;
    }

    public void reverse() {
        if (first == null) return;

        Node previous = first;
        Node current = first.next;

        while (current != null) {
            if (previous == first) {
                last = previous;
                last.next = null;
            }
            if (current.next == null)
                first = current;

            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    private Node findPreviousNode() {
        var current = first;
        Node previousNode = null;

        while (current != null) {
            if (current.next == last) {
                previousNode = current;
                return previousNode;
            }
            current = current.next;
        }

        throw new NoSuchElementException();
    }

}
