void printPrimes (int max){
    for (int f = 2; f <= max; f++){

        int x = 0;
        for(int n = 2; n <= (int)Math.sqrt(f); n++){
            if (f % n == 0)
                    x = 1;
        }
        if (x == 0)
            System.out.println(f + " is prime");
    }
}
