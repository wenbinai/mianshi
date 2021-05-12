package com.bishi._19;

public class LRUCache02 {
    Node head, tail;
    Node[] nodes;

    int size = 0;
    int capacity;

    public LRUCache02(int capacity) {
        this.capacity = capacity;
        nodes = new Node[3001];
    }

    public int get(int key) {
        Node node = nodes[key];
        if (node == null) return -1;
        Node pre = node.pre, next = node.next;
        if (pre != null && next != null) {
            // 在中间
            midToHead(node, pre, next);
        } else if (next != null) {
            // 在尾
            tailToHead(node, next);
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodes[key];
        if (node != null) {
            node.val = value;
            Node pre = node.pre, next = node.next;
            if (pre != null && next != null) {
                // 在中间
                midToHead(node, pre, next);
            } else if (next != null) {
                // 在尾
                tailToHead(node, next);
            }
        } else {
            // 新增
            node = new Node(key, value);
            nodes[key] = node;
            if (head != null) {
                // 插入到头
                node.pre = head;
                head = head.next = node;
            } else {
                // 第一个元素
                tail = head = node;
            }
            if (++size > capacity) {
                // 删除最久未用
                int oldKey = tail.key;
                nodes[oldKey] = null;
                tail.next.pre = null;
                tail = tail.next;
                size--;
            }
        }
    }

    private void midToHead(Node node, Node pre, Node next) {
        pre.next = next;
        next.pre = pre;
        node.pre = head;
        node.next = null;
        head = head.next = node;
    }

    private void tailToHead(Node node, Node next) {
        tail = next;
        next.pre = null;
        node.pre = head;
        node.next = null;
        head = head.next = node;
    }
}

