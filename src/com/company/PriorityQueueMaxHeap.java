package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PriorityQueueMaxHeap implements PriorityQueue {

    private ArrayList<Comparable> a;
    private int heapsize = 0;

    public PriorityQueueMaxHeap(Comparable[] cRay) {

        a = new ArrayList<>();
        a.add(cRay[0]);

        for (int j = 1; j < cRay.length; j++) {
            addElement(cRay[j]);
        }
        System.out.println(a);
    }

    private void increaseKey(int i, Comparable elem) {

        try {
            if (i > 1 & elem.compareTo(a.get(i)) < 0) throw new Exception("alköjsdf");

            a.set(i, elem);

            while (heapsize > 1 && i > 0 && a.get(i >> 1).compareTo(a.get(i)) < 0) {
                Collections.swap(a, i >> 1, i); // Elemente vertauschen
                i = i >> 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    }
}
