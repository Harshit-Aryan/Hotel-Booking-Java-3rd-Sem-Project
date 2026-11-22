
import java.util.*;

class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean available;

    Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = true;
    }

    void displayRoom() {
        System.out.println(
            roomNumber + "\t" + roomType + "\tRs." +
            price + "\t" + (available ? "Available" : "Booked")
        );
    }
}

class Booking {
    String bookingId;
    String customerName;
    int roomNumber;
    int nights;
    double totalAmount;

    Booking(String bookingId, String customerName,
            int roomNumber, int nights, double totalAmount) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalAmount = totalAmount;
    }

    void displayBooking() {
        System.out.println("\nBooking ID: " + bookingId);
        System.out.println("Customer: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Nights: " + nights);
        System.out.println("Total Amount: Rs." + totalAmount);
    }
}

public class HotelBookingSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static HashMap<String, Booking> bookings = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static int bookingCounter = 1001;

    public static void main(String[] args) {

        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Double", 2500));
        rooms.add(new Room(103, "Deluxe", 4000));
        rooms.add(new Room(104, "Single", 1800));
        rooms.add(new Room(105, "Suite", 6000));

        int choice;

        do {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search Rooms");
            System.out.println("3. Sort Rooms by Price");
            System.out.println("4. Book a Room");
            System.out.println("5. Search Booking");
            System.out.println("6. Cancel Booking");
            System.out.println("7. View All Bookings");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    searchRooms();
                    break;
                case 3:
                    sortRooms();
                    break;
                case 4:
                    bookRoom();
                    break;
                case 5:
                    searchBooking();
                    break;
                case 6:
                    cancelBooking();
                    break;
                case 7:
                    viewBookings();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static void viewRooms() {
        System.out.println("\nRoom No.\tType\tPrice\tStatus");

        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    static void searchRooms() {
        System.out.print("Enter room type: ");
        String type = sc.nextLine();

        boolean found = false;

        for (Room room : rooms) {
            if (room.roomType.equalsIgnoreCase(type) && room.available) {
                room.displayRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available rooms found!");
        }
    }

    static void sortRooms() {
        rooms.sort(
            Comparator.comparingDouble(room -> room.price)
        );

        System.out.println("\nRooms sorted by price:");
        viewRooms();
    }

    static void bookRoom() {
        viewRooms();

        System.out.print("\nEnter room number: ");
        int number = sc.nextInt();
        sc.nextLine();

        Room selectedRoom = null;

        for (Room room : rooms) {
            if (room.roomNumber == number && room.available) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not available!");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();
        sc.nextLine();

        if (nights <= 0) {
            System.out.println("Invalid number of nights!");
            return;
        }

        double total = selectedRoom.price * nights;
        String id = "HB" + bookingCounter++;

        Booking booking = new Booking(
            id, name, number, nights, total
        );

        bookings.put(id, booking);
        selectedRoom.available = false;

        System.out.println("\nRoom booked successfully!");
        System.out.println("Booking ID: " + id);
        System.out.println("Total Amount: Rs." + total);
    }

    static void searchBooking() {
        System.out.print("Enter Booking ID: ");
        String id = sc.nextLine().toUpperCase();

        Booking booking = bookings.get(id);

        if (booking != null) {
            booking.displayBooking();
        } else {
            System.out.println("Booking not found!");
        }
    }

    static void cancelBooking() {
        System.out.print("Enter Booking ID: ");
        String id = sc.nextLine().toUpperCase();

        Booking booking = bookings.remove(id);

        if (booking != null) {
            for (Room room : rooms) {
                if (room.roomNumber == booking.roomNumber) {
                    room.available = true;
                    break;
                }
            }

            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Booking not found!");
        }
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        for (Booking booking : bookings.values()) {
            booking.displayBooking();
            System.out.println("-------------------------");
        }
    }
}
