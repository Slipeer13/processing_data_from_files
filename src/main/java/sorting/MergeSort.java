package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static DirectSorting directSorting;

    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> list, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(list, start, middle);
        mergeSort(list, middle + 1, end);
        merge(list, start, middle, end);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int start, int middle, int end) {
        int left = start;
        int right = middle + 1;
        List<T> temp = new ArrayList<>();
        while (left <= middle && right <= end) {
            if(directSorting == DirectSorting.ASK) {
                if (list.get(left).compareTo(list.get(right)) <= 0) {
                    temp.add(list.get(left++));
                } else {
                    temp.add(list.get(right++));
                }
            } else {
                if (list.get(left).compareTo(list.get(right)) >= 0) {
                    temp.add(list.get(left++));
                } else {
                    temp.add(list.get(right++));
                }
            }
        }
        while (left <= middle) {
            temp.add(list.get(left++));
        }
        while (right <= end) {
            temp.add(list.get(right++));
        }
        for (int i = 0; i < temp.size(); i++) {
            list.set(start + i, temp.get(i));
        }
    }
}
