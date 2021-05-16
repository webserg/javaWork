package masteringLambdas;

import java.time.Year;
import java.util.List;

public class Book {
    private String title;
    private List<String> authors;
    private int[] pageCounts;
    private Topic topic;
    private Year pubDate;
    private double height;

    public Book(String title, List<String> authors, int[] pageCounts, Year pubdate, double height, Topic topic) {
        this.title = title;
        this.pageCounts = pageCounts;
        this.authors = authors;
        this.topic = topic;
        this.pubDate = pubdate;
        this.height = height;
    }

    public Book(String title) {
        this.title = title;
        this.pageCounts = new int[]{10};
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setPageCounts(int[] pageCounts) {
        this.pageCounts = pageCounts;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Year getPubDate() {
        return pubDate;
    }

    public void setPubDate(Year pubDate) {
        this.pubDate = pubDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    @Override
    public String toString() {
        return title;
    }
}
