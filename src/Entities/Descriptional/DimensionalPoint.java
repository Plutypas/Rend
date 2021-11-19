package Entities.Descriptional;

public class DimensionalPoint {

    private double x;
    private double y;
    private double z;

    public DimensionalPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public DimensionalPoint subtract(DimensionalPoint subtractPoint) {
        DimensionalPoint returnPoint = new DimensionalPoint(0,0,0);
        returnPoint.setX(this.getX()-subtractPoint.getX());
        returnPoint.setY(this.getY()-subtractPoint.getY());
        returnPoint.setZ(this.getZ()-subtractPoint.getZ());
        return returnPoint;
    }

    public DimensionalPoint add(DimensionalPoint addPoint) {
        DimensionalPoint returnPoint = new DimensionalPoint(0,0,0);
        returnPoint.setX(this.getX()+addPoint.getX());
        returnPoint.setY(this.getY()+addPoint.getY());
        returnPoint.setZ(this.getZ()+addPoint.getZ());
        return returnPoint;
    }
}
