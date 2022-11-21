package dz.collections.handmadecollections;

public interface HandMadeList <T> {
    T get (int index);
    void add (T t);
    boolean removeIndex (int index);
    void clean ();
    int size();
}
