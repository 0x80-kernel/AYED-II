package E2;

/**
 * EJERCICIO
 *
 * Se define un nuevo TDA denominado DiccionarioSimpleModTDA basado en
 * DiccionarioSimpleTDA, con la particularidad de registrar la cantidad de veces
 * que el valor se ve modificado. Codificar la clase que implementa
 * DiccionarioSimpleModTDA, con representación dinámica.
 *
 * ESTRATEGIA UTILIZADA
 * 
 * La mejor forma que se me ocurrio de añadir un contador de seguimiento de
 * modificaciones de claves es usando un atributo mod en cada nodo que se inicializa
 * en 0 si el nodo es nuevo y si se modifica uno ya existente actualiza el atributo.
 * Asi, sigo las modificaciones en tiempo real.
 */

public class Main {

    public static void main(String[] args) {
        DiccionarioSimpleMod dict = new DiccionarioSimpleMod();
        // (7,3), (16,4), (3,4), (16,2), (3,6), (5,3)
        int[] testValuesPairs = { 7, 3, 16, 4, 3, 4, 16, 2, 3, 6, 5, 3 };
        if (testValuesPairs.length % 2 != 0) {
            return;
        }
        for (int i = 0; i < testValuesPairs.length; i += 2) {
            dict.add(testValuesPairs[i], testValuesPairs[i + 1]);
        }
        ConjuntoTDA keys = dict.keys();
        System.out.println(keys.contains(2)); // false
        System.out.println(keys.contains(3)); // true
        System.out.println(keys.contains(99)); // false
        System.out.println(dict.recoverMod(3)); // 1
        System.out.println(dict.recoverMod(7)); // 0
        System.out.println(dict.recoverMod(16)); // 1
        System.out.println(dict.recover(3)); // 6
    }

}
