import java.util.*;

public class HotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of hotels: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Hotel> hotels = new ArrayList<>();
        List<Hotel> bookedHotels = new ArrayList<>(); // store hotels that got bookings

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for Hotel " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter total number of rooms in " + name + ": ");
            int rooms = sc.nextInt();
            sc.nextLine();

            hotels.add(new Hotel(name, rooms));
        }

        while (!hotels.isEmpty()) {
            System.out.print("\nDo you want to book a room? (yes/no): ");
            String choice = sc.next().toLowerCase();
            sc.nextLine();

            if (choice.equals("no")) {
                break;
            }

            System.out.println("\nAvailable hotels:");
            for (int i = 0; i < hotels.size(); i++) {
                System.out.print((i + 1) + ". ");
                hotels.get(i).displayAvailable();
            }

            System.out.print("\nEnter hotel number to book (1-" + hotels.size() + "): ");
            int hotelNum = sc.nextInt();
            sc.nextLine();

            if (hotelNum < 1 || hotelNum > hotels.size()) {
                System.out.println("Invalid hotel number. Try again.");
                continue;
            }

            Hotel selectedHotel = hotels.get(hotelNum - 1);

            if (selectedHotel.bookRoom()) {
                System.out.println("Room booked successfully at " + selectedHotel.name + ".");
                if (!bookedHotels.contains(selectedHotel)) {
                    bookedHotels.add(selectedHotel);
                }
            }

            // Remove hotel if fully booked
            if (selectedHotel.isFull()) {
                System.out.println(selectedHotel.name + " is now fully booked and removed from the list.");
                hotels.remove(selectedHotel);
            }

            if (hotels.isEmpty()) {
                System.out.println("All hotels are fully booked.");
            }
        }

        // Show all booked hotels and number of booked rooms before ending
        System.out.println("\n=== Booking Summary ===");
        for (Hotel h : bookedHotels) {
            h.displayBookedRooms();
        }

        System.out.println("Booking process ended.");
        sc.close();
    }
}
