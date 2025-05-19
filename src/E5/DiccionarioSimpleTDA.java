package E5;

public class DiccionarioSimpleTDA implements IDiccionarioSimpleTDA {

	// Private
	private class KeyNode {
		int key;
		int value;
		KeyNode nextKey;

		// Constructor
		public KeyNode(int key, int value, KeyNode nextKey) {
			this.key = key;
			this.value = value;
			this.nextKey = nextKey;
		}

	}

	private KeyNode head;

	private KeyNode Key2KeyNode(int key) {
		// O(n) -> En el peor de los casos recorre toda la lista
		KeyNode aux = head;
		while (aux != null && aux.key != key) {
			aux = aux.nextKey;
		}
		return aux;
	}

	// Public
	public void initialize() {
		// O(1)
		head = null;
	}

	public void add(int key, int value) {
		// O(n) -> Se llama a Key2KeyNode()
		KeyNode kn = Key2KeyNode(key); // O(n)
		if (kn == null) { // Nuevo elemento
			kn = new KeyNode(key, value, head);
			head = kn;
		}
		kn.value = value;
	}

	public void remove(int key) {
		// O(n) -> En el peor de los casos recorre toda la lista
		if (head == null) {
			return;
		}
		// Si el diccionario tiene elementos
		if (head.key == key) { // Encuentro la clave
			head = head.nextKey;
		} else { // Busco en el resto de Claves
			KeyNode aux = head;
			while (aux.nextKey != null && aux.nextKey.key != key) {
				aux = aux.nextKey;
			}
			if (aux.nextKey != null) {
				aux.nextKey = aux.nextKey.nextKey;
			}
		}
	}

	public int recover(int key) {
		// O(n) -> Llama Key2KeyNode()
		KeyNode n = Key2KeyNode(key);
		if (n == null) {
			return -1;
		}
		return n.value;
	}

	public ConjuntoTDA keys() {
		// O(n²) -> Debido a ConjuntoTDA.add(), O(n) x O(n) = O(n²)
		ConjuntoTDA s = new ConjuntoTDA();
		s.initialize();
		if (head == null) {
			return s;
		}
		KeyNode aux = head;
		while (aux != null) { // O(n)
			s.add(aux.key); // O(n)
			aux = aux.nextKey;
		}
		return s;
	}

}
