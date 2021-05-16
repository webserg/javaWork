package masteringLambdas.streams;

import masteringLambdas.Book;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static masteringLambdas.Topic.*;

public class BookFactory implements Supplier<List<Book>> {

    @Override
    public List<Book> get() {
        Book nails = new Book("Fundamentals of Chinese Fingernail Image",
                Arrays.asList("Li", "Fu", "Li"),
                new int[]{256}, // pageCount per volume
                Year.of(2014), // publication date
                25.2, // height in cms
                MEDICINE);
        Book dragon = new Book("Compilers: Principles, Techniques and Tools",
                Arrays.asList("Aho", "Lam", "Sethi", "Ullman"),
                new int[]{1009},
                Year.of(2006), // publication date (2nd edition)
                23.6,
                COMPUTING);
        Book voss = new Book("Voss",
                Arrays.asList("Patrick White"),
                new int[]{478},
                Year.of(1957),
                19.8,
                FICTION);
        Book lotr = new Book("Lord of the Rings",
                Arrays.asList("Tolkien"),
                new int[]{531, 416, 624},
                Year.of(1955),
                23.0,
                FICTION);
        return List.of(nails, dragon, voss, lotr);
    }
}
