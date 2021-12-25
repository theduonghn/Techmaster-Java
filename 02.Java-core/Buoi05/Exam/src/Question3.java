import java.util.Random;

public class Question3 {

    public static void checkRandomNumberIsPrime() {
        Random rd = new Random();
        int randomNum = rd.nextInt(100);
        if (PrimeNumber.isPrimeNumber(randomNum)) {
            System.out.println("So " + randomNum + " la so nguyen to");
        } else {
            System.out.println("So " + randomNum + " khong la so nguyen to");
        }
        System.out.println();
    }
}
