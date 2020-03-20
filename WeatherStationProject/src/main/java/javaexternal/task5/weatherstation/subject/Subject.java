package javaexternal.task5.weatherstation.subject;


import javaexternal.task5.weatherstation.observer.Observer;

public interface Subject
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
