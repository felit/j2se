package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集问题
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class SubSetSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 1; i < Math.pow(2, nums.length); i++) {  // 从1到2^10-1的每个数，分别输出一个一维数组
            int j = 1; //j用来控制按位与的次数，
            int flag = 1;
            List<Integer> temp = new ArrayList<>();
            while (j <= nums.length) {  //循环的放一维数组
                if ((flag & i) != 0) {
                    temp.add(nums[nums.length - j]);
                }
                flag <<= 1;
                System.out.println("flag:"+flag);
                j++;
            }
            resultList.add(temp);
        }
        resultList.add(new ArrayList<>());
        return resultList;
    }

    @Test
    public void test() {
        SubSetSolution solution = new SubSetSolution();
        System.out.println(solution.subsets(new int[]{1, 2, 3, 4,6}));
    }
}
