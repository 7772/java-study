
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 2, 3, 4, 1};

        print(array);
        sort(array);
        print(array);
    }

    private static void sort(int[] array) {
        int j;
        int temp;

        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;

            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }
}
