package org.project.DAO;

import org.project.Util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {
    public void addProductToCart(int productId) {
        try (Connection connection = DbUtil.getDbConnection()) {
            String query = "INSERT INTO cart_items (product_id) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            statement.executeUpdate();
            System.out.println("Product added to the cart.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
