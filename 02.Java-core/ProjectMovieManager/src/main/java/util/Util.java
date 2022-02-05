package util;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Util {
    public static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        return Integer.parseInt(sc.nextLine());
    }

    public static UUID generateId() {
        return java.util.UUID.randomUUID();
    }

    public static <E> void showAll(List<E> list) {
        for (E item : list) {
            System.out.println(item);
        }
    }

    public static <E> void showAllWithRowNumber(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    public static <E> E selectItemByRowNumber(List<E> list, int rowNumber) {
        try {
            return list.get(rowNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Không có lựa chọn này");
        }
        return null;
    }
}
