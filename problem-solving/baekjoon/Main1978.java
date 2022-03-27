import java.util.Scanner;

public class Main1978 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int count = 0;

        while (n > 0) {
            count += solve(scanner.nextInt());
            n--;
        }

        System.out.println(count);
    }

    public static int solve(int number) {
        if (number == 1) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count > 2 ? 0 : 1;
    }
}
