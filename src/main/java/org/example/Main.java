package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rideType = "";
        double getDistance = 0;
        double getDuration = 0;
        int option;
        String fareType;
        double baseFare = 0;
        double surcharge = 0;
        double distanceCost = 0;
        double durationCost = 0;
        double totalFare = 0;

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
                    System.out.println("\n=== Book a Ride ===");
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
                    System.out.println("\n=== Calculate Fare ===");
                    if(rideType.isEmpty()) {
                        System.out.println("Please book a ride first.");
                        break;
                    }
                    do {
                        System.out.print("Enter Fare Type (normal/night): ");
                        fareType = scanner.nextLine().toLowerCase();

                        // Check for eligibility of input for ride type
                        if (fareType.isEmpty()) {
                            System.out.println("Fare type must not be empty.");
                        }
                        if (!fareType.equals("normal") && !fareType.equals("night")) {
                            System.out.println("Ride type must only be 'normal' or 'night'.");
                        }
                    } while (!fareType.equals("normal") && !fareType.equals("night"));

                    // Fare Strategies and Ride Type strategies to compute fare
                    totalFare = baseFare + distanceCost + durationCost + surcharge;

                    System.out.printf("Base Fare: %.2f%n", baseFare);
                    System.out.printf("Distance Cost: %.2f%n", distanceCost);
                    System.out.printf("Duration Cost: %.2f%n", durationCost);
                    System.out.printf("Surcharge (Night): %.2f%n", surcharge);
                    System.out.printf("Total Fare: %.2f%n", totalFare);
                    break;
                }
                case 3: {
                    if (rideType.isEmpty()) {
                        System.out.println("No rides booked yet.");
                        break;
                    }
                    System.out.println("\n--- Receipt ---");
                    System.out.println("Ride Type: " + rideType);
                    System.out.printf("Distance: %.0f km%n", getDistance);
                    System.out.printf("Duration: %.0f mins%n", getDuration);
                    System.out.printf("Total Fare: %.2f%n", totalFare);
                    break;
                }
                case 4: {
                    System.out.println("=== Thank you for riding with us! ===");
                    break;
                }
            }
        } while (option != 4);
    }
}