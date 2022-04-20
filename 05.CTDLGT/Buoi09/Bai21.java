public class Bai21 {
    // Cách 1 - duyệt
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode iNode = list1;
        ListNode jNode = list2;
        ListNode kNode;

        if (iNode.val <= jNode.val) {
            kNode = iNode;
            iNode = iNode.next;
        } else {
            kNode = jNode;
            jNode = jNode.next;
        }

        ListNode head = kNode;

        while (iNode != null && jNode != null) {
            if (iNode.val <= jNode.val) {
                kNode.next = iNode;
                iNode = iNode.next;
            } else {
                kNode.next = jNode;
                jNode = jNode.next;
            }
            kNode = kNode.next;
        }

        if (iNode == null) {
            kNode.next = jNode;
        } else {
            kNode.next = iNode;
        }

        return head;
    }

    // Cách 2 - đệ quy
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
}
