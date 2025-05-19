package E4;

/**
 * EJERCICIO
 *
 * Se define un método que reciba una PilaTDA y devuelva un ConjuntoTDA con los
 * elementos repetidos de la pila.
 *
 * ESTRATEGIA UTILIZADA
 * 
 * Primero, uso estructuras auxiliares:
 * Pila aux -> para preservar la pila original
 * Conjunto seen -> para registrar elementos ya vistos
 * Conjunto repeated -> para almacenar elementos repetidos
 * Recorro la pila original, vaciandola temporalmente, por cada elemento
 * extraido:
 * Si ya esta en "seen" se agrega al conjunto "repeated", sino, a "seen",
 * mientras almaceno cada elemento original en una pila auxiliar para
 * restaurar la original.
 */

public class Main {

    public static void main(String[] args) {
        PilaTDA p = new PilaTDA();
        p.initialize();
        // Entrada para la Pila: <3,3,6,2,6,7,8,4>
        int[] testValues = { 4, 8, 7, 6, 2, 6, 3, 3 }; // Orden invertido para la pila
        for (int i = 0; i < testValues.length; i++) {
            p.push(testValues[i]);
        }
        System.out.println("Contenido de la pila (desde el tope):");
        printPila(p);
        ConjuntoTDA repeatedElems = findRepeatedElements(p);
        System.out.println("Elementos repetidos:");
        printConjunto(repeatedElems);
    }

    // Metodo que imprime una pila
    public static void printPila(PilaTDA p) {
        // O(n²) -> Lineal
        if (p.isEmpty()) {
            return;
        }
        PilaTDA aux = new PilaTDA();
        aux.initialize();
        // Copiar y mostrar elementos
        while (!p.isEmpty()) { // O(n)
            int value = p.top();
            System.out.print(value + " ");
            p.pop();
            aux.push(value);
        }
        // Restaurar
        while (!aux.isEmpty()) { // O(n)
            p.push(aux.top());
            aux.pop();
        }
        System.out.println();
    }

    // Metodo que imprime un conjunto
    public static void printConjunto(ConjuntoTDA s) {
        // O(n²) -> Lineal, siempre itera por todo el conjunto dos veces
        if (s.isEmpty()) {
            return;
        }
        ConjuntoTDA auxSet = new ConjuntoTDA();
        auxSet.initialize();
        while (!s.isEmpty()) { // O(n)
            int elem = s.choose();
            System.out.print(elem + " ");
            s.remove(elem);
            auxSet.add(elem);
        }
        // Restaurar conjunto original
        while (!auxSet.isEmpty()) { // O(n)
            int elem = auxSet.choose();
            s.add(elem);
            auxSet.remove(elem);
        }
        System.out.println();
    }

    public static ConjuntoTDA findRepeatedElements(PilaTDA p) {
        // Inicializacion de estructuras auxiliares
        PilaTDA aux = new PilaTDA();
        ConjuntoTDA seen = new ConjuntoTDA();
        ConjuntoTDA repeated = new ConjuntoTDA();
        aux.initialize();
        seen.initialize();
        repeated.initialize();
        // Desapilo los elementos de la pila original y los copio en una auxiliar
        while (!p.isEmpty()) {
            int num = p.top();
            p.pop();
            aux.push(num);
            // Si el numero ya fue visto lo agrego al conjunto de repetidos
            if (seen.contains(num)) {
                repeated.add(num);
            } else {
                // Si es la primera vez que lo veo lo agrego al conjunto de vistos
                seen.add(num);
            }
        }
        // Restauro la pila original usando la auxiliar
        while (!aux.isEmpty()) {
            p.push(aux.top());
            aux.pop();
        }
        return repeated;
    }

}