// In collaboration with 2613065y, 2614579a, 2615938b
package matrix;

/* implement a class to support parallel matrix multiplication by multiplying one row at a time */

public class MatrixRowMultiplier extends Thread {
    private int[] row;
    private int[][] matrix;
    private int[] result;

    public MatrixRowMultiplier(int[] row, int[][] matrix){
        this.row = row;
        this.matrix = matrix;
    }

    /** computes the product between the stored row and matrix and stores the result so that it can be returned later */
    public void multiplyByRow(){
        result = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
           int sum = 0;
           for(int j = 0; j < matrix.length; j++){
               sum += row[j] * matrix[j][i];
           }
           result[i] = sum;
        }
    }

    /**
     * returns the row vector that corresponds to the product of row and matrix.
     * This method can assume that multiplyByRow() has been called – no error checking is needed
     */
    public int[] getResult(){
        return result;
    }


   /**  * this method is called by the thread to perform the multiplication
     */
   @Override
    public void run(){
        multiplyByRow();
    }
}
