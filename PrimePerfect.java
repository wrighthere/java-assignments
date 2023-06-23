import java.lang.System;
import java.util.Scanner;

class PrimePerfect {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter a number");
    int num = sc.nextInt();
    int sum = 1;
    boolean isPrime = true;
    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime)
      System.out.println(num + " is a prime number");
    else
      System.out.println(num + " is not a prime number");

    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        sum += i;
        if (i != num / i) {
          sum += (num / i);
        }
      }
    }
    if (sum == num)
      System.out.println(num + " is a perfect number");
    else
      System.out.println(num + " is not a perfect number");
    sc.close();
  }
}