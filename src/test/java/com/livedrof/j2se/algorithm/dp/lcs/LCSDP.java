package com.livedrof.j2se.algorithm.dp.lcs;

import org.junit.Test;

/**
 * https://blog.csdn.net/lj6020382/article/details/81111558
 */
public class LCSDP {
    /**
     * public void method(char[] a, char[] b) {
     * int na = a.length;
     * int nb = b.length;
     * int[][] f = new int[na+1][nb+1];
     * <p>
     * // 公式
     * int i,j;
     * for (i=1; i<=na; i++) {
     * for (j=1; j<=nb; j++) {
     * // 考虑a,b中有一个是在目标子串中
     * f[i][j] = f[i-1][j] > f[i][j-1] ? f[i-1][j] : f[i][j-1];
     * // 当a,b都在目标子串中
     * if (a[i-1] == b[j-1]) {
     * f[i][j] = (f[i-1][j-1] + 1) > f[i][j] ? (f[i-1][j-1] + 1) : f[i][j];
     * }
     * }
     * }
     * <p>
     * System.out.println("long = " + f[na][nb]);
     * }
     */
    @Test
    public void test() {
        String first = "1239045";
        String second = "123adsf";
        int fLength = first.length();
        int sLength = second.length();
        int[][] maxLengthMatrix = new int[fLength + 1][sLength + 1];
        for (int i = 0; i < fLength; i++) {//按行扫描
            for (int j = 0; j < sLength; j++) {
                maxLengthMatrix[i][j] = maxLengthMatrix[i - 1][j] > maxLengthMatrix[i][j - 1] ? maxLengthMatrix[i - 1][j] : maxLengthMatrix[i][j - 1];
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    maxLengthMatrix[i][j] = (maxLengthMatrix[i - 1][j - 1] + 1) > maxLengthMatrix[i][j] ? (maxLengthMatrix[i - 1][j - 1] + 1) : maxLengthMatrix[i][j];
                }
            }
        }
        System.out.println("long = " + maxLengthMatrix[fLength][sLength]);
    }
}
