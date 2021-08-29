package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class IsPalindrome {

    @Test
    public void test() {
        ListNode l1 = ListNode.initListNode(new int[] {1, 1, 2, 1});
        log.info(".......................{}",
                isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        // 使用快慢指针找到链表的中间节点
        ListNode midNode = getMidNode(head);
        // 然后反转中间节点之后的链表
        ListNode newNode = reverse(midNode.next);
        // 最后判断反转之后的链表和前半部分链表是否相等
        ListNode p = head;
        ListNode q = newNode;
        while (q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /**
     * 获取中间节点
     * @param head
     * @return
     */
    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转后面部分的节点
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode header = new ListNode();
        ListNode p = head;

        while (p != null) {
            ListNode temp = p.next;
            p.next = header.next;
            header.next = p;
            p = temp;
        }
        return header.next;
    }
}
