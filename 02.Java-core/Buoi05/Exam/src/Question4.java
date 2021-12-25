public class Question4 {
    public static int[] firstPrimeNumbers(int n) {
        int count = 0;
        int i = 0;
        int[] primeNumbers = new int[n];
        while (count < n) {
            if (PrimeNumber.isPrimeNumber(i)) {
                primeNumbers[count] = i;
                count += 1;
            }
            i += 1;
        }
        return primeNumbers;
    }

    public static void printFirstPrimeNumbers() {
        int[] primeNumbers = firstPrimeNumbers(10);
        System.out.println("10 so nguyen to dau tien la: ");
        for (int num : primeNumbers) {
            System.out.print(num + "\t");
        }
        System.out.println("\n");
    }

    public static void printPrimeNumbersSmallerThan10() {
        System.out.println("Cac so nguyen to nho hon 10: ");
        for (int i = 0; i < 10; ++i) {
            if (PrimeNumber.isPrimeNumber(i)) {
                System.out.print(i + "\t");
            }
        }
        System.out.println("\n");
    }
}
