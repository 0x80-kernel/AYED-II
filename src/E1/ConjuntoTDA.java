package E1;

// Interfaz base
public interface ConjuntoTDA {

	void initialize();
	void add(int x);
	void remove(int x);
	int choose();
	boolean contains(int x);
	boolean isEmpty();

}
