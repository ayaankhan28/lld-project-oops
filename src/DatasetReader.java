// DatasetReader.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the CSV dataset and creates Book objects
 */
public class DatasetReader {
    
    /**
     * Reads the CSV file and returns a list of Book objects
     * @param filename The path to the CSV file
     * @return List of Book objects
     */
    public static List<Book> readDataset(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                // Skip header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                try {
                    Book book = parseBookFromLine(line);
                    if (book != null) {
                        books.add(book);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line);
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return books;
    }
    
    /**
     * Parses a CSV line and creates a Book object
     * @param line CSV line to parse
     * @return Book object or null if parsing fails
     */
    private static Book parseBookFromLine(String line) {
        try {
            // Handle CSV parsing with potential commas in quoted fields
            String[] fields = parseCSVLine(line);
            
            if (fields.length < 7) {
                System.err.println("Insufficient fields in line: " + line);
                return null;
            }
            
            String title = fields[0].trim();
            String author = fields[1].trim();
            double userRating = Double.parseDouble(fields[2].trim());
            int reviews = Integer.parseInt(fields[3].trim());
            double price = Double.parseDouble(fields[4].trim());
            int year = Integer.parseInt(fields[5].trim());
            String genre = fields[6].trim();
            
            return new Book(title, author, userRating, reviews, price, year, genre);
            
        } catch (NumberFormatException e) {
            System.err.println("Number format error in line: " + line);
            return null;
        }
    }
    
    /**
     * Parses a CSV line handling quoted fields that may contain commas
     * @param line The CSV line to parse
     * @return Array of field values
     */
    private static String[] parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentField = new StringBuilder();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
        
        // Add the last field
        fields.add(currentField.toString());
        
        return fields.toArray(new String[0]);
    }
}