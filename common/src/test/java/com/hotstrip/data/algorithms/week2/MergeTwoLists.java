package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class MergeTwoLists {

    @Test
    public void test() {
        ListNode l1 = ListNode.initListNode(new int[] {1, 2, 4});
        ListNode l2 = ListNode.initListNode(new int[] {1, 3, 4});
        log.info(".......................");
        ListNode listNode = mergeTwoLists(l1, l2);
        ListNode.print(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 判断是否为空
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 定义一个新的链表
        ListNode newNode = new ListNode();
        ListNode tail = newNode;

        ListNode p = l1;
        ListNode q = l2;

        // 使用双指针遍历两个链表
        while (p != null && q != null) {
            // 判断两个指针当前的 val 大小，谁小一些谁就指向下一个节点，同时把当前小的节点添加到新链表的尾部，还需要更新当前的尾部节点
            if (p.val >= q.val) {
                tail.next = q;
                tail = q;
                q = q.next;
            } else {
                tail.next = p;
                tail = p;
                p = p.next;
            }
        }

        // 一直到某个指针的节点为 null，就把另一个指针的后面节点添加到新链表尾部
        if (p != null) {
            tail.next = p;
        }
        if (q != null) {
            tail.next = q;
        }

        return newNode.next;

    }
}
