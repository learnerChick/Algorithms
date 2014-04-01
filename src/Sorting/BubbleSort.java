package Sorting;

/**
 *  Bubble sort - compare each item with the item next to it and swap is left is larger than right.  Continue to the end
 *  of the list and then reloop again.
 *
 *  Runs in 0(N^2)
 *  1) Start at the end of the array for the outer loop.
 *  2) Have another loop that starts from beginning to end of outer loop
 *  3) Now, in the inner loop, take each item and compare it to the item next to it.  If item on left is larger than right, swap.
 *  4) These swapping motions will move the bigger item to the right one by one..
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

