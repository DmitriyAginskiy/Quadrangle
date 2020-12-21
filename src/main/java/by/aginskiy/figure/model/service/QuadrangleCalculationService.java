package by.aginskiy.figure.model.service;

import by.aginskiy.figure.model.entity.Quadrangle;

import java.util.List;

public interface QuadrangleCalculationService {

    List<Double> calculateSidesLengths(Quadrangle quadrangle);

    List<Double> calculateDiagonals(Quadrangle quadrangle);

    double calculateAngleCosBetweenSides(List<Double> firstVector, List<Double> secondVector);

    double calculatePerimeter(Quadrangle quadrangle);

    double calculateArea(Quadrangle quadrangle);
}
