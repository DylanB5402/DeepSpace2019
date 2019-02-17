package com.team687.constants;



/**
 * Important constants
 */

public class Constants {    

    // Camera constants
    public final static double kHorizontalFOV = 55;
    public final static double kVerticalFOV = 42.65386; // calculated from focalLength
    public final static double kHorizontalPixels = 320;
    public final static double kVerticalPixels = 240; 
    public final static double kXFocalLength = 341.3307738; // focalLength = px_width / (2 * tan(FOV / 2))
    public final static double kYFocalLength = 332.3115843;

    // camera instrinsics
    public final static double kF_X = 341.3307738;
    public final static double kF_Y = 332.3115843;
    public final static double kG_X = 0;
    public final static double kG_Y = 0;

    // Physical camera constants
    public final static double kCameraHorizontalMountAngle = 5; 
    public final static double kCameraMountHeight = 38.50;
    public final static double kCameraHorizontalOffset = 5.5;
    
    public final static double kTargetHeight = 28.50; // inches
    
    public final static double kDriveRotationDeadband = 1.75;

    public final static double kJoystickDeadband = 0.02;
    public final static double kAngleTolerance = 0.1;
    public final static double kDistanceTolerance = 0.1; 
}
