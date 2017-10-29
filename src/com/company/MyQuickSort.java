

public class MyQuickSort {


    public static void myQS(int bottom, int upper, int[] ind, int[] arr){
        int a = bottom;
        int b = upper;
        int swap = 0;

        double mid = arr[ind[(a+(b-a)/2)]];

        while (a<=b){

            while (arr[ind[a]] < mid)
                a++;

            while (arr[ind[b]] > mid)
                b--;

            if (a <= b){
                swap = arr[ind[a]];
                arr[ind[a]] = arr[ind[b]];
                arr[ind[b]] = swap;
                a++; b--;
            }
        }

        if (bottom < b)
            myQS(bottom, b, ind, arr);
        if (upper > a)
            myQS(a, upper, ind, arr);
    }

}
