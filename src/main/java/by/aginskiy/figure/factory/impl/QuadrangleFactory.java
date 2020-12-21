package by.aginskiy.figure.factory.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.factory.ShapeFactory;

import java.util.List;

public class QuadrangleFactory implements ShapeFactory<Quadrangle> {

    @Override
    public Quadrangle createQuadrangle(List<CustomPoint> points) {
        return new Quadrangle(points.get(0), points.get(1), points.get(2), points.get(3));
    }
}
