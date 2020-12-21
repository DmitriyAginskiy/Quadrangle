package by.aginskiy.figure.model.service;

import by.aginskiy.figure.model.entity.CustomPoint;

import java.util.List;

public interface PointService {

    double calculateDistanceBetweenPoints(CustomPoint point1, CustomPoint point2);

    List<Double> calculateVectorCoordinates(CustomPoint point1, CustomPoint point2);

    boolean isThreePointsOnLine(CustomPoint p1, CustomPoint p2, CustomPoint p3);
}
