package com.company;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        boolean running = true;

        MyLinkedList<Product> products = new MyLinkedList<>();


        do {
            int selectedOption = showMenu();

            switch (selectedOption) {
                case 1:
                    loadDataFromFileAndDisplay(products);
                    break;
                case 2:
                    addNewProduct(products);
                    break;
                case 3:
                    displayData(products);
                    break;
                case 4:
                    saveAll(products);
                    break;
                case 5:
                    searchById(products);
                    break;
                case 6:
                    deleteById(products);
                    break;
                case 7:
                    sortById(products);
                    break;
                case 8:
                    convertToBinary(products);
                    break;
                case 9:
                    loadDataToStack();
                    break;
                case 10:
                    loadDataToQueue();
                    break;
                default:
                    running = false;
                    break;
            }

        } while (running);
    }

    public static int showMenu() {
        System.out.println("=============================================");
        System.out.println("Choose one of this options:");
        System.out.println("1. Load data from file and display.");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data.");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID.");
        System.out.println("6. Delete by ID.");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary.");
        System.out.println("9. Load to stack and display.");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.println("=============================================");
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("=============================================\n");
        OperationToProduct.writeConsoleOutputToFile("Choose one of this options:\n");
        OperationToProduct.writeConsoleOutputToFile("1. Load data from file and display.\n");
        OperationToProduct.writeConsoleOutputToFile("2. Input & add to the end.\n");
        OperationToProduct.writeConsoleOutputToFile("3. Display data.3. Display data.\n");
        OperationToProduct.writeConsoleOutputToFile("4. Save product list to file.\n");
        OperationToProduct.writeConsoleOutputToFile("5. Search by ID.\n");
        OperationToProduct.writeConsoleOutputToFile("6. Delete by ID.\n");
        OperationToProduct.writeConsoleOutputToFile("7. Sort by ID.\n");
        OperationToProduct.writeConsoleOutputToFile("8. Convert to Binary.\n");
        OperationToProduct.writeConsoleOutputToFile("9. Load to stack and display.\n");
        OperationToProduct.writeConsoleOutputToFile("10. Load to queue and display.\n");
        OperationToProduct.writeConsoleOutputToFile("0. Exit\n");
        OperationToProduct.writeConsoleOutputToFile("=============================================\n");
        OperationToProduct.writeConsoleOutputToFile("\n");

        Scanner inputReader = new Scanner(System.in);
        return inputReader.nextInt();
    }


    public static void loadDataFromFileAndDisplay(MyLinkedList<Product> products) {
        OperationToProduct.getAllItemsFromFile("data.txt", products);

        displayData(products);
    }


    /**
     * Function 2, add a new product to the linked list
     *
     * @param products linked list
     */
    public static void addNewProduct(MyLinkedList<Product> products) {
        Product product = OperationToProduct.createProduct();
        products.insertToEnd(product);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 3, display all the data in the linked list.
     *
     * @param products linked list
     */
    public static void displayData(MyLinkedList<Product> products) {
        System.out.println();
        System.out.println("ID   |   Title   |   Quantity   |   Price");
        System.out.println("------------------------------------------");

        OperationToProduct.writeConsoleOutputToFile("ID   |   Title   |   Quantity   |   Price\n");
        OperationToProduct.writeConsoleOutputToFile("------------------------------------------\n");

        OperationToProduct.displayAll(products);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 4, save all products to file.
     *
     * @param products
     */
    public static void saveAll(MyLinkedList<Product> products) {
        OperationToProduct.writeAllItemsToFile("data.txt", products);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 5, search a product by id from the linked list
     *
     * @param products linked list
     */
    public static void searchById(MyLinkedList<Product> products) {

        OperationToProduct.searchByCode(products);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 6, delete a product by id from the linked list.
     *
     * @param products linked list
     */
    public static void deleteById(MyLinkedList<Product> products) {

        OperationToProduct.deleteByCode(products);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    public static void sortById(MyLinkedList<Product> products) {

        OperationToProduct.sortByCode(products);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 8, convert quantity of the first product to binary
     *
     * @param products linked list
     */
    public static void convertToBinary(MyLinkedList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Linked List is empty!!!");
            OperationToProduct.writeConsoleOutputToFile("Linked List is empty!!!\n");
            return;
        }

        int quantityOfFirstProduct = products.getHead().getInfo().getQuantity();
        System.out.println("Product quantity in decimal:");
        OperationToProduct.writeConsoleOutputToFile("Product quantity in decimal:\n");
        System.out.println(quantityOfFirstProduct);
        OperationToProduct.writeConsoleOutputToFile(quantityOfFirstProduct + "\n");
        System.out.println("Product quantity in binary:");
        OperationToProduct.writeConsoleOutputToFile("Product quantity in binary:\n");
        OperationToProduct.convertBinary(quantityOfFirstProduct);
        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 9, load data from file to a stack, and display data in the stack.
     */
    public static void loadDataToStack() {
        MyStack<Product> stack = new MyStack<>();
        OperationToProduct.getAllItemsFromFile("data.txt", stack);

        OperationToProduct.displayAll(stack);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }


    /**
     * Function 10, load data from file to a queue, and display data in the queue.
     */
    public static void loadDataToQueue() {
        MyQueue<Product> queue = new MyQueue<>();
        OperationToProduct.getAllItemsFromFile("data.txt", queue);

        OperationToProduct.displayAll(queue);

        System.out.println();
        System.out.println();

        OperationToProduct.writeConsoleOutputToFile("\n\n");
    }
}
