public class Main {
    public static void main(String[] args) throws Exception {
        // Question 1
        System.out.println("Cau 1");
        Question1.printSquare();
        Question1.printTriangle1();
        Question1.printTriangle2();

        // Question 2
        System.out.println("Cau 2");
        String sentence = "You only live once, but if you do it right, once is enough";
        Question2.countWord(sentence);
        char targetChar = 'o';
        Question2.countChar(sentence, targetChar);

        // Question 3
        System.out.println("Cau 3");
        Question3.checkRandomNumberIsPrime();

        // Question 4
        System.out.println("Cau 4");
        Question4.printFirstPrimeNumbers();
        Question4.printPrimeNumbersSmallerThan10();

        // Question 5
        System.out.println("Cau 5");
        String name = "   phAm   thE   dUONg   ";
        System.out.println("Ten chua duoc chuan hoa: ");
        System.out.println(name);
        Question5.printFormattedName(name);
        Question5.checkInputtedStringIsPalindrome();

        // Question 6
        System.out.println("Cau 6");
        int[][] arr = Question6.input2DArray();
        Question6.print2DArray(arr);
        Question6.printMainDiagonal(arr);
    }
}
