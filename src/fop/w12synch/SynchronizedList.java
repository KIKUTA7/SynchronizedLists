package fop.w12synch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedList<T> {
    private ReadWriteLock RWLock = new ReentrantReadWriteLock();
    private List<T> innerList = new LinkedList<>();
    private RW rw = new RW();
    public void add(int index, T e) throws InterruptedException {
        rw.startWrite();
        innerList.add(index, e);
        rw.endWrite();
    }

    public T remove(int index) throws InterruptedException {
        rw.startWrite();
        T rem = innerList.remove(index);
        rw.endWrite();
        return rem;
    }

    public T get(int index) throws InterruptedException {
        rw.startRead();
        T get = innerList.get(index);
        rw.endRead();
        return get;
    }

    public boolean contains(T e) throws InterruptedException {
        rw.startRead();
        boolean t = innerList.contains(e);
        rw.endRead();
        return t;
    }
}
