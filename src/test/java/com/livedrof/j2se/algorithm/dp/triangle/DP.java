package com.livedrof.j2se.algorithm.dp.triangle;

import org.junit.Test;

/**
 * TODO: Java-数字三角形(回溯法) https://blog.csdn.net/qq_45803545/article/details/115703388
 * 参考：https://blog.csdn.net/qq_33945246/article/details/96303291
 * 最优子结构、重叠子问题;
 * 总结：
 * 1、边界，即起始点；
 * 2、状态转换，并考虑边界; 即最优子结构; 累加、状态
 * 3、两层迭代(因其是表格形式,二维数据)；
 * 4、取最终值
 * TODO: 结果如何输出?
 */

public class DP {
    /**
     * 状态转换后的结果
     * 9	0	0	0	0
     * 21	24	0	0	0
     * 31	30	32	0	0
     * 33	49	41	37	0
     * 52	56	59	45	53
     */
    private int[][] nums2 = {
            {9},
            {12, 15},
            {10, 6, 8},
            {2, 18, 9, 5},
            {19, 7, 10, 4, 16},
    };

    private int[][] nums = {
            {1},
            {10, 1},
            {1, 10, 1},
            {1, 10, 1, 1},
            {1, 10, 1, 1, 1}
    };

    /**
     * 怎样取值的路径(解)
     * O(n平方/2)
     */
    @Test
    public void testTopToDown() {
        int[][] nums = this.nums;
        //存储转换之后的状态；即最优子结构的状态
        int[][] table = new int[nums.length][nums.length];
        // 边界；由原来的个体的状态，转换成累加等最优子结构状态；回溯法？？
        table[0][0] = nums[0][0];

        // 状态转移方程
        int row, tmpCol;
        //按层迭代
        for (row = 1; row < nums.length; row++) { // O(nums.length)
            for (tmpCol = 0; tmpCol <= row; tmpCol++) {

                /*判断是否数组越界,左右两边需单独处理*/
                if (tmpCol == 0) {//开头特殊处理
                    table[row][tmpCol] = table[row - 1][tmpCol] + nums[row][tmpCol];
                } else if (tmpCol == row) {//结尾特殊处理
                    table[row][tmpCol] = table[row - 1][tmpCol - 1] + nums[row][tmpCol];
                } else {// 最优子结构
                    int max = table[row - 1][tmpCol] > table[row - 1][tmpCol - 1] ? table[row - 1][tmpCol] : table[row - 1][tmpCol - 1];
                    table[row][tmpCol] = max + nums[row][tmpCol];
                }
            }
        }

        // 获取最大值
        int temp = 0;
        for (row = 0; row < nums.length; row++) {
            if (table[nums.length - 1][row] > temp) {
                temp = table[nums.length - 1][row];
            }
        }
        //TODO Arrays.asList(int[])-> List<int[]>

        System.out.println(table[nums.length - 1][nums.length - 1]);

        this.printIntArrays(nums, table);
        System.out.println(temp);
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private void printIntArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + ":\t");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void printIntArrays(int[][] original, int[][] target) {
        System.out.println("原数组:");
        this.printIntArray(original);
        System.out.println("------------------------");
        this.printIntArray(target);
    }

    /**
     * 逆推
     * 含义：f[x][y]表示从x,y到终点的最大值,所以f[0][0]即为所求
     * 公式：f[x][y] = max{f[x+1][y+1],f[x+1][y]} + a[x][y]
     * 边界：f[length-1][0...length-1] = a[length-1][0...length-1]
     */
    @Test
    public void testDownToTop() {
        int[][] nums = this.nums2;
        int[][] table = new int[nums.length][nums.length];

        // 边界
        int i, j;
        for (i = 0; i < nums.length; i++) {//最后一行数
            table[nums.length - 1][i] = nums[nums.length - 1][i];
        }
        this.printIntArray(table);
        // 状态转移
        for (i = nums.length - 2; i >= 0; i--) {
            for (j = 0; j <= i; j++) {
                int[] row_nums = table[i + 1];
                int max = row_nums[j + 1] > row_nums[j] ? row_nums[j + 1] : row_nums[j];
                table[i][j] = max + nums[i][j];
            }
        }
        printIntArrays(nums, table);
    }
}
