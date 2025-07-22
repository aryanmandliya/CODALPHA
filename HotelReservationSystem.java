import java.util.*;

class Room {
    String type;
    boolean isBooked;

    Room(String type) {
        this.type = type;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();

    static {
        // Adding 5 rooms per category
        for (int i = 0; i < 5; i++) rooms.add(new Room("Standard"));
        for (int i = 0; i < 5; i++) rooms.add(new Room("Deluxe"));
        for (int i = 0; i < 5; i++) rooms.add(new Room("Suite"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom(sc);
                case 3 -> cancelRoom(sc);
                case 4 -> {
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void viewRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            if (!r.isBooked) {
                System.out.println("Room " + (i + 1) + ": " + r.type);
            }
        }
    }

    static void bookRoom(Scanner sc) {
        System.out.print("Enter room type to book (Standard/Deluxe/Suite): ");
        String type = sc.nextLine();
        for (Room r : rooms) {
            if (r.type.equalsIgnoreCase(type) && !r.isBooked) {
                r.isBooked = true;
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("No available rooms of that type.");
    }

    static void cancelRoom(Scanner sc) {
        System.out.print("Enter room number to cancel: ");
        int num = sc.nextInt();
        if (num >= 1 && num <= rooms.size()) {
            Room r = rooms.get(num - 1);
            if (r.isBooked) {
                r.isBooked = false;
                System.out.println("Reservation cancelled.");
            } else {
                System.out.println("Room was not booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }
}

