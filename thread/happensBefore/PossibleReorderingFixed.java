package thread.happensBefore;

/*
The Java Memory Model is specified in terms of actions, which include reads and writes to
variables, locks and unlocks of monitors, and starting and joining with threads. The JMM defines
a partial ordering [2] called happens-before on all actions within the program. To guarantee that
the thread executing action B can see the results of action A (whether or not A and B occur in
different threads), there must be a happens-before relationship between A and B. In the absence
of a happens-before ordering between two operations, the JVM is free to reorder them as it
pleases.

A data race occurs when a variable is read by more than one thread, and written by at least one
thread, but the reads and writes are not ordered by happens-before. A correctly synchronized
program is one with no data races; correctly synchronized programs exhibit sequential
consistency, meaning that all actions within the program appear to happen in a fixed, global
order.

How Can This Happen?
? Compiler can reorder statements
? Or keep values in registers
? Processor can reorder them
? On multi-processor, values not synchronized to
global memory
? The memory model is designed to allow
aggressive optimization
? including optimizations no one has implemented yet
? Good for performance
? bad for your intuition about insufficiently
synchronized code
The rules for happens-before are:
Program order rule. Each action in a thread happens-before every action in that
thread that comes later in the program order.

Monitor lock rule. An unlock on a monitor lock happens-before every subsequent
lock on that same monitor lock.[3]

Volatile variable rule. A write to a volatile field happens-before every subsequent
read of that same field.[4]

Thread start rule. A call to Thread.start on a thread happens-before every action in
the started thread.

Thread termination rule. Any action in a thread happens-before any other thread
detects that thread has terminated, either by successfully return from Thread.join or by

Thread.isAlive returning false.

Interruption rule. A thread calling interrupt on another thread happens-before the
interrupted thread detects the interrupt (either by having InterruptedException
tHRown, or invoking isInterrupted or interrupted).

Finalizer rule. The end of a constructor for an object happens-before the start of the
finalizer for that object.

Transitivity. If A happens-before B, and B happens-before C, then A happens-before C.

Memory Consistency Properties

Chapter 17 of The Java Language Specification defines the happens-before relation on memory operations such as reads
and writes of shared variables. The results of a write by one thread are guaranteed to be visible to a read by another
thread only if the write operation happens-before the read operation. The synchronized and volatile constructs, as well as the Thread.start() and Thread.join() methods, can form happens-before relationships. In particular:
Each action in a thread happens-before every action in that thread that comes later in the program's order.
An unlock (synchronized block or method exit) of a monitor happens-before every subsequent lock (synchronized block or
method entry) of that same monitor. And because the happens-before relation is transitive, all actions of a thread prior
to unlocking happen-before all actions subsequent to any thread locking that monitor.
A write to a volatile field happens-before every subsequent read of that same field. Writes and reads of volatile fields
have similar memory consistency effects as entering and exiting monitors, but do not entail mutual exclusion locking.
A call to start on a thread happens-before any action in the started thread.

All actions in a thread happen-before any other thread successfully returns from a join on that thread.
The methods of all classes in java.util.concurrent and its subpackages extend these guarantees to higher-level
synchronization. In particular:

Actions in a thread prior to placing an object into any concurrent collection happen-before actions subsequent to the
access or removal of that element from the collection in another thread.
Actions in a thread prior to the submission of a Runnable to an Executor happen-before its execution begins. Similarly
for Callables submitted to an ExecutorService.
Actions taken by the asynchronous computation represented by a Future happen-before actions subsequent to the retrieval
of the result via Future.get() in another thread.
Actions prior to "releasing" synchronizer methods such as Lock.unlock, Semaphore.release, and CountDownLatch.countDown
happen-before actions subsequent to a successful "acquiring" method such as Lock.lock, Semaphore.acquire, Condition.await,
 and CountDownLatch.await on the same synchronizer object in another thread.
For each pair of threads that successfully exchange objects via an Exchanger, actions prior to the exchange() in each
thread happen-before those subsequent to the corresponding exchange() in another thread.
Actions prior to calling CyclicBarrier.await and Phaser.awaitAdvance (as well as its variants) happen-before actions p
erformed by the barrier action, and actions performed by the barrier action happen-before actions subsequent to a
successful return from the corresponding await in other threads.
*/
public class PossibleReorderingFixed {
    static int x = 0, y = 0;
    static volatile boolean bool = false;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                if(bool)
                x =  1 /b; //guarantie b  will be 1
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                bool = true;
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("( " + x + "," + y + ")");
    }
}
