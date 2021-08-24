package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class DeleteDuplicates {

    @Test
    public void test() {
        ListNode listNode = ListNode.initListNode(new int[] {1, 1, 2});
        ListNode.print(listNode);
        log.info(".......................");
        listNode = deleteDuplicates(listNode);
        ListNode.print(listNode);

        listNode = ListNode.initListNode(new int[] {1, 1, 2, 3, 3});
        ListNode.print(listNode);
        log.info(".......................");
        listNode = deleteDuplicates(listNode);
        ListNode.print(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 判断非空
        if (head == null)
            return null;
        ListNode header = new ListNode();
        header.next = head;
        ListNode p = head;

        // 遍历
        while (p.next != null) {
            // 如果当前节点和下一个节点 val 相等，就删除
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                // 否则就赋值下一个节点
                p = p.next;
            }
        }
        return header.next;
    }
}
