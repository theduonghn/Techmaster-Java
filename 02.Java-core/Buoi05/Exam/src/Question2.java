public class Question2 {
    public static void countWord(String sentence) {
        String[] words = sentence.split("\s+");
        System.out.println("So tu trong chuoi la: " + words.length);
        System.out.println();
    }

    public static void countChar(String sentence, char targetChar) {
        int count = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            if (sentence.charAt(i) == targetChar) {
                count += 1;
                System.out.println("Ky tu \"" + targetChar + "\" xuat hien tai index " + i);
            }
        }
        System.out.println("Ky tu \"" + targetChar + "\" xuat hien " + count + " lan");
        System.out.println();
    }

}
