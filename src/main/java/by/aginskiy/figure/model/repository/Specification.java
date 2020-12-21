package by.aginskiy.figure.model.repository;

import by.aginskiy.figure.model.entity.Quadrangle;

public interface Specification {

    int POINTS_NUMBER = 4;

    boolean specify(Quadrangle quadrangle);
}
