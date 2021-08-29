package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class MiddleNode {

    @Test
    public void test() {
        ListNode listNode = ListNode.initListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        listNode = middleNode(listNode);
        ListNode.print(listNode);
        log.info("----------------");

        listNode = ListNode.initListNode(new int[] {1, 2, 3, 4});
        listNode = middleNode(listNode);
        ListNode.print(listNode);
        log.info("----------------");

        listNode = ListNode.initListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        listNode = middleNode2(listNode);
        ListNode.print(listNode);
        log.info("----------------");

        listNode = ListNode.initListNode(new int[] {1, 2, 3, 4});
        listNode = middleNode2(listNode);
        ListNode.print(listNode);
        log.info("----------------");

        listNode = ListNode.initListNode(new int[] {1});
        listNode = middleNode2(listNode);
        ListNode.print(listNode);
        log.info("----------------");

    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode p = head;
        // 遍历链表，获取节点个数
        while (p != null) {
            count++;
            p = p.next;
        }

        // 再次遍历链表，找到中间节点
        ListNode header = new ListNode();
        header.next = head;
        int i = 0;
        while (i < count / 2) {
            header.next = header.next.next;
            i++;
        }
        return header.next;
    }

    /**
     * 快慢指针
     * 快指针每次走两步，慢指针每次走一步
     * 当快指针走完，慢指针的位置就是中间节点
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
