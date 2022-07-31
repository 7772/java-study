import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main15656 {

    private static int N;
    private static int M;
    private static int[] array;
    private static int[] temp;
    private static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        array = new int[N];
        temp = new int[N];

        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer1.nextToken());
        }

        Arrays.sort(array);

        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
                temp[depth] = array[i];
                dfs(depth + 1);
        }
    }
}
