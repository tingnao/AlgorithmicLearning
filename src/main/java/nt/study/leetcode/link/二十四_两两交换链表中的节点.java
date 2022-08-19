package nt.study.leetcode.link;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

public class 二十四_两两交换链表中的节点 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */


    public static ListNode swapPairs(ListNode head) {
        ListNode root = packTrack(head);
        return root;
    }

    public static  ListNode packTrack(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode rightNode = head.next;
        head.next = packTrack(rightNode.next);
        rightNode.next = head;
        return rightNode;
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
