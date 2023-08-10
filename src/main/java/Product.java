public class Product {
 private int productId;
 private String name;
 private String brand;
 private int year;
 private double price;

    public Product(int productId, String name, String brand, int year, double price) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Product(String name, String brand, int year, double price) {
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandMake() {
        return brand;
    }

    public void setBrandMake(String brandMake) {
        this.brand = brandMake;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", brandMake='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

