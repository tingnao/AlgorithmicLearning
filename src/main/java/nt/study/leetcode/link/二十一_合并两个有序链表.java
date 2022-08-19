package nt.study.leetcode.link;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

public class 二十一_合并两个有序链表 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
     */
    public static  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preRoot = new ListNode(-1), currentNode = preRoot;
        // 判断两者是否为空，将两个节点中值小的节点挂在preRoot上，然后最后将不为空的部分挂到preRoot的末尾即可
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                currentNode.next = list2;
                list2 = list2.next;
            }else{
                currentNode.next = list1;
                list1 = list1.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = list1 != null ? list1 : list2;
        return preRoot.next;
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
