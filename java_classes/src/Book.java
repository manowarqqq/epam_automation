public class Book {
    //
//    Создать классы, спецификации которых приведены ниже.
//    Определить конструкторы и методы setТип(), getТип(), toString().
//    Определить дополнительно методы в классе, создающем массив объектов.
//    Задать критерий выбора данных и вывести эти данные на консоль.
//    В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//5. Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
//    Создать массив объектов. Вывести:
//    a) список книг заданного автора;
//    b)   список книг, выпущенных заданным издательством;
//    c)   список книг, выпущенных после заданного года.
    private static int count = 0;
    private long id;
    private String name;
    private String author;
    private PublishingHouse publishingHouse;
    private int publishingYear;
    private int numberOfPages;
    private int price;
    private BindingType bindingType;


    public Book(String name, String author, PublishingHouse publishingHouse, int publishingYear, int numberOfPages, int price, BindingType bindingType) {
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
        setId(++count);
    }

    public Book(String name, String author, PublishingHouse publishingHouse, int publishingYear, int numberOfPages, int price) {
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.numberOfPages = numberOfPages;
        this.price = price;
        setId(++count);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BindingType getBindingType() {
        return bindingType;
    }

    public void setBindingType(BindingType bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse=" + publishingHouse +
                ", publishingYear=" + publishingYear +
                ", numberOfPages=" + numberOfPages +
                ", price=" + price +
                ", bindingType=" + bindingType +
                '}';
    }
}
