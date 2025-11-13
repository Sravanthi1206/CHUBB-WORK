import java.util.ArrayList;
import java.util.List;

class Hotel {
    String name;
    int totalRooms;
    int availableRooms;
    List<Integer> bookedRooms; // store booked room numbers

    Hotel(String name, int totalRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
        this.bookedRooms = new ArrayList<>();
    }

    boolean bookRoom() {
        if (availableRooms > 0) {
            int roomNumber = totalRooms - availableRooms + 1;
            bookedRooms.add(roomNumber);
            availableRooms--;
            return true;
        }
        return false;
    }

    boolean isFull() {
        return availableRooms == 0;
    }

    void displayAvailable() {
        System.out.println(name + " — Available Rooms: " + availableRooms);
    }

    void displayBookedRooms() {
        System.out.println(name + " — Booked Rooms: " + bookedRooms.size());
    }
}
