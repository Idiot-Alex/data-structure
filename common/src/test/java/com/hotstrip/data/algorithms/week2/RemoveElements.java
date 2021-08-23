package com.hotstrip.data.algorithms.week2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class RemoveElements {

    @Test
    public void test() {
        ListNode listNode = ListNode.initListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        ListNode.print(listNode);
        log.info(".......................");
        listNode = removeElements(listNode, 6);
        ListNode.print(listNode);

        log.info("=======================");

        listNode = ListNode.initListNode(new int[] {7, 7, 7, 7, 7, 7, 7});
        ListNode.print(listNode);
        log.info(".......................");
        listNode = removeElements(listNode, 7);
        ListNode.print(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        // 定义头节点和遍历用的当前节点
        ListNode header = new ListNode();
        header.next = head;
        ListNode p = header;

        // 终止条件是链表的下一个元素为空
        // 遍历链表元素，判断是否和 val 相等
        while (null != p.next) {
            // 如果相等，删除这个元素
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                // 下一个
                p = p.next;
            }
        }
        return header.next;
    }
}
