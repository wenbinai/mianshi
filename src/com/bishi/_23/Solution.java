package com.bishi._23;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 递归实现自定义排序链表功能
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p = head;
        while (p.next.next != null) p = p.next;
        ListNode insertNode = p.next;
        p.next = null;
        insertNode.next = head.next;
        head.next = insertNode;
        reorderList(insertNode.next);
    }
}
