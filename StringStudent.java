import java.util.Scanner;

class StringStudent {
  public static void main(String[] args) {
    String sId, sName, sEmailId, sMobileNo, uName, pWord;
    Scanner sc = new Scanner(System.in);
    boolean[] pWordset = new boolean[4];
    for (; true;) {
      System.out.println("enter student id");
      sId = sc.nextLine();
      if (sId.substring(0, 2) != "std" || sId.length() <= 6 || sId.length() >= 10
          || (int) sId.charAt(sId.length() - 1) < 48 || (int) sId.charAt(sId.length() - 1) > 57) {
        System.out.println("incorrect format");
        continue;
      }
      System.out.println("enter student name");
      sName = sc.nextLine();
      if (sName.length() < 5 || sName.length() > 15 || (int) sName.charAt(0) < 65 || (int) sName.charAt(0) > 90) {
        System.out.println("incorrect format");
        continue;
      }
      for (int i = 1; i < sName.length() - 1; i++) {
        if (sName.charAt(i) < 97 || sName.charAt(i) > 122) {
          System.out.println("incorrect format");
        }
      }
      System.out.println("enter student email id");
      sEmailId = sc.nextLine();
      if (sEmailId.length() < 10 || sEmailId.length() > 25) {
        System.out.println("incorrect format");
        continue;
      } else if (!(sEmailId.substring(sEmailId.length() - 4, sEmailId.length() - 1).equals(".com") ||
          sEmailId.substring(sEmailId.length() - 3, sEmailId.length() - 1).equals(".in"))) {
        System.out.println("incorrect format");
        continue;
      } else if (sEmailId.contains("@") && sEmailId.contains(".")) {
        System.out.println("incorrect format");
        continue;
      }
      for (int i = 1; i < sEmailId.length(); i++) {
        if (!((sEmailId.charAt(i) < 'a' && sEmailId.charAt(i) > 'z') || (sEmailId.charAt(i) < 'A' &&
            sEmailId.charAt(i) > 'Z') || (sEmailId.charAt(i) == '_')))
          System.out.println("incorrect format");
        continue;
      }
      System.out.println("enter student mobile number");
      sMobileNo = sc.nextLine();
      if (sMobileNo.length() != 10) {
        System.out.println("incorrect format");
        continue;
      }
      for (int i = 1; i < sMobileNo.length(); i++) {
        if (sMobileNo.charAt(i) < '0' || sMobileNo.charAt(i) > '9') {
          System.out.println("incorrect format");
          continue;
        }
      }
      System.out.println("enter username");
      uName = sc.nextLine();
      System.out.println("enter password");
      pWord = sc.nextLine();
      if (uName.length() < 8 || uName.length() > 15 || (uName.charAt(0) < 'a' && uName.charAt(0) > 'z')
          || (uName.charAt(0) < 'A' && uName.charAt(0) > 'Z') || (uName.contains(" ")) || uName.equals(pWord)) {
        System.out.println("incorrect format");
        continue;
      }

      if (pWord.length() < 8 || pWord.length() > 15 || pWord.contains(" ")) {
        System.out.println("incorrect format");
        continue;
      }
      for (int i = 0; i < pWord.length(); i++) {
        if (pWord.charAt(i) >= 'a' && pWord.charAt(i) <= 'z')
          pWordset[0] = true;
        else if (pWord.charAt(i) >= 'A' && pWord.charAt(i) <= 'Z')
          pWordset[1] = true;
        else if (pWord.charAt(i) >= '0' && pWord.charAt(i) <= '9')
          pWordset[2] = true;
        else
          pWordset[3] = true;
      }
      if (!(pWordset[0] == true || pWordset[1] == true || pWordset[2] == true || pWordset[3] == true)) {
        System.out.println("incorrect format");
        continue;
      }
    }
  }
}