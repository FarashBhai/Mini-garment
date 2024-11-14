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

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    List<Fabric> suppliedFabric = new ArrayList<>();

    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void addGarment(Garment garment) {
        garments.add(garment);
    }
     double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }
    
      void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }
}
class Inventory {

    List<Garment> garments = new ArrayList<>();

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id)); 
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null;
    }
}

public class OopLabTask3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        Garment g1 = new Garment("G001", "T-Shirt", "Cotton T-Shirt", "M", "Blue", 20.0, 50);
        Garment g2 = new Garment("G002", "Jeans", "Denim Jeans", "L", "Black", 40.0, 30);
        inventory.addGarment(g1);
        inventory.addGarment(g2);

        System.out.println("Welcome to Garment Management System");
        System.out.println("1. Calculate Discount Price");
        System.out.println("2. Find Garment by ID");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter discount percentage: ");
                double discountPercentage = scanner.nextDouble();
                double discountedPrice = g1.calculateDiscountPrice(discountPercentage);
                System.out.println("Discounted Price: " + discountedPrice);
                break;
            case 2:
                System.out.print("Enter garment ID: ");
                String garmentId = scanner.next();
                Garment foundGarment = inventory.findGarment(garmentId);
                if (foundGarment != null) {
                    System.out.println("Garment Found:");
                    System.out.println("Name: " + foundGarment.name);
                    System.out.println("Price: " + foundGarment.price);
                } else {
                    System.out.println("Garment not found");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
}


//Ended 
