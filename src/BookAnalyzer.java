
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookAnalyzer {
    

    public static int getTotalBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    

    public static Set<String> getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    public static List<String> getBooksByAuthor(String authorName, List<Book> books) {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookTitles.add(book.getTitle());
            }
        }
        return bookTitles;
    }

    public static List<Book> getBooksByRating(double rating, List<Book> books) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (Math.abs(book.getUserRating() - rating) < 0.01) { // Handle double comparison
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
    

    public static List<String> getBooksAndPricesByAuthor(String authorName, List<Book> books) {
        List<String> bookPrices = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookPrices.add(book.getTitle() + " - $" + book.getPrice());
            }
        }
        return bookPrices;
    }
    
 
    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = getAllAuthors(books);
        System.out.println("All Authors in the Dataset:");
        System.out.println("==========================");
        for (String author : authors) {
            System.out.println("- " + author);
        }
        System.out.println("\nTotal unique authors: " + authors.size());
    }
}