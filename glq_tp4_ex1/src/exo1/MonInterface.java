package exo1;

public interface MonInterface extends Iterable<String> {
    void methode1() throws Exception;
    int methode2();
    int methode3(int i) throws Exception;
    int methode4(int i, Object o);
    int methode5(int i, String s, Object o);
}