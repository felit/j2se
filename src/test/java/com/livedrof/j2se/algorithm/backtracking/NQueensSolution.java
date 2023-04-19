package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolution {
    @Test
    public void test() {
        System.out.println(new NQueensSolution().solveNQueens(6));
        print(new NQueensSolution().solveNQueens(4));
    }

    private static void print(List<List<String>> kk) {
        for (int i = 0; i < kk.size(); i++) {
            for (int j = 0; j < kk.size(); j++) {
                System.out.println(kk.get(i).get(j));
            }
            System.out.println("-----");
        }
    }

    private List<List<String>> res = new ArrayList<>(); // 最终答案

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n]; // 定义棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.'; // 棋盘初始化默认都是空
            }
        }
        // 占用为true，未占用false
        // 记录第k列有没有被占用
        boolean[] col = new boolean[n];
        // 记录主对角线方向有没有被占用（左上到右下）
        // 该方向的x=row-col是固定的，范围为-n+1~n-1共2n-1个数，n-x之后范围是1~2n-1，用2n的数组就可以容纳
        boolean[] mainDiag = new boolean[2 * n];
        // 记录副对角线方向有没有被占用（右上到左下）
        // 该方向的x=row+col是固定的，范围为0~2n-2共2n-1个数，用2n的数组也可以表示2n-1条对角方向
        boolean[] subDiag = new boolean[2 * n];
        dfs(0, n, grid, col, mainDiag, subDiag); // 利用dfs为每一个皇后搜索摆放位置
        return res;
    }

    // 策略为每个皇后摆放一行，r代表当前摆放到行index, n为皇后个数，grid棋盘，后面3个冲突检查数组
    public void dfs(int r, int n, char[][] grid, boolean[] col, boolean[] mainDiag, boolean[] subDiag) {
        if (r == n) { // 当最后一个皇后摆放完毕（任务成昆！）
            List<String> list = new ArrayList<>(); // 新list记录当前此种摆放结果
            for (int i = 0; i < n; i++) { // 每一行
                list.add(new String(grid[i])); // 将char[]转成String添加进去
            }
            res.add(list); // 此种摆放结果添加到结果集
            return;
        }
        for (int c = 0; c < n; c++) { // 对每一列遍历（摆放女王，列也不能重复）
            // 该列空，该位置主对角线方向空，该位置副对角线方向空
            if (!col[c] && !mainDiag[n - r + c] && !subDiag[r + c]) {
                // 可以摆放，棋盘记录
                grid[r][c] = 'Q';
                // 更新冲突数组
                col[c] = mainDiag[n - r + c] = subDiag[r + c] = true;
                // 摆放下一个皇后
                dfs(r + 1, n, grid, col, mainDiag, subDiag);
                // 撤销操作，不影响下一次摆放
                col[c] = mainDiag[n - r + c] = subDiag[r + c] = false;
                grid[r][c] = '.';
            }
        }
    }
}