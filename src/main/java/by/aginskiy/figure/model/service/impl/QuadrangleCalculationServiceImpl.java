package by.aginskiy.figure.model.service.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.model.service.QuadrangleCalculationService;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCalculationServiceImpl implements QuadrangleCalculationService {

    private static PointServiceImpl pointService = new PointServiceImpl();

    public List<Double> calculateSidesLengths(Quadrangle quadrangle) {
        final int sidesCount = 4;
        ArrayList<Double> sidesLengths = new ArrayList<>();
        CustomPoint p1 = null;
        CustomPoint p2 = null;
        for(int i = 0; i < sidesCount - 1; i++) {
            p1 = quadrangle.getPoint(i);
            p2 = quadrangle.getPoint(i + 1);
            sidesLengths.add(pointService.calculateDistanceBetweenPoints(p1, p2));
        }
        p1 = quadrangle.getPoint(3);
        p2 = quadrangle.getPoint(0);
        sidesLengths.add(pointService.calculateDistanceBetweenPoints(p1, p2));
        return sidesLengths;
    }

    public List<Double> calculateDiagonals(Quadrangle quadrangle) {
        ArrayList<Double> diagonals = new ArrayList<>();
        diagonals.add(pointService.calculateDistanceBetweenPoints(quadrangle.getPoint(0),
                quadrangle.getPoint(2)));
        diagonals.add(pointService.calculateDistanceBetweenPoints(quadrangle.getPoint(1),
                quadrangle.getPoint(3)));
        return diagonals;
    }

    public double calculateAngleCosBetweenSides(List<Double> firstVector, List<Double> secondVector) {
        double scalarProduct = firstVector.get(0) * secondVector.get(0) + firstVector.get(1) * secondVector.get(1);
        double firstVectorAbs = Math.sqrt(firstVector.get(0) * firstVector.get(0) + firstVector.get(1) * firstVector.get(1));
        double secondVectorAbs = Math.sqrt(secondVector.get(0) * secondVector.get(0) + secondVector.get(1) * secondVector.get(1));
        double angleCos = scalarProduct / (firstVectorAbs * secondVectorAbs);
        return angleCos;
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        List<Double> sidesLengths = calculateSidesLengths(quadrangle);
        double perimeter = 0;
        for(int i = 0; i < sidesLengths.size(); i++) {
            perimeter += sidesLengths.get(i);
        }
        return perimeter;
    }

    public double calculateArea(Quadrangle quadrangle) {
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        List<Double> diagonalLengths = calculateDiagonals(quadrangle);
        List<Double> firstDiagonal = pointService.calculateVectorCoordinates(quadrangle.getPoint(0),
                quadrangle.getPoint(2));
        List<Double> secondDiagonal = pointService.calculateVectorCoordinates(quadrangle.getPoint(1),
                quadrangle.getPoint(3));
        double sinBetweenDiagonals = Math.sqrt(1 - Math.pow(calculateAngleCosBetweenSides(firstDiagonal, secondDiagonal), 2));
        return 0.5 * diagonalLengths.get(0) * diagonalLengths.get(1) * sinBetweenDiagonals;
    }
}
