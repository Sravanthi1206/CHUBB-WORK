package model;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent {
    private String name;
    private String city;
    private List<DeliveryPackage> assignedPackages;

    public DeliveryAgent(String name, String city) {
        this.name = name;
        this.city = city;
        this.assignedPackages = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public List<DeliveryPackage> getAssignedPackages() { return assignedPackages; }

    public void assignPackage(DeliveryPackage p) {
        assignedPackages.add(p);
    }

    @Override
    public String toString() {
        return name + " (" + city + ") - Packages: " + assignedPackages.size();
    }
}
