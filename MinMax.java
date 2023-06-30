import java.util.Scanner;

class MinMax {
  public static void main(String[] args) {
    int[] arr = new int[5];
    int min, max;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 5 values");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    min = arr[0];
    max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i])
        min = arr[i];
      if (max < arr[i])
        max = arr[i];
    }
    System.out.println("maximum value is " + max + " minimum value is " + min);
  }
}