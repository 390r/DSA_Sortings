

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static LinkedList<Integer> digits = new LinkedList<Integer>();
    public static LinkedList<Integer> chars = new LinkedList<Integer>();

    /**
     * Sort initial array using 4 different sort techniques:
     * -QuickSort
     * -BubbleSort
     * -SelectionSort
     * -InsertionSort
     * Store all 4 different arrays with the results of sorting.
     * @param intIndexes
     * @param charIndexes
     * @param arr
     */
    public static void doSorts(int[] intIndexes, int[] charIndexes, int[] arr) throws Exception{

        int[] QS_Result, Bubble_Result;
        int[] Selection_Result, InsertionSort_Result;

        // Clone array "arr" to the arrays that will be used in sorting techniques.
        QS_Result = arr.clone();
        Bubble_Result = arr.clone();
        Selection_Result = arr.clone();
        InsertionSort_Result = arr.clone();

        // Do Quick Sort on chars and digits indexes
        MyQuickSort.myQS(0, intIndexes.length-1, intIndexes, QS_Result);
        MyQuickSort.myQS(0, charIndexes.length-1, charIndexes, QS_Result);

        // Do Bubble Sort on chars and digits indexes
        MyBubbleSort.BB_Sort(intIndexes.length, intIndexes, Bubble_Result);
        MyBubbleSort.BB_Sort(charIndexes.length, charIndexes, Bubble_Result);

        // Do Selection Sort on chars and digits indexes
        MySelectionSort.Sel_Sort(intIndexes.length, intIndexes, Selection_Result);
        MySelectionSort.Sel_Sort(charIndexes.length, charIndexes, Selection_Result);

        // Do Insertion Sort on chars and digits indexes
        MyInsertionSort.insertionSort(intIndexes.length, intIndexes, InsertionSort_Result);
        MyInsertionSort.insertionSort(charIndexes.length, charIndexes, InsertionSort_Result);

        // If all 4 arrays are equal to each other, then we can print the result.
        if (Compare(QS_Result, Bubble_Result) && Compare(Bubble_Result, Selection_Result) && Compare(Selection_Result, InsertionSort_Result))
                printArr(QS_Result);


    }

    /**
     * Print the array to the file.
     * @param arr
     */
    public static void printArr(int[] arr) throws Exception{
        PrintWriter wr = new PrintWriter("output.txt");

        for(int i=0; i<arr.length; i++){
            if (chars.contains(i))
                wr.print(Character.toUpperCase((char)arr[i]));
            else
                wr.print(arr[i]);

            if (i != arr.length-1)
                wr.print(" ");
        }

        wr.close();

    }

    /**
     * Compare two arrays (are they and their length equal)
     * @param first
     * @param second
     * @return boolean
     */
    public static boolean Compare(int[] first, int[] second){
        if (first.length != second.length)
            return false;

        for (int i = 0; i < first.length; i++){
            if (first[i] != second[i])
                return false;
        }

        return true;

    }


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("input.txt"));

        int[] arr, intIndexes, charIndexes;
        int j = 0;

        String input = "";
        String[] splittedinput;

        // Read inputted text to the string
        input = sc.nextLine();
        // Split this line to the separated array of numbers/chars
        splittedinput = input.split(" ");
        // Set the length of array "arr"
        arr = new int[splittedinput.length];

        // Fill arrays of indexes
        for (int i = 0; i < splittedinput.length; i++){
            /* If value of this index in original array is char,
               then add this index to the array of char indexes,
               and to int indexes array otherwise
             */
            if (splittedinput[i].toLowerCase().charAt(0) >= 'a' && splittedinput[i].charAt(0) <= 'z') {
                arr[i] = splittedinput[i].charAt(0);
                chars.add(i);
            }
            else{
                arr[i] = Integer.parseInt(splittedinput[i]);
                digits.add(i);
            }
        }

        intIndexes = new int[digits.size()];
        charIndexes = new int[chars.size()];

        // Rewrite all indexes from LinkedList to simple array (to simplify further work)
        while(digits.size()>0){
            intIndexes[j] = digits.pop();
            j++;
        }

        j = 0;
        // Rewrite all indexes from LinkedList to simple array (to simplify further work)
        while(chars.size()>0){
            charIndexes[j] = chars.pop();
            j++;
        }

        for (int i=0; i<charIndexes.length; i++)
            chars.add(charIndexes[i]);


        // Call sort method
        doSorts(intIndexes, charIndexes, arr);


    }
}
