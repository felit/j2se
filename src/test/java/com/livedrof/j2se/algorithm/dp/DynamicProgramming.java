package com.livedrof.j2se.algorithm.dp;

public class DynamicProgramming {
    // 递归算法
    public void test1() {

        //    三角形行数
        int n = 5;
        //    三角形数据
        int[][] nums = {
                {9},
                {12, 15},
                {10, 6, 8},
                {2, 18, 9, 5},
                {19, 7, 10, 4, 16},
        };


    }


    //    递归算法
    public int test(int x,int y) {
//        //如果已经到三角形底部就直接返回底部的数据
//        if(x == n-1) {
//            return nums[x][y];
//        }
//        //每个位置下面有两个选择，选择最大和的那个
//        return (nums[x][y] + (test(x+1,y) >= test(x+1,y+1) ? test(x+1,y) : test(x+1,y+1)));
        return 0;
    }



}
