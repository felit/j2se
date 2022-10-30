package com.livedrof.algs.sort;

/**
 * 选择排序
 */
public class SelectionSort extends SortTemplate {

    public SelectionSort(Comparable[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int num = this.arr.length;
        for (int i = 0; i < num; i++) {
            int min = i;
            for (int j = i + 1; j < num; j++) {
                if (this.less(this.arr[j], this.arr[min])) {
                    min = j;
                }
            }
            this.exch(i, min);
        }
    }

    public static void main(String args[]) {
        Integer[] a = new Integer[]{2, 3, 4, 5, 2, 1, 3, 5, 6, 7, 8, 5, 44, 4};
        SortTemplate sortAlgs = new SelectionSort(a);
        sortAlgs.sort();
        sortAlgs.show();
    }

}
