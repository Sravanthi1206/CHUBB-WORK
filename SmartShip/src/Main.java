import model.*;
import service.*;
import exceptions.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeliveryManager manager = new DeliveryManager();

        try {
            manager.addAgent(new DeliveryAgent("Amit", "Delhi"));
            manager.addAgent(new DeliveryAgent("Riya", "Mumbai"));
            manager.addAgent(new DeliveryAgent("Karan", "Delhi"));

            manager.addRoute("Warehouse", "Delhi");
            manager.addRoute("Warehouse", "Mumbai");

            manager.addPackage(new DeliveryPackage("PKG1", "Delhi", 3));
            manager.addPackage(new DeliveryPackage("PKG2", "Mumbai", 1));
            manager.addPackage(new DeliveryPackage("PKG3", "Delhi", 2));

            manager.assignPackages();
            manager.showAllAgents();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
