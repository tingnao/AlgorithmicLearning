package nt.study.leetcode.link;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

public class 八十二_删除排序链中的重复元素Ⅱ {
    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    public ListNode myDeleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preNode = new ListNode(-1, head);
        ListNode leftNode = preNode, rightNode = head.next;
        while(rightNode != null){
            if(leftNode.next.val == rightNode.val){
                while(rightNode!=null && leftNode.next.val == rightNode.val){
                    rightNode = rightNode.next;
                }
                leftNode.next = rightNode;
            }else{
                leftNode = leftNode.next;
            }
            if(rightNode != null){
                rightNode = rightNode.next;
            }
        }
        return preNode.next;
    }


    // 力扣解法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    @Builder
    @Data
    @ToString
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
