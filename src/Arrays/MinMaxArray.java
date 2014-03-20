package Arrays;

/**
 * Write a function to find the min and max in an array with minimum comparisons.
 * Solution: Compare in pairs
 * If n is odd, then initialize min and max = arr[0]. Counter (index pos for array) begins at 1 here.
 * If n is even, the initialize min = arr[0] and max = arr[1].  Counter begins at 2 here.
 * Then, start going through each element and compare min and max
 * Time complexity: 0(n)
 * Comparisons: We're doing 3 comparisons every time, and since we're going down the route of 2 numbers each time, divide that by half.
 * 3*(n-1)/2 ~1.5n
 */

public class MinMaxArray {
    public static void main(String[] args){
        //int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11};
        int[] arr = {4, 33, 5, 33, 2, 6, 9, 2, 10, 11,45};
        int min;
        int max;
        int i = 0;
        int totalElements = arr.length;

        //no items in array, show a message
        if(totalElements == 0){
            System.out.println("There are no itesm in the array");
        }
        else if(totalElements == 1){
            System.out.println("Min: " + arr[0]);
            System.out.println("Max: " + arr[0]);
        }
        else{
            if(totalElements % 2 != 0){
                min = arr[0];
                max = arr[0];
                i = 1;
            }
            else{
                min = arr[0];
                max = arr[1];
                i = 2;
            }

            //check while there are items to go through
            while(i < totalElements - 1){
                //here, we check if the left item is larger than the right, if it is, we then check the larger item with max and the smaller one with min.
                if(arr[i] > arr[i + 1]){
                    if(arr[i] > max){
                        max = arr[i];
                    }
                    if(arr[i+1] < min){
                        min = arr[i+1];
                    }
                }
                //same as above, just flip the order
                else{
                    if(arr[i+1] > max){
                        max = arr[i+1];
                    }
                    if(arr[i] < min) {
                        min = arr[i];
                    }
                }
                //move counter two ahead because we've compared 2 ahead already
                i = i + 2;
            }
            System.out.println("Min is: " + min);
            System.out.println("Max is: " + max);
        }
    }

}
