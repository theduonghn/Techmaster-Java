public class Bai707 {
    static class MyLinkedList {
        public class MyNode {
            int val;
            MyNode next;

            public MyNode(int val) {
                this.val = val;
            }
        }

        public MyNode head;

        public MyLinkedList() {

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("");
            MyNode iNode = this.head;
            while (iNode != null) {
                sb.append(iNode.val + "->");
                iNode = iNode.next;
            }
            String str = sb.toString();
            if (str.equals("")) {
                return "List is empty";
            } else {
                return str;
            }
        }

        public int get(int index) {
            int i = -1;
            MyNode iNode = this.head;
            while (iNode != null) {
                i++;
                if (i == index) {
                    return iNode.val;
                }
                iNode = iNode.next;
            }
            return -1;
        }

        public void addAtHead(int val) {
            MyNode newNode = new MyNode(val);
            newNode.next = this.head;
            this.head = newNode;
        }

        public void addAtTail(int val) {
            MyNode newNode = new MyNode(val);
            if (this.head == null) {
                this.head = newNode;
                return;
            }
            MyNode iNode = this.head;
            while (iNode != null) {
                if (iNode.next == null) {
                    iNode.next = newNode;
                    return;
                }
                iNode = iNode.next;
            }
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }

            MyNode newNode = new MyNode(val);
            int i = 0;
            MyNode iNode = this.head;
            MyNode jNode = null;
            while (iNode != null) {
                if (i == index) {
                    newNode.next = iNode;
                    jNode.next = newNode;
                    break;
                }

                i++;
                jNode = iNode;
                iNode = iNode.next;
            }
            if (i == index) {
                jNode.next = newNode;
            }
        }

        public void deleteAtIndex(int index) {
            if (this.head == null) {
                return;
            }
            if (index == 0) {
                this.head = this.head.next;
                return;
            }

            int i = 0;
            MyNode iNode = this.head;
            MyNode jNode = null;
            while (iNode != null) {
                if (i == index) {
                    jNode.next = iNode.next;
                    break;
                }

                i++;
                jNode = iNode;
                iNode = iNode.next;
            }
        }
    }

    public static void main(String[] args) {
        // Test addAtHead
        System.out.println("Test addAtHead");
        MyLinkedList obj = new MyLinkedList();
        System.out.println(obj); // List is empty
        obj.addAtHead(10);
        System.out.println(obj); // 10
        obj.addAtHead(5);
        System.out.println(obj); // 5->10

        // Test addAtTail
        System.out.println("Test addAtTail");
        MyLinkedList obj2 = new MyLinkedList();
        obj2.addAtTail(7);
        System.out.println(obj2); // 7
        obj2.addAtTail(6);
        System.out.println(obj2); // 7->6

        // Test get
        System.out.println("Test get");
        System.out.println(obj.get(0)); // 5
        System.out.println(obj.get(1)); // 10
        System.out.println(obj.get(2)); // -1
        System.out.println(obj.get(10)); // -1

        // Test addAtIndex
        System.out.println("Test addAtIndex");
        MyLinkedList obj3 = new MyLinkedList();
        obj3.addAtIndex(1, 5); // Cannot insert
        System.out.println(obj3); // List is empty
        obj3.addAtIndex(0, 5);
        System.out.println(obj3); // 5
        obj3.addAtIndex(1, 6);
        System.out.println(obj3); // 5->6
        obj3.addAtIndex(0, 4);
        System.out.println(obj3); // 4->5->6
        obj3.addAtIndex(3, 7);
        System.out.println(obj3); // 4->5->6->7
        obj3.addAtIndex(5, 10); // Cannot insert
        System.out.println(obj3); // 4->5->6->7

        // Test deleteAtIndex
        System.out.println("Test deleteAtIndex");
        obj3.deleteAtIndex(8);
        System.out.println(obj3); // 4->5->6->7
        obj3.deleteAtIndex(0);
        System.out.println(obj3); // 5->6->7
        obj3.deleteAtIndex(2);
        System.out.println(obj3); // 5->6
        obj3.deleteAtIndex(1);
        System.out.println(obj3); // 5
        obj3.deleteAtIndex(1);
        System.out.println(obj3); // 5
        obj3.deleteAtIndex(0);
        System.out.println(obj3); // List is empty
    }
}