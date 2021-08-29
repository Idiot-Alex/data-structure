package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class GetKthFromEnd {

    @Test
    public void test() {
        ListNode listNode = ListNode.initListNode(new int[] {1, 2, 3, 4, 5});
        listNode = getKthFromEnd(listNode, 2);
        ListNode.print(listNode);
        log.info("----------------");
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 思路：快慢指针，快指针先走 k 步。
        // 然后双指针往后走，当快指针走到了尾部节点，慢指针就是倒数第 k 个节点
        ListNode fast = head;
        ListNode slow = head;

        int index = 1;
        while (index < k) {
            index++;
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
