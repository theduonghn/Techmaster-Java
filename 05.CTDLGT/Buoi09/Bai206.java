public class Bai206 {
    // Cách 1 - 2 con trỏ
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode iNode = head;
        ListNode jNode = null;

        while (true) {
            ListNode tNode = iNode.next;
            iNode.next = jNode;
            jNode = iNode;
            iNode = tNode;

            if (iNode == null) {
                return jNode;
            }
        }
    }

    // Cách 2 - đệ quy
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tNode = head.next;
        head.next = null; // remove link
        return addToTail(reverseList2(tNode), head);
    }

    public static ListNode addToTail(ListNode head, ListNode newTail) {
        if (head == null) {
            return newTail;
        }

        ListNode iNode = head;
        while (iNode != null) {
            if (iNode.next == null) {
                iNode.next = newTail;
                break;
            }
            iNode = iNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode.show(n1);
        ListNode.show(reverseList2(n1));
    }
}
