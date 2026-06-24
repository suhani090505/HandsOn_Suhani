public class Main {

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "C++", "Bjarne Stroustrup"),
                new Book(102, "DBMS", "Korth"),
                new Book(103, "Java", "James Gosling"),
                new Book(104, "Python", "Guido van Rossum")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book b1 = LibrarySearch.linearSearch(books, "Java");

        if (b1 != null)
            b1.display();
        else
            System.out.println("Book Not Found");

        // Binary Search
        System.out.println("\nBinary Search:");
        Book b2 = LibrarySearch.binarySearch(books, "Java");

        if (b2 != null)
            b2.display();
        else
            System.out.println("Book Not Found");
    }
}