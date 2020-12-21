package by.aginskiy.figure.model.service.impl;

import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.model.service.QuadrangleConditionService;

import java.util.List;

public class QuadrangleConditionServiceImpl implements QuadrangleConditionService {

    private static QuadrangleCalculationServiceImpl calculationService = new QuadrangleCalculationServiceImpl();
    private static PointServiceImpl pointService = new PointServiceImpl();

    public boolean isQuadrangleExists(Quadrangle quadrangle) {
        final int pointsCount = 4;
        boolean isExists = true;
        int i = 0;
        while(i < pointsCount - 1 && isExists) {
            int j = i + 1;
            while(j < pointsCount - 1) {
                if(pointService.isThreePointsOnLine(quadrangle.getPoint(i), quadrangle.getPoint(j),
                   quadrangle.getPoint(j + 1))) {
                    isExists = false;
                    break;
                }
                j++;
            }
            i++;
        }
        return isExists;
    }

    public boolean isRhombus(Quadrangle quadrangle) {
        if(!isQuadrangleExists(quadrangle)) {
            return false;
        }
        List<Double> sidesLengths = calculationService.calculateSidesLengths(quadrangle);
        boolean isRhombus = true;
        int i = sidesLengths.size() - 1;
        while(i > 0) {
            if (!sidesLengths.get(i).equals(sidesLengths.get(i - 1))) {
                isRhombus = false;
                break;
            }
            i--;
        }
        return isRhombus;
    }

    public boolean isRectangle(Quadrangle quadrangle) {
        if(!isQuadrangleExists(quadrangle)) {
            return false;
        }
        final int anglesCount = 4;
        boolean isRectangle = true;
        int i = 1;
        while(i < anglesCount - 1) {
            List<Double> firstVector = pointService.calculateVectorCoordinates(quadrangle.getPoint(i - 1),
                    quadrangle.getPoint(i));
            List<Double> secondVector = pointService.calculateVectorCoordinates(quadrangle.getPoint(i + 1),
                    quadrangle.getPoint(i));
            if (calculationService.calculateAngleCosBetweenSides(firstVector, secondVector) != 0.0) {
                isRectangle = false;
                break;
            }
            i++;
        }
        return isRectangle;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        boolean isSquare = isRectangle(quadrangle) && isRhombus(quadrangle);
        return isSquare;
    }
}
