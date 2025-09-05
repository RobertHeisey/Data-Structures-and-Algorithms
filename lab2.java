// lab2.java
// Robert Heisey
// September 5, 2025
// Calculates primes using Sieve of Eratosthenes
// Demonstrates command line arguments and methods
// *** My answers to performance questions here ***
// The maximum prime number I was able to get before the program stopped running bigger limits
// was 999999937. I got this number after running a limit of 1 billion. For the second question,
// I commenting out the print statement and timing the outputs. From what I observed, without 
// printing, the program seemed to perform faster. And for the final question, the main factors
// limiting my program was memory and output speed. Eventually, the computer just did not have the 
// storage capacity to withold the information, and even if it did, it would just take far too long
// to process to be worth the time.

public class lab2 {

    public static void main(String[] args) {
        int num;

        //add code to get num from command line argument
        if (args.length > 0) {
            try {
                num = Integer.parseInt(args[0]);
                if (num < 2) {
                    System.out.println("Enter a number >= 2. Using default 1000.");
                    num = 1000;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default 1000.");
                num = 1000;
            }
        } else {
            num = 1000;
        }

        //call showPrimes
        showPrimes(num);
    }

    public static void showPrimes(int N) {
        // This creates boolean array of size N+1.
        boolean[] isPrime = new boolean[N + 1];

        // Initializes all entries as true and marks non-primes false.
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes - the big one
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Displays all prime numbers.
        System.out.println("Prime numbers up to " + N + ":");
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
