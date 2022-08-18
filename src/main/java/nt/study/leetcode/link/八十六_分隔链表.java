package nt.study.leetcode.link;

public class 八十六_分隔链表 {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode partition(ListNode head, int x) {
        ListNode  preNode = new ListNode(-1, head), bigValPreNode = preNode, findMinValNode, temp;
        // 从链表头开始查找，查找大于等于x的第一个节点的前置节点，用于插入小于x的节点
        while(bigValPreNode.next != null && bigValPreNode.next.val  < x){
            bigValPreNode = bigValPreNode.next;
        }
        // 从第一个大于等于x的节点的下一个节点开始查找小于x的节点
        findMinValNode = bigValPreNode.next;
        while(findMinValNode != null && findMinValNode.next != null){
            // 如果匹配到了，将匹配到的节点放入bigValPreNode和bigValPreNode.next之间
            if(findMinValNode.next.val < x){
                temp = findMinValNode.next.next;
                findMinValNode.next.next = bigValPreNode.next;
                bigValPreNode.next= findMinValNode.next;
                findMinValNode.next = temp;
                bigValPreNode = bigValPreNode.next;
            }else{
                // 未匹配到，查找指针后移
                findMinValNode = findMinValNode.next;
            }
        }
        return preNode.next;
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

    public static void main(String[] args) {

    }
}
