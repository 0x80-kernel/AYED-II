package E6;

/**
 * EJERCICIO
 * 
 * Se define un método que reciba un DiccionarioMultipleTDA (implementación con
 * estructura de datos dinámica) y devuelva una ColaTDA con todos los valores
 * del diccionario,
 * sin ninguna repetición.
 * 
 * ESTRATEGIA UTILIZADA
 * 
 * Cree el metodo nonRepeatedValues(), su funcion es pasar los elementos del
 * diccionario recibido a un ConjuntoTDA, ya que, no acepta duplicados,
 * despues inicializo una cola, encolo todos los valores del ConjuntoTDA y
 * devuelvo la ColaTDA sin elementos repetidos. El proceso de nonRepeatedValues
 * es iterar cada clave del diccionario, recorriendo todos sus valores.
 */

public class Main {

    public static void main(String[] args) {
        DiccionarioMultipleTDA dict = new DiccionarioMultipleTDA();
        dict.initialize();
        // Clave 4: 4, 5, 6
        addValues(dict, 4, new int[] { 4, 5, 6 });
        // Clave 6: 7, 5, 8, 9
        addValues(dict, 6, new int[] { 7, 5, 8, 9 });
        // Clave 9: 4, 8, 7, 5
        addValues(dict, 9, new int[] { 4, 8, 7, 5 });
        // Clave 8: 7, 4, 5, 9, 0, 4
        addValues(dict, 8, new int[] { 7, 4, 5, 9, 0, 4 });
        // Resultado esperado: 0 4 5 6 7 8 9
        ColaTDA result = nonRepeatedValues(dict);
        System.out.println("Valores no repetidos:");
        while (!result.isEmpty()) {
            System.out.print(result.first() + " ");
            result.dequeue();
        }
        System.out.println();
    }

    public static void addValues(DiccionarioMultipleTDA dict, int key, int[] values) {
        // O(n²) -> Para cada elemento del array llama a add() que tiene una complejidad
        // de O(n)
        for (int i = 0; i < values.length; i++) { // O(n)
            dict.add(key, values[i]); // O(n)
        }
    }

    public static ColaTDA nonRepeatedValues(DiccionarioMultipleTDA dict) {
        // O(n²) -> En el peor caso
        ConjuntoTDA uniqueValues = new ConjuntoTDA();
        uniqueValues.initialize();
        ConjuntoTDA keys = dict.keys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            ConjuntoTDA keyValues = dict.recover(key); // O(n)
            while (!keyValues.isEmpty()) {
                int value = keyValues.choose();
                uniqueValues.add(value);
                keyValues.remove(value);
            }
            keys.remove(key);
        }
        ColaTDA result = new ColaTDA();
        result.initialize();
        while (!uniqueValues.isEmpty()) { // O(n)
            int value = uniqueValues.choose();
            result.enqueue(value);
            uniqueValues.remove(value);
        }
        return result;
    }

}
