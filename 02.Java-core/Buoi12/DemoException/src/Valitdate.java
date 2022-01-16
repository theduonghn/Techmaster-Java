public class Valitdate {
    public static void validateAge (int age) throws MyException {
        if (age <= 0) {
            throw new MyException("Tuổi không được phép nhỏ hơn hoặc bằng 0");
        } else {
            System.out.println("Tuổi của bạn là " + age);
        }
    }
}
