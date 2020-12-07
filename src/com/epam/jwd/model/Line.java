package com.epam.jwd.model;

import com.epam.jwd.strategy.LineInfoStrategy;
import com.epam.jwd.strategy.Strategy;

public class Line extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private final Point[] points;
    public static Strategy figurePropertiesStrategy = LineInfoStrategy.INSTANCE;

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    Line(Point[] points){
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }
    @Override
    public boolean equalityCheck(){
        return this.getFirstPoint().equals(this.getSecondPoint());
    }

    @Override
    public String toString(){
        return this.firstPoint.toString() + " - " + this.secondPoint.toString();
    }

    @Override
    public int numOfPoints(){
        return 2;
    }
}
