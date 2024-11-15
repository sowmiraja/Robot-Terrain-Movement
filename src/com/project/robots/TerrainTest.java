package com.project.robots;

import static org.junit.Assert.*;

import org.junit.Test;

class TerrainTest {

	@Test
    public void testRobotCreation() {
        Terrain terrain = new Terrain(5, 5);
        BasicRobot robot = new BasicRobot(1);
        terrain.addRobot(robot);
        assertEquals("(0, 0)", terrain.getRobotPosition(1));
    }

    @Test
    public void testRobotMovement() {
        Terrain terrain = new Terrain(5, 5);
        BasicRobot robot = new BasicRobot(1);
        terrain.addRobot(robot);
        terrain.moveRobot(1, "E2"); // Move 2 steps east
        assertEquals("(2, 0)", terrain.getRobotPosition(1));
    }

    @Test
    public void testCollision() {
        Terrain terrain = new Terrain(5, 5);
        BasicRobot robot1 = new BasicRobot(1);
        BasicRobot robot2 = new BasicRobot(2);
        terrain.addRobot(robot1);
        terrain.addRobot(robot2);

        terrain.moveRobot(1, "E3"); // Robot1 moves to (3, 0)
        terrain.moveRobot(2, "E4"); // Robot2 tries to move to (4, 0), stops at (2, 0)
        
        assertEquals("(3, 0)", terrain.getRobotPosition(1));
        assertEquals("(2, 0)", terrain.getRobotPosition(2)); // Collision detected
    }

}
