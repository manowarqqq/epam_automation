import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
//        5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
//           Создать массив объектов. Вывести:
//        a) список книг заданного автора;
//        b)   список книг, выпущенных заданным издательством;
//        c)   список книг, выпущенных после заданного года.
        BookShop localShop = new BookShop(BooksData.getBooksData());
        System.out.println("HELLO, WELCOM TO OUR SHOP.\n" +
                "---------------------------\n" +
                "To show books by AUTHOR, PRESS 1 and ENTER name of author.\n" +
                "To show books by Publishing house PRESS 2 and ENTER name of houses(We have  " + PublishingHouse.getHouses() + " .\n" +
                "To show books after specific  year PRESS 3 and ENTER the year.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1:
                System.out.println("Enter author");
                String author = scanner.nextLine();
                System.out.println(localShop.getBooksByAuthor(author));
                break;
            case 2:
                System.out.println("Enter Publishing house(" + PublishingHouse.getHouses() + " )");
                String publishingHouse = scanner.nextLine();
                System.out.println(localShop.getBooksByPublishingHouse(publishingHouse));
                break;
            case 3:
                System.out.println("Enter year");
                int year=scanner.nextInt();
                System.out.println(localShop.getBooksAfterYear(year));
        }

    }
}
