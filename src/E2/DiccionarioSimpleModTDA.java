package E2;

public interface DiccionarioSimpleModTDA {

    public void initialize();
    public void add(int key, int value);
    public void remove(int key);
    public int recover(int key);
    public int recoverMod(int key);
    public ConjuntoTDA keys();

}
