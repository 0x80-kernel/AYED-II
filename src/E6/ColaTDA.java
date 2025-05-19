package E6;

public class ColaTDA implements IColaTDA {

    // Private
    private int[] array;
    private int i;

    // Public
    public void initialize() {
        // O(1) -> Operacion constante
        array = new int[64];
        i = 0;
    }

    public void enqueue(int x) {
        // O(1) -> Operacion constante
        array[i] = x;
        i++;
    }

    public void dequeue() {
        // O(n) -> Recorre todos los elementos
        if (i == 0) {
            return;
        }
        for (int j = 0; j < i - 1; j++) { // O(n)
            array[j] = array[j + 1];
        }
        i--;
    }

    public int first() {
        // O(1) -> Operacion constante
        return array[0];
    }

    public boolean isEmpty() {
        // O(1) -> Operacion constante
        return i == 0;
    }

}
