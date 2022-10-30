package com.livedrof.algs.tree.bin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 前、中、后序遍历
 */
public class BinTreeNode {
    private BinTreeNode left;
    private BinTreeNode parent;
    private BinTreeNode right;
    private Object data;

    public BinTreeNode(Object data) {
        this.data = data;
    }

    public BinTreeNode(BinTreeNode left, BinTreeNode right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public BinTreeNode getParent() {
        return parent;
    }

    public void setParent(BinTreeNode parent) {
        this.parent = parent;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BinTreeNode createBinTree(Object[] objs) {
        List<BinTreeNode> nodes = Arrays.asList(objs).stream().map(o -> new BinTreeNode(o)).collect(Collectors.toList());
        for (int i = 0; i < objs.length / 2; i++) {
            nodes.get(i).left = nodes.get(i * 2 + 1);
//            右孩子
            if (i * 2 + 2 < nodes.size()) {//避免偶数的时候 下标越界
                nodes.get(i).right = nodes.get(i * 2 + 2);
            }
        }
        return nodes.get(0);
    }

    public void preOrder(BinTreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }

    }

    public void inOrder(BinTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getData());
            inOrder(node.getRight());
        }
    }

    public void afterOrder(BinTreeNode node) {
        if (node != null) {
            afterOrder(node.getLeft());
            afterOrder(node.getRight());
            System.out.println(node.getData());
        }
    }

    public static void main(String args[]) {
        BinTreeNode root = createBinTree(new Object[]{2, 4, 5, 7, 1, 6, 12, 32, 51, 22});
        root.preOrder(root);
        System.out.println("----");
        root.inOrder(root);
        System.out.println("----");
        root.afterOrder(root);
        System.out.println("----");

    }
}
