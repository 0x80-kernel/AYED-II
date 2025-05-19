package E4;

// Interfaces para ConjuntoTDA y PilaTDA

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
