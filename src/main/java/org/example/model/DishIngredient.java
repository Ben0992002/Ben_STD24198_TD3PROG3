package org.example.model;

public class DishIngredient {
    private int idDish;
    private int idIngredient;
    private double quantityRequired;

    public DishIngredient(int idDish, int idIngredient, double quantityRequired) {
        this.idDish = idDish;
        this.idIngredient = idIngredient;
        this.quantityRequired = quantityRequired;
    }

    // Getters
    public int getIdIngredient() { return idIngredient; }
    public double getQuantityRequired() { return quantityRequired; }
}
