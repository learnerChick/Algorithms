package Arrays;

import java.util.Arrays;

/**
 *  Given a number whose digits are unique, find the next larger number that can be formed with those digits.
 *  Algorithm:
 *      1) Start from the end.
 *      2) Compare digit on left with right.  If left is larger than right, move on.
 *      3) If left is smaller than right, this will be the first pivot point.
 *      4) Divide the numbers into 2 chunks.  One from index 0 to right before pivot.  The other from pivot to end.
 *      5) Sort second chunk into order.  Find the smallest number larger than the pivot.
 *      6) Keep track of that number (pivot replacer).  It will be inserted into final next largest number.
 *      7) Join chunk one, pivot replacer and chunk two (without pivot replacer)
 *      Algorithm below runs at 0(N^2).
 */
public class LargerNumber {
    int[] numbers;


    public LargerNumber(int num){
        String numAsString = Integer.toString(num);
        numbers = new int[numAsString.length()];
        int index = 0;

        String[] items = numAsString.split("");

        for(int i = 1; i < items.length; i++){
            numbers[index] = Integer.valueOf(items[i]);
            index++;
        }
    }

    public void FindLarger(){
        int[] nextLargest = new int[numbers.length];
        int index = 0;
        for(int i = numbers.length - 1; i > 0; i--){
            int left = numbers[i-1];
            int right = numbers[i];
            int pivot = left;
            int pivotReplacer = -1;
            int pivotReplacerIndex = 0;

            if(left < right){

                int[] firstSublist = Arrays.copyOfRange(numbers, 0, i-1);
                int[] secondSublist = Arrays.copyOfRange(numbers, i-1, numbers.length);
                Arrays.sort(secondSublist);

                //find a replacer
                for(int j = 0; j < secondSublist.length; j++){
                    if(secondSublist[j] > pivot){
                        pivotReplacer = secondSublist[j];
                        pivotReplacerIndex = j;
                        break;
                    }
                }

                //copy first part
                for(int  j= 0; j < firstSublist.length; j++){
                    nextLargest[index] = firstSublist[j];
                    index++;
                }

                //push in pivotReplacer
                nextLargest[index] = pivotReplacer;
                index++;

                //push in rest of second part
                for(int j = 0; j < secondSublist.length; j++){
                    if(j != pivotReplacerIndex){
                        nextLargest[index] = secondSublist[j];
                        index++;
                    }
                }

                //print resulting number
                for(int j = 0; j < nextLargest.length; j++){
                    System.out.print(nextLargest[j]);
                }
                return;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
       // LargerNumber ln = new LargerNumber(1234); //1243
        //LargerNumber ln = new LargerNumber(12543); //13245
        //LargerNumber ln = new LargerNumber(38276); //38627
        LargerNumber ln = new LargerNumber(7865); //8567
        ln.FindLarger();
    }
}
