import java.util.Scanner;

public class Main2750 {

    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        sort2(array);
    }

    private static void sort(int[] array) {
        int memory = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    memory = array[i];
                    array[i] = array[j];
                    array[j] = memory;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void sort2(int[] array) {
        int tmp = 0;
        int j = 0;

        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
