import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main15654 {

    private static int N;
    private static int M;
    private static int[] nodeArray;
    private static int[] inputArray;
    private static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer1.nextToken());
        M = Integer.parseInt(tokenizer1.nextToken());

        nodeArray = new int[M];
        inputArray = new int[N];
        visits = new boolean[N];

        StringTokenizer tokenizer2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(tokenizer2.nextToken());
            visits[i] = false;
        }

        Arrays.sort(inputArray);

        solve(0);
    }

    private static void solve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(nodeArray[i] + " ");
            }

            System.out.println("");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                nodeArray[depth] = inputArray[i];
                solve(depth + 1);
                visits[i] = false;
            }
        }
    }
}
