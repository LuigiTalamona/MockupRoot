package org.talamona.literatePrimes;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/6/13
 * Time: 3:48 PM
 *
 */
public class PrintPrimesRefactored {
    public static void main(String[] args) {
        final int m = 1000;
        final int RR = 50;
        final int CC = 4;
        final int WW = 10;
        final int ORDMAX = 30;
        int p[] = new int[m + 1];
        int pageNumber;
        int pageOffset;
        int rowOffset;
        int c;
        int j;
        int k;
        int ord;
        boolean jPrime;
        int square;
        int n;
        int mult[] = new int[ORDMAX + 1];
        /* TO DO: REMOVE COMMENTS AND COMPLETE REFACTORING
        p[1] = 2;
        selectPrimesFromIntegers(m, p, mult);
            pageNumber = 1;
            pageOffset = 1;
            while (pageOffset <= m) {
                System.out.println("The First " + m +
                        " Prime Numbers --- Page " + pageNumber);
                System.out.println("");
                for (rowOffset = pageOffset; rowOffset < pageOffset + RR; rowOffset++) {
                    for (c = 0; c < CC; c++)
                        if (rowOffset + c * RR <= m)
                            System.out.format("%10d", p[rowOffset + c * RR]);
                    System.out.println("");
                }
                System.out.println("\n");
                pageNumber = pageNumber + 1;
                pageOffset = pageOffset + RR * CC;
            }
    }

    private static int[] selectPrimesFromIntegers(int m) {
        int[] retValue = new int[m + 1];
        int j = 1, k = 1;
        int ord = 2, square = 9;
        int n;
        boolean jPrime;
        square = 9;
        while (k < m) {
            do {
                j = j + 2;
                if (j == square) {
                    ord = ord + 1;
                    square = retValue[ord] * retValue[ord];
                    mult[ord - 1] = j;
                }
                n = 2;
                jPrime = true;
                while (n < ord && jPrime) {
                    while (mult[n] < j)
                        mult[n] = mult[n] + retValue[n] + retValue[n];
                    if (mult[n] == j)
                        jPrime = false;
                    n = n + 1;
                }
            } while (!jPrime);
            k = k + 1;
            retValue[k] = j;
        }
        return retValue; */
    }
}
