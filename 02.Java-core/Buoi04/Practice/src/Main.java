import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String name = "pham   the   duong";
        String[] letters = name.split("\s+");
        System.out.println(Arrays.toString(letters));
        for (int i = 0; i < letters.length; ++i) {
            letters[i] = letters[i].substring(0, 1).toUpperCase() + letters[i].substring(1);

        }
        String formatedName = "";
        for (String letter : letters) {
            formatedName += letter + " ";
        }
        formatedName = formatedName.trim();

        System.out.println(formatedName);
    }
}
