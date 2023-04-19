package com.livedrof.j2se.algorithm.backtracking;

/**
 * https://leetcode.cn/problems/bst-sequences-lcci/description/
 *  二叉搜索树序列
 *  从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 *
 * 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3]
 * 输出: [[2,1,3],[2,3,1]]
 * 解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
 *        2
 *       / \
 *      1   3
 * 示例 2:
 * 输入: root = [4,1,null,null,3,2]
 * 输出: [[4,1,3,2]]
 *
 *
 * 提示：
 * 二叉搜索树中的节点数在 [0, 1000] 的范围内
 * 1 <= 节点值 <= 10^6
 * 用例保证符合要求的数组数量不超过 5000
 */
public class BinaryTreeSequenceSolution {
}
