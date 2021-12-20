package fop.w12synch;

public class RW {
    private int countReaders = 0;
    public synchronized void startRead() throws InterruptedException {
        while (countReaders < 0)
         this.wait();
        countReaders++;
    }

    public synchronized void endRead() {
        countReaders--;
        if(countReaders == 0)
            this.notify();
    }

    public synchronized void startWrite() throws InterruptedException {
        while (countReaders != 0)
            this.wait();
        countReaders = -1;

    }

    public synchronized void endWrite() {
        countReaders = 0;
        notifyAll();
    }
}
