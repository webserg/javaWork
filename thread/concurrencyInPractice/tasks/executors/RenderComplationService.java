package thread.concurrencyInPractice.tasks.executors;

import java.util.List;
import java.util.concurrent.*;

/**
 * We can create a separate task for downloading each image and
 * execute them in a thread pool, turning the sequential download into
 * a parallel one: this reduces the amount of time to download all the
 * images. And by fetching results from the CompletionService and
 * rendering each image as soon as it is available, we can give the
 * user a more dynamic and responsive user interface.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 18, 2009 4:39:58 PM
 */
public class RenderComplationService {
    private final ExecutorService executor;
    Ad DEFAULT_AD;

    RenderComplationService(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) throws Throwable {
        final List<ImageInfo> info = Action.scanForImageInfo(source);
        // The implementation of ExecutorCompletionService
        // is quite straightforward. The constructor
        // creates a BlockingQueue to hold the completed
        // results.
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(
                executor);
        for (final ImageInfo imageInfo : info)
            completionService.submit(new Callable<ImageData>() {
                public ImageData call() {
                    return imageInfo.downloadImage();
                }
            });
        Action.renderText(source);
        try {
            for (int t = 0, n = info.size(); t < n; t++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                Action.renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw e.getCause();
        }
    }

    /**
     * if an activity does not complete within a certain amount of
     * time, the result is no longer needed and the activity can be
     * abandoned.
     * <p>
     * The timed version of Future.get supports this requirement: it
     * returns as soon as the result is ready, but throws
     * TimeoutException if the result is not ready within the timeout
     * period.
     *
     * @return
     * @throws InterruptedException
     */
    Page renderPageWithAd() throws InterruptedException {
        long endNanos = System.nanoTime() + 1000;
        Future<Ad> f = executor.submit(new Callable<Ad>() {
            public Ad call() {
                return new Ad();
            }
        });
        // Render the page while waiting for the ad
        //Page page = renderPageBody();
        Ad ad;
        try {
            // Only wait for the remaining time budget
            long timeLeft = endNanos - System.nanoTime();
            ad = f.get(timeLeft, TimeUnit.NANOSECONDS);
        } catch (ExecutionException e) {
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {
            ad = DEFAULT_AD;
            f.cancel(true);
        }
        Page p = new Page();
        p.setAd(ad);
        return p;
    }
}
