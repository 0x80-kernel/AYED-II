package E5;

public class ConjuntoTDA implements IConjuntoTDA {

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

    private Node head;

    // Public
    public void initialize() {
        // O(1) -> Operacion constante
        head = null;
    }

    public void add(int x) {
        // O(n) -> Debido a contains()
        if (!this.contains(x)) { // O(n) -> En el peor de los casos recorre toda la lista
            Node newNode = new Node(x, head);
            head = newNode;
        }
    }

    public void remove(int x) {
        // O(n) -> En el peor caso (recorre toda la lista enlazada)
        if (head == null) {
            return;
        }
        if (head.data == x) {
            head = head.next;
        } else {
            Node aux = head;
            while (aux.next != null && aux.next.data != x) { // O(n)
                aux = aux.next;
            }
            if (aux.next != null) {
                aux.next = aux.next.next;
            }
        }
    }

    public int choose() {
        // O(1) -> Acceso directo al primer nodo
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public boolean contains(int x) {
        // O(n) -> En el peor caso recorre toda la lista enlazada
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current != null) { // O(n)
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        // O(1) -> Operacion constante
        return head == null;
    }

}
