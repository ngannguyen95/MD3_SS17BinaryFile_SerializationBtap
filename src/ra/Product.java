package ra;

import java.io.Serializable;

import static ra.Main.scanner;

public class Product implements IProduct, Serializable {
    private int productId;
    private String productName;
    private String brand;
    private long price;
    private String other;

    public Product() {
    }

    public Product(int productId, String productName, String brand, long price, String other) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.other = other;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Product[" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", other='" + other + '\'' +
                ']';
    }

    @Override
    public void inputData() {
        System.out.println("Nhập vào tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập vào hãng sản xuất: ");
       this.brand = scanner.nextLine();
        System.out.println("Nhập vào giá: ");
        this.price = Long.parseLong(scanner.nextLine());
        System.out.println("Các mô tả khác: ");
        this.other = scanner.nextLine();

    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------");
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Hãng sản xuất: " + brand);
        System.out.println("Giá: " + price);
        System.out.println("Mô tả: " + other);
        System.out.println("----------------------------------------");
    }
}
