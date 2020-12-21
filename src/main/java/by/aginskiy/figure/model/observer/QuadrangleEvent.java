package by.aginskiy.figure.model.observer;

import by.aginskiy.figure.model.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {

    public QuadrangleEvent(Object source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle) super.getSource();
    }
}
