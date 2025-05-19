package E6;

public class DiccionarioMultipleTDA implements IDiccionarioMultipleTDA {

    // Private
    private class KeyNode {
        int key;
        ValueNode values;
        KeyNode nextKey;

        // Constructor
        public KeyNode(int key, ValueNode values, KeyNode nextKey) {
            this.key = key;
            this.values = values;
            this.nextKey = nextKey;
        }
    }

    private class ValueNode {
        int value;
        ValueNode nextValue;

        // Constructor
        public ValueNode(int value, ValueNode nextValue) {
            this.value = value;
            this.nextValue = nextValue;
        }
    }

    private KeyNode start;

    // Funciones de ayuda para no repetir codigo
    // Busca un KeyNode, si lo encuentra lo devuelve, sino, devuelve null
    private KeyNode findKeyNode(int key) {
        // O(n) -> En el peor de los casos recorre todos los elementos
        KeyNode aux = start;
        while (aux != null && aux.key != key) {
            aux = aux.nextKey;
        }
        return aux;
    }

    // Elimina un valor de un nodo
    private void removeValueFromNode(KeyNode n, int value) {
        // O(n) -> En el peor de los casos recorre todos los elementos del Nodo
        // KeyNode sin valores
        if (n.values == null) {
            return;
        }
        // El valor buscado es el primero
        if (n.values.value == value) {
            n.values = n.values.nextValue;
            return;
        }
        // Seguimos buscando
        ValueNode aux = n.values;
        while (aux.nextValue != null && aux.nextValue.value != value) {
            aux = aux.nextValue;
        }
        if (aux.nextValue != null) {
            aux.nextValue = aux.nextValue.nextValue;
        }
    }

    // Public
    public void initialize() {
        // O(1) -> Operacion constante
        start = null;
    }

    public void add(int key, int value) {
        // O(n) -> En el peor de los casos recorre todas las claves y valores de una
        // clave
        KeyNode kn = findKeyNode(key);
        if (kn == null) { // La clave no existe, hay que crearla
            kn = new KeyNode(key, null, start);
            start = kn;
            return;
        }
        // Si existe, verificamos valores existentes, solo se añade si no es un valor
        // existente
        ValueNode aux = kn.values;
        while (aux != null) {
            if (aux.value == value) {
                return;
            }
            aux = aux.nextValue;
        }
        kn.values = new ValueNode(value, kn.values);
    }

    public void removeValue(int key, int value) {
        // O(n) -> en el peor de los casos recorre todas las claves y todos los
        // valores de una clave
        // Dict vacio
        if (start == null) {
            return;
        }
        // El valor buscado es el primero
        if (start.key == key) {
            removeValueFromNode(start, value);
            if (start.values == null) {
                start = start.nextKey;
            }
            return;
        }
        // Se sigue buscando
        KeyNode aux = start;
        while (aux.nextKey != null && aux.nextKey.key != key) {
            aux = aux.nextKey;
        }
        if (aux.nextKey != null) {
            removeValueFromNode(aux.nextKey, value);
            if (aux.nextKey.values == null) {
                aux.nextKey = aux.nextKey.nextKey;
            }
        }
    }

    public void remove(int key) {
        // O(n) -> En el peor de los casos recorremos todas las claves
        // Dict vacio
        if (start == null) {
            return;
        }
        // La clave buscada es la primera en el Dict
        if (start.key == key) {
            start = start.nextKey;
            return;
        }
        // Se sigue buscando
        KeyNode aux = start;
        while (aux.nextKey != null && aux.nextKey.key != key) {
            aux = aux.nextKey;
        }
        if (aux.nextKey != null) {
            aux.nextKey = aux.nextKey.nextKey;
        }
    }

    public ConjuntoTDA recover(int key) {
        // O(n) -> En el peor caso recorremos todas las claves y todos los valores
        // de la clave encontrada
        ConjuntoTDA s = new ConjuntoTDA();
        s.initialize();
        KeyNode kn = findKeyNode(key);
        if (kn == null) {
            return s;
        }
        if (kn != null) {
            ValueNode aux = kn.values;
            while (aux != null) {
                s.add(aux.value);
                aux = aux.nextValue;
            }
        }
        return s;
    }

    public ConjuntoTDA keys() {
        // O(n) -> Lineal respecto al numero de claves
        ConjuntoTDA s = new ConjuntoTDA();
        s.initialize();
        KeyNode aux = start;
        while (aux != null) {
            s.add(aux.key);
            aux = aux.nextKey;
        }
        return s;
    }

}