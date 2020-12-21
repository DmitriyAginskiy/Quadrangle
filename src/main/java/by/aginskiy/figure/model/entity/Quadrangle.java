package by.aginskiy.figure.model.entity;

import by.aginskiy.figure.model.observer.QuadrangleEvent;
import by.aginskiy.figure.model.observer.QuadrangleObservable;
import by.aginskiy.figure.model.observer.QuadrangleObserver;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle extends Shape2D implements QuadrangleObservable {

    private ArrayList<CustomPoint> points = new ArrayList<>();
    private List<QuadrangleObserver> observers;

    public Quadrangle() {
        observers = new ArrayList<>();
    }

    public Quadrangle(CustomPoint... points) {
        if(points.length == 4) {
            for(int i = 0; i < points.length; i++) {
                this.points.add(points[i]);
            }
        }
        observers = new ArrayList<>();
    }

    public CustomPoint getPoint(int pointNumber) {
        return points.get(pointNumber);
    }

    public void setPoint(int pointNumber, CustomPoint point) {
        points.set(pointNumber, point);
        notifyObservers();
    }

    @Override
    public void attach(QuadrangleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(QuadrangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        QuadrangleEvent event = new QuadrangleEvent(this);
        for(QuadrangleObserver observer : observers) {
            observer.parameterChanged(event);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrangle that = (Quadrangle) o;

        if (id != that.id) return false;
        return points.equals(that.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (observers != null ? observers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append("id=").append(id);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
