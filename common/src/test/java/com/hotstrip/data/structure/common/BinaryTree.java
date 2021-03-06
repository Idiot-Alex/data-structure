package com.hotstrip.data.structure.common;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * use stack
     */

    /**
     * pre order
     * @param node
     */
    public static void preOrderTreeNodeWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                log.info("{}", node.getData());
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    /**
     * in order
     * @param node
     */
    public static void inOrderTreeNodeWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                log.info("{}", node.getData());
                node = node.getRight();
            }
        }
    }

    /**
     * post order
     * this does not complete
     * @param node
     */
    public static void postOrderTreeNodeWithStack(TreeNode node) {
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                log.info("{}", node.getData());
//                node = node.getLeft();
//            }
//
//            if (!stack.isEmpty()) {
//                node = stack.pop();
//                log.info("{}", node.getData());
//                node = node.getRight();
//            }
//
//        }
    }

    /**
     * level order
     */
    public static void levelOrderTreeNode(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            log.info("{}", tempNode.getData());
            if (tempNode.getLeft() != null) {
                queue.offer(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.offer(tempNode.getRight());
            }
        }
    }

}
