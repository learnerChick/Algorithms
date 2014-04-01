package ArrayExamples;
import java.util.Arrays;

import java.lang.reflect.Array;

/**
 * Find the least difference between any two elements of an integer array.
 *
 * Time is N(log N) because of the sorting step
 */
public class LeastDifference {

    public static void main(String[] args){
        int arr[] = {77,99,44,55,22,88,18,00,66,33};
        Arrays.sort(arr);

        int min = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] < min){
                min = arr[i+1] - arr[i];
            }
        }

        System.out.println("Minimum difference is: " + min);
    }

}
