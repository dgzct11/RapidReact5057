// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.functional;

import frc.robot.functional.trajectory.Position;

/** Add your docs here. */
public class BoundingBox {
    public double[] A;
    public double[] B;
    public double[] C;
    public double[] D;
    public BoundingBox(double[] a, double[] b, double[] c, double[] d){
        A = a.clone();
        B = b.clone();
        C = c.clone();
        D = d.clone();
    }
    public BoundingBox(Position a, Position b, Position c, Position d){
        A = a.point;
        B = b.point;
        C = c.point;
        D = d.point;
    }
}
