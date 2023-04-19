package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 求子集 (subset)，求排列(permutation)，求组合(combination)
 */
public class Backtrack {
    /**
     * 组合 n*(n-1)/2
     *
     * @param n
     * @param k
     * @return
     */
    public int[][] combination(int n, int k) {
        int sum = n * (n - k) / 2; //????
        System.out.println("组合种类:" + sum);

        //TODO 实现
        return null;
    }

    /**
     * n*(n-1)*....*1
     *
     * @param n
     * @param k
     * @return
     */
    public int[][] permutation(int n, int k) {
        assert n > k;
        int sum = 1;
        for (int i = 1; i <= k; i++) {
            sum = sum * (n - k + 1);
        }
        System.out.println("排列种类:" + sum);
        return null;
    }

    @Test
    public void ttest() {
        combination(4, 2);
    }


}
