public class algorithms {

    /* PART 1A */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int l, int r) {
        int k = l - 1;
        for (int i = l; i < r; i++) {

            if (arr[i] <= arr[r]) {
                k++;
                swap(arr, k, i);
            }
        }
        swap(arr, k + 1, r);
        return k + 1;
    }
    public static void quickSort(int[] arr, int l, int r) {
        if (r > l) {
            int piv = partition(arr, l, r);
            quickSort(arr, l, piv - 1);
            quickSort(arr, piv + 1, r);
        }
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /* PART 1B */
    static void cutOff(int[] arr, int l, int r, int cut) {
        if (l < r) {
            if (r - l + 1 < cut) {
                return;
            }
            int piv = partition(arr, l, r);
            cutOff(arr, l, piv - 1, cut);
            cutOff(arr, piv + 1, r, cut);
        }
    }
    public static void insertionSort(int[] arr) {
        int k, i, j;
        for (i = 1; i < arr.length; i++) {
            k = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
    public static void hybridSort(int[] arr, int cutoff) {
        cutOff(arr, 0, arr.length - 1, cutoff);
        insertionSort(arr);
    }
    /* PART 1C */
    public static int medianPartition(int arr[], int l, int r, double piv) {
        int leftPtr = l;
        int rightPtr = r - 1;

        while (true) {
            while (arr[++ leftPtr] < piv)
                ;
            while (arr[-- rightPtr] > piv)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, r - 1);
        return leftPtr;
    }
    public static void Sort(int arr[], int l, int r) {
        int size = r - l + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (arr[l] > arr[r])
                swap(arr, l, r);
            return;
        } else {
            if (arr[l] > arr[r - 1])
                swap(arr, l, r - 1);
            if (arr[l] > arr[r])
                swap(arr, l, r);
            if (arr[r - 1] > arr[r])
                swap(arr, r - 1, r);
        }
    }
    public static int medianOfThree(int[] arr, int l, int r) {
        int center = (l + r) / 2;

        if (arr[l] > arr[center])
            swap(arr, l, center);

        if (arr[l] > arr[r])
            swap(arr, l, r);

        if (arr[center] > arr[r])
            swap(arr, center, r);

        swap(arr, center, r - 1);
        return arr[r - 1];
    }

    public static void recQuickSort(int arr[], int l, int r) {
        int size = r - l + 1;
        if (size <= 3)
            Sort(arr, l, r);
        else {
            double median = medianOfThree(arr, l, r);
            int partition = medianPartition(arr, l, r, median);
            recQuickSort(arr, l, partition - 1);
            recQuickSort(arr, partition + 1, r);
        }
    }
    public static void medianOfThree(int arr[]) {
        recQuickSort(arr, 0, arr.length - 1);
    }

    /* PART 1D */
    private static int[] threePartition(int[] arr, int l, int r) {
        int m = l;
        while (m < r + 1) {
            if(arr[m] > arr[l]) {
                swap(arr, m, r--);
                continue;
            }
            if (arr[m] < arr[l]) {
                swap(arr, l++, m++);
                continue;
            }
            if(arr[m] == arr[l]) {
                m++;
            }

        }
        return new int[]{l , r};
    }

    public static void threeWayQuickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] partition = threePartition(arr, l, r);
            threeWayQuickSort(arr, l, partition[0] - 1);
            threeWayQuickSort(arr, partition[1] + 1, r);
        }
    }

    public static void threeWayQuickSort(int[] arr) {
        threeWayQuickSort(arr, 0, arr.length - 1);
    }

    /* Merge Sort */
    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        if (n1 >= 0) System.arraycopy(a, p, L, 0, n1);
        for (int j = 0; j < n2; j++)
            R[j] = a[q + 1 + j];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
    }
    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }





}


