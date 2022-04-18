import java.util.Scanner;
import java.lang.Integer;
import java.lang.Math;

public class Main2231 {

    private static int N;
    private static int LENGTH;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        LENGTH = Integer.toString(N).length();
        int min = 0;

        for (int i = N; i >= N - (LENGTH * 9); i--) {
            if (N == splitAndSum(i)) {
                min = i;
            }
        }

        System.out.println(min);
    }

    private static int splitAndSum(int number) {
        int sum = number;

        for (int i = 1; i <= LENGTH; i++) {
            sum += (number % (Math.pow(10, i))) / Math.pow(10, i - 1);
        }

        return sum;
    }
}
