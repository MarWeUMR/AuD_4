package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PriorityQueueMaxHeap implements PriorityQueue {

    private ArrayList<Comparable> a;
    private int heapsize = 0;

    public PriorityQueueMaxHeap(Comparable[] cRay) {
        // Konstruktor arbeitet als Build Max Heap

        a = new ArrayList<>(Arrays.asList(cRay));
        heapsize = cRay.length - 1;

        System.out.println("Initial Heap (unoptimized)");
        createTreeStrings(0, a).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();


        for (int i = heapsize >> 1; i >= 0; i--) {
            maxHeapify(i);


        }

        System.out.println("Heapified");
        createTreeStrings(0, a).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();
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

        int l = (2 * i) + 1;
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

        System.out.println("Added Element");
        createTreeStrings(0, a).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

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
            a.set(0, a.get(heapsize));
            a.remove(heapsize);
            heapsize--;

            maxHeapify(0);

            getFirst();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("After Deletion");
        createTreeStrings(0, a).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public void deleteSpecific(int i) {

        a.set(i, a.get(heapsize));
        a.remove(heapsize);
        heapsize--;
        maxHeapify(i);

        System.out.println("After specific Deletion");
        createTreeStrings(0, a).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public void heapSort() {

        for (int i = heapsize; i >= 1; i--) {
            Collections.swap(a, 0, i);
            heapsize--;
            maxHeapify(0);
        }

        System.out.println(a);

    }

    // ###############################################################################################
    // Output
    // ###############################################################################################

    static String pad(String s, int lengthRigth, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = length - lengthRigth - s.length(); i > 0; i--) {
            sb.append(' ');
        }

        sb.append(s);

        for (int i = 0; i < lengthRigth; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    static StringBuilder withSpacesAppended(String s, int spaceCount) {
        StringBuilder sb = new StringBuilder(s.length() + spaceCount).append(s);
        for (int i = 0; i < spaceCount; i++) {
            sb.append(' ');
        }
        return sb;
    }

    static void joinLists(List<String> list1, List<String> list2) {
        int i;
        final int size = list2.size();
        for (i = 0; i < size; i++) {
            list1.set(i, withSpacesAppended(list1.get(i), 2).append(list2.get(i)).toString());
        }
    }

    static List<String> createTreeStrings(int index, ArrayList<Comparable> array) {
        int child1 = 2 * index + 1;
        int child2 = 2 * index + 2;
        if (child1 >= array.size()) {
            return new ArrayList<>(Collections.singletonList(toText(index, array)));
        } else {
            List<String> childList1 = createTreeStrings(child1, array);
            if (child2 < array.size()) {
                joinLists(childList1, createTreeStrings(child2, array));
            }
            String text = toText(index, array);
            int currentLength = childList1.get(0).length();

            if (currentLength >= text.length()) {
                text = pad(text, (currentLength - text.length()) / 2, currentLength);
            } else {
                for (int i = 0, size = childList1.size(); i < size; i++) {
                    childList1.set(i, pad(childList1.get(i), (currentLength - text.length()) / 2, currentLength));
                }
            }

            childList1.add(0, text);
            return childList1;
        }
    }

    static String toText(int index, ArrayList<Comparable> array) {
        return array.get(index).toString() + '(' + index + ')';
    }

}
