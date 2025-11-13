package service;

import model.DeliveryPackage;
import java.util.Comparator;

public class PriorityComparator implements Comparator<DeliveryPackage> {
    @Override
    public int compare(DeliveryPackage p1, DeliveryPackage p2) {
        return Integer.compare(p2.getPriority(), p1.getPriority());
    }
}
