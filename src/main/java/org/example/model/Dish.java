package org.example.model;

public class Dish {
    private int id;
    private String name;
    private String type; // Correspond à l'ENUM (START, MAIN, DESSERT)
    private Double unitPrice; // PRIX DE VENTE (Utilise Double car peut être NULL)

    public Dish(int id, String name, String type, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public Double getUnitPrice() { return unitPrice; }

    // Setters
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
}
