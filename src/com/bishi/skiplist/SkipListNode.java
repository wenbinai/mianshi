//package com.mianshi.bishi.skiplist;
//
//import java.util.Arrays;
//
//// 手写跳表
//public class SkipListNode<E> {
//    int key;
//    E value;
//    SkipListNode<E>[] forwards;
//
//    public SkipListNode(int key, E value, int maxLevel) {
//        this.key = key;
//        this.value = value;
//        this.forwards = new SkipListNode[maxLevel];
//    }
//
//    @Override
//    public String toString() {
//        return "SkipListNode{" +
//                "key=" + key +
//                ", value=" + value +
//                ", forwards=" + Arrays.toString(forwards) +
//                '}';
//    }
//
//    public E search(int searchKey) {
//        SkipListNode<E> c = this.head;
//        for (int i = currentLevel - 1; i >= 0; i--) {
//            while (c.forwards[i].key < searchKey) {
//                c = c.forwards[i];
//            }
//            if (c.forwards[i].key == searchKey) {
//                return c.forwards[i].value;
//            }
//        }
//        return null;
//    }
//
//    public void insert(int searchKey, E newValue) {
//
//    }
//
//}
