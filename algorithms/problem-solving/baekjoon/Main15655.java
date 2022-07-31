import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main15655 {

    private static int N;
    private static int M;
    private static int[] array;
    private static int[] temp;
    private static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer1.nextToken());
        M = Integer.parseInt(tokenizer1.nextToken());

        array = new int[N];
        temp = new int[N];
        visits = new boolean[N];

        StringTokenizer tokenizer2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer2.nextToken());
        }

        Arrays.sort(array);
        dfs(0, 0);
    }

    private static void dfs(int index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i] && array[index] <= array[i]) {
                visits[i] = true;
                temp[depth] = array[i];
                dfs(i, depth + 1);
                visits[i] = false;
            }
        }
    }
}
