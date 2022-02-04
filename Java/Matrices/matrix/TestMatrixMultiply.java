// In collaboration with 2613065y, 2614579a, 2615938b
package matrix;

public class TestMatrixMultiply {
    public static void main(String[] args) {
        int [][] matrix1 = MatrixGenerator.generateMatrix(1000, 1000);
        int [][] matrix2 = MatrixGenerator.generateMatrix(1000, 1000);

        long startTime1 = System.currentTimeMillis();
        int[][] res1 = MatrixMultiplication.matrixMultiply(matrix1, matrix2);
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.currentTimeMillis();
        int[][] res2 = MatrixMultiplication.parallelMatrixMultiply(matrix1, matrix2);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;

        System.out.println("Matrix 1");
        System.out.println("Completed in " + duration1 + "ms");

        System.out.println("");

        System.out.println("Matrix 2");
        System.out.println("Completed in " + duration2 + "ms");

    }
}
