package Sorting;

/**
 * 1) First place marker on first item.
 * 2) This divides list into two parts, sorted and unsorted list.
 * 3) Repeatedly compare the marker with numbers in sorted section.
 * 4) If find a lower number, swap.
 * 5) Move marker to the right.
 *
 *
 * Insertion sort is good for lists that are almost sorted because/
 * At best case, it makes N-1 compares and 0 exchanges. 0(N)
 * Worst case (N^2 compares and N^2) exchanges 0(N^2)
 * It's a stable sort.  Constant space is requires  0(1)
 */
public class InsertionSort {
    int[] toSort;
    int total = 0;

    public InsertionSort(int[] arr){
        toSort = arr;
        total = arr.length;
    }

    public void sort(){
        for(int i = 0; i < total; i++){
            for(int j = i; j > 0; j--){
                if(toSort[j] < toSort[j-1]){
                    swap(j, j - 1);
                }
                else{
                    //we should just leave the loop here because as soon as it hits a point where the number is smaller, we know
                    //the list is sorted.
                    break;
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
        InsertionSort iSort = new InsertionSort(array);
        iSort.sort();
        System.out.println(iSort.toString());
    }
}
