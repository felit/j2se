package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、迭代形式实现 时间复杂度:
 * 2、回溯形式实现 时间复杂度:
 */
public class PermutationSolution {
    /**
     * 思路: 用迭代，没有用递归
     * 按层遍历，每一层在上一层的基础上添加元素的位置
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permutationForIterationDebug(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new LinkedList<>();
        List<Integer> tmp;
        res.add(row);
        for (int eleIndex = 0; eleIndex < nums.length; eleIndex++) {
            int ele = nums[eleIndex];// 待排列元素
            System.out.println("------------eleIndex:" + eleIndex);
            // 上一层(轮)的元素
            for (int size = res.size(), j = size - 1; j >= 0; j--) {
                tmp = res.remove(j);
                System.out.println("tmp:" + tmp);
                //eleIndex+1个位置
                for (int k = 0; k < eleIndex + 1; k++) {
                    row = new LinkedList<>(tmp);
                    row.add(k, ele);
                    res.add(row);
                }
                System.out.println("res:" + res);
            }
        }
        return res;
    }

    public List<List<Integer>> permutationForIteration2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 为空数组的初始值
        result.add(new LinkedList<>());
        List<Integer> row, tmp;
        for (int index = 0; index < nums.length; index++) {
            int elem = nums[index];
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                tmp = result.remove(j); //影响result大小，所以上行代码，只能是倒序
                for (int i = 0; i < index + 1; i++) {
                    row = new ArrayList<>(tmp);
                    row.add(i, elem);
                    result.add(row);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        PermutationSolution solution = new PermutationSolution();
//        System.out.println(solution.permutation(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(solution.permutationForIteration2(new int[]{1, 2, 3}));
//        System.out.println(solution.permutationForIterationDebug(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<Integer>());
        return res;

    }

    /**
     * @param res
     * @param nums
     * @param path
     */
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, nums, path);
            path.remove(path.size() - 1);
        }
    }
}
