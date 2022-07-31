import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class Main10973 {
    private static int N;
    private static int numberArray[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numberArray = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(tokenizer.nextToken());
        }

        solve();
    }

    private static void solve() {
        int startIndex = -1;
        int endIndex = -1;

        for (int i = N - 1; i > 0; i--) {
            if (numberArray[i - 1] > numberArray[i]) {
                startIndex = i;
                break;
            }
        }

        if (startIndex > 0) {
            int max = Integer.MIN_VALUE;
            for (int i = startIndex; i < N; i++) {
                if (max < numberArray[i]) {
                    max = numberArray[i];

                    if (max < numberArray[startIndex - 1]) {
                        endIndex = i;
                    }
                }
            }

            swap(startIndex - 1, endIndex);
            sortDescFrom(startIndex);
            print();
        } else {
            System.out.println("-1");
        }
    }

    private static void swap(int start, int end) {
        int temp = numberArray[start];
        numberArray[start] = numberArray[end];
        numberArray[end] = temp;
    }

    private static void sortDescFrom(int index) {
        int[] subArray = Arrays.copyOfRange(numberArray, index, N);
        Arrays.sort(subArray);

        for (int i = index; i < N; i++) {
            numberArray[i] = subArray[N - i - 1];
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(numberArray[i] + " ");
        }
    }
}
