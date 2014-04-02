package ArrayExamples;

/**
 * Created by Dhana on 4/1/2014.
 */
public class SpiralArray {
    int[][] matrix;

    public SpiralArray(int[][] arr){
        matrix = arr;
    }

    public void printTopRight(int x1, int y1, int x2, int y2){
        int i = 0;
        int j = 0;


        //print row on top
        for(i = x1; i <= x2; i++){
            System.out.print(matrix[y1][i] + " ");
        }

        //print column down, start j at one higher because the row already printed the first value for the column
        // bacause x is on the end, print x2
        for(j = y1 + 1; j <= y2; j++){
            System.out.print(matrix[j][x2] + " ");
        }

        //see if any more layers need to be printed
        if(x2-x1 > 0){
            printBottomLeft(x1, y1+1,x2-1, y2);
        }
    }

    public void printBottomLeft(int x1, int y1, int x2, int y2){
        int i = 0;
        int j = 0;

        for(i = x2; i >= x1; i--){
            System.out.print(matrix[y2][i] + " ");
        }

        for(j = y2 - 1; j > y1; j--){
            System.out.print(matrix[j][x1] + " ");
        }

        if(x2-x1 > 0){
            printTopRight(x1 + 1, y1, x2, y2 - 1);
        }
    }

    public static void main(String[] args){
        int[][] matrix =
                {
                        { 3, 4, 5, 6, 2, 5 },
                        { 2, 4, 6, 2, 5, 7 },
                        { 2, 5, 7, 8, 9, 3 },
                        { 2, 4, 7, 3, 5, 8 },
                        { 6, 4, 7, 3, 5, 7 } };
        SpiralArray arr = new SpiralArray(matrix);
        arr.printTopRight(0, 0 , matrix[0].length - 1, matrix.length - 1);
    }
}
