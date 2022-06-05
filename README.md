As you may find in the Documentation, LinkedLists in Java are not thread-safe. In this assignment you therefore should implementa a class SynchonizedList which allows multiple threads to operate on the same shared list.

First execute the main method from the template multiple times without synchronization. Discuss the observed results.

Now synchronize all accesses by means of synchronized. Execute again the main method. Discuss why the program now is significantly slower.

Finally, synchronize by means of a read-write lock. For that, implement the corresponding class RW with the methods startRead(), stopRead(), startWrite() and stopWrite() as in the lecture.
The lock is meant to guarantee that several reading threads may concurrently access, while only a single writing access is permitted.
Take care that your implementation is free of race conditions or deadlocks. Subsequently, execute the main method again and argue why the program now is much faster.
