import java.util.Scanner;

class BookInventory {
  public static void main(String[] args) {
    BookOperations bookManager = new BookOperations();
    Scanner sc = new Scanner(System.in);
    int quantity;
    float price;
    String Author;
    String title;
    int numSold;
    while (true) {
      System.out.println("1. Add Book");
      System.out.println("2. Search book by Author");
      System.out.println("3. Sell Book");
      System.out.println("Enter an option");
      int option = sc.nextInt();

      switch (option) {
        case 1:
          System.out.println("Enter title");
          title = sc.next();
          System.out.println("Enter Author");
          Author = sc.next();
          System.out.println("Enter price");
          price = sc.nextFloat();
          System.out.println("Enter quantity");
          quantity = sc.nextInt();
          bookManager.AddBook(title, Author, price, quantity);
          break;

        case 2:
          System.out.println("Enter Author");
          Author = sc.next();
          bookManager.SearchByAuthor(Author);
          break;

        case 3:
          System.out.println("Enter title");
          title = sc.next();
          System.out.println("Enter num sold");
          numSold = sc.nextInt();
          bookManager.bookSold(title, numSold);
          break;
      }
    }
  }
}

class BookOperations {
  Book[] bookArray = new Book[100];
  int bookCount = 0;

  void AddBook(String title, String author, float price, int quantity) {
    Book newBook = new Book(title, author, price, quantity);
    bookArray[bookCount++] = newBook;
  }

  void SearchByAuthor(String author) {
    int authorCount = 0;
    for (int i = 0; i < bookCount; i++) {
      if (bookArray[i].author.equals(author)) {
        printBook(i);
        authorCount++;
      }
    }
    if (authorCount == 0)
      System.out.println("No Such Author");
  }

  void printBook(int num) {
    System.out.println("name: " + bookArray[num].title + "Author: " + bookArray[num].author +
        "price: " + bookArray[num].price + "quantity: " + bookArray[num].quantity);
  }

  void bookSold(String title, int count) {
    for (int i = 0; i < bookCount; i++) {
      if (bookArray[i].title.equals(title)) {
        if (bookArray[i].quantity >= count) {
          bookArray[i].quantity -= count;
        } else {
          System.out.println("Not enough quantity");
        }
        printBook(i);
        return;
      }
    }
  }

}

class Book {
  String title;
  String author;
  float price;
  int quantity;

  Book(String title, String author, float price, int quantity) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.quantity = quantity;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}