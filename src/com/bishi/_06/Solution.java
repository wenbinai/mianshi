//import java.util.*;
//
///*
// * public class ListNode {
// *   int val;
// *   ListNode next = null;
// * }
// */
//
//public class Solution {
//    /**
//     *
//     * @param head ListNode类
//     * @param m int整型
//     * @param n int整型
//     * @return ListNode类
//     */
//    public ListNode reverseBetween (ListNode head, int m, int n) {
//        // write code here
//        if(head == null || head.next == null || m == n) return head;
//        ListNode tmpHead = head;
//        // 1 2 3 4 5  2 4
//        int num = m;
//        while(m -- > 1) {
//            tmpHead = tmpHead.next;
//        }
//
//        ListNode tmp = tmpHead.next;
//        // tmp = 2
//        ListNode pre = tmp, next = null;
//        // 1 2
//        // 1-2-3-4-5
//        // 2->3->4->5
//        // 5->4->3->2->->
//        for(int i = 1; i <= n-num; i ++) {
//            // 1->2->3->4->5
//            next = tmp.next;
//            // 2->4->5
//            tmp.next = next.next;
//            // 3->2->4->5
//            next.next = pre;
//            pre = next;
//        }
//        tmpHead.next = pre;
//        return head;
//    }
//}