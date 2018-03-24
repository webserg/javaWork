package thread.littleBookOfSemafore.smokersProblem;

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
public class SmokersWorldSolution {
    //    final Semaphore[] tobacco = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] paper = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] matches = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
//    final Semaphore[] agentsSupply = {new Semaphore(1),new Semaphore(1),new Semaphore(1)};
    final Semaphore tobacco = new Semaphore(0);
    final Semaphore paper = new Semaphore(0);
    final Semaphore matches = new Semaphore(0);
    final Semaphore agentSem = new Semaphore(1);
    final Semaphore[] agentsSupply = {tobacco, paper, matches};
    final Semaphore tobaccoSem = new Semaphore(0);
    final Semaphore paperSem = new Semaphore(0);
    final Semaphore matchesSem = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    boolean isTobacco, isPaper, isMatches = false;


    public static void main(String[] args) {
        final SmokersWorldSolution obj = new SmokersWorldSolution();
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
                    obj.tobaccoSem.acquire();
                    System.out.println("tobacco got");
//                    obj.paperSem.acquire();
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
                    obj.paperSem.acquire();
                    System.out.println("paper got");
//                    obj.matchesSem.acquire();
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
                    obj.matchesSem.acquire();
                    System.out.println("matches got");
//                    obj.tobaccoSem.acquire();
                    System.out.println("tobacco got");
                    System.out.println("have paper smokes");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.agentSem.release();
                }
            }
        };

        Runnable tobaccoPusher = () -> {

            while (true) {
                try {
                    obj.tobacco.acquire();
                    obj.mutex.acquire();
                    System.out.println("tobacco push");
                    if (obj.isPaper) {
                        obj.isPaper = false;
                        obj.matchesSem.release();
                    } else if (obj.isMatches) {
                        obj.isMatches = false;
                        obj.paperSem.release();
                    } else obj.isTobacco = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.mutex.release();
                }
            }
        };
        Runnable paperPusher = () -> {
//            final Semaphore mutex = new Semaphore(1);
            while (true) {
                try {
                    obj.paper.acquire();
                    obj.mutex.acquire();
                    System.out.println("paper push");
                    if (obj.isTobacco) {
                        obj.isTobacco = false;
                        obj.matchesSem.release();
                    } else if (obj.isMatches) {
                        obj.isMatches = false;
                        obj.tobaccoSem.release();
                    } else obj.isPaper = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.mutex.release();
                }
            }
        };
        Runnable matcherPusher = () -> {
//            final Semaphore mutex = new Semaphore(1);
            while (true) {
                try {
                    obj.matches.acquire();
                    obj.mutex.acquire();
                    System.out.println("matches push");
                    if (obj.isPaper) {
                        obj.isPaper = false;
                        obj.tobaccoSem.release();
                    } else if (obj.isTobacco) {
                        obj.isTobacco = false;
                        obj.paperSem.release();
                    } else obj.isMatches = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.mutex.release();
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(agent);
        Executors.newSingleThreadExecutor().execute(smokerMatches);
        Executors.newSingleThreadExecutor().execute(smokerPaper);
        Executors.newSingleThreadExecutor().execute(smokerTobacco);
        Executors.newSingleThreadExecutor().execute(tobaccoPusher);
        Executors.newSingleThreadExecutor().execute(paperPusher);
        Executors.newSingleThreadExecutor().execute(matcherPusher);
    }
}
