public class Main {
    public static void main(String[] args) {
        // Print result of question 1
        System.out.println("\nCau 1");
        double a = 12;
        double b = 3;
        System.out.printf("a = %.2f, b = %.2f\n", a, b);
        System.out.printf("Cong 2 so a va b: %.2f + %.2f = %.2f\n",
                a, b, Calculator.add(a, b));
        System.out.printf("Tru 2 so a va b: %.2f - %.2f = %.2f\n",
                a, b, Calculator.subtract(a, b));
        System.out.printf("Nhan 2 so a va b: %.2f * %.2f = %.2f\n",
                a, b, Calculator.multiply(a, b));
        System.out.printf("Chia 2 so a va b: %.2f / %.2f = %.2f\n",
                a, b, Calculator.divide(a, b));

        // Print result of question 2
        System.out.println("\nCau 2");
        double weight = 65.5;
        double height = 1.73;
        BmiCalculator.calculateBmiVoid();
        System.out.printf(
                "Chi so BMI cho can nang 40.0 kg va chieu cao 1.50 m (phuong thuc co kieu tra ve la double) la: %.2f\n",
                BmiCalculator.calculateBmiDouble());
        System.out.printf(
                "Chi so BMI cho can nang %.1f kg va chieu cao %.2f m (phuong thuc co kieu tra ve la double va co truyen tham so) la: %.2f\n",
                weight,
                height,
                BmiCalculator.calculateBmiParameters(weight, height));
        System.out.println();

        // Compare 3 methods of class BmiCalculator
        System.out.println(
                "- Phuong thuc co kieu tra ve la void luon phai in ra ket qua, ket qua khong the luu tru vao bien");
        System.out.println(
                "- Phuong thuc co kieu tra ve la double co the luu tru ket qua vao bien, nhung khong the tinh toan voi chieu cao can nang khac nhau trong cung mot chuong trinh");
        System.out.println(
                "- Phuong thuc co kieu tra ve la double va co truyen tham so co the luu tru ket qua vao bien, co the tinh toan voi chieu cao can nang khac nhau trong cung mot chuong trinh -> phuong thuc nay la tot nhat");
    }
}
