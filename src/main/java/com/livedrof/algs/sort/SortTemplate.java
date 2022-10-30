package com.livedrof.algs.sort;

public abstract class SortTemplate {
    protected Comparable[] arr;

    public SortTemplate(Comparable[] arr) {
        this.arr = arr;
    }

    public abstract void sort();

    /**
     * 升序排列
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exch(int i, int j) {
        Comparable t = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = t;
    }

    protected void show() {
        assert this.isSort();
        for (Comparable a : this.arr) {
            this.print(a);
        }
        this.println();
    }

    public boolean isSort() {
        for (int i = 1; i < this.arr.length; i++) {
            if (this.less(this.arr[i], this.arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private void print(Comparable a) {
        System.out.print(a + " ");
    }

    private void println() {
        System.out.println();
    }
}
