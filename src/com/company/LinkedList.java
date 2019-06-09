package com.company;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        private Object data;
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;

        head = newNode;
        size++;
        if(head.next == null) {
            tail = head;
        }
    }
    public void addLast(Object input) {
        Node newNode = new Node(input);
        if(size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    Node node(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void add(int k, Object input){
        if(k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;

            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }
    public String toString() {
        if(head == null) {
            return "[]";
        }

        Node temp = head;
        String str = "[";

        while(temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }

        str += temp.data;
        return str+"]";
    }
    public Object removeFirst(){

        Node temp = head;
        head = temp.next;

        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    public Object remove(int k) {
        if(k == 0) return removeFirst();

        Node temp = node(k - 1);
        Node todoDeleted = temp.next;

        temp.next = temp.next.next;

        Object returnData = todoDeleted.data;
        if(todoDeleted == tail) {
            tail = temp;
        }

        todoDeleted = null;
        size--;
        return returnData;
    }
    public Object removeLast(){
        return remove(size - 1);
    }
    public int size(){
        return size;
    }
    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
    public void swapNodes(int index1, int index2){
        // Note - Edge conditions such as the first and last elements not taken care of.
        Node previous1 = null;
        Node previous2 = null;
        
        Node currentNode = head;
        int position = 0;
        while(null != currentNode && null != currentNode.next){
            
            if(position == index1 - 1){
                previous1 = currentNode;
            }else if(position == index2 - 1){
                previous2 = currentNode;
            }
            if(null != previous1 && null != previous2){
                break;
            }
            currentNode = currentNode.next;
            position++;
        }
        
        Node node1 = previous1.next;
        Node node2 = previous2.next;
        
        Node node1Next = node1.next;
        Node node2Next = node2.next;
        
        previous1.next = node2;
        previous2.next = node1;
        
        node2.next = node1Next;
        node1.next = node2Next;
    }
}
