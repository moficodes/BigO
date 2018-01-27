package com.coding.mechanic.BigO;

/**
 * PrimeFinder
 * Finds if a number is prime in a few different ways
 */
public class PrimeFinder {
    private PrimeFinder() {
        //EMPTY CONSTRUCTOR
    }

    public static boolean isPrimeBasic(int n) {
        //O(n), Ω(n), θ(n)
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimizedByHalf(int n) {
        //O(n), Ω(n), θ(n)
        //We use the knowledge that any number bigger than n/2 can no longer divide n with 0 remainder
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimizedByIncrement(int n) {
        //O(n), Ω(n), θ(n)
        //if a number is not divisible by two it wont be by any other even number
        //we can use this to eliminate even more checks
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i < n / 2; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimizedBySquareRoot(int n) {
        //O(√n), Ω(√n), θ(√n)
        //We use the mathematical fact that all any non prime
        //will have a divisor between 2 and the sqrt of the number
        //for example 49 has only one divisor 7
        //which is sqrt of 49
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimizedByObservedMathematics(int n) {
        //O(√n), Ω(√n), θ(√n)
        //This can be proved mathematically but harder to explain
        if (n <= 1) return false;
        else if (n <= 3) return true;
        else if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void runTimerTest(int n) {
        int count = 0;
        long startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            if (isPrimeBasic(i)) count++;
        }
        long endTime = System.nanoTime();
        long difference = (endTime - startTime);

        System.out.println(String.format("Total Prime in first %d numbers calculated by %s method. \nTime taken : %d nano second.\nTime Taken : %.6f seconds \nPrime found : %d", n, "isPrimeBasic", difference, (double)difference/1000000000.0,count));


        System.out.println("\n=====================================================\n");

        count = 0;
        startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            if (isPrimeOptimizedByHalf(i)) count++;
        }
        endTime = System.nanoTime();

        difference = (endTime - startTime);
        System.out.println(String.format("Total Prime in first %d numbers calculated by %s method. \nTime taken : %d nano second.\nTime Taken : %.6f seconds \nPrime found : %d", n, "isPrimeOptimizedByHalf", difference,(double)difference/1000000000.0, count));

        System.out.println("\n=====================================================\n");

        count = 0;
        startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            if (isPrimeOptimizedByIncrement(i)) count++;
        }
        endTime = System.nanoTime();
        difference = (endTime - startTime);
        System.out.println(String.format("Total Prime in first %d numbers calculated by %s method. \nTime taken : %d nano second.\nTime Taken : %.6f seconds \nPrime found : %d", n, "isPrimeOptimizedByIncrement", difference,(double)difference/1000000000.0, count));


        System.out.println("\n=====================================================\n");

        count = 0;
        startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            if (isPrimeOptimizedBySquareRoot(i)) count++;
        }
        endTime = System.nanoTime();
        difference = (endTime - startTime);

        System.out.println(String.format("Total Prime in first %d numbers calculated by %s method. \nTime taken : %d nano second.\nTime Taken : %.6f seconds \nPrime found : %d", n, "isPrimeOptimizedBySquareRoot",difference ,(double)difference/1000000000.0 ,count));


        System.out.println("\n=====================================================\n");

        count = 0;
        startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            if (isPrimeOptimizedByObservedMathematics(i)) count++;
        }
        endTime = System.nanoTime();
        difference = (endTime - startTime);
        System.out.println(String.format("Total Prime in first %d numbers calculated by %s method. \nTime taken : %d nano second.\nTime Taken : %.6f seconds \nPrime found : %d", n, "isPrimeOptimizedByObservedMathematics", difference, (double)difference/1000000000.0,count));

    }
}
