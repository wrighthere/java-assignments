import java.lang.System;
import java.util.Scanner;

class Factors {
  public static void main(String[] args) {
    System.out.println("Enter a number");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int i = 1; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        System.out.print(i + " ");
        if (i != num / i) {
          System.out.print(num / i + " ");
        }
      }
    }
  }
}