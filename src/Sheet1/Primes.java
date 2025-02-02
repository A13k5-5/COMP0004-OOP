package Sheet1;

import java.util.ArrayList;

public class Primes {
    private static boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        System.out.println(num);
        return true;
    }

    public static void findAllPrimes() {
        ArrayList<Long> primes = new ArrayList<>();
        primes.add(2L);
        long max = (long) Math.pow(2, 63);
        for (long num = 2; num < 100000000; num++) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size() && primes.get(j) * primes.get(j) < num; j++) {
                if (num % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }
        System.out.println(primes.size());
    }

    public static void Eratosthenes(long max) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < max; i++){
            nums.add(i);
        }
        boolean[] isPrime = new boolean[(int)max];
        
    }

    public static void main(String[] args) {

    }
}
