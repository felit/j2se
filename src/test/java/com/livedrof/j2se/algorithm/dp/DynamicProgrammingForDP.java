package com.livedrof.j2se.algorithm.dp;

public class DynamicProgrammingForDP {
    //    三角形行数
    private int n = 5;
    //    三角形数据
    private int[][] nums = {
            { 9},
            {12,  15},
            {10,   6,   8},
            { 2,  18,   9,   5},
            {19,   7,  10,   4,  16},
    };
    public int test1() {
        //  对nums二维数组的行作遍历,从倒数第二行开始
        int start = n-2;
        for(int i = start; i >= 0; i--) {
            //  每一行的长度
            int j = nums[i].length;
            //  对nums二维数组的行中的数组元素作遍历
            for(int k = 0; k < j; k++) {
                nums[i][k] += (nums[i+1][k] >= nums[i+1][k+1] ? nums[i+1][k] : nums[i+1][k+1]);
            }
        }
        //  返回三角形顶的数据,此时的三角形顶的值就是三角形最大和
        return nums[0][0];
    }

    public static void main(String[] args) {
        DynamicProgrammingForDP dynamicProgramming = new DynamicProgrammingForDP();
//        System.out.println(dynamicProgramming.test(0,0));
        System.out.println(dynamicProgramming.test1());
    }
}
