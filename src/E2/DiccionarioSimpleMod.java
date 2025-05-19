package E2;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

	// Private
	private class KeyNode {
		int key;
		int value;
		int mod = 0;
		KeyNode nextKey;

		// Constructor para nodos nuevos
		public KeyNode(int key, int value, KeyNode nextKey) {
			this(key, value, 0, nextKey); // mod se inicializa en 0 por defecto
		}

		// Constructor completo
		public KeyNode(int key, int value, int mod, KeyNode nextKey) {
			this.key = key;
			this.value = value;
			this.mod = mod;
			this.nextKey = nextKey;
		}

	}

	private KeyNode head;

	private KeyNode Key2KeyNode(int key) {
		// O(n) -> En el peor de los casos recorre toda la lista
		KeyNode aux = head;
		while (aux != null && aux.key != key) { // O(n)
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
		} else { // Elemento modificado, incremento en 1 el atributo mod
			kn.mod++;
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
			return;
		}
		// Busco en el resto de Claves
		KeyNode aux = head;
		while (aux.nextKey != null && aux.nextKey.key != key) { // O(n)
			aux = aux.nextKey;
		}
		if (aux.nextKey != null) {
			aux.nextKey = aux.nextKey.nextKey;
		}
	}

	public int recover(int key) {
		// O(n) -> Llama Key2KeyNode()
		KeyNode n = Key2KeyNode(key); // O(n)
		if (n == null) {
			return -1;
		}
		return n.value;
	}

	public int recoverMod(int key) {
		// O(n) -> Llama Key2KeyNode()
		KeyNode n = Key2KeyNode(key); // O(n)
		if (n == null) {
			return -1;
		}
		return n.mod;
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
