package com.project.robots;

import java.util.HashMap;
import java.util.Map;

//Terrain class encapsulates the environment and manages multiple robots
class Terrain {
 private final int rows;
 private final int cols;
 private final Map<Integer, Robot> robots;

 public Terrain(int rows, int cols) {
     this.rows = rows;
     this.cols = cols;
     this.robots = new HashMap<>();
 }

 // Encapsulated method to add a robot to the terrain
 public void addRobot(Robot robot) {
     if (!robots.containsKey(robot.getRobotId())) {
         robots.put(robot.getRobotId(), robot);
     } else {
         throw new IllegalArgumentException("Robot with ID " + robot.getRobotId() + " already exists.");
     }
 }

 public Robot getRobot(int robotId) {
     return robots.get(robotId);
 }

 // Helper method to check grid boundaries
 public boolean isWithinBounds(int x, int y) {
     return x >= 0 && x < cols && y >= 0 && y < rows;
 }

 // Check if a cell is occupied by any robot
 public boolean isOccupied(int x, int y) {
     for (Robot robot : robots.values()) {
         if (robot.getX() == x && robot.getY() == y) {
             return true;
         }
     }
     return false;
 }

 // Move a specific robot based on its ID and command
 public void moveRobot(int robotId, String command) {
     Robot robot = getRobot(robotId);
     if (robot != null) {
         robot.move(command, this);
     } else {
         throw new IllegalArgumentException("No robot found with ID " + robotId);
     }
 }

 // Return the position of a specific robot
 public String getRobotPosition(int robotId) {
     Robot robot = getRobot(robotId);
     if (robot != null) {
         return "(" + robot.getX() + ", " + robot.getY() + ")";
     } else {
         throw new IllegalArgumentException("No robot found with ID " + robotId);
     }
 }
}
