package org.example;
import org.example.repository.DataRetriever;
import org.example.model.*;
import java.util.List;

public class Main {
    private static DataRetriever retriever = new DataRetriever();

    public static void main(String[] args) {
        // Test pour la Salade Fraîche (ID 1)
        try {
            double cost = getDishCost(1);
            System.out.println("Coût de la Salade : " + cost);

            double margin = getGrossMargin(1, 2000.0);
            System.out.println("Marge de la Salade : " + margin);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // MÉTHODE TD3 : On calcule tout dans une boucle Java
    public static Double getDishCost(int dishId) {
        double total = 0.0;
        List<DishIngredient> components = retriever.findIngredientsByDishId(dishId);

        for (DishIngredient di : components) {
            Ingredient ing = retriever.findIngredientById(di.getIdIngredient());
            if (ing != null) {
                // Astuce : Quantité * Prix Unitaire
                total += (di.getQuantityRequired() * ing.getUnitPrice());
            }
        }
        return total;
    }

    public static Double getGrossMargin(int dishId, Double sellingPrice) {
        if (sellingPrice == null) {
            throw new RuntimeException("EXCEPTION : Le prix de vente est absent pour le plat " + dishId);
        }
        return sellingPrice - getDishCost(dishId);
    }
}