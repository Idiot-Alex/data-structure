package com.hotstrip.data.structure.common;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class BinaryTree {

    /**
     * 生成二叉树
     * @param list
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode();
        Integer data = list.removeFirst();
        if (data != null) {
            node.setData(data);
            node.setLeft(createBinaryTree(list));
            node.setRight(createBinaryTree(list));
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        log.info("{}", node.getData());
        preOrderTreeNode(node.getLeft());
        preOrderTreeNode(node.getRight());
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTreeNode(node.getLeft());
        log.info("{}", node.getData());
        inOrderTreeNode(node.getRight());
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTreeNode(node.getLeft());
        postOrderTreeNode(node.getRight());
        log.info("{}", node.getData());
    }
}
