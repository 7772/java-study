import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10819 {

    private static int N;
    private static int[] array;
    private static int[] temp;
    private static boolean[] visits;
    private static int max = Integer.MIN_VALUE;
    private static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N];
        temp = new int[N];
        visits = new boolean[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
            visits[i] = false;
        }

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i = 2; i <= N; i++) {
                sum += Math.abs(temp[i - 2] - temp[i - 1]);
            }

            max = max < sum ? sum : max;
            sum = 0;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                temp[depth] = array[i];
                dfs(depth + 1);
                visits[i] = false;
            }
        }
    }
}
