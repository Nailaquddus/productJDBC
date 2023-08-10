import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMethodImpl implements ProductMethod  {
private Connection connect;

    public ProductMethodImpl(Connection connect) {
        this.connect = connect;
    }

    @Override
    public void addProduct(Product product) {
        try (PreparedStatement statement = connect.prepareStatement("INSERT INTO product(name, brand, year, price) VALUES (?,?,?,?)");) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getBrandMake());
            statement.setInt(3, product.getYear());
            statement.setDouble(4, product.getPrice());

            //Execute the SQL Statement
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
    }




    }


    @Override
    public void updateProduct(Product product) {
        try (PreparedStatement statement = connect.prepareStatement("UPDATE product SET name=?, brand=?, year=?, price=? WHERE productId=?")) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getBrandMake());
            statement.setInt(3, product.getYear());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getProductId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try (PreparedStatement statement = connect.prepareStatement("DELETE FROM product WHERE productId=?")) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int productId) {
        Product product= null;
        try(PreparedStatement statement= connect.prepareStatement(

                "SELECT * FROM product WHERE  productId=?"))
        {

            statement.setInt(1,productId);
            ResultSet rs = statement.executeQuery();{


            while(rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int year = rs.getInt("year");
                double price = rs.getDouble("price");
                product = new Product(id, name, brand, year, price);
            }
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products=new ArrayList<>();
        try(PreparedStatement statement= connect.prepareStatement("SELECT * FROM product ");
            ResultSet rs= statement.executeQuery()) {

          //  Product product = null;
            while (rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("Name");
                String brand = rs.getString("Brand");
                int year = rs.getInt("Year");
                double price = rs.getDouble("price");

                Product product = new Product(id, name, brand, year, price);

                products.add(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

            return products;
    }
}
