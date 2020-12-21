package by.aginskiy.figure.model.repository.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.model.repository.Specification;


public class ThirdQuadrantSpecification implements Specification {

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean isThirdQuadrant = false;
        int i = 0;
        while(i < POINTS_NUMBER) {
            CustomPoint point = quadrangle.getPoint(i);
            if(point.getPositionX() < 0 && point.getPositionY() < 0) {
                isThirdQuadrant = true;
                break;
            }
            i++;
        }
        return isThirdQuadrant;
    }
}
