package org.example;

import java.util.*;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rideType;
        double getDistance;
        double getDuration;
        int option;

        do {// UI for selecting options
            System.out.println("\n=== Ride Booking System ===");
            System.out.println("1. Book a Ride");
            System.out.println("2. Calculate Fare");
            System.out.println("3. View Receipt");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("=== Book a Ride ===");
                    do {
                        System.out.print("Enter Ride Type (standard/premium): ");
                        rideType = scanner.nextLine().toLowerCase();

                        // Check for eligibility of input for ride type
                        if (rideType.isEmpty()) {
                            System.out.println("Ride type must not be empty.");
                        }
                        if (!rideType.equals("standard") && !rideType.equals("premium")) {
                            System.out.println("Ride type must only be 'standard' or 'premium'.");
                        }
                    } while (!rideType.equals("standard") && !rideType.equals("premium"));

                    while (true) {
                        System.out.print("Enter Distance (km): ");
                        // Ensures that input is a number
                        try {
                            getDistance = scanner.nextDouble();
                            // Ensures that distance is greater than 0
                            if (getDistance <= 0) {
                                System.out.println("Invalid input. Distance must be greater than 0.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Distance must be a number.");
                            scanner.next();
                        }
                    }

                    while (true) {
                        System.out.print("Enter Duration (mins): ");
                        // Ensures that input is a number
                        try {
                            getDuration = scanner.nextDouble();
                            // Ensures that distance is greater than 0
                            if (getDuration <= 0) {
                                System.out.println("Invalid input. Duration must be greater than 0.");
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Duration must be a number.");
                            scanner.next();
                        }
                    }
                    System.out.println("Ride booked successfully!");
                    break;
                }
                case 2: {

                }
            }
        } while (option != 4);
    }
}