public class Bai141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode iNode = head;
        ListNode kNode = head;

        while (true) {
            iNode = iNode.next;
            kNode = kNode.next;
            if (kNode == null) {
                return false;
            }
            kNode = kNode.next;
            if (kNode == null) {
                return false;
            }

            if (iNode == kNode) {
                return true;
            }
        }
    }
}