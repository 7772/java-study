import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2869 {

    private static long A;
    private static long B;
    private static long V;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        A = Long.parseLong(input.nextToken());
        B = Long.parseLong(input.nextToken());
        V = Long.parseLong(input.nextToken());

        solve();
    }

    private static void solve() {
        // B 를 V 에서 뺀다는 것은 마지막 밤의 case 를 생각하지 않겠다는 것
        long count = (V - B) / (A - B);

        // 마지막 밤의 case 를 꼭 계산해야만 하는 경우는 나머지가 존재할 경우
        // 1 단계만 더 가면 달성 가능하다
        if ((V - B) % (A - B) != 0) count++;

        System.out.print(count);
    }
}
