package nt.study.leetcode.link;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class 二_两数相加 {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0, x, y;
        ListNode root = l1;
        while(l1 != null || l2 !=null || add != 0){
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            add = add + x + y;
            l1.val = add % 10;
            add = add / 10;
            if(l1.next == null && ((l2 !=null && l2.next !=null) || add !=  0)){
                l1.next = new ListNode();
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        return root;
    }

    @Builder
    @ToString
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode build = ListNode.builder().val(2).next(ListNode.builder().val(4).next(ListNode.builder().val(3).next(null).build()).build()).build();
        ListNode build2 = ListNode.builder().val(5).next(ListNode.builder().val(6).next(null).build()).build();
        ListNode listNode = addTwoNumbers(build, build2);
        System.out.println(listNode.toString());

    }
}
