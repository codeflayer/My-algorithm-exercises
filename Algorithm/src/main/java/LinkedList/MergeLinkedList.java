package LinkedList;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeLinkedList {

    public static void main(String[] argu) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l4 = new ListNode();
        l4.val = 4;
        l1.next = l2;
        l2.next = l4;


        ListNode l11 = new ListNode();
        l11.val = 1;
        ListNode l3 = new ListNode();
        l3.val = 2;
        ListNode l44 = new ListNode();
        l44.val = 4;
        l11.next = l3;
        l3.next = l44;

        ListNode node = mergeTwoLists(l1, l11);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val <= l2.val) {
                node = l1;
                node.next = mergeTwoLists(l1.next, l2);
            } else {
                node = l2;
                node.next = mergeTwoLists(l1, l2.next);
            }
            return node;
        }
    }


}


