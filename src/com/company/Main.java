package com.company;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{0,21,4,2,12,800,20,7,3,60,1};

        PriorityQueueMaxHeap heap = new PriorityQueueMaxHeap(arr);

        heap.heapSort();





    }
}
