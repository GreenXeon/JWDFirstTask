package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;

public abstract class Figure {
    private Strategy figurePropertiesStrategy;
    private Point[] points = {};

    public boolean equalityCheck() {
        return true;
    }

    public boolean validationCheck() {
        return false;
    }

    public int numOfPoints() {
        return 0;
    }

    public Point[] getPoints(){
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
