package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {



        Integer[] arr = new Integer[]{0,21,4,2,12,80,20,7,3,60,1};
        //Integer[] arr = new Integer[]{0,21,4};
        Character[] crr = new Character[]{'a', 'c', 'e', 'a', 'g', 'b'};

        PriorityQueueMaxHeap heap = new PriorityQueueMaxHeap(arr);

        heap.addElement(500);
        heap.addElement(1);
        heap.deleteFirst();

        System.out.println("First Element");
        System.out.println(heap.getFirst());

        System.out.println("Sorted with heapSort");
        heap.heapSort();





    }
}
