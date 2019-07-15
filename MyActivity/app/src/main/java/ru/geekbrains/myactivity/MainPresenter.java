package ru.geekbrains.myactivity;

public class MainPresenter {
    private static MainPresenter instance = null;

    private static final Object syncobj = new Object();

    private int counter;

    private MainPresenter(){
        counter = 0;
    }

    public void incrementCounter(){
        counter++;
    }

    public static MainPresenter getInstance(){
        synchronized (syncobj){
            if (instance == null){
                instance = new MainPresenter();
            }
            return instance;
        }
    }

    public String getCounter() {
        return ((Integer)counter).toString();
    }
}
