package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PriorityQueueMaxHeap implements PriorityQueue {

    private ArrayList<Comparable> a;
    private int heapsize = 0;

    public PriorityQueueMaxHeap(Comparable[] cRay) {
        // Konstruktor arbeitet als Build Max Heap

        a = new ArrayList<>(Arrays.asList(cRay));
        heapsize = cRay.length - 1;

        for (int i = heapsize>> 1; i >= 0; i--) {
            maxHeapify(i);
        }

        System.out.println(a);
    }

    private void increaseKey(int i, Comparable elem) {

        try {
            if (i > 1 & elem.compareTo(a.get(i)) < 0) throw new Exception("Error...somewhere. Try 42.");

            a.set(i, elem);

            while (heapsize > 1 && i > 0 && a.get(i >> 1).compareTo(a.get(i)) < 0) {
                Collections.swap(a, i >> 1, i); // Elemente vertauschen
                i = i >> 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void maxHeapify(int i) {

        int l = 2 * i;
        int r = l + 1;

        int max = (l <= heapsize && a.get(l).compareTo(a.get(i)) > 0)
                ? l
                : i;

        if (r <= heapsize && a.get(r).compareTo(a.get(max)) > 0) {
            max = r;
        }

        if (max != i) {
            Collections.swap(a, i, max);
            maxHeapify(max);
        }
    }


    @Override
    public void addElement(Comparable elem) {
        heapsize++;
        a.add(Integer.MIN_VALUE); // Sentinel ergänzen
        increaseKey(heapsize, elem);
    }

    @Override
    public Comparable getFirst() {
        return a.get(0);
    }

    @Override
    public void deleteFirst() {

        try {
            if (heapsize < 1) {
                throw new Exception("Error...somewhere. Try 42.");
            }

            Comparable max = a.get(0);
            a.set(1, a.get(heapsize));

            heapsize--;

            maxHeapify(1);

            getFirst();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buildMaxHeap() {


    }
}
