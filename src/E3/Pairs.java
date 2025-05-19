package E3;

public class Pairs implements PilaTDA {

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
    private int evenCount;

    // Helper
    private boolean isEven(int x) {
        // O(1)
        return x % 2 == 0;
    }

    // Public
    public void initialize() {
        // O(1)
        first = null;
        evenCount = 0;
    }

    public void push(int x) {
        // O(1)
        Node n = new Node(x, first);
        first = n;
        if (isEven(x)) {
            evenCount++;
        }
    }

    public void pop() {
        // O(1)
        if (isEmpty()) {
            return;
        }
        if (isEven(first.data)) {
            evenCount--;
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

    public int numberOfPairs() {
        // O(1)
        return evenCount;
    }

}
