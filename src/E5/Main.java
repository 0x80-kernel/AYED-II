package E5;

/**
 * EJERCICIO
 * 
 * Se define un método que reciba una PilaTDA y devuelva un DiccionarioSimpleTDA,
 * en el cual se guardarán los elementos de la pila como claves, y la cantidad
 * de apariciones de dicho elemento en la pila, como valores.
 * 
 * ESTRATEGIA UTILIZADA
 * 
 * Hice la funcion apparitions(Pila TDA p) que crea un DiccionarioSimpleTDA,
 * recorro la pila usando top() y pop(), para cada elemento compruebo si ya
 * esta en el diccionario con recover() (que retorna -1 si el elemento
 * no existe), si el elemento no existe se agrega con 1, sino, se
 * incrementa su valor en 1. A la vez cada elemento extraido se almacena en
 * la pila auxiliar, al terminar de recorrer la pila original, re establesco
 * los elementos de la misma usando la pila auxiliar.
 */

public class Main {

    public static void main(String[] args) {
        // Entrada para la Pila: <4,3,6,6,6,7,8,4>
        PilaTDA p = new PilaTDA();
        p.initialize();
        int[] testValues = { 4, 3, 6, 6, 6, 7, 8, 4 };
        for (int i = 0; i < testValues.length; i++) {
            p.push(testValues[i]);
        }
        DiccionarioSimpleTDA amountApparitions = apparitions(p);
        System.out.println(amountApparitions);
        System.out.println(apparitions(p).recover(3));
        System.out.println(apparitions(p).recover(6));
        System.out.println(apparitions(p).recover(4));
        System.out.println(apparitions(p).recover(7));
    }

    public static DiccionarioSimpleTDA apparitions(PilaTDA p) {
        // O(n²)
        // La pila esta vacia
        if (p.isEmpty()) {
            DiccionarioSimpleTDA emptyDict = new DiccionarioSimpleTDA();
            emptyDict.initialize();
            return emptyDict;
        }
        DiccionarioSimpleTDA dict = new DiccionarioSimpleTDA();
        dict.initialize();
        PilaTDA aux = new PilaTDA();
        aux.initialize();
        // Procesa la pila original, guardando temporalmente en aux
        while (!p.isEmpty()) {
            int element = p.top();
            int currentValue = dict.recover(element); // O(n)
            if (currentValue == -1) { // La clave no existe
                dict.add(element, 1);
            } else {
                dict.add(element, currentValue + 1);
            }
            aux.push(element);
            p.pop();
        }
        // Restaura la pila original
        while (!aux.isEmpty()) { // O(n)
            p.push(aux.top());
            aux.pop();
        }
        return dict;
    }

}
