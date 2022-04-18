import java.util.Scanner;

public class Main2798 {

    private static int N;
    private static int M;

    public static void main(String[] args) {
        int[] array;

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        solve(array);
    }

    public static void solve(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int sum = array[i] + array[j] + array[k];
                    if (sum == M) {
                        System.out.println(sum);
                        return;
                    }

                    if (sum < M && sum >= max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}

