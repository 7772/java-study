import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main10972 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int[] numberArray = new int[N];

        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(tokenizer.nextToken());
        }

        solve(numberArray);
    }

    private static void solve(int[] numberArray) {
        // 해당 지점부터 마지막까지 i - 1 보다 크고 리스트 중 가장 작은 값의 인덱스 endIndex 를 찾는다
        // i - 1 과 end 를 swap 한다
        // 나머지 부분 오름차순 전환

        int startIndex = -1;
        int endIndex = -1;

        // 오름차순 변경되는 마지막 지점 찾기
        for (int i = 1; i < N; i++) {
            if (numberArray[i - 1] < numberArray[i]) {
                startIndex = i;
            }
        }

        if (startIndex > 0) {
            // 오름차순 존재
            int min = Integer.MAX_VALUE;
            for (int i = startIndex; i < N; i++) {
                if (min > numberArray[i]) {
                    min = numberArray[i];

                    if (min > numberArray[startIndex - 1]) {
                        endIndex = i;
                    }
                }
            }

            swap(numberArray, startIndex - 1, endIndex);

            // 나머지 부분 오름차순 전환
            int[] subArray = Arrays.copyOfRange(numberArray, startIndex, N);
            Arrays.sort(subArray);

            for (int i = startIndex; i < N; i++) {
                numberArray[i] = subArray[i - startIndex];
            }

            print(numberArray);
        } else {
            // 오름차순 존재 X
            System.out.println("-1");
        }

    }

    private static void swap(int[] numberArray, int start, int end) {
        int temp = numberArray[start];
        numberArray[start] = numberArray[end];
        numberArray[end] = temp;
    }

    private static void print(int[] numberArray) {
        for (int i = 0; i < N; i++) {
            System.out.print(numberArray[i] + " ");
        }
    }
}
