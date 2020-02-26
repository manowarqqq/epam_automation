import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class BookShop {
    private List<Book> collection;


    public BookShop(List<Book> collection) {
        this.collection = collection;
    }


    public List<Book> getCollection() {
        return collection;
    }

    public List<Book> addBookToCollection(Book book) {
        this.collection.add(book);
        return collection;
    }

    public List<String> getBooksByAuthor(String author) {
        List<String> books = new ArrayList<>();
        for (Book book : this.collection) {
            if (book.getAuthor().equals(author)) books.add(book.getName());
        }
        if (books.isEmpty()) books.add("We don't have books by this author");
        return books;
    }

    public List<String> getBooksByPublishingHouse(String publishingHouse) {
        String house = publishingHouse.toUpperCase().trim().replace(" ", "_");
        List<String> books = new ArrayList<>();
        if (!(PublishingHouse.isExist(house))) {
            books.add("No such house");
            return books;
        }
        PublishingHouse ph = PublishingHouse.valueOf(house);
        for (Book book : this.collection) {
            if (book.getPublishingHouse().equals(ph)) {
                books.add(book.getName());
            }
            if (books.isEmpty()) books.add("No books");
        }
        return books;
    }

    public List<String> getBooksAfterYear(int year) {
        List<String> books = new ArrayList<>();
        if (year <= 0) {
            books.add("Wrong year");
            return books;
        }
        for (Book book : this.collection) {
            if (book.getPublishingYear() > year) {
                books.add(book.getName());
            }
        }
        if(books.isEmpty())  books.add("No books");
        return books;
    }
}
