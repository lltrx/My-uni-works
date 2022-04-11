package AE2;

public class minHeap {
    static int size;
    static int[] heap;

    public static void insert(int value) {
        if (size == heap.length) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        int i = size - 1;
        while (i > 0 && heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void minHeapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < size && heap[l] < heap[i]) {
            smallest = l;
        }
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);
        return root;
    }

    public static int min(){
        return heap[0];
    }

    public static void main(String[] args) {
        heap = new int[10];
        insert(30);
        insert(20);
        insert(35);
        insert(25);
        insert(25);
        insert(10);
        insert(55);
        System.out.println("MinHeap:");
        display();
        System.out.println("The minimum is: " + min());
        extractMin();
        System.out.println("MinHeap after extraction: ");
        display();
        System.out.println("The minimum is: " + min());
        extractMin();
        System.out.println("MinHeap after extraction: ");
        display();
}
}

