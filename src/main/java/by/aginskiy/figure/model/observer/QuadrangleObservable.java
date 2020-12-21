package by.aginskiy.figure.model.observer;

public interface QuadrangleObservable {

    void attach(QuadrangleObserver observer);

    void detach(QuadrangleObserver observer);

    void notifyObservers();
}
