package org.example.model;

public class Ingredient {
    private int id;
    private String name;
    private double unitPrice; // Le prix par unité (ex: 5000.0 pour le poulet)

    // Constructeur : pour créer l'objet quand on sort la ligne de la DB
    public Ingredient(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Getters : indispensables pour que le Main puisse faire les calculs
    public int getId() { return id; }
    public String getName() { return name; }
    public double getUnitPrice() { return unitPrice; }

    // Setters : si tu as besoin de modifier l'objet en Java
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}