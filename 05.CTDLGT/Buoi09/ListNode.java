public class ListNode {
    int val;
    ListNode next;

    static void show(ListNode head) {
        ListNode iNode = head;
        while (iNode != null) {
            System.out.print(iNode.val + "->");
            iNode = iNode.next;
        }
        System.out.println();
    }

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
