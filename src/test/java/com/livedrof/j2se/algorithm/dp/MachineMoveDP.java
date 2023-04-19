package com.livedrof.j2se.algorithm.dp;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

import static com.livedrof.j2se.algorithm.dp.Utils.printArrays;

/**
 *机器人的运动范围 https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MachineMoveDP {
    public static int movingCount(int m, int n, int k) {
        int count = 0;
        int round = 10;
        if (k >= 9) {
            round = (k - 7) * 10;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && i + j < round; j++) {
                int sumI = i / 100 + i / 10 + i % 10;
                int sumJ = j / 100 + j / 10 + j % 10;
                if (sumI + sumJ <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(movingCount(10, 10, 8));
        System.out.println(movingCount(16, 8, 4));
//        System.out.println(movingCountForIterator(16, 8, 14));
        System.out.println(movingCountForIterator(38, 15, 10));
    }

    @Test
    public void test2() {
        System.out.println(sumOf(123));
        System.out.println(sumOfTwo(123, 82));
    }

//    public void movingCountFor

    public int movingCountForIterator(int m, int n, int k) {
        //TODO 判断
        boolean[][] booleans = new boolean[m][n];
        booleans[0][0] = true;
        int count = 1;
        // 初始化部分是否可以转至主体部分?
        for (int i = 1; i < m; i++) {
            booleans[i][0] = i == 0 ? sumOf(i) <= k : (sumOf(i) <= k) && booleans[i - 1][0];
            if(booleans[i][0]){
                count++;
            }
        }
        for (int i = 1; i < n; i++) {
            booleans[0][i] = i == 0 ? sumOf(i) <= k : (sumOf(i) <= k) && booleans[0][i - 1];
            if(booleans[0][i]){
                count++;
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                // 上一个阶段决策：booleans[i - 1][j] && booleans[i][j - 1]
                // sumOfTwo(i, j) <= k 本阶段决策
                booleans[row][col] = (booleans[row - 1][col] || booleans[row][col - 1]) && sumOfTwo(row, col) <= k;
                if (booleans[row][col]) {
                    count++;
                }
            }
        }
        printArrays(booleans);
        return count;
    }

    /**
     * 两个数的数位之和
     *
     * @param i
     * @param j
     * @return
     */
    private int sumOfTwo(int i, int j) {
        return this.sumOf(i) + this.sumOf(j);
    }

    /**
     * 一个数的数位之和
     *
     * @param k
     * @return
     */
    private int sumOf(int k) {
        assert k < 1000;
        return k / 100 + k % 100 / 10 + k % 10;
    }


    @Test
    public void test22() {
        System.out.println(movingCountForDfs(38, 15, 10));
        System.out.println(movingCountForIterator(38, 15, 10));
        System.out.println(movingCountForBfs(38, 15, 10));
    }

    public int movingCountForDfs(int m, int n, int k) {
        // 状态转移且的默认值是false
        boolean[][] visited = new boolean[m][n];
        printArrays(visited);
        int count =  dfs(visited, m, n, k, 0, 0);
        printArrays(visited);
        return count;
    }

    /**
     * 可以及时终止;如果K比较小的话，可以降低时间复杂度；
     *
     * @param visited
     * @param m
     * @param n
     * @param k
     * @param i
     * @param j
     * @return
     */
    private int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
        if(i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) return 0;
        visited[i][j] = true;
        //行的方向，列的方向 上一阶段的关系如何表达的?
        return 1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1) ;
    }

    private int bitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int movingCountForBfs(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        // 移动方向
        int[][] direct = {{1, 0}, {0, 1}};
        int res = 0;
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(0, 0));
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> cor = queue.poll();
            Integer x = cor.getKey();
            Integer y = cor.getValue();
            int sum = x / 10 + x % 10 + y / 10 + y % 10;
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || sum > k) {
                continue;
            }
            visited[x][y] = true;
            res++;
            for (int i = 0; i < 2; i++) {
                queue.add(new AbstractMap.SimpleEntry<>(x + direct[i][0], y + direct[i][1]));
            }
        }
        return res;
    }
}
