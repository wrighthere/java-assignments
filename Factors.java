import java.lang.System;
import java.util.Scanner;

class Factors {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;
    System.out.println("Enter a number");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int i = 1; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        count += 1;
        sum += i;
        System.out.print(i + " ");
        if (i != num / i) {
          count += 1;
          sum += (num / i);
          System.out.print(num / i + " ");
        }
      }
    }
    System.out.print("\nnum of factors = " + count);
    System.out.print("\nsum of factors = " + sum);
  }
}