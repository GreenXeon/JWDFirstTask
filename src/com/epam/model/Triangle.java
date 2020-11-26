package com.epam.model;

public class Triangle extends Figure implements Validator{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }
    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    @Override
    public String toString(){
        return this.firstPoint.toString() + " - " + this.secondPoint.toString() +
                " - " + this.thirdPoint.toString();
    }

    @Override
    public boolean equalityCheck(){
        return ((this.getFirstPoint().equals(this.getSecondPoint()))
                || (this.getFirstPoint().equals(this.getThirdPoint()))
                || (this.getSecondPoint().equals(this.getThirdPoint())));
    }

    @Override
    public boolean validationCheck(){
        double firstSide = Math.sqrt(Math.pow(this.secondPoint.getX() - this.firstPoint.getX(), 2) +
                Math.pow(this.secondPoint.getY() - this.firstPoint.getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.thirdPoint.getX() - this.firstPoint.getX(), 2) +
                Math.pow(this.thirdPoint.getY() - this.firstPoint.getY(), 2));;
        double thirdSide = Math.sqrt(Math.pow(this.thirdPoint.getX() - this.secondPoint.getX(), 2) +
                Math.pow(this.thirdPoint.getY() - this.secondPoint.getY(), 2));
        return (firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                && (secondSide + thirdSide > firstSide);
    }
}
