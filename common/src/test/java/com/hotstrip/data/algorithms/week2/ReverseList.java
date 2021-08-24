package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class ReverseList {
    @Test
    public void test() {
        ListNode l1 = ListNode.initListNode(new int[] {1, 2, 4});
        log.info(".......................");
        ListNode listNode = reverseList(l1);
        ListNode.print(listNode);
    }

    public ListNode reverseList(ListNode head) {
        // 遍历传入的链表
        ListNode header = new ListNode();

        ListNode p = head;

        while (p != null) {
            ListNode temp = new ListNode(p.val);
            temp.next = header.next;
            header.next = temp;

            p = p.next;
        }
        return header.next;
    }
}
