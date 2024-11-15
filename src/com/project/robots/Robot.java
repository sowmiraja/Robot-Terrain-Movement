package com.project.robots;

	import java.util.HashMap;
	import java.util.Map;

	// Abstract base class Robot encapsulates core behavior of robots
	abstract class Robot {
	    private final int robotId;
	    private int x;
	    private int y;

	    public Robot(int robotId) {
	        this.robotId = robotId;
	        this.x = 0;
	        this.y = 0;
	    }

	    public int getRobotId() {
	        return robotId;
	    }

	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	    // Template method for moving the robot
	    public void move(String command, Terrain terrain) {
	        String direction = command.substring(0, 1);
	        int steps = Integer.parseInt(command.substring(1));
	        executeMovement(direction, steps, terrain);
	    }

	    // Encapsulated method for executing movement logic
	    protected void executeMovement(String direction, int steps, Terrain terrain) {
	        int dx = 0, dy = 0;
	        switch (direction) {
	            case "N": dy = -1; break;
	            case "S": dy = 1; break;
	            case "E": dx = 1; break;
	            case "W": dx = -1; break;
	        }

	        for (int i = 0; i < steps; i++) {
	            int newX = this.x + dx;
	            int newY = this.y + dy;
	            if (terrain.isWithinBounds(newX, newY) && !terrain.isOccupied(newX, newY)) {
	                this.x = newX;
	                this.y = newY;
	            } else {
	                break;
	            }
	        }
	    }
	}



