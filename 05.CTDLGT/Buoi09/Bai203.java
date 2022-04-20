public class Bai203 {
    // Cách 1 - duyệt
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode iNode = head;
        ListNode jNode = null;

        while (iNode != null) {
            if (iNode.val == val) {
                if (jNode == null) {
                    head = head.next;
                } else {
                    jNode.next = iNode.next;
                }
            } else {
                jNode = iNode;
            }
            iNode = iNode.next;
        }

        return head;
    }

    // Cách 2 - đệ quy
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

    // public static void main(String[] args) {
    // ListNode n1 = new ListNode(1);
    // n1.next = new ListNode(2);
    // n1.next.next = new ListNode(3);
    // n1.show();
    // }
}