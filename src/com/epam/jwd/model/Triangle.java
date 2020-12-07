package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;
import com.epam.jwd.strategy.TriangleInfoStrategy;

public class Triangle extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    public static Strategy figurePropertiesStrategy = TriangleInfoStrategy.getInstance();

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    private final Point[] points;

    public Point[] getPoints() {
        return points;
    }

    Triangle(Point[] points){
        this.points = points;
    }

    @Override
    public String toString() {
        return this.firstPoint.toString() + " - " + this.secondPoint.toString() +
                " - " + this.thirdPoint.toString();
    }

    @Override
    public boolean equalityCheck() {
        return ((this.getFirstPoint().equals(this.getSecondPoint()))
                || (this.getFirstPoint().equals(this.getThirdPoint()))
                || (this.getSecondPoint().equals(this.getThirdPoint())));
    }

    @Override
    public boolean validationCheck() {
        double firstSide = Math.sqrt(Math.pow(this.secondPoint.getX() - this.firstPoint.getX(), 2) +
                Math.pow(this.secondPoint.getY() - this.firstPoint.getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.thirdPoint.getX() - this.firstPoint.getX(), 2) +
                Math.pow(this.thirdPoint.getY() - this.firstPoint.getY(), 2));
        ;
        double thirdSide = Math.sqrt(Math.pow(this.thirdPoint.getX() - this.secondPoint.getX(), 2) +
                Math.pow(this.thirdPoint.getY() - this.secondPoint.getY(), 2));
        return (firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                && (secondSide + thirdSide > firstSide);
    }

    @Override
    public int numOfPoints(){
        return 3;
    }
}
