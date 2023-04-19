package com.livedrof.j2se.algorithm.dp;

public class Utils {
    public static void printArrays(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printArrays(boolean[][] grid) {
        System.out.print("\t");
        for (int j = 0; j < grid[0].length; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print((grid[i][j]? 'Y':' ') + "\t");
            }
            System.out.println();
        }
    }
}
