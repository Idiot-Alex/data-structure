package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class RemoveNthFromEnd {

    @Test
    public void test() {
        ListNode listNode = ListNode.initListNode(new int[] {1, 2, 3, 4, 5});
        listNode = removeNthFromEnd(listNode, 2);
        ListNode.print(listNode);
        log.info("----------------");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针遍历，快指针先走 n 步，然后两个一起往后遍历，当快指针走到尾部，慢指针就是需要删除的节点
        ListNode header = new ListNode();
        header.next = head;

        ListNode fast = header;
        ListNode slow = header;
        int index = 0;
        while (index < n) {
            fast = fast.next;
            index++;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return header.next;
    }
}
