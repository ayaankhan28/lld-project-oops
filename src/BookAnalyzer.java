// BookAnalyzer.java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Provides analysis methods for the book dataset
 */
public class BookAnalyzer {
    
    /**
     * Returns the total number of books by a specific author
     * @param authorName The name of the author
     * @param books List of all books
     * @return Number of books by the author
     */
    public static int getTotalBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Returns all unique authors in the dataset
     * @param books List of all books
     * @return Set of unique author names
     */
    public static Set<String> getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }
    
    /**
     * Returns all book titles by a specific author
     * @param authorName The name of the author
     * @param books List of all books
     * @return List of book titles by the author
     */
    public static List<String> getBooksByAuthor(String authorName, List<Book> books) {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookTitles.add(book.getTitle());
            }
        }
        return bookTitles;
    }
    
    /**
     * Returns all books with a specific user rating
     * @param rating The user rating to filter by
     * @param books List of all books
     * @return List of books with the specified rating
     */
    public static List<Book> getBooksByRating(double rating, List<Book> books) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (Math.abs(book.getUserRating() - rating) < 0.01) { // Handle double comparison
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
    
    /**
     * Returns book titles and prices for a specific author
     * @param authorName The name of the author
     * @param books List of all books
     * @return List of strings containing book title and price information
     */
    public static List<String> getBooksAndPricesByAuthor(String authorName, List<Book> books) {
        List<String> bookPrices = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookPrices.add(book.getTitle() + " - $" + book.getPrice());
            }
        }
        return bookPrices;
    }
    
    /**
     * Prints all authors in the dataset
     * @param books List of all books
     */
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