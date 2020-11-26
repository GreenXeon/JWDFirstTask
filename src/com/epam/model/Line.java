package com.epam.model;

public class Line extends Figure {
    private Point firstPoint;
    private Point secondPoint;

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
