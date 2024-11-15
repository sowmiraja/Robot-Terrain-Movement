package com.project.robots;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up the terrain dimensions
        System.out.print("Enter the number of rows for the terrain: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the terrain: ");
        int cols = scanner.nextInt();
        Terrain terrain = new Terrain(rows, cols);

        // Adding robots to the terrain
        System.out.print("Enter the number of robots to add: ");
        int numRobots = scanner.nextInt();
        
        for (int i = 1; i <= numRobots; i++) {
            BasicRobot robot = new BasicRobot(i);
            terrain.addRobot(robot);
            System.out.println("Robot " + i + " added at starting position (0, 0).");
        }

        // Process movement commands
        while (true) {
            System.out.print("Enter robot ID to move (or 'exit' to quit): ");
            String robotIdInput = scanner.next();

            if (robotIdInput.equalsIgnoreCase("exit")) {
                break;
            }

            int robotId;
            try {
                robotId = Integer.parseInt(robotIdInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid robot ID. Please enter a number.");
                continue;
            }

            if (terrain.getRobot(robotId) == null) {
                System.out.println("No robot found with ID " + robotId);
                continue;
            }

            System.out.print("Enter movement command (e.g., N4, E2): ");
            String command = scanner.next();

            try {
                terrain.moveRobot(robotId, command);
                System.out.println("Robot " + robotId + " Position: " + terrain.getRobotPosition(robotId));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Program exited.");
    }
}


