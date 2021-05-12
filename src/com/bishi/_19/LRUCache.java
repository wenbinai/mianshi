package com.bishi._19;

import java.util.HashMap;
import java.util.Map;

// 自己定义一个双链表实现一个LRUCache
// > 扩展: 如何添加定时删除的功能? 如何保存在内存中? (参考Redis里面的实现)
public class LRUCache {
    private Map<Integer, Node> map;
    private DoubleList doubleList;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            doubleList.moveToFirst(node);
            return node.val;
        }
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
            doubleList.addFirst(node);
            map.put(key, node);
        } else {
            if (doubleList.size() == capacity) {
                map.remove(doubleList.removeLast().key);
            }
            doubleList.addFirst(node);
            map.put(key, node);
        }
    }
}

class DoubleList {
    private Node head;
    private Node tail;
    private int count = 0;

    public DoubleList() {
        tail = new Node();
        head = new Node();
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        count++;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        count--;
    }

    public Node removeLast() {
        Node node = tail.pre;
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
        count--;
        return node;
    }

    public int size() {
        return count;
    }

    public void moveToFirst(Node node) {
        remove(node);
        addFirst(node);
    }
}

class Node {
    public int key, val;
    public Node next, pre;

    public Node() {
    }

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}