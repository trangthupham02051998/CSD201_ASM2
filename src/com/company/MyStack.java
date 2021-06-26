package com.company;

class MyStack<T> {

    private final MyLinkedList<T> linkedList;

    public MyStack() {
        this.linkedList = new MyLinkedList<>();
    }

    /**
     * Push a new node to the stack.
     *
     * @param x value of the new node
     * @return true or false
     */
    public boolean push(T x) {
        this.linkedList.insertToHead(x);
        return true;
    }

    /**
     * Get a node on top of the stack, and remove it from the stack.
     *
     * @return T
     */
    public T pop() {
        Node<T> head = linkedList.deleteHead();
        if (head == null) return null;
        return head.getInfo();
    }

    /**
     * Check to see if the stack is empty or not.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

}
