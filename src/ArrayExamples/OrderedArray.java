package Arrays;
/* Benefit: Good for when searches are frequent, but insertions and deletes aren't */

public class OrderedArray {
    private int numElements;
    private int[] items;

    public OrderedArray(int max) {
        items = new int[max];
        numElements = 0;
    }

    /*
        Inserting in an ordered array is 0(n) at worst case.
    */

    public void insert(int item) {
        int j = 0;
        /* If the array is empty, the numElements is 0, so it won't go through the loops below and automatically
         add the item to the first index.  Also, if it's added in ascending order, it will j will end up being the next
         empty slot.
       */
        for (j = 0; j < numElements; j++) {
            //go through each item and find the position to insert
            if (items[j] > item) {
                break;
            }
        }
         /*
            At this point, we need to move each item from position j up to make space for the new number.
            One thing to note is since we're copying numbers, start from the end so we don't overwrite array values.
         */

        for (int k = numElements; k > j; k--) {
            items[k] = items[k - 1];
        }

        items[j] = item;
        numElements++;
    }

    public void printItems() {
        System.out.println("Items in array are:");
        for (int i = 0; i < numElements; i++) {
            System.out.print(items[i] + " ");
        }
    }

    /* Finding an item is 0(n log(n)) because we can keep halving the search area */
    public int find(int item){
        int begin = 0;
        int end = numElements - 1;
        int mid;

        while(true){
            mid = (end + begin)/2;
            if(items[mid] == item){
                return mid;
            }
            else if(begin > end){
                return -1;
            }
            else{
                if(items[mid] < item){
                    begin = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
    }

    public boolean delete(int item){
        int index = find(item);
        if(index > -1){
            /* go through each item in array and bring it down one, thus erasing current item.  Move from current position */
            for(int i = index; i < numElements; i++){
                items[i] = items[i + 1];
            }
            numElements--;
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray arr = new OrderedArray(maxSize);
        arr.insert(1);
        arr.insert(5);
        arr.insert(3);
        arr.printItems();
        System.out.println(arr.find(5));
        System.out.println(arr.delete(1));
        arr.printItems();
    }
}
