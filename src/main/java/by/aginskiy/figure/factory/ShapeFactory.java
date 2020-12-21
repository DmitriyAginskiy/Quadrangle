package by.aginskiy.figure.factory;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Shape2D;

import java.util.List;

public interface ShapeFactory<T extends Shape2D> {

    T createQuadrangle(List<CustomPoint> points);
}
