import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main2639 {

    private static final Scanner scanner = new Scanner(System.in);
    private static int ARRAY_LENGTH = 10;
    private static int N = 3;

    public static void main(String[] args) {
        int count = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        while (count > 0) {
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                arr.add(scanner.nextInt());
            }

            results.add(solve(arr));
            arr.clear();

            count--;
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    public static int solve(List<Integer> arr) {
        for (int i = 0; i < N - 1; i++) {
            arr.remove(max(arr));
        }

        return max(arr);
    }

    public static Integer max(List<Integer> arr) {
        int max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (max < arr.get(i)) {
                max = arr.get(i);
            }
        }

        return max;
    }
}
