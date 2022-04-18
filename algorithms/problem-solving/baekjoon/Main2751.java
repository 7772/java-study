import java.io.BufferedReader;
import java.lang.Integer;
import java.io.InputStreamReader;

public class Main2751 {

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(bf.readLine());
        }

        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int LEFT, int RIGHT) {
        int mid = (LEFT + RIGHT) / 2;
        int left = LEFT;
        int right = mid + 1;
        int k = LEFT;

        int[] tmp = new int[N];

        while (left <= mid && right <= RIGHT) {
            tmp[k++] = array[left] >= array[right] ? array[right++] : array[left++];
        }

        if (left > mid) {
            for (int i = right; i <= RIGHT; i++) {
                tmp[k++] = array[i];
            }
        } else {
            for (int i = left; i <= mid; i++) {
                tmp[k++] = array[i];
            }
        }

        for (int i = LEFT; i <= RIGHT; i++) {
            array[i] = tmp[i];
        }
    }
}
