package com.livedrof.j2se.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSolution {
    List<List<Integer>> result = new ArrayList<>();//存放最终的结果
    LinkedList<Integer> path = new LinkedList<>();//存放每个结果，并且充当栈的作用，进行回溯操作

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    //每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
    //@param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）
    private void dfs(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {//因为一次是要找k个数的组合
            result.add(new ArrayList<>(path));
            return;
        }
        //单层逻辑
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            //剪枝过程：已经选择的元素为path.size(),还需要的元素个数为k-path.size(),剪枝是因为总i后面开始，不能组成长度为k的组合（长度不足）
            //比如n=4,k=2,path.size()=80,startIndex=1,2,3都可以,但是4不行，容易得出i的上限为:n-(k-path.size())+1
            path.add(i);
            dfs(n, k, i + 1);
            System.out.println(path);
            //TODO 回溯方法
            path.removeLast();
        }
    }

    @Test
    public void test() {
        CombinationSolution so = new CombinationSolution();
        so.combine(5, 3);
        System.out.println(so.result);
    }
}