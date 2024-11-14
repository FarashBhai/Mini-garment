package oop.lab.task.pkg3;‍
‍
import java.util.List;‍
import java.util.ArrayList;‍
import java.util.Date;‍
‍
class Garment {‍
‍
    public String id;‍
    public String name;‍
    public String description;‍
    public String size;‍
    public String color;‍
    public double price;‍
    public int stockQuantity;‍
‍
    void updateStock(int quantity) {‍
        this.stockQuantity = quantity;‍
    }
    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return price - discount;
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}

