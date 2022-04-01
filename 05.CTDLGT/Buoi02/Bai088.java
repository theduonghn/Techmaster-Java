import java.util.Arrays;

public class Bai088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        for (int k = 0; k < n;) {
            if (i < 0) {
                nums1[i + 1] = nums2[k];
                k++;
                i = m - 1 + k;
            } else if (nums1[i] <= nums2[k]) {
                nums1[i + 1] = nums2[k];
                k++;
                i = m - 1 + k;
            } else {
                nums1[i + 1] = nums1[i];
                i--;
            }
        }
    }

    public static void main(String[] args) {
        // int[] a1 = new int[] { 1, 2, 3, 0, 0, 0 };
        // int[] a2 = new int[] { 2, 5, 6 };
        // merge(a1, 3, a2, 3);
        // System.out.println(Arrays.toString(a1));

        // int[] b1 = new int[] { 0 };
        // int[] b2 = new int[] { 1 };
        // merge(b1, 0, b2, 1);
        // System.out.println(Arrays.toString(b1));

        int[] c1 = new int[] { 2, 0 };
        int[] c2 = new int[] { 1 };
        merge(c1, 1, c2, 1);
        System.out.println(Arrays.toString(c1));
    }
}
