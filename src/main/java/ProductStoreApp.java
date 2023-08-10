

import java.util.Scanner;

public class ProductStoreApp {

    private static ProductMethod productMethod = new ProductMethodImpl(ProductJDB.getConnection());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println(" ================== WELCOME TO MY NEW PRODUCT STORE");
            System.out.println("""
                    Please choose from the following options:\s
                    1. Add a new product"\s
                    2. Update a product\s
                    3. Delete a product\s
                    4. Retrieve a product\s
                    5. Show all products\s
                    6. Exit the program
                    """);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                     deleteProduct(scanner);
                    break;
                case 4:
                    getProductById(scanner);
                    break;
                case 5:
                    getAllProduct();
                    break;
                case 6:
                    System.out.println(" Bye!");
                    System.exit(0);
                default:
                    System.out.println("invalid choice, try again");
            }

        }
        while (choice != -1);
    }

    public static void getAllProduct() {
        if (productMethod.getAllProducts().size() > 0) {

            for (Product product : productMethod.getAllProducts()) {
                System.out.println(product);
            }
        } else {
            System.out.println("no products available  ");

        }
    }

    public static void addProduct(Scanner scanner) {
        System.out.println("Enter the product name ");
        String name = scanner.nextLine();
        System.out.println("Enter the product brand");
        String brand = scanner.nextLine();
        System.out.println("Enter the product made year");
        int year = scanner.nextInt();
        System.out.println("Enter the product price");
        double price = scanner.nextDouble();
        // creating a new book
        Product product = new Product(name, brand, year, price);
        //adding the product to the database.
        productMethod.addProduct(product);
        System.out.println("product added to the database successfully ");
        ;
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("enter the product Id to update : ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = productMethod.getProductById(productId);
        if (product == null) {
            System.out.println("No product found");
        } else {
            System.out.println("Enter the product name (or press Enter to skip): ");
            String name = scanner.nextLine();
            System.out.println("Enter the product brand (or press Enter to skip):");
            String brand = scanner.nextLine();
            System.out.println("Enter the year of made (or press Enter to skip):");
            int year = scanner.nextInt();
            System.out.println("Enter the product price (or press 0 to skip): ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // newline character
            product.setName(name.isEmpty() ? product.getName() : name);
            product.setBrandMake(brand.isEmpty() ? product.getBrandMake() : brand);
            product.setYear(year == 0 ? product.getYear() : year);
            product.setPrice(price == 0 ? product.getPrice() : price);
            productMethod.updateProduct(product);
            System.out.println("Product with id: " + productId + "update successfully");
        }
    }

        public static void deleteProduct (Scanner scanner){
            System.out.println("Enter product id to delete : ");
           int productId = scanner.nextInt();
            scanner.nextLine();
            if (productMethod.getProductById(productId) != null) {
                productMethod.deleteProduct(productId);
                System.out.println("Product deleted successfully");
            }
            System.out.println(" no product deleted ");

        }
        public static void getProductById (Scanner scanner){
            System.out.println("Enter product id to retrieve product info  : ");
            int productId = scanner.nextInt();
            scanner.nextLine();
            Product product1 = productMethod.getProductById(productId);
            if (product1 == null) {
                System.out.println("no product found! ");
            } else {
                System.out.println(product1);
            }
        }

}