package Entities;

import Entities.Descriptional.DimensionalPoint;
import Entities.Descriptional.Location;

public class Camera {

    private Location location;
    private double depth;
    private int[] dimensions;

    public Camera(Location location, double depth, int[] dimensions) {
        this.location = location;
        this.depth = depth;
        this.dimensions = dimensions;
    }

    public double getDepth() {
        return depth;
    }

    public DimensionalPoint getLocation() {
        return this.location.getLocation();
    }
}
