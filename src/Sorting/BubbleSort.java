package Sorting;

/**
 *  Bubble sort - compare each item with the item next to it and swap is left is larger than right.  Continue to the end
 *  of the list and then reloop again.
 *
 *  Runs in 0(N^2)
 *
 *  Smallest item are in the beginning of the array, largest items are at the end.  The outer loop starts at the end and
 *  decrements itself each time through the loop and moves left.  The inner loop starts at the beginning and increments
 *  itself.
 *
 *
 */


public class BubbleSort {
    int[] toSort;
    int total = 0;

    public BubbleSort(int[] arr){
        toSort = arr;
        total = arr.length;
    }

    public void sort(){
        for(int out = total - 1; out > 1; out--){
            for(int in = 0; in < out; in++){
                if(toSort[in] > toSort[in + 1]){
                    swap(in, in+1);
                }
            }
        }
    }

    public void swap(int a, int b){
        int tmp = toSort[a];
        toSort[a] = toSort[b];
        toSort[b] = tmp;
    }

    public String toString(){
        String arrayItems = "";
        for(int i=0; i<toSort.length; i++){
            arrayItems = arrayItems + toSort[i] + " ";
        }
        return arrayItems;
    }

    public static void main(String[] args){
        int[] array = {77,99,44,55,22,88,11,00,66,33};
        BubbleSort bSort = new BubbleSort(array);
        bSort.sort();
        System.out.println(bSort.toString());
    }
}

