import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main1759 {

    private static int L;
    private static int C;
    private static char[] inputArray;
    private static char[] printArray;
    private static boolean[] visitArray;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(tokenizer1.nextToken());
        C = Integer.parseInt(tokenizer1.nextToken());

        inputArray = new char[C];
        printArray = new char[L];
        visitArray = new boolean[C];

        inputArray = br.readLine().replaceAll(" ", "").toCharArray();

        Arrays.sort(inputArray);

        for (int i = 0; i < C; i++) {
            visitArray[i] = false;
        }

        solve(0);
    }

    private static void solve(int depth) {
        if (depth == L) {
            int countA = 0; // 자음
            int countB = 0; // 모음
            for (int i = 0; i < L; i++) {
                if (
                    printArray[i] == 'a' ||
                        printArray[i] == 'e' ||
                        printArray[i] == 'i' ||
                        printArray[i] == 'o' ||
                        printArray[i] == 'u'
                ) {
                    countA++;
                } else {
                    countB++;
                }
            }

            if (countA > 0 && countB > 1) {
                for (int i = 0; i < L; i++) {
                    System.out.print(printArray[i]);
                }

                System.out.println("");
                return;
            } else {
                return;
            }
        }

        for (int i = 0; i < C; i++) {
            if (depth > 0 && (int) printArray[depth - 1] > (int) inputArray[i]) {
                continue;
            }

            if (!visitArray[i]) {
                visitArray[i] = true;
                printArray[depth] = inputArray[i];
                solve(depth + 1);
                visitArray[i] = false;
            }
        }
    }
}

