package htw.berlin.ui;

import htw.berlin.service.Observer;

public interface Observable {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();
}