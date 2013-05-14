package org.talamona.comments;

import java.util.Arrays;

/**
 * This class Generates prime numbers up to a user specified maximum. The
 * algorithm used is the Sieve of Eratosthenes. <p> Eratosthenes of Cyrene, b.
 * c. 276 BC, Cyrene, Libya -- d. c. 194, Alexandria. The first man to calculate
 * the circumference of the Earth. Also known for working on calendars with leap
 * years and ran the library at Alexandria. <p> The algorithm is quite simple.
 * Given an array of integers starting at 2. Cross out all multiples of 2. Find
 * the next uncrossed integer, and cross out all of its multiples. Repeat until
 * you have passed the square root of the maximum value.
 *
 * @author Luigi
 * @version April 25, 2013
 */
public class GeneratePrimesRefactored {

    /**
     * @param maxValue is the generation limit.
     */
    public int[] generatePrimes(int maxValue) {
        int[] primes = new int[0];

        if (maxValue >= 2) { // the only valid case

            boolean[] startingArray = prepareArrayWithDefaultValues(maxValue + 1);

            boolean[] sievedArray = sieveArrayToFindPrimes(startingArray);

            primes = collectsPrimesFromSievedArray(sievedArray);

        }
        return primes;
    }

    private boolean[] prepareArrayWithDefaultValues(int s) {
        boolean[] retValue = new boolean[s];

        Arrays.fill(retValue, true);

        // get rid of known non-primes
        retValue[0] = retValue[1] = false;
        return retValue;
    }

    private boolean[] sieveArrayToFindPrimes(boolean[] f) {

        int s = f.length;
        int limit = determineIterationLimit(s);
        for (int i = 2; i < limit + 1; i++) {
            if (f[i]) // if i is uncrossed, cross its multiples.
            {
                for (int j = 2 * i; j < s; j += i) {
                    f[j] = false;
                } // multiple is not prime
            }
        }
        return f;
    }

    private int determineIterationLimit(int length) {
        double sqrt = Math.sqrt(length);
        return (int) sqrt;

    }

    private int[] collectsPrimesFromSievedArray(boolean[] f) {
        int s = f.length;
        int[] primes = new int[countPrimes(f)];

        // move the primes into the result
        for (int i = 0, j = 0; i < s; i++) {
            if (f[i]) {
                primes[j++] = i;
            }
        }

        return primes; // return the primes
    }

    private int countPrimes(boolean[] f) {
        int s = f.length;
        int count = 0;
        for (int i = 0; i < s; i++) {
            if (f[i]) {
                count++;
            } // bump count.
        }
        return count;
    }


}
