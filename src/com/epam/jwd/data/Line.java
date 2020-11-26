package com.epam.jwd.data;

import com.epam.jwd.strategy.LineInfoStrategy;
import com.epam.jwd.strategy.Strategy;

public class Line extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    public static Strategy figurePropertiesStrategy = LineInfoStrategy.INSTANCE;

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Line(Point firstPoint, Point secondPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public boolean equalityCheck(){
        return this.getFirstPoint().equals(this.getSecondPoint());
    }

    @Override
    public String toString(){
        return this.firstPoint.toString() + " - " + this.secondPoint.toString();
    }
}
