package com.livedrof.algs.sort;

public class InsertionSort extends SortTemplate {
    public InsertionSort(Comparable[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        int num = this.arr.length;
        for (int i = 1; i < num; i++) {
            for (int j = i; j > 0 && this.less(this.arr[j], this.arr[j - 1]); j--) {
                this.exch(j, j - 1);
            }
        }
    }

    public static void main(String args[]) {
        Integer[] a = new Integer[]{2, 3, 4, 5, 2, 1, 3, 5, 6, 7, 8, 5, 44, 4};
        SortTemplate sortAlgs = new InsertionSort(a);
        sortAlgs.sort();
        sortAlgs.show();
    }
}
