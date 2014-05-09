package thread.smokersProblem;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 08.05.2014.
 * Four threads are involved: an agent and three smokers. The smokers loop
 * forever, first waiting for ingredients, then making and smoking cigarettes. The
 * ingredients are tobacco, paper, and matches.
 * We assume that the agent has an infinite supply of all three ingredients, and
 * each smoker has an infinite supply of one of the ingredients; that is, one smoker
 * has matches, another has paper, and the third has tobacco.
 * The agent repeatedly chooses two different ingredients at random and makes
 * them available to the smokers. Depending on which ingredients are chosen, the
 * smoker with the complementary ingredient should pick up both resources and
 * proceed.
 * For example, if the agent puts out tobacco and paper, the smoker with the
 * matches should pick up both ingredients, make a cigarette, and then signal the
 * agent.
 */
public class SmokersWorldDeadlock {
    //    final Semaphore[] tobacco = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] paper = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] matches = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] agentsSupply = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
    final Semaphore tobacco = new Semaphore(0);
    final Semaphore paper = new Semaphore(0);
    final Semaphore matches = new Semaphore(0);
    final Semaphore agentSem = new Semaphore(1);
    final Semaphore[] agentsSupply = {tobacco, paper, matches};


    public static void main(String[] args) {
        final SmokersWorldDeadlock obj = new SmokersWorldDeadlock();
        Runnable agent = () -> {
            Random randomGenerator = new Random();
            while (true) {
                try {
                    obj.agentSem.acquire();
                    int k = randomGenerator.nextInt(3);
                    System.out.println("k=" + k);
                    for (int i = 0; i < 3; i++) {
                        if (i != k) obj.agentsSupply[i].release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable smokerMatches = () -> {
            while (true) {
                try {
                    obj.tobacco.acquire();
                    System.out.println("tobacco got");
                    obj.paper.acquire();
                    System.out.println("paper got");
                    System.out.println("have matches smokes");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.agentSem.release();
                }
            }
        };
        Runnable smokerTobacco = () -> {
            while (true) {
                try {
                    obj.paper.acquire();
                    System.out.println("paper got");
                    obj.matches.acquire();
                    System.out.println("matches got");
                    System.out.println("have tobacco smokes");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.agentSem.release();
                }
            }
        };
        Runnable smokerPaper = () -> {
            while (true) {
                try {
                    obj.matches.acquire();
                    System.out.println("matches got");
                    obj.tobacco.acquire();
                    System.out.println("tobacco got");
                    System.out.println("have paper smokes");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.agentSem.release();
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(agent);
        Executors.newSingleThreadExecutor().execute(smokerMatches);
        Executors.newSingleThreadExecutor().execute(smokerPaper);
        Executors.newSingleThreadExecutor().execute(smokerTobacco);
    }
}
