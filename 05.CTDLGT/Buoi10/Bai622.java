public class Bai622 {
    static class MyCircularQueue {
        private int[] data;
        private int headIndex;
        private int tailIndex;
        private int k;

        public MyCircularQueue(int k) {
            this.data = new int[k];
            this.k = k;
            this.headIndex = -1;
            this.tailIndex = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            if (isEmpty()) {
                tailIndex++;
                headIndex++;
            } else {
                tailIndex++;
                if (tailIndex == k) {
                    tailIndex = 0;
                }
            }
            data[tailIndex] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            // Dequeue last element
            if (headIndex == tailIndex) {
                headIndex = -1;
                tailIndex = -1;
                return true;
            }

            // Normal case
            headIndex++;
            if (headIndex == k) {
                headIndex = 0;
            }
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return data[headIndex];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return data[tailIndex];
        }

        public boolean isEmpty() {
            return headIndex == -1 && tailIndex == -1;
        }

        public boolean isFull() {
            if (headIndex == 0 && tailIndex == k - 1) {
                return true;
            } else if (headIndex != 0 && tailIndex == headIndex - 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(6);
        System.out.println(obj.enQueue(6));
        System.out.println(obj.Rear());
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(5));
        System.out.println(obj.Rear());
        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());

        // MyCircularQueue obj = new MyCircularQueue(2);
        // obj.enQueue(1);
        // obj.enQueue(2);
        // obj.deQueue();
        // obj.enQueue(3);
        // obj.deQueue();
        // obj.enQueue(3);
        // obj.deQueue();
        // obj.enQueue(3);
        // obj.deQueue();
        // System.out.println(obj.Front());

        // MyCircularQueue obj = new MyCircularQueue(30);
        // obj.enQueue(71);
        // System.out.println(obj.isFull());
        // obj.enQueue(32);
        // obj.enQueue(1);
        // System.out.println(obj.isFull());
        // obj.enQueue(32);
        // obj.enQueue(8);
        // obj.enQueue(6);
        // System.out.println(obj.Front());
        // System.out.println(obj.Front());
        // System.out.println(obj.Rear());
        // obj.enQueue(8);
        // System.out.println(obj.Rear());
        // obj.enQueue(3);
        // System.out.println(obj.Rear());
        // System.out.println(obj.Front());
        // obj.enQueue(56);
        // obj.enQueue(41);
        // System.out.println(obj.Front());
    }
}
