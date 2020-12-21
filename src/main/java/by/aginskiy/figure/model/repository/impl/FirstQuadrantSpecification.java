package by.aginskiy.figure.model.repository.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.model.repository.Specification;


public class FirstQuadrantSpecification implements Specification {

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean isFirstQuadrant = false;
        int i = 0;
        while(i < POINTS_NUMBER) {
            CustomPoint point = quadrangle.getPoint(i);
            if(point.getPositionX() > 0 && point.getPositionY() > 0) {
                isFirstQuadrant = true;
                break;
            }
            i++;
        }
        return isFirstQuadrant;
    }
}
