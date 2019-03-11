package com.xujm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>示例： 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * @author xujm
 * @date 2018/12/11
 */
public class AddTwoNumbers {

    private static final int NICE = 9;

    public static void main(String[] args) {
        ListNode l1 = build(1, 8);
        ListNode l2 = build(0);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = build(l1.val + l2.val);
        ListNode node = result;
        while (null != l1.next || null != l2.next) {
            int val = 0;
            if (null != l1.next) {
                val = l1.next.val;
                l1 = l1.next;
            }
            if (null != l2.next) {
                val = l2.next.val + val;
                l2 = l2.next;
            }
            if (null != node.next) {
                val = node.next.val + val;
            }
            node.next = build(val);
            node = node.next;
        }

        return result;
    }

    private static ListNode build(int val) {
        ListNode node = new ListNode(val % 10);
        if (NICE < val) {
            node.next = new ListNode(1);
        }
        return node;
    }

    private static ListNode build(int... vals) {
        ListNode node = null;
        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(vals[i]);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode node = next;
            while (null != node) {
                sb.append(",");
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }
}
