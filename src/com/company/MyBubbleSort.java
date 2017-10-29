

public class MyBubbleSort {

    public static void BB_Sort(int end, int[] ind, int[] arr){
        int swap = 0;

        for (int i = 0; i < end; i++){
            for (int j = 1; j < end; j++){
                if (arr[ind[j]] < arr[ind[j-1]]){
                    swap = arr[ind[j]];
                    arr[ind[j]] = arr[ind[j-1]];
                    arr[ind[j-1]] = swap;
                }
            }
        }
    }

}
