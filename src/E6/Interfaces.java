package E6;

// Interfaces para ColaTDA, ConjuntoTDA y DiccionarioMultipleTDA
// Las puse aca para centralizar las interfaces en un solo archivo,
// es mas simple

interface IColaTDA {

    void initialize();
    void enqueue(int x);
    void dequeue();
    int first();
    boolean isEmpty();

}

interface IConjuntoTDA {

    void initialize();
    void add(int x);
    void remove(int x);
    int choose();
    boolean contains(int x);
    boolean isEmpty();

}

interface IDiccionarioMultipleTDA {

    void initialize();
    void add(int key, int value);
    void removeValue(int key, int value);
    void remove(int key);
    ConjuntoTDA recover(int key);
    ConjuntoTDA keys();

}
