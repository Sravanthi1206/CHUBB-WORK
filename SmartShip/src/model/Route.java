package model;

public class Route {
    private String source;
    private String destination;

    public Route(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() { return source; }
    public String getDestination() { return destination; }

    @Override
    public String toString() {
        return source + " → " + destination;
    }
}
