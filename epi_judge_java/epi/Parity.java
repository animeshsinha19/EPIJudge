package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class Parity {
  // Brute force method
  // @EpiTest(testDataFile = "parity.tsv")
  // public static short parity(long x) {
  //   short result = 0;
  //   while(x != 0) {
  //     result ^= (x & 1);
  //     x >>>= 1;
  //   }
  //   return result;
  // }

  // unset least significant set bit method
  // @EpiTest(testDataFile = "parity.tsv")
  // public static short parity(long x) {
  //   short result = 0;
  //   while(x != 0) {
  //     result ^= 1;
  //     x &= (x - 1);
  //   }
  //   return result;
  // }

  // using XOR's associative property
  @EpiTest(testDataFile = "parity.tsv")
  public static short parity(long x) {
    int denominator = Long.SIZE / 2;
    while (denominator != 0) {
      x ^= x >>> denominator;
      denominator /= 2;
    }
    return (short) (x & 0x1);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
