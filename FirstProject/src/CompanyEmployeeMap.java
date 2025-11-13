import java.util.*;

public class CompanyEmployeeMap {

    public static void main(String[] args) {

        // Step 1: Create a Map where keys = company names, values = list of employee names
        Map<String, List<String>> companyMap = new HashMap<>();

        // Step 2: Add 5 companies with some employees
        companyMap.put("TCS", new ArrayList<>(Arrays.asList("Amit", "Sonia", "Ravi")));
        companyMap.put("Infosys", new ArrayList<>(Arrays.asList("Neha", "Arjun", "Priya")));
        companyMap.put("Wipro", new ArrayList<>(Arrays.asList("Vikram", "Simran", "Raj")));
        companyMap.put("HCL", new ArrayList<>(Arrays.asList("Shreya", "Karan", "Pooja")));
        companyMap.put("IBM", new ArrayList<>(Arrays.asList("Anil", "Geeta", "Ramesh")));

        // Step 3: Print all companies and employees
        System.out.println("Company -> Employees:");
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Step 4: Check if "Cognizant" exists, if not add it
        companyMap.putIfAbsent("Cognizant", new ArrayList<>(Arrays.asList("John", "Ram", "Lisa")));

        // Step 5: Check if "Ram" works in Cognizant
        List<String> cognizantEmployees = companyMap.get("Cognizant");
        if (cognizantEmployees != null) {
            if (cognizantEmployees.contains("Ram")) {
                System.out.println("\nRam is working in Cognizant");
            } else {
                System.out.println("\nRam is not found in Cognizant");
            }
        } else {
            System.out.println("\nCognizant company not found");
        }

        // Step 6: Print updated map
        System.out.println("\nUpdated Company -> Employees:");
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
