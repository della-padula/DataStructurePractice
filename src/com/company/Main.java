package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        numbers.addLast(50);
        numbers.addFirst(60);

        System.out.println(numbers.toString());
        numbers.swapNodes(1, 4);
        System.out.println(numbers.toString());
    }
}
