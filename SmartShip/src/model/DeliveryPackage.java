package model;

public class DeliveryPackage {
    private String packageId;
    private String destinationCity;
    private int priority;

    public DeliveryPackage(String packageId, String destinationCity, int priority) {
        this.packageId = packageId;
        this.destinationCity = destinationCity;
        this.priority = priority;
    }

    public String getPackageId() { return packageId; }
    public String getDestinationCity() { return destinationCity; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "DeliveryPackage[" + packageId + ", " + destinationCity + ", Priority=" + priority + "]";
    }
}
