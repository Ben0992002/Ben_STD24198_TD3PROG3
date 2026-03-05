package org.example.repository;
import org.example.connection.DatabaseConnection;
import org.example.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    private DatabaseConnection db = new DatabaseConnection();

    // Trouver tous les liens Ingrédients pour un plat donné
    public List<DishIngredient> findIngredientsByDishId(int dishId) {
        List<DishIngredient> list = new ArrayList<>();
        String sql = "SELECT * FROM dish_ingredient WHERE id_dish = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dishId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DishIngredient(
                        rs.getInt("id_dish"),
                        rs.getInt("id_ingredient"),
                        rs.getDouble("quantity_required")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // Trouver un ingrédient par son ID pour avoir son prix
    public Ingredient findIngredientById(int id) {
        String sql = "SELECT * FROM ingredient WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Utilisation de "unit_price" (nom exact dans ton schema.sql)
                return new Ingredient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("unit_price")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    // Ajout de findDishById pour gérer le prix de vente NULL (Page 3 du PDF)
    public Dish findDishById(int id) {
        String sql = "SELECT * FROM dish WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // On utilise getObject pour que si le prix est NULL en DB, il soit null en Java
                Double unitPrice = (rs.getObject("unit_price") != null) ? rs.getDouble("unit_price") : null;
                return new Dish(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        unitPrice
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}