int computeFibonacci (int n) {
    if ( n <= 1){
        return n;

    }
    int result = 1, lastResult = 1, temp = 0;
    for (int i = 0; i < n - 2; i++){
        temp = result + lastResult;
            result = lastResult;
            lastResult = temp;
    }
    return lastResult;
}