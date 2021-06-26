package com.company;

class MyQueue<T> {

    private MyLinkedList<T> linkedList;

    public MyQueue() {
        this.linkedList = new MyLinkedList<>();
    }


    /**
     * Add a new node to the end of the queue.
     *
     * @param x value of the new node
     * @return true or false
     */
    public boolean add(T x) {
        linkedList.insertToEnd(x);
        return true;
    }


    /**
     * Get a node on top of the queue, and remove it from the queue.
     *
     * @return T
     */
    public T poll() {
        Node<T> head = linkedList.deleteHead();
        if (head == null) return null;
        return head.getInfo();
    }

}
