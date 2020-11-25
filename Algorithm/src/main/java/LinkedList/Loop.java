package LinkedList;

public class Loop {

    /**
     * ### 题目描述
     * <p>
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。
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
        l5.next = l2;

        boolean status = loop(l1);

    }

    public static boolean loop(ListNode node) {
        ListNode next = node;
        ListNode nNext = node;
        while (next != null && nNext != null) {
            next = next.next;
            nNext = nNext.next.next;
            if (next == nNext) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

}
