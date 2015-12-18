package thread.folkJoinIssue.documentIndexer;

import java.util.concurrent.RecursiveTask;

/**
 * Created by webserg on 27.05.2014.
 */
public class DocumentSearchTask extends RecursiveTask<Long> {
    private final Document document;
    private final String searchedWord;
    private WordCounter wordCounter = new WordCounter();

    DocumentSearchTask(Document document, String searchedWord) {
        super();
        this.document = document;
        this.searchedWord = searchedWord;
    }

    @Override
    protected Long compute() {
        return wordCounter.occurrencesCount(document, searchedWord);
    }
}
