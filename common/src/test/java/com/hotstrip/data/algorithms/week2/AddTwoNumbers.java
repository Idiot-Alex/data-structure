package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class AddTwoNumbers {

    @Test
    public void test() {
        ListNode l1 = ListNode.initListNode(new int[] {1, 2, 4});
        ListNode l2 = ListNode.initListNode(new int[] {1, 3, 9});
        log.info(".......................");
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.print(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 还是双指针分别遍历两个链表，直到其中一个链表遍历完成
        // 每次取出一个数字相加，如果大于 9 就需要在下一个节点上加 1
        ListNode head = new ListNode();
        ListNode tail = head;

        ListNode p1 = l1;
        ListNode p2 = l2;

        int temp = 0;

        while (p1 != null || p2 != null || temp != 0) {
            ListNode node = new ListNode();
            // 处理节点为空的情况
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;

            int sum = val1 + val2 + temp;

            node.val = sum % 10;
            temp = sum / 10;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

            // 添加到新链表
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }
}
