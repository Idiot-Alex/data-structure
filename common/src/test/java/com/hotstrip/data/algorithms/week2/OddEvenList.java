package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class OddEvenList {

    @Test
    public void test() {
        ListNode l1 = ListNode.initListNode(new int[] {1, 2, 3, 4, 5});
        ListNode listNode = oddEvenList(l1);
        ListNode.print(listNode);
        log.info(".......................");
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 分奇偶链表
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        ListNode p = head;

        int index = 1;
        while (p != null) {
            ListNode temp = p.next;
            // 奇数链表
            if (index % 2 == 1) {
                p.next = null;
                oddTail.next = p;
                oddTail = p;
            } else {
                // 偶数链表
                p.next = null;
                evenTail.next = p;
                evenTail = p;
            }
            index++;
            p = temp;
        }

        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}
