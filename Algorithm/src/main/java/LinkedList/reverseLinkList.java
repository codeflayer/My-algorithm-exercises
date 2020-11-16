package LinkedList;

public class reverseLinkList {


    /**
     * 反转链表
     *
     * @param argu
     */
    public static void main(String[] argu) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l3 = new ListNode();
        l3.val = 3;
        ListNode l4 = new ListNode();
        l4.val = 4;
        ListNode l5 = new ListNode();
        l5.val = 5;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode node = reverse(l1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode reverse(ListNode l1) {
        ListNode pre = null;
        ListNode cur = l1;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

}
