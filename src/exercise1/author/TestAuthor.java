package exercise1.author;

public class TestAuthor {
    public static void main(String[] args) {
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        System.out.println(ahTeck);
        System.out.println(ahTeck.getEmail() + " " + ahTeck.getName() + " " + ahTeck.getGender());
    }
}
