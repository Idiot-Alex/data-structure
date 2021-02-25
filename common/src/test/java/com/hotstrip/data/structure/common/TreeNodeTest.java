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
        log.info("前序遍历...");
        BinaryTree.preOrderTreeNode(treeNode);
        // 中序遍历
        log.info("中序遍历...");
        BinaryTree.inOrderTreeNode(treeNode);
        // 后序遍历
        log.info("后序遍历...");
        BinaryTree.postOrderTreeNode(treeNode);
    }
}