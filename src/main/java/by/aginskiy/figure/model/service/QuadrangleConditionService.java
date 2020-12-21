package by.aginskiy.figure.model.service;

import by.aginskiy.figure.model.entity.Quadrangle;

public interface QuadrangleConditionService {

    boolean isQuadrangleExists(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isRectangle(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);
}
