package masteringLambdas.streams;

import masteringLambdas.Book;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static masteringLambdas.Topic.COMPUTING;

public class StreamProcessing {
    public static void main(String[] args) {
        Supplier<List<Book>> supplier = new BookFactory();
        var library = supplier.get();

        Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
        ArrayList<String> a1 = s3.get();
        System.out.println(a1);

//        A stream that contains only computing books:
        Stream<Book> computingBooks = library.stream()
                .filter(b -> b.getTopic() == COMPUTING);
//        A stream of book titles:
        Stream<String> bookTitles = library.stream()
                .map(Book::getTitle);
//        A stream of Book, sorted by title:
        Stream<Book> booksSortedByTitle = library.stream()
                .sorted(Comparator.comparing(Book::getTitle));
//        Use this sorted stream to create a stream of authors, in order of book title,
//        with duplicates removed:
        Stream<String> authorsInBookTitleOrder = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .flatMap(book -> book.getAuthors().stream())
                .distinct();
//        A stream yielding the 􀃥rst 100 books in alphabetical order of title:
        Stream<Book> readingList = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .limit(100);
//        A stream with the rest:
        Stream<Book> remainderList = library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .skip(100);
//        The earliest-published book in my library:
        Optional<Book> oldest = library.stream()
                .min(Comparator.comparing(Book::getPubDate));
//        The set of titles of the books in my library:
        Set<String> titles = library.stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());

        int totalAuthorships = library.stream()
                .mapToInt(b -> b.getAuthors().size())
                .sum();

        Stream<List<String>> authorStream = library.stream()
                .map(b -> b.getAuthors());

        authorStream.forEach(System.out::println);
//        System.out.println(authorStream.count());

        Stream<String> authorStream2 = library.stream()
                .flatMap(b -> b.getAuthors().stream());
        System.out.println(authorStream2.count());

        int totalPageCount = library.stream()
                .flatMapToInt(b -> IntStream.of(b.getPageCounts()))
                .sum();
        System.out.println(totalPageCount);
    }
}
