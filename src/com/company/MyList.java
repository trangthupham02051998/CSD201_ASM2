package com.company;

class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    //  Constructor method
    public MyLinkedList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }


    public MyLinkedList() {
    }


    /**
     * Check if the LinkedList is empty or not.
     *
     * @return boolean empty or not
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Get size of LinkedList
     *
     * @return size
     */
    public int length() {
        return length;
    }

    /**
     * Insert to head of Linked List
     *
     * @param x value of the new node
     */
    public void insertToHead(T x) {
        if (head == null) {
            this.head = new Node<>(x, null);
            this.tail = this.head;
        } else {
            this.head = new Node<>(x, head);
        }
        length++;
    }

    /**
     * Insert after of position k
     *
     * @param position where to insert
     * @param x        value of the new node
     */
    public void insertAfterPosition(int position, T x) {
        Node<T> curr = this.head;
        int currPos = -1;

        while (curr != null) {

            if (currPos == position - 1) {
                Node<T> newNode = new Node<>(x, curr.getNext());
                if (curr.getNext() == null) tail = newNode;
                curr.setNext(newNode);
                length++;
                break;
            }

            currPos++;
            curr = curr.getNext();
        }
    }


    /**
     * Insert a new node to the end of the LinkedList
     *
     * @param x value of the new node
     */
    public void insertToEnd(T x) {
        if (head == null) {
            this.head = new Node<>(x, null);
            this.tail = this.head;
        } else {
            Node<T> newNode = new Node<>(x);

            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        length++;
    }


    /**
     * Delete head node of the LinkedList
     *
     * @return the node which has been deleted
     */
    public Node<T> deleteHead() {
        if (this.head == null) return null;

        Node<T> element = this.head;
        this.head = this.head.getNext();
        length--;

        if (this.head == null) this.tail = null;

        return element;
    }


    /**
     * Delete element at tail of Linked List
     */
    public void deleteTail() {
        if (head == null) return;
        if (head.getInfo().equals(tail.getInfo())) {
            this.head = null;
            this.tail = null;
            length = 0;
            return;
        }
        Node<T> curr = this.head;

        while (curr != null) {

            if (curr.getNext() != null && curr.getNext().getInfo().equals(tail.getInfo())) {
                tail = curr;
                curr.setNext(null);
                length--;
                break;
            }

            curr = curr.getNext();
        }
    }

    /**
     * Delete element has value = x
     *
     * @param x value of the node which needs to be delete
     */
    public void deleteElement(T x) {
        if (head == null) return;
        if (head.getInfo().equals(x)) {
            this.head = null;
            this.tail = null;
            length = 0;
            return;
        }
        Node<T> curr = this.head;

        while (curr != null) {

            if (curr.getNext() != null && curr.getNext().getInfo().equals(x)) {
                if (curr.getNext().getInfo().equals(tail.getInfo())) {
                    tail = curr;
                    curr.setNext(null);
                } else {
                    curr.setNext(curr.getNext().getNext());
                }
                length--;
                break;
            }

            curr = curr.getNext();
        }
    }


    public Node<T> getHead() {
        return head;
    }

}
