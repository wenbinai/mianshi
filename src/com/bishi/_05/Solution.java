//package com.mianshi.bishi._05;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//
//public class Solution {
//    public static void main(String[] args) {
//
//    }
//
//    // LRU缓存算法
//    public int[] LRU(int[][] operators, int k) {
//        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<>();
//        ArrayList<Integer> result = new ArrayList<>();
//
//        for (int[] opt : operators) {
//            int key = opt[1];
//            switch (opt[0]) {
//                case 1:
//                    int value = opt[2];
//                    if (lruMap.size() < k) lruMap.put(key, value);
//                    else {
//                        Iterator<Integer> iterator = lruMap.keySet().iterator();
//                        lruMap.remove(iterator.next());
//                        lruMap.put(key, value);
//                    }
//                    break;
//                case 2:
//                    if (lruMap.containsKey(key)) {
//                        Integer val = lruMap.get(key);
//                        result.add(val);
//                        lruMap.remove(key);
//                        lruMap.put(key, val);
//                    } else {
//                        result.add(-1);
//                    }
//                    break;
//                default:
//            }
//        }
//    }
//}
