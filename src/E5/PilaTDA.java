package E5;

public class PilaTDA implements IPilaTDA {

    // Private
    private class Node {
        int data;
        Node next;

        // Constructor
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first;

    // Public
    public void initialize() {
        // O(1)
        first = null;
    }

    public void push(int x) {
        // O(1)
        Node n = new Node(x, first);
        first = n;
    }

    public void pop() {
        // O(1)
        if (isEmpty()) {
            return;
        }
        first = first.next;
    }

    public boolean isEmpty() {
        // O(1)
        return first == null;
    }

    public int top() {
        // O(1)
        return first.data;
    }

}
