package E1;

/**
 * EJERCICIO
 *
 * Se define un nuevo TDA denominado ConjuntoEspecialTDA basado en
 * ConjuntoTDA, con la particularidad de que se permite más de una acepción de
 * cada elemento agregado. Tal cual como en ConjuntoTDA, no existe orden alguno.
 * Codificar la clase que implementa ConjuntoEspecialTDA, con representación dinamica.
 *
 * ESTRATEGIA UTILIZADA
 * 
 * Usando ConjuntoTDA como base, creo ConjuntoEspecialTDA y la subclase Node:
 * - data -> el valor que tiene el nodo
 * - next -> puntero al siguiente nodo
 * En el conjuntoTDA tengo que verificar si el valor que voy a añadir esta o no
 * en el conjunto, aca no hago esa verificacion para poder almacenar valores
 * duplicados
 */

public class Main {

    public static void main(String[] args) {
        ConjuntoEspecialTDA set = new ConjuntoEspecialTDA();
        set.initialize();
        // Entrada para el conjunto: {18,2,7,4,18,22,2,7}
        int[] testValues = { 18, 2, 7, 4, 18, 22, 2, 7 };
        // Añado los valores a testear
        for (int i = 0; i < testValues.length; i++) {
            set.add(testValues[i]);
        }
        // contains / pertenece
        System.out.println(set.contains(18)); // true
        System.out.println(set.contains(7)); // true
        System.out.println(set.contains(99)); // false
        System.out.println(set.printSet()); // 7 2 22 18 4 7 2 18
        // remove
        set.remove(18);
        set.remove(7);
        set.remove(2);
        set.remove(99);
        System.out.println(set.printSet()); // 22 4
        // add
        set.add(18);
        System.out.println(set.printSet()); // 18 22 4
    }

}
