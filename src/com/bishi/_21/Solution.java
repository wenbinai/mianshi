package com.bishi._21;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// 随机指针链表的复制
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head;
        Node next = null;
        // build hash relation
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // copy random
        cur = head;
        Node copyHead = null;
        while (cur != null) {
            next = cur.next.next;
            copyHead = cur.next;
            copyHead.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        // spilt
        cur = head;
        Node res = head.next;
        while (cur != null) {
            next = cur.next.next;
            copyHead = cur.next;
            cur.next = next;
            copyHead.next = next == null ? null : next.next;
            cur = next;
        }
        return res;
    }
}
