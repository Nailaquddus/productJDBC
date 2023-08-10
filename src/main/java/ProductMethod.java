import java.util.List;

public interface ProductMethod {

    void addProduct(Product product); // to add a product;
    void updateProduct(Product product);  // to update product details;

    void deleteProduct(int productId);  // to delete a product

    Product getProductById( int productId); // get product by their id;

    List<Product> getAllProducts(); // get all products;


}
