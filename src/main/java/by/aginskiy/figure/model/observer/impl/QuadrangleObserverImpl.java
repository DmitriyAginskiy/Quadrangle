package by.aginskiy.figure.model.observer.impl;

import by.aginskiy.figure.model.entity.Quadrangle;
import by.aginskiy.figure.model.entity.QuadrangleCondition;
import by.aginskiy.figure.model.observer.QuadrangleEvent;
import by.aginskiy.figure.model.observer.QuadrangleObserver;
import by.aginskiy.figure.model.service.impl.QuadrangleCalculationServiceImpl;
import by.aginskiy.figure.model.warehouse.QuadrangleConditionWarehouse;

public class QuadrangleObserverImpl implements QuadrangleObserver {

    @Override
    public void parameterChanged(QuadrangleEvent event) {
        Quadrangle quadrangle = event.getSource();
        QuadrangleCalculationServiceImpl calculationService = new QuadrangleCalculationServiceImpl();
        double square = calculationService.calculateArea(quadrangle);
        double perimeter = calculationService.calculatePerimeter(quadrangle);
        QuadrangleCondition quadrangleCondition = new QuadrangleCondition(square, perimeter);
        QuadrangleConditionWarehouse.getWarehouse().put(quadrangle.getId(), quadrangleCondition);
    }
}
