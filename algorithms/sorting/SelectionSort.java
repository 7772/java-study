
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 2, 3, 4, 1};

        print(array);
        sort(array);
        print(array);
    }

    private static void sort(int[] array) {
        int minIndex = 0;
        int temp;

        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }
}
