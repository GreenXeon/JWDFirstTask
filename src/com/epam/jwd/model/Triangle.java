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
        return this.getPoints()[0].toString() + " - " + this.getPoints()[1].toString() +
                " - " + this.getPoints()[2].toString();
    }

    @Override
    public boolean equalityCheck() {
        return ((this.getPoints()[0].equals(this.getPoints()[1]))
                || (this.getPoints()[0].equals(this.getPoints()[2]))
                || (this.getPoints()[1].equals(this.getPoints()[2])));
    }

    @Override
    public boolean validationCheck() {
        double firstSide = Math.sqrt(Math.pow(this.getPoints()[1].getX() - this.getPoints()[0].getX(), 2) +
                Math.pow(this.getPoints()[1].getY() - this.getPoints()[0].getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.getPoints()[2].getX() - this.getPoints()[0].getX(), 2) +
                Math.pow(this.getPoints()[2].getY() - this.getPoints()[0].getY(), 2));
        ;
        double thirdSide = Math.sqrt(Math.pow(this.getPoints()[2].getX() - this.getPoints()[1].getX(), 2) +
                Math.pow(this.getPoints()[2].getY() - this.getPoints()[1].getY(), 2));
        return (firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                && (secondSide + thirdSide > firstSide);
    }

    @Override
    public int numOfPoints(){
        return 3;
    }
}
