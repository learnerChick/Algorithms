package Sorting;

/**
 * Different from bubble sort because the sorted element(smallest) will end up being placed on the left first.  It is
 * more efficient than bubble sort because although there are n^2 comparisons, the swaps are O(N).
 *
 * Selection sort is called selection sort because you look at each item one by one, compare its value and then finally choose the smallest to swap
 * it with.
 *
 * 1) Start from the left for the outer loop.  End the loop at < length - 1.
 * 2) Set the min to the position of the outer loop's marker.
 * 3) Start the inner loop at outerloop + 1.  End at  < length.
 * 4) Compare inner loop with min.  If inner loop item is less than min, then replace min marker with inner loop marker.
 * 5) At the close of inner loop, swap the min with the current outer loop's index.  Continue.
 */
public class SelectionSort {
    int[] toSort;
    int total = 0;
    public SelectionSort(int[] arr){
        toSort = arr;
        total = toSort.length;
    }

    public void sort(){
        for(int i = 0; i < total-1; i++){
            int min = i;
            for(int j = i+1; j < total; j++){
                if(toSort[j] < toSort[min]){
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    public void swap(int i, int j){
        int temp = toSort[i];
        toSort[i] = toSort[j];
        toSort[j] = temp;
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
        SelectionSort sSort = new SelectionSort(array);
        sSort.sort();
        System.out.println(sSort.toString());
    }
}
