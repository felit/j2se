package com.livedrof.j2se.tree;

import com.livedrof.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TreeTest {
    @Before
    public void setUp() {
        TreeNode node1 = new TreeNode<String>("hello1");
        TreeNode node2 = new TreeNode<String>("world2");
        TreeNode node3 = new TreeNode<String>("hello3");
        TreeNode node4 = new TreeNode<String>("hello4");
        TreeNode node5 = new TreeNode<String>("hello5");
        TreeNode node6 = new TreeNode<String>("hello6");
        TreeNode node7 = new TreeNode<String>("hello7");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        node4.setRight(node7);
    }

    @Test
    public void test() {

    }

    public void inOrder(TreeNode<String> root) {
        if (root == null) {
            System.out.println(root.getValue());
        }else{

        }
    }
}
