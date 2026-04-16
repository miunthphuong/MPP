package prob3;

/*
//prob3.a
import java.util.stream.Stream;
import java.math.BigInteger;

public class PrimeStream {
    // A final variable containing an infinite stream of primes
    final Stream<Integer> primes = Stream.iterate(2, n -> {
        BigInteger b = BigInteger.valueOf(n);
        return b.nextProbablePrime().intValue();
    });
}
*/

//prob3.b
import java.util.stream.Stream;
import java.math.BigInteger;

public class PrimeStream {

    // Method to generate a fresh stream of primes each time it is called
    public Stream<Integer> getPrimesStream() {
        return Stream.iterate(2, n -> BigInteger.valueOf(n).nextProbablePrime().intValue());
    }

    public void printFirstNPrimes(long n) {
        // We call the generator method here so a new stream is created for every call
        getPrimesStream()
                .limit(n)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();

        System.out.println("First 10 primes:");
        ps.printFirstNPrimes(10);

        System.out.println("====");

        System.out.println("First 5 primes (demonstrating reusability):");
        ps.printFirstNPrimes(5);
    }
}