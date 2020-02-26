import java.util.ArrayList;
import java.util.List;

public class BooksData {

    public static List<Book> getBooksData() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Hobbit", "Tolkien", PublishingHouse.PENGUIN_RANDOM_HOUSE, 1937, 50, 44, BindingType.HARDCOVER));
        books.add(new Book("War and peace", "Tolstoy", PublishingHouse.HACHETTE_LIVRE, 1869, 1333, 144, BindingType.HARDCOVER));
        books.add(new Book("Romeo and Juliet", "Shakespeare", PublishingHouse.PENGUIN_RANDOM_HOUSE, 1595, 120, 30, BindingType.PAPERBACK));
        books.add(new Book(" The Lord of the Rings", "Tolkien", PublishingHouse.PENGUIN_RANDOM_HOUSE, 1954, 433, 74, BindingType.HARDCOVER));
        return books;
    }
}
