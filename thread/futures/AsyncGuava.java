package thread.futures;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


public class AsyncGuava {

    ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

    public static void main(String[] args) {
        AsyncGuava asyncGuava = new AsyncGuava();
        asyncGuava.asyncChainExample();
    }

    public void asyncChainExample() {
        Callable<User> fetcher = new RemoteUserFetcher("user0001");
        ListenableFuture<User> userFuture = executor.submit(fetcher);

        AsyncFunction<User, Stats> userToStats = new AsyncFunction<User, Stats>() {
            @Override
            public ListenableFuture<Stats> apply(User user) throws Exception {
                return executor.submit(new StatsCalculator(user));
            }
        };

        ListenableFuture<Stats> statsFuture = Futures.transform(userFuture, userToStats);

        Futures.addCallback(statsFuture, new FutureCallback<Stats>() {
            public void onSuccess(Stats result) {
                handleResult(result);
            }

            public void onFailure(Throwable thrown) {
                handleFailure();
            }
        });
    }

    private void handleFailure() {
        System.out.println("failure");
    }

    private void handleResult(Stats result) {
        System.out.println("good result");
    }

    private Stats computeStats(User user) throws InterruptedException {
        Thread.sleep(1000);
        return new Stats(1);
    }

    private class RemoteUserFetcher implements Callable<User> {
        private final String userId;

        public RemoteUserFetcher(String userId) {
            this.userId = userId;
        }

        @Override
        public User call() throws Exception {
            Thread.sleep(1000);
            throw new RuntimeException();
            //return new User(userId);
        }
    }

    private class StatsCalculator implements Callable<Stats> {
        private final User user;

        public StatsCalculator(User user) {
            this.user = user;
        }

        @Override
        public Stats call() throws Exception {
            return computeStats(user);
        }
    }

}
