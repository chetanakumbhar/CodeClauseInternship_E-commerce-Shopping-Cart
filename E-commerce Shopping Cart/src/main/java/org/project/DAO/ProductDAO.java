package org.project.DAO;

import org.project.Bean.Product;
import org.project.Util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbUtil.getDbConnection()) {
            String query = "SELECT * FROM products";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
