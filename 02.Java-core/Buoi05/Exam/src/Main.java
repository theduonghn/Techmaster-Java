import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Danh sach cau hoi: ");
            for (int i = 1; i <= 6; ++i) {
                System.out.print(i + ". Cau " + i + "\t");
            }
            System.out.print("0. Thoat chuong trinh");
            System.out.println();
            System.out.print("Nhap lua chon cua ban: ");
            int chosenQuesion = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (chosenQuesion) {
                case 1:
                    question1();
                    break;
                case 2:
                    question2();
                    break;
                case 3:
                    question3();
                    break;
                case 4:
                    question4();
                    break;
                case 5:
                    question5();
                    break;
                case 6:
                    question6();
                    break;
                case 0:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Ban chon sai roi, hay chon lai");
                    break;
            }
        }
    }

    public static void question1() {
        // Question 1
        System.out.println("Cau 1");
        Question1.printSquare();
        Question1.printTriangle1();
        Question1.printTriangle2();
    }

    public static void question2() {
        // Question 2
        System.out.println("Cau 2");
        String sentence = "You only live once, but if you do it right, once is enough";
        Question2.countWord(sentence);
        char targetChar = 'o';
        Question2.countChar(sentence, targetChar);
    }

    public static void question3() {
        // Question 3
        System.out.println("Cau 3");
        Question3.checkRandomNumberIsPrime();
    }

    public static void question4() {
        // Question 4
        System.out.println("Cau 4");
        Question4.printFirstPrimeNumbers();
        Question4.printPrimeNumbersSmallerThan10();
    }

    public static void question5() {
        // Question 5
        System.out.println("Cau 5");
        String name = "   phAm   thE   dUONg   ";
        System.out.println("Ten chua duoc chuan hoa: ");
        System.out.println(name);
        Question5.printFormattedName(name);
        Question5.checkInputtedStringIsPalindrome();
    }

    public static void question6() {
        // Question 6
        System.out.println("Cau 6");
        int[][] arr = Question6.input2DArray();
        Question6.print2DArray(arr);
        Question6.printMainDiagonal(arr);
    }
}
