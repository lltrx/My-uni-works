// In collaboration with 2613065y, 2614579a, 2615938b
package matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    /** Compute and return the product between matrix1 and matrix2. Please refer to the previous sections on how to multiply two matrices */
    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];

                }
            }
        }

        return result;
    }

    /**
     * create and start matrix1.length many threads using the class MatrixRowMultiplier
     * join the threads together
     * combine all the resulting vectors from multiple threads into a single matrix
     * return that matrix
     */
    public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2){
        List<MatrixRowMultiplier> threads = new ArrayList<>();
        for (int i = 0; i < matrix1.length; i++) {
            threads.add(new MatrixRowMultiplier(matrix1[i], matrix2));
        }
        for (MatrixRowMultiplier thread : threads) {
            thread.run();
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < threads.toArray().length; i++) {
            MatrixRowMultiplier row = (MatrixRowMultiplier) threads.toArray()[i];
            result[i] = row.getResult();
        }
        return result;
    }

}
