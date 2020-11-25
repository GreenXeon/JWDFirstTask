package com.epam.model;

public class Line {
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
    public String toString(){
        return "Line's first point is " + this.firstPoint.toString() + " and second point is "
        + this.secondPoint.toString();
    }
}
