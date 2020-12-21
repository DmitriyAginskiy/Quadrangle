package by.aginskiy.figure.model.service.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.service.PointService;

import java.util.ArrayList;
import java.util.List;

public class PointServiceImpl implements PointService {

    public double calculateDistanceBetweenPoints(CustomPoint point1, CustomPoint point2) {
        double result = Math.pow(point1.getPositionX() - point2.getPositionX(), 2)
                        + Math.pow(point1.getPositionY() - point2.getPositionY(), 2);
        return Math.sqrt(result);
    }

    public List<Double> calculateVectorCoordinates(CustomPoint point1, CustomPoint point2) {
        ArrayList<Double> coordinates = new ArrayList<>(2);
        coordinates.add(point2.getPositionX() - point1.getPositionX());
        coordinates.add(point2.getPositionY() - point1.getPositionY());
        return coordinates;

    }

    public boolean isThreePointsOnLine(CustomPoint p1, CustomPoint p2, CustomPoint p3) {
        return ((p1.getPositionY() - p2.getPositionY()) * p3.getPositionX()
                + (p2.getPositionX() - p1.getPositionX()) * p3.getPositionY()
                + (p1.getPositionX() * p2.getPositionY() - p2.getPositionX()
                * p1.getPositionY()) == 0.0);
    }
}
