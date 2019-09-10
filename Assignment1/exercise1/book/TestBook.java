package exercise1.book;

import exercise1.author.Author;

public class TestBook {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        Book book = new Book("1984", ahTeck, 45.1, 6);
        System.out.println(book);
        System.out.println(book.getAuthor());
        System.out.println(book.getAuthorEmail());
        System.out.println(book.getAuthorGender());
        System.out.println(book.getAuthorName());
        System.out.println(book.getName());
        System.out.println(book.getPrice());
        System.out.println(book.getQty());

    }
}
