package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperationToProduct {

    /**
     * Search index of element of product in Linked list, if not found then return -1
     *
     * @param p
     * @param list
     * @return
     */
    public int index(Product p, MyLinkedList<Product> list) {
        Node<Product> curr = list.getHead();
        int index = -1;

        while (curr != null) {
            index++;
            if (curr.getInfo().equals(p)) {
                break;
            }

            curr = curr.getNext();
        }

        return index;
    }

    /**
     * Create a product have:(ID, name, quantity, price) that input from keyboard
     *
     * @return a new Product
     */
    public static Product createProduct() {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Product code: ");
        Integer id = Integer.parseInt(inputReader.nextLine());
        System.out.print("Product title: ");
        String title = inputReader.nextLine();
        System.out.print("Product quantity: ");
        Integer quantity = inputReader.nextInt();
        System.out.print("Product price: ");
        double price = inputReader.nextDouble();
        return new Product(id, title, quantity, price);
    }

    /**
     * Read all products from file and save to Linked List ( Insert at tail of Linked List), info of a product in a line
     *
     * @param fileName
     * @param list
     */
    public static void getAllItemsFromFile(String fileName, MyLinkedList<Product> list) {
        readFile(fileName, list::insertToEnd);
    }

    /**
     * Read all products from file and save to Stack
     *
     * @param fileName
     * @param stack
     */
    public static void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        readFile(fileName, stack::push);
    }

    /**
     * Read all products from file and save to Stack
     *
     * @param fileName
     * @param queue
     */
    public static void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        readFile(fileName, queue::add);
    }

    /**
     * Display info of all product on Linked list
     *
     * @param list
     */
    public static void displayAll(MyLinkedList<Product> list) {
        Node<Product> curr = list.getHead();

        while (curr != null) {

            System.out.println(curr.getInfo());
            writeConsoleOutputToFile(curr.getInfo().toString());
            writeConsoleOutputToFile("\n");

            curr = curr.getNext();
        }
    }

    /**
     * Display info of all product on Linked list
     *
     * @param stack
     */
    public static void displayAll(MyStack<Product> stack) {
        Product curr;

        while ((curr = stack.pop()) != null) {

            System.out.println(curr);
            writeConsoleOutputToFile(curr.toString());
            writeConsoleOutputToFile("\n");
        }
    }

    /**
     * Display info of all product on Linked list
     *
     * @param queue
     */
    public static void displayAll(MyQueue<Product> queue) {
        Product curr;

        while ((curr = queue.poll()) != null) {

            System.out.println(curr);
            writeConsoleOutputToFile(curr.toString());
            writeConsoleOutputToFile("\n");
        }
    }

    /**
     * Write all product of Linked List to file
     *
     * @param fileName
     * @param list
     */
    public static void writeAllItemsToFile(String fileName, MyLinkedList<Product> list) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            Node<Product> curr = list.getHead();
            while (curr != null) {
                fileWriter.write(curr.getInfo().toString().replace(" ", "").trim());
                fileWriter.write("\n");
                curr = curr.getNext();
            }

            fileWriter.close();

            System.out.println("Save!!!");
            writeConsoleOutputToFile("Save!!!");
            writeConsoleOutputToFile("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Search first element by ID
     *
     * @param list
     */
    public static void searchByCode(MyLinkedList<Product> list) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Input ID to search: ");
        Integer id = inputReader.nextInt();

        Node<Product> curr = list.getHead();
        Product found = null;

        while (curr != null) {
            if (curr.getInfo().getId().equals(id)) {
                found = curr.getInfo();
                break;
            }

            curr = curr.getNext();
        }

        if (found != null) {
            System.out.printf("Result: %s%n", found);
            writeConsoleOutputToFile("Result: " + found);
            writeConsoleOutputToFile("\n");
        } else {
            System.out.printf("Result: -1%n");
            writeConsoleOutputToFile("Result: -1");
            writeConsoleOutputToFile("\n");
        }
    }

    /**
     * Delete first element by ID (=ID)
     *
     * @param list
     */
    public static void deleteByCode(MyLinkedList<Product> list) {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Input ID to delete: ");
        Integer id = inputReader.nextInt();

        Node<Product> curr = list.getHead();

        if (curr != null && curr.getInfo().getId().equals(id) ) {
            list.deleteHead();
            System.out.println("Deleted!!!");
            writeConsoleOutputToFile("Deleted!!!");
            writeConsoleOutputToFile("\n");
            return;
        }

        while (curr != null) {
            if (curr.getNext().getInfo().getId().equals(id)) {
                list.deleteElement(curr.getNext().getInfo());
                System.out.println("Deleted!!!");
                writeConsoleOutputToFile("Deleted!!!");
                writeConsoleOutputToFile("\n");
                break;
            }

            curr = curr.getNext();
        }
    }

    /**
     * Sort by ID
     *
     * @param list
     */
    public static void sortByCode(MyLinkedList<Product> list) {
        Node<Product> sorted = mergeSort(list.getHead());

        Node<Product> curr = sorted;

        while (curr != null) {
            System.out.println(curr.getInfo());

            writeConsoleOutputToFile(curr.getInfo().toString());
            writeConsoleOutputToFile("\n");

            curr = curr.getNext();
        }
    }

    /**
     * Implement merge sort on linked list
     *
     * @param head
     * @return
     */
    private static Node<Product> mergeSort(Node<Product> head) {
        if (head == null || head.getNext() == null) return head;

        Node<Product> middle = getMiddle(head);
        Node<Product> nextToMiddle = middle.getNext();

        middle.setNext(null);

        Node<Product> left = mergeSort(head);
        Node<Product> right = mergeSort(nextToMiddle);

        return merge(left, right);
    }


    /**
     * Merge node a and node b
     *
     * @param a Node a
     * @param b Node b
     * @return
     */
    private static Node<Product> merge(Node<Product> a, Node<Product> b) {
        if (a == null) return b;
        if (b == null) return a;

        Node<Product> result;

        if (a.getInfo().getId() < b.getInfo().getId()) {
            result = a;
            result.setNext(merge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(merge(a, b.getNext()));
        }

        return result;
    }

    /**
     * Get middle of a linked list
     *
     * @param head head of the linked list
     * @return
     */
    private static Node<Product> getMiddle(Node<Product> head) {
        if (head == null) return null;
        Node<Product> slow = head;
        Node<Product> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }


    /**
     * Convert to binary
     *
     * @param i number to convert
     */
    public static void convertBinary(int i) {
        if (i == 0) return;
        convertBinary(i / 2);
        System.out.print(i % 2);
        writeConsoleOutputToFile(i % 2 + "");
    }

    /**
     * Read data from file
     *
     * @param fileName    file to read
     * @param processItem how to process items data which received from file.
     */
    private static void readFile(String fileName, ProcessItem processItem) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");

                Product product = new Product(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                processItem.process(product);
            }

            bufferedReader.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    public static void writeConsoleOutputToFile(String content) {
        try {
            FileWriter fileWriter = new FileWriter("console_output.txt", true);

            fileWriter.write(content);

            fileWriter.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

}
