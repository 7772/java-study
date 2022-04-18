import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.StringTokenizer;

public class Main15651 {

    private static int N;
    private static int M;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        array = new int[M];

        dfs(0);
        System.out.println(stringBuilder);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i : array) {
                stringBuilder.append(i).append(" ");
            }

            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            array[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
