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
