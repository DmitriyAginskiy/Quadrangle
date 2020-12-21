package by.aginskiy.figure.model.entity;

public class CustomPoint {

    private double positionX;
    private double positionY;

    public CustomPoint() {

    }

    public CustomPoint(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomPoint point = (CustomPoint) o;

        if (Double.compare(point.positionX, positionX) != 0) return false;
        return Double.compare(point.positionY, positionY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(positionX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(positionY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
