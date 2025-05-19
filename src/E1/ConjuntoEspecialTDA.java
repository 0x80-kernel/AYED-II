package E1;

public class ConjuntoEspecialTDA implements ConjuntoTDA {

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
        // O(1) -> Operacion constante
        head = new Node(x, head);
    }

    public void remove(int x) {
        // O(n) -> Recorre toda la lista enlazada
        // Conjunto vacio
        if (isEmpty()) {
            return;
        }
        // Elimina valores consecutivos al inicio
        while (!isEmpty() && head.data == x) {
            head = head.next;
        }
        if (isEmpty()) {
            return;
        }
        // Elimina ocurrencias en el resto de la lista
        Node current = head;
        while (current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next;
            } else {
                current = current.next;
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
        // O(n) -> En el peor caso (recorre toda la lista enlazada)
        if (isEmpty()) {
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
        // O(1)
        return head == null;
    }

    public String printSet() {
        // O(n) Recorre todos los nodos para construir el string
        if (isEmpty()) {
            return "";
        }
        Node current = head;
        String str = "";
        while (current != null) { // O(n)
            str += current.data + " ";
            current = current.next;
        }
        return str;
    }

}
