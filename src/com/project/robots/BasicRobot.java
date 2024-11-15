package com.project.robots;

//Specialized class of Robot with additional behaviors if needed
class BasicRobot extends Robot
{
 public BasicRobot(int robotId) 
 {
     super(robotId);
 }

 @Override
 public void move(String command, Terrain terrain) 
 {
     System.out.println("Basic Robot " + getRobotId() + " moving with command: " + command);
     super.move(command, terrain);
 }
}
