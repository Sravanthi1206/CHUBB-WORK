package service;

import exceptions.*;
import model.*;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryManager {

    private Map<String, DeliveryAgent> agents = new HashMap<>();
    private Queue<DeliveryPackage> packageQueue = new PriorityQueue<>(new PriorityComparator());
    private Set<String> validRoutes = new HashSet<>();

    private static final int MAX_PACKAGES_PER_AGENT = 3;

    public void addAgent(DeliveryAgent agent) throws DuplicateEntryException {
        if (agents.containsKey(agent.getName()))
            throw new DuplicateEntryException("Agent " + agent.getName() + " already exists.");
        agents.put(agent.getName(), agent);
    }

    public void addRoute(String source, String destination) {
        validRoutes.add(source + "-" + destination);
    }

    public void addPackage(DeliveryPackage p) throws InvalidPackageException {
        if (p.getPriority() <= 0)
            throw new InvalidPackageException("Package " + p.getPackageId() + " has invalid priority.");
        packageQueue.add(p);
    }

    public void assignPackages() throws AgentNotAvailableException, OverloadException, RouteUnavailableException {
        while (!packageQueue.isEmpty()) {
            DeliveryPackage p = packageQueue.poll();
            String destination = p.getDestinationCity();

            if (!validRoutes.contains("Warehouse-" + destination))
                throw new RouteUnavailableException("No route found to " + destination);

            List<DeliveryAgent> availableAgents = agents.values().stream()
                    .filter(a -> a.getCity().equalsIgnoreCase(destination))
                    .sorted(Comparator.comparingInt(a -> a.getAssignedPackages().size()))
                    .collect(Collectors.toList());

            if (availableAgents.isEmpty())
                throw new AgentNotAvailableException("No agent available in " + destination);

            DeliveryAgent agent = availableAgents.get(0);

            if (agent.getAssignedPackages().size() >= MAX_PACKAGES_PER_AGENT)
                throw new OverloadException(agent.getName() + " already has max packages.");

            agent.assignPackage(p);
            System.out.println("Assigned " + p + " to " + agent.getName());
        }
    }

    public void showAllAgents() {
        agents.values().forEach(System.out::println);
    }
}
