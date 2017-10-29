
public class MyInsertionSort {

    public static void insertionSort(int len, int[] ind, int arr[]) {

        for (int j = 1; j < len; j++) {

            int exp = arr[ind[j]];
            int i = j - 1;

            while ((i > -1) && (arr[ind[i]] > exp)) {
                arr[ind[i + 1]] = arr[ind[i]];
                i--;
            }

            arr[ind[i + 1]] = exp;
        }
    }
}