public class Question1 {
    public static void printSquare() {
        System.out.println("Hinh vuong: ");
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print("*  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTriangle1() {
        System.out.println("Hinh tam giac 1: ");
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < i + 1; ++j) {
                System.out.print("*  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTriangle2() {
        System.out.println("Hinh tam giac 2: ");
        for (int i = 0; i < 4; ++i) {
            System.out.print("  ".repeat(3 - i));
            for (int j = 0; j < i + 1; ++j) {
                System.out.print("*   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
