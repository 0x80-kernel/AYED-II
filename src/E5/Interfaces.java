package E5;

// Interfaces para ConjuntoTDA, PilaTDA y DiccionarioSimpleTDA

interface IPilaTDA {

    void initialize();
    void push(int x);
    void pop();
    boolean isEmpty();
    int top();

}

interface IConjuntoTDA {

    void initialize();
    void add(int x);
    void remove(int x);
    int choose();
    boolean contains(int x);
    boolean isEmpty();

}

interface IDiccionarioSimpleTDA {

    public void initialize();
    public void add(int key, int value);
    public void remove(int key);
    public int recover(int key);
    public ConjuntoTDA keys();

}
