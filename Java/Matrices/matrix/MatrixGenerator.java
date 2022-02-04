//// In collaboration with 2613065y, 2614579a, 2615938b
package matrix;

public class MatrixGenerator {

    /** Generates a matrix of dimentions rows x columns consisting of random integers between 0 and 9 */
    public static int[][] generateMatrix(int rows, int columns){
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
        return matrix;
    }

    /** Print in the command line/terminal a nicely formatted string representation of matrix */
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
