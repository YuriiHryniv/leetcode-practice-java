package closet_prime_numbers_in_range;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieve = new boolean[right + 1];

        sieve[0] = true;
        sieve[1] = true;

        int currentPrime = -1;

        int firstRes = -1;
        int secondRes = -1;

        sieve(right, sieve);

        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (!sieve[i] && currentPrime == -1) {
                currentPrime = i;
            } else if (currentPrime != -1 && !sieve[i] ) {
                if (i - currentPrime < min) {
                    min = i - currentPrime;
                    firstRes = currentPrime;
                    secondRes = i;
                }
                currentPrime = i;
            }
        }

        if (firstRes == -1 || secondRes == -1) {
            return new int[] {-1, -1};
        }

        return new int[] {firstRes, secondRes};
    }

    private void sieve(int n, boolean[] sieve) {
        double sqrt = Math.sqrt((double) n);
        int square = (int) Math.floor(sqrt);

        for (int i = 2; i <= square; i++) {
            markAsSieved(i, i, sieve);
        }
    }

    private void markAsSieved(int multiply, int number, boolean[] sieve) {
        number += multiply;
        while (number < sieve.length) {
            sieve[number] = true;
            number += multiply;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.closestPrimes(1, 1021)));

    }
}