import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class testSortingAlgorithms {
    public static boolean isSorted(int[] a){
        int n = a.length;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                return false;
            } }
        return true;
    }

    public static int[] readFile(String fileName) throws FileNotFoundException {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            al.add(Integer.parseInt(line));
        }
        int[] array = new int[al.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = al.get(i);
        }
        scanner.close();
        return array;
    }

    public static void main(String[] algorithms) {

        try {

            int[] int1000 = readFile("src/int1000.txt");
            int[] int20k = readFile("src/int20k.txt");
            int[] int500k = readFile("src/int500k.txt");
            int[] dutch = readFile("src/dutch.txt");
            int[] intBig = readFile("src/intBig.txt");

            int[][] files = {int1000, int20k, int500k, dutch, intBig};
            testTime(files);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public static void testTime(int[] files){
        System.out.println("--------------------------------");
        System.out.println("Time taken to sort " + files.length + " Integers" + ":");
        System.out.println("--------------------------------");

        int[] test1 = files.clone();
        long time1 = System.currentTimeMillis();
        algorithms.quickSort(test1);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        boolean sorted = isSorted(test1);
        System.out.println("QuickSort:\n " + "Sorted " + sorted + " in "
                + timeTaken + " millisecond\n");

        int[] test2 = files.clone();
        time1 = System.currentTimeMillis();
        algorithms.hybridSort(test2, 40);
        time2 = System.currentTimeMillis();
        timeTaken = time2 - time1;
        sorted = isSorted(test2);
        System.out.println("QuickSort with InsertionSort:\n " + "Sorted " + sorted + " in "
                + timeTaken + " millisecond\n");

        int[] test3 = files.clone();
        time1 = System.currentTimeMillis();
        algorithms.medianOfThree(test3);
        time2 = System.currentTimeMillis();
        timeTaken = time2 - time1;
        sorted = isSorted(test3);
        System.out.println("QuickSort Median of Three Partitioning:\n " + "Sorted " + sorted +
                " in " + timeTaken + " millisecond\n");

        int[] test4 = files.clone();
        time1 = System.currentTimeMillis();
        algorithms.threeWayQuickSort(test4);
        time2 = System.currentTimeMillis();
        timeTaken = time2 - time1;
        sorted = isSorted(test4);
        System.out.println("3-Way Quicksort: \n" +"Sorted " + sorted + " in "
                + timeTaken + " millisecond\n");

        int[] test5 = files.clone();
        time1 = System.currentTimeMillis();
        algorithms.mergeSort(test5);
        time2 = System.currentTimeMillis();
        timeTaken = time2 - time1;
        sorted = isSorted(test5);
        System.out.println("MergeSort: \n" + "Sorted " + sorted + " in "
                + timeTaken + " millisecond\n");

        int[] test6 = files.clone();
        time1 = System.currentTimeMillis();
        algorithms.insertionSort(test6);
        time2 = System.currentTimeMillis();
        timeTaken = time2 - time1;
        sorted = isSorted(test6);
        System.out.println("InsertionSort:\n " +"Sorted " + sorted + " in "
                + timeTaken + " millisecond\n");

    }

    public static void testTime(int[][] files){
        for ( int[] file : files) {
            testTime(file);
        }
    }
}
