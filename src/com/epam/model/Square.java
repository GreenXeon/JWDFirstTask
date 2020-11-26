package com.epam.model;

public class Square extends Figure implements Validator{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getFourthPoint() {
        return fourthPoint;
    }

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    @Override
    public String toString(){
        return this.firstPoint.toString() + " - " + this.secondPoint.toString() +
                " - " + this.thirdPoint.toString() + " - " + this.fourthPoint.toString();
    }

    @Override
    public boolean equalityCheck(){
       return ((this.getFirstPoint().equals(this.getSecondPoint()))
                || (this.getFirstPoint().equals(this.getThirdPoint()))
                || (this.getFirstPoint().equals(this.getFourthPoint()))
                || (this.getSecondPoint().equals(this.getThirdPoint()))
                || (this.getSecondPoint().equals(this.getFourthPoint()))
                || (this.getThirdPoint().equals(this.getFourthPoint())));
    }

    @Override
    public boolean validationCheck(){
        double firstSide = Math.sqrt(Math.pow(this.secondPoint.getX() - this.firstPoint.getX(), 2) +
                Math.pow(this.secondPoint.getY() - this.firstPoint.getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.thirdPoint.getX() - this.secondPoint.getX(), 2) +
                Math.pow(this.thirdPoint.getY() - this.secondPoint.getY(), 2));;
        double thirdSide = Math.sqrt(Math.pow(this.fourthPoint.getX() - this.thirdPoint.getX(), 2) +
                Math.pow(this.fourthPoint.getY() - this.thirdPoint.getY(), 2));
        double fourthSide = Math.sqrt(Math.pow(this.firstPoint.getX() - this.fourthPoint.getX(), 2) +
                Math.pow(this.firstPoint.getY() - this.fourthPoint.getY(), 2));
        return Math.hypot(firstSide,secondSide) == Math.hypot(thirdSide, fourthSide);
    }
}
