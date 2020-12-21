package by.aginskiy.figure.model.entity;

public class QuadrangleCondition {

    private double square;
    private double perimeter;

    public QuadrangleCondition(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleCondition{");
        sb.append("square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
