package com.hotstrip.data.structure.common;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
public class TreeNodeTest extends TestCase {

    @Test
    public void test1() {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);

        // 前序遍历
        log.info("pre order...");
        BinaryTree.preOrderTreeNode(treeNode);
        // 中序遍历
        log.info("in order...");
        BinaryTree.inOrderTreeNode(treeNode);
        // 后序遍历
        log.info("post order...");
        BinaryTree.postOrderTreeNode(treeNode);
    }

    @Test
    public void test2() {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);

        // 前序遍历
        log.info("pre order...");
        BinaryTree.preOrderTreeNodeWithStack(treeNode);

        // 中序遍历
        log.info("in order...");
        BinaryTree.inOrderTreeNodeWithStack(treeNode);

        // 后序遍历
        log.info("post order...");
        BinaryTree.postOrderTreeNodeWithStack(treeNode);
    }
}