class LibrarySearch {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search (Array must be sorted by title)
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if (result == 0)
                return books[mid];

            else if (result < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }
}