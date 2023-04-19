package com.livedrof.j2se.algorithm.dp;

import org.junit.Test;

public class DynamicProgrammingFor {

    //    三角形行数
    private int n = 5;
    //    三角形数据
    private int[][] nums = {
            {9},
            {12, 15},
            {10, 6, 8},
            {2, 18, 9, 5},
            {19, 7, 10, 4, 16},
    };

//    public int ee() {
//
//    }
    //    递归算法

    /**
     * @param x
     * @param y
     * @return
     */
    public int test(int x, int y) {
        //如果已经到三角形底部就直接返回底部的数据
        if (x == n - 1) {
            return nums[x][y];
        }
        //每个位置下面有两个选择，选择最大和的那个
        int left = test(x + 1, y);
        int right = test(x + 1, y + 1);
        System.out.println(x+":"+y);
        return (nums[x][y] + (left >= right ? left : right));
    }

    @Test
    public void test2() {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        System.out.println(dynamicProgramming.test(0, 0));
    }
}
