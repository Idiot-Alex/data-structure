package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 输出节点
     */
    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * init ListNode
     * @param nums
     * @return
     */
    public static ListNode initListNode(int[] nums) {
        ListNode listNode = new ListNode(nums[0]);
        ListNode p = listNode;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return listNode;
    }
}