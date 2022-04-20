import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {

    private static int N;
    private static int K;
    private static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input.nextToken());
        K = Integer.parseInt(input.nextToken());

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(bf.readLine());
        }

        solve();
    }

    private static void solve() {
        int number = K;
        int count = 0;

        while (number > 0) {
            int max = getMax(number);

            if (max >= 0) {
                number -= max;
                count++;
            }
        };

        System.out.println(count);
    }

    private static int getMax(int number) {
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max <= array[i] && array[i] <= number) {
                max = array[i];
            }
        }

        return max;
    }
}
