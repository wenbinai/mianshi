package com.bishi._25;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head, head1 = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode head2 = recover(fast);
        head1 = head;
        head = merge(head1, head2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode res = head1, next1 = null, next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;
            head2.next = next1;
            head1.next = head2;
            head2 = next2;
            head1 = next1;
        }
        return res;
    }

    private static ListNode recover(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, pre = head, next = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) return pre;
            cur.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }
}
