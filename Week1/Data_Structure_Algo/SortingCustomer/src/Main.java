public class Main {

    public static void main(String[] args) {

        Order[] orders1 = {
                new Order(101, "Rahul", 1500),
                new Order(102, "Priya", 5000),
                new Order(103, "Amit", 2500),
                new Order(104, "Neha", 1000),
                new Order(105, "Karan", 4000)
        };

        System.out.println("Orders Before Bubble Sort:");
        SortingOperation.displayOrders(orders1);

        SortingOperation.bubbleSort(orders1);

        System.out.println("\nOrders After Bubble Sort:");
        SortingOperation.displayOrders(orders1);

        Order[] orders2 = {
                new Order(101, "Rahul", 1500),
                new Order(102, "Priya", 5000),
                new Order(103, "Amit", 2500),
                new Order(104, "Neha", 1000),
                new Order(105, "Karan", 4000)
        };

        SortingOperation.quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nOrders After Quick Sort:");
        SortingOperation.displayOrders(orders2);
    }
}