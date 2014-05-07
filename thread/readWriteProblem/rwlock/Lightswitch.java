package thread.readWriteProblem.rwlock;

import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 07.05.2014.
 * class Lightswitch:
 * 2 def __init__(self):
 * 3 self.readerCounter = 0
 * 4 self.mutex = Semaphore(1)
 * 5
 * 6 def lock(self, semaphore):
 * 7 self.mutex.wait()
 * 8 self.readerCounter += 1
 * 9 if self.readerCounter == 1:
 * 10 semaphore.wait()
 * 11 self.mutex.signal()
 * 12
 * 13 def unlock(self, semaphore):
 * 14 self.mutex.wait()
 * 15 self.readerCounter -= 1
 * 16 if self.readerCounter == 0:
 * 17 semaphore.signal()
 * 18 self.mutex.signal()
 */
public class Lightswitch {
    volatile int counter;
    Semaphore mutex;

    public Lightswitch() {
        mutex = new Semaphore(1);
    }


}
