import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1107 {

    private static int N;
    private static int M;
    private static boolean[] pressable;
    private static int CURRENT = 100;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        pressable = new boolean[10];
        for (int i = 0; i < 10; i++) {
            pressable[i] = true;
        }

        if (M != 0) {
            StringTokenizer tokeninzer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int idx = Integer.parseInt(tokeninzer.nextToken());
                pressable[idx] = false;
            }
        }

        int onlyMoved = N > CURRENT ? (N - CURRENT) : (CURRENT - N);

        dfs(0, "");
        System.out.println(MIN > onlyMoved ? onlyMoved : MIN);
    }

    private static void dfs(int idx, String clicked) {
        if (idx > 6) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (pressable[i]) {
                String newString = clicked + String.valueOf(i);
                int count = Math.abs(N - Integer.parseInt(newString)) + newString.length();
                MIN = count < MIN ? count : MIN;
                dfs(idx + 1, newString);
            }
        }
    }
}


