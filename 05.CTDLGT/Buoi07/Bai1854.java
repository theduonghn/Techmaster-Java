import java.util.Arrays;

public class Bai1854 {
    public static int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int[] birthYear = new int[n];
        int[] deathYear = new int[n];
        for (int i = 0; i < n; i++) {
            birthYear[i] = logs[i][0];
            deathYear[i] = logs[i][1];
        }
        Arrays.sort(birthYear);
        Arrays.sort(deathYear);

        int population = 0;
        int maxPopulation = 0;
        int maxYear = 0;
        int i = 0;
        int j = 0;

        while (i < n) {
            if (birthYear[i] == deathYear[j]) {
                i++;
                j++;
            } else if (birthYear[i] < deathYear[j]) {
                population++;
                if (population > maxPopulation) {
                    maxPopulation = population;
                    maxYear = birthYear[i];
                }
                i++;
            } else {
                population--;
                j++;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {

    }
}
