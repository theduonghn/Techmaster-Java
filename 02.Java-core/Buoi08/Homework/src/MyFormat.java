import java.text.DecimalFormat;

public class MyFormat {
    private static DecimalFormat formatVnd = new DecimalFormat("###,###,### VND");

    public static String formatVnd(long num) {
        return formatVnd.format(num);
    }
}
