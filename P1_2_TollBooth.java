import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bike = 0, car = 0, truck = 0;

        while (true) {

            System.out.print("Enter vehicle number (or done): ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.nextLine().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> -1;
            };

            if (toll == -1) {
                System.out.println("Invalid vehicle type!");
                continue;
            }

            totalToll += toll;

            switch (v.type()) {
                case "bike" -> bike++;
                case "car" -> car++;
                case "truck" -> truck++;
            }

            System.out.println("Toll: " + toll);
        }

        System.out.println("\nTotal Toll: " + totalToll);

        if (bike >= car && bike >= truck) {
            System.out.println("Highest Count: Bike");
        } else if (car >= bike && car >= truck) {
            System.out.println("Highest Count: Car");
        } else {
            System.out.println("Highest Count: Truck");
        }

        sc.close();
    }
}
