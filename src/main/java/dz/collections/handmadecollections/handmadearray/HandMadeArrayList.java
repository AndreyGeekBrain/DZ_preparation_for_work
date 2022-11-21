package dz.collections.handmadecollections.handmadearray;
import dz.collections.handmadecollections.HandMadeList;
import java.util.Objects;

public class HandMadeArrayList <T>  implements HandMadeList {
    int capacity = 10;
    int size = 0;
    T[] t1 = (T[]) new Object[capacity];

    @Override
    public T get(int index) {
        if (index<0 || index>=capacity){
            throw new  IndexOutOfBoundsException();
        }else
            return t1[index];
    }


    @Override
    public void add(Object t) {
        if (capacity -1 <= size) {
            T[] t2 = (T[]) new Object[capacity*2];
            for (int i = 0; i <= size ; i++) {
                t2[i] = t1[i];
            }
            t1 = t2;
        }
        t1[size] = (T) t;
        size++;
    }

    @Override
    public boolean removeIndex(int index) {
        if (index<0 || index>=capacity){
            throw new  IndexOutOfBoundsException();
        }
        if (t1[index] == null){
            return false;
        }else {
            for (int i = index; i <= size; i++) {
                t1[index] = t1[index+1];
            }
            if (size !=0){
                size--;
            }
            return true;
        }
    }

    @Override
    public void clean() {
        t1=(T[]) new Object[capacity];
        size=0;
    }

    @Override
    public int size() {
        return size;
    }
}
