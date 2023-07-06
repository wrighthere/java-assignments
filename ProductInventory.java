import java.util.Scanner;
import java.util.ArrayList;

class ProductInventory {
  public static void main(String[] args) {
    ProductOperations prodOp = new ProductOperations();
    Scanner sc = new Scanner(System.in);
    int id, qty;
    String name;
    float price;
    while (true) {
      System.out.println("1. Add product");
      System.out.println("2. Display products");
      System.out.println("3. Delete product");
      System.out.println("4. Update product");
      System.out.println("select an option");
      int option = sc.nextInt();
      switch (option) {
        case 1:
          System.out.println("Enter product id");
          id = sc.nextInt();
          System.out.println("Enter name");
          name = sc.next();
          System.out.println("Enter price");
          price = sc.nextFloat();
          System.out.println("Enter quantity");
          qty = sc.nextInt();
          ProductDetails product = new ProductDetails(id, name, price, qty);
          prodOp.AddProduct(product);
          break;

        case 2:
          prodOp.DisplayProducts();
          break;

        case 3:
          System.out.println("enter product id to delete");
          id = sc.nextInt();
          prodOp.RemoveProduct(id);
          break;

        case 4:
          System.out.println("Enter the product ID to update");
          id = sc.nextInt();
          System.out.println("Enter name");
          name = sc.next();
          System.out.println("Enter price");
          price = sc.nextFloat();
          System.out.println("Enter quantity");
          qty = sc.nextInt();
          prodOp.UpdateProduct(id, name, price, qty);
          break;
      }
    }
  }
}

class ProductOperations {
  ProductDetails[] prodAL = new ProductDetails[100];
  int numProducts = 0;

  void AddProduct(ProductDetails product) {
    for (int i = 0; i < numProducts; i++) {
      if (prodAL[i].getPID() == product.getPID()) {
        System.out.println("productID already exists");
        return;
      }
    }
    prodAL[numProducts++] = product;
  }

  void RemoveProduct(int id) {
    for (int i = 0; i < numProducts; i++) {
      if (prodAL[i].getPID() == id) {
        prodAL[i] = null;
        for (int j = i + 1; j < numProducts; j++) {
          prodAL[j - 1] = prodAL[j];
        }
        numProducts--;
        return;
      }
    }
    System.out.println("no such product id");
  }

  void DisplayProducts() {
    for (int i = 0; i < numProducts; i++) {
      System.out.println(prodAL[i].getPID() + " " + prodAL[i].getName() + " "
          + prodAL[i].getPrice() + " " + prodAL[i].getQty());
    }
  }

  void UpdateProduct(int pid, String name, float price, int qty) {
    for (int i = 0; i < numProducts; i++) {
      if (prodAL[i].getPID() == pid) {
        prodAL[i].setName(name);
        prodAL[i].setPrice(price);
        prodAL[i].setQty(qty);
        break;
      }
    }
    System.out.println("no such product id");
  }
}

class ProductDetails {
  private int pId;
  private String pName;
  private float pPrice;
  private int pQty;

  public ProductDetails(int pId, String pName, float pPrice, int pQty) {
    this.pId = pId;
    this.pName = pName;
    this.pPrice = pPrice;
    this.pQty = pQty;
  }

  public int getPID() {
    return pId;
  }

  public String getName() {
    return pName;
  }

  public float getPrice() {
    return pPrice;
  }

  public int getQty() {
    return pQty;
  }

  public void setName(String name) {
    pName = name;
  }

  public void setPrice(float price) {
    pPrice = price;
  }

  public void setQty(int qty) {
    pQty = qty;
  }
}