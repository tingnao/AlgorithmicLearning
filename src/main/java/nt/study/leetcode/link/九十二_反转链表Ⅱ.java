package nt.study.leetcode.link;

public class 九十二_反转链表Ⅱ {
    public ListNode reverseBetween(ListNode head, int left, int right){
        ListNode preNode = new ListNode(-1, head), leftNode = preNode, rightNode;
        for (int i = 0; i <= left - 1; i++) {
            leftNode = leftNode.next;
        }
        int count = right - left;
        while(count > 0){
            rightNode = leftNode;
            for (int i = 0; i < count; i++) {
                rightNode = rightNode.next;
            }
            swap(leftNode, rightNode);
            count -= 2;
            leftNode = leftNode.next;
        }
            return preNode.next;
    }

    private void swap(ListNode leftNode, ListNode rightNode) {
        ListNode temp = leftNode.next;
        leftNode.next = rightNode.next;
        rightNode.next = temp;
        temp = leftNode.next.next;
        leftNode.next.next = rightNode.next.next;
        rightNode.next.next = temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
