package com.livedrof.j2se.algorithm.dp;

import org.junit.Test;

import static com.livedrof.j2se.algorithm.dp.Utils.printArrays;

/**
 *
 */
public class LL {
    private int dp(int[][] data) {
        int m = data.length;
        int n = data[0].length;
        System.out.println(m+""+n);
        int[][] dpp = new int[m][n];
        dpp[0][0] = data[0][0];

        for (int row = 1; row < m; row++) {
            dpp[row][0] = dpp[row-1][0]+data[row][0];
        }
        for (int col = 1; col < n; col++) {
            dpp[0][col] = dpp[0][col-1]+data[0][col];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dpp[row][col] = Math.min(dpp[row - 1][col], dpp[row][col - 1])+ data[row][col];
            }
        }
        System.out.println(dpp[m-1][n-1]);
        printArrays(data);
        System.out.println("-----");
        printArrays(dpp);
        return dpp[m-1][n-1];
    }

    @Test
    public void test() {
        int[][] origin = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        dp(origin);
    }
}
