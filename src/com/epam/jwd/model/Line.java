package com.epam.jwd.model;

import com.epam.jwd.strategy.LineInfoStrategy;
import com.epam.jwd.strategy.Strategy;

public class Line extends Figure {
    private Point[] points;
    public static Strategy figurePropertiesStrategy = LineInfoStrategy.INSTANCE;

    Line(Point[] points){
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
    @Override
    public boolean equalityCheck(){
        return this.getPoints()[0].equals(this.getPoints()[1]);
    }

    @Override
    public String toString(){
        return this.getPoints()[0].toString() + " - " + this.getPoints()[1].toString();
    }

    @Override
    public int numOfPoints(){
        return 2;
    }
}
