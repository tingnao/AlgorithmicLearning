package nt.study.leetcode.link;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

public class 十九_删除链表的倒数第N个结点 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for(int i = 0; i < n  ;i++){
            if(Objects.isNull(right.next)){
                return head.next;
            }
            right = right.next;
        }
        while(!Objects.isNull(right.next)){
            right =right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }


    @Builder
    @Data
    @ToString
      public static class ListNode {
          int val;ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        ListNode build = ListNode.builder().val(1).next(ListNode.builder().val(2).next(ListNode.builder().val(3).next(ListNode.builder().val(4).next(null).build()).build()).build()).build();
        ListNode listNode = removeNthFromEnd(build, 2);
        System.out.println(listNode);

    }
}
