package E3;

/**
 * EJERCICIO
 *
 * Se define un método que reciba una PilaTDA y devuelva un int (número entero)
 * con la cantidad de elementos pares de la pila. Codificar la clase que implementa
 * PilaTDA, con representación dinámica.
 *
 * ESTRATEGIA UTILIZADA
 * 
 * La forma mas optimizada que encontre de resolver el contador de numeros pares
 * de la pila fue inicializando la variable evenCount con la inicializacion de la
 * pila y ir verificando si el numero es par cuando se añade o borra un elemento
 * de la pila. Ademas al necesitar hacer la comprobacion numero % 2 == 0 mas de
 * una vez hice un metodo auxiliar que comprueba si el numero es o no par.
 * 
 * push(int x) -> Ademas de apilar el elemento, si este es par, incrementa
 * evenCount.
 * pop() -> Ademas de desapilar el elemento, si este es par, decrementa
 * evenCount.
 */

public class Main {

    public static void main(String[] args) {
        // Entrada para la pila: <3,4,6,2,45,7,8>
        int[] testValues = { 3, 4, 6, 2, 45, 7, 8 };
        Pairs p = new Pairs();
        p.initialize();
        System.out.println(p.numberOfPairs());
        for (int i = 0; i < testValues.length; i++) {
            p.push(testValues[i]);
        }
        System.out.println(p.numberOfPairs());
    }

}
