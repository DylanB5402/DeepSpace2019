package com.team687.constants;

import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoConstants {

    // pathfinder constants
    public static final double dt = 0.02;
    // max speed and accel
    public static final double kAcceleration = 13;
    public static final double kCruiseVelocity = 13;
    // Jerk is set to a high number since jerk barely matters, poofs don't jerk anymore
    public static final double kJerk = 100;
    
    private static double kRobotLength = 0;
    private static double kRobotWidth = 0;
    private static double kTapeLength = 18;

    private static double kRightRobotOriginX = 0;
    private static double kRightRobotOriginY = 0;
    private static double kAllianceWallToFirstCargoShipTapeX = 0;
    private static double kRightWallToCargoShip = 0;
    private static double kAllianceWallToTape2X = 0;
    private static double kAllianceWallToTape3X = 0;

}