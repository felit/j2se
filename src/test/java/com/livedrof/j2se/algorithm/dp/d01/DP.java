package com.livedrof.j2se.algorithm.dp.d01;

import org.junit.Test;

public class DP {
    /**
     * TODO 错误 因为N+2会被计算两次，
     *
     * @param n
     * @return
     */
    public int dd(int n) {
        if (n <= 2) {
            return n;
        } else {
//            System.out.println(dd(n - 1));
            return dd(n - 1) + dd(n - 2);
        }
    }

    @Test
    public void test() {
        System.out.println(dd(14));
        System.out.println("------------");
        System.out.println(dp(14));
    }

    public int dp(int n) {
        if (n <= 2) { // 边界
            return n;
        } else {
            // 最优子结构与动态转换方程
            int result = 3;
            int n1 = 1, n2 = 2;
            for (int i = 3; i < n; i++) {
                result = n1 + n2;
                n1 = n2;
                n2 = result;
            }
            return result;
        }
    }


    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // 存储状态转移结果
        //初始化
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(dp[j]+"\t");
        }
        System.out.println();
        //  输出结果集
        for (int j = nums.length  ; j >= 0; j--) {
            if (dp[j] == max) {

            }
        }
        return max;
    }

    @Test
    public void test22() {
        System.out.println(maxSubArray(new int[]{-4,-1,-2,3,4,-10,5,6,-1,4,-10}));
    }

}
