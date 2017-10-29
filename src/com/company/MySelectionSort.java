

public class MySelectionSort {

    public static void Sel_Sort(int len, int[] ind, int arr[])
    {
        int swap = 0;

        for (int i = 0; i < len-1; i++)
        {
            int min = i;
            for (int j = i+1; j < len; j++)
                if (arr[ind[j]] < arr[ind[min]])
                    min = j;

            swap = arr[ind[min]];
            arr[ind[min]] = arr[ind[i]];
            arr[ind[i]] = swap;
        }
    }

}
