package com.livedrof.j2se.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SqrtTransform extends RecursiveAction {
    private final int seqThreshold = 1000;
    private double[] data;
    private int start, end;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        System.out.println("start:" + start + ", end:" + end + ", seqTheshold:" + seqThreshold);
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle),
                    new SqrtTransform(data, middle, end));

        }
    }
}

class ForkJoinDemo {
    public static void main(String args[]) {
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("A portion of the original sequence:");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        fjp.invoke(task);
        System.out.println("A portion of the transformed sequence" + "(to four decimal places):");
        for (int i = 0; i < 101; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}
