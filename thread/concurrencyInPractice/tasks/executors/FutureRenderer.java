package thread.concurrencyInPractice.tasks.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * As a first step towards making the page renderer more concurrent,
 * let's divide it into two tasks, one that renders the text and one
 * that downloads all the images. (Because one task is largely
 * CPU-bound and the other is largely I/O-bound, this approach may
 * yield improvements even on single-CPU systems.)
 *
 * @author Sergiy Doroshenko Feb 17, 2009 11:19:44 PM
 */
public class FutureRenderer {
    private static final int NTHREADS = 100;

    private final ExecutorService executor = Executors
            .newFixedThreadPool(NTHREADS);

    void renderPage(CharSequence source) throws Throwable {
        final List<ImageInfo> imageInfos = Action.scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            public List<ImageData> call() {
                List<ImageData> result = new ArrayList<ImageData>();
                for (ImageInfo imageInfo : imageInfos)
                    result.add(imageInfo.downloadImage());
                return result;
            }
        };
        Future<List<ImageData>> future = executor.submit(task);

        Action.renderText(source);
        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData)
                Action.renderImage(data);
        } catch (InterruptedException e) {
            // Re-assert the thread's interrupted status
            Thread.currentThread().interrupt();
            // We don't need the result, so cancel the task too
            future.cancel(true);
        } catch (ExecutionException e) {
            throw e.getCause();
        }
    }
}
