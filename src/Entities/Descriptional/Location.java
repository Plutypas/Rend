package Entities.Descriptional;

public class Location {

    private DimensionalPoint location;

    public Location(DimensionalPoint dimensionalPoint) {
        this.location = dimensionalPoint;
    }
    // Add Yaw, Pitch, Roll after initial POC.

    public DimensionalPoint getLocation() {
        return location;
    }

    public void setLocation(double x, double y, double z) {
        this.location = new DimensionalPoint(x, y, z);
    }
}
