# Amazon Bestselling Books Dataset Analysis

A Java application for analyzing Amazon's bestselling books dataset, providing interactive data exploration and analysis capabilities.

## 📁 Project Structure

```
SST Assignments/
├── src/                    # Source code files
│   ├── Book.java          # Book data model
│   ├── BookAnalyzer.java  # Analysis methods
│   ├── DatasetReader.java # CSV data reader
│   └── Driver.java        # Main application entry point
├── data/
│   └── data.csv          # Amazon bestselling books dataset
├── bin/                  # Compiled class files
└── README.md            # Project documentation
```

## 🚀 Quick Start

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Command line interface** (PowerShell, CMD, or Terminal)

### Setup Instructions

1. **Clone or download the project**
   ```bash
   git clone https://github.com/ayaankhan28/lld-project-oops
   cd "lld-project-oops"
   ```

2. **Compile the Java files**
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin Driver
   ```

### Alternative Setup (if using an IDE)

1. **Import the project** into your Java IDE (Eclipse, IntelliJ IDEA, VS Code)
2. **Set the source folder** to `src/`
3. **Set the output folder** to `bin/`
4. **Run** the `Driver.java` file

## 📊 Dataset Information

The application analyzes a CSV dataset containing **550+ Amazon bestselling books** with the following attributes:

| Field | Type | Description |
|-------|------|-------------|
| Name | String | Book title |
| Author | String | Author name |
| User Rating | Double | Average user rating (0.0-5.0) |
| Reviews | Integer | Number of reviews |
| Price | Double | Book price in USD |
| Year | Integer | Publication/listing year |
| Genre | String | Book genre (Fiction/Non Fiction) |

### Sample Data
```csv
Name,Author,User Rating,Reviews,Price,Year,Genre
10-Day Green Smoothie Cleanse,JJ Smith,4.7,17350,8,2016,Non Fiction
11/22/63: A Novel,Stephen King,4.6,2052,22,2011,Fiction
1984 (Signet Classics),George Orwell,4.7,21424,6,2017,Fiction
```

## 🎯 Features

The application provides an interactive menu with the following analysis options:

### 1. **Author Analysis**
- Get total number of books by a specific author
- Display all unique authors in the dataset
- List all books by a specific author
- Get book titles and prices by author

### 2. **Rating Analysis**
- Find all books with a specific user rating
- Filter books based on rating criteria

### 3. **Dataset Overview**
- Display all books in the dataset (with pagination for large datasets)
- Show dataset statistics and information

## 🖥️ Application Interface

### Main Menu
```
==================================================
Amazon Bestselling Books Dataset Analysis
==================================================
1. Get total number of books by an author
2. Display all authors in the dataset
3. Get all books by an author
4. Get books by user rating
5. Get book prices by author
6. Display all books in dataset
7. Exit
==================================================
```

### Example Usage

**Finding books by author:**
```
Enter author name: Stephen King
Books by Stephen King:
========================================
1. 11/22/63: A Novel
2. The Stand
3. IT
Total books found: 3
```

**Finding books by rating:**
```
Enter user rating (e.g., 4.7): 4.7
Books with rating 4.7:
========================================
1. 10-Day Green Smoothie Cleanse by JJ Smith
2. 12 Rules for Life: An Antidote to Chaos by Jordan B. Peterson
3. 1984 (Signet Classics) by George Orwell
Total books found: 3
```

## 🏗️ Code Architecture

### Core Classes

#### `Book.java`
- **Purpose**: Data model representing a book
- **Key Features**:
  - Complete getter/setter methods
  - Formatted `toString()` method
  - `printDetails()` for detailed output

#### `DatasetReader.java`
- **Purpose**: Handles CSV file reading and parsing
- **Key Features**:
  - Robust CSV parsing with quoted field support
  - Error handling for malformed data
  - Header row detection and skipping

#### `BookAnalyzer.java`
- **Purpose**: Provides static analysis methods
- **Key Methods**:
  - `getTotalBooksByAuthor()` - Count books by author
  - `getAllAuthors()` - Get unique authors
  - `getBooksByAuthor()` - Filter books by author
  - `getBooksByRating()` - Filter books by rating
  - `getBooksAndPricesByAuthor()` - Get books with prices

#### `Driver.java`
- **Purpose**: Main application controller
- **Key Features**:
  - Interactive menu system
  - User input validation
  - Error handling
  - Formatted output display

