import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {

    private static int N;
    private static int[] array;
    private static int[] dp;0

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N + 1];
        dp = new int[N + 1];
        dp[0] = 0;

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        solution();
        System.out.println(dp[N]);
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + array[j]);
            }
        }
    }
}
