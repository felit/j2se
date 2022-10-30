package com.livedrof.algs.chapter1_4;

import java.security.MessageDigest;

public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }

            }
        }
        return cnt;
    }

    public static void main(String args[]) {
        int[] a = new int[]{1, -2, 3, 4, 5, -7, 8, 8, 8, 6, 44, 3, 2, 2, 2, 3, 5, 6, 6, 2};
        System.out.println(count(a));
//        MessageDigest md= MessageDigest.getInstance();
//        md.getAlgorithm();
    }
}