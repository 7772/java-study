import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main17425 {

    private static int N;
    private static long[] dp;
    private static long[] sum;

    private static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // NlogN 방식
        StringBuffer sb = new StringBuffer();

        dp = new long[MAX];
        sum = new long[MAX];

        Arrays.fill(dp, 1);

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j * i < MAX; j++) {
                dp[i * j] += i;
            }
        }

        for (int i = 1; i < MAX; i++) {
            sum[i] += sum[i - 1] + dp[i];
        }

        while (N-- > 0) {
            sb.append(sum[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);

//        N^2 방식
//        while (N-- > 0) {
//            int total = 0;
//            int _n = Integer.parseInt(br.readLine());
//
//            for (int i = 1; i <= _n; i++) {
//                total += (_n / i) * i;
//            }
//
//            System.out.println(total);
//        }
    }
}
