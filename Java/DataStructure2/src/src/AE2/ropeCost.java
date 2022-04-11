package AE2;

import static AE2.minHeap.*;

public class ropeCost {


    public static int ropes(int min1, int min2){
        return min1 + min2;
    }
    public static int minimumCost(int h[]) {
        int cost = 0;
        for( int rope : h){
            insert(rope);
        }
        while( size > 1){
            int min1 = extractMin();
            int min2 = extractMin();
            cost += ropes(min1, min2);
        }
        return cost;

    }



    public static void main(String[] args) {
        heap = new int[10];
          int[] h = {4,8,3,1,6,9,12,7,2};

          System.out.println("Minimum cost is " + minimumCost(h));
    }
}



