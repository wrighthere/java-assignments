import java.util.Scanner;

class Arrayduplicates {
  public static void main(String[] args) {
    int[] arr = new int[10];
    int[] duparr = { 0, 0, 0, 0, 0 };
    int dupcount = 0;
    System.out.println("Enter 10 positive numbers");
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    for (int i = 0; i < (arr.length - 1); i++) {
      for (int j = (i + 1); j < (arr.length); j++) {
        if (arr[i] == arr[j]) {
          for (int k = 0; k < duparr.length; k++) {
            if (duparr[k] == arr[i]) {
              break;
            }
            if (k == duparr.length - 1) {
              duparr[dupcount++] = arr[i];
            }
          }
        }
      }
    }
    System.out.println("there are " + dupcount + " duplicates, they are");
    for (int i = 0; i < dupcount; i++) {
      System.out.println(duparr[i]);
    }
  }
}