public class BmiCalculator {
    // This class calculates BMI
    // BMI = weight / height^2
    // weight: kg
    // height: m
    public static void calculateBmiVoid() {
        // Calculate BMI and print
        double weight = 75;
        double height = 1.7;
        double bmi = weight / (height * height);
        System.out.printf(
                "Chi so BMI cho can nang %.1f kg va chieu cao %.2f m (phuong thuc co kieu tra ve la void) là: %.2f\n",
                weight, height, bmi);
    }

    public static double calculateBmiDouble() {
        // Calculate BMI and return
        double weight = 40;
        double height = 1.5;
        double bmi = weight / (height * height);
        return bmi;
    }

    public static double calculateBmiParameters(double weight, double height) {
        // Receive 2 parameters: weight (double) and height (double)
        // Return BMI
        double bmi = weight / (height * height);
        return bmi;
    }
}
