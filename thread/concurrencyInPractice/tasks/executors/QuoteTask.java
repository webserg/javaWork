package thread.concurrencyInPractice.tasks.executors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class QuoteTask {
    private TravelCompany company;
    private TravelInfo travelInfo;

    public TravelQuote call() throws Exception {
        return company.solicitQuote(travelInfo);
    }

    public List<TravelQuote> getRankedTravelQuotes(TravelInfo travelInfo,
            Set<TravelCompany> companies, Comparator<TravelQuote> ranking,
            long time, TimeUnit unit) throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<QuoteTask>();
       // for (TravelCompany company : companies)
        //    tasks.add(new QuoteTask(company, travelInfo));
        List<Future<TravelQuote>> futures = new ArrayList<Future<TravelQuote>>();//= exec.invokeAll(tasks, time, unit);
        List<TravelQuote> quotes = new ArrayList<TravelQuote>(tasks.size());
        Iterator<QuoteTask> taskIter = tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
               // quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
               // quotes.add(task.getTimeoutQuote(e));
            }
        }
        Collections.sort(quotes, ranking);
        return quotes;
    }
}

interface TravelCompany {
     TravelQuote solicitQuote(TravelInfo travelInfo);
}

interface TravelInfo {
}

interface TravelQuote {
}
