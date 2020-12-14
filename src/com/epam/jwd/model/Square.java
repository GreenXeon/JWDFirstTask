package com.epam.jwd.model;

import com.epam.jwd.strategy.SquareInfoStrategy;
import com.epam.jwd.strategy.Strategy;

public class Square extends Figure{
    public static Strategy figurePropertiesStrategy = SquareInfoStrategy.getInstance();

    private Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    Square(Point[] points){
        this.points = points;
    }

    @Override
    public String toString(){
        return this.getPoints()[0].toString() + " - " + this.getPoints()[1].toString() +
                " - " + this.getPoints()[2].toString() + " - " + this.getPoints()[3].toString();
    }

    @Override
    public boolean equalityCheck(){
       return ((this.getPoints()[0].equals(this.getPoints()[1]))
                || (this.getPoints()[0].equals(this.getPoints()[2]))
                || (this.getPoints()[0].equals(this.getPoints()[3]))
                || (this.getPoints()[1].equals(this.getPoints()[2]))
                || (this.getPoints()[1].equals(this.getPoints()[3]))
                || (this.getPoints()[2].equals(this.getPoints()[3])));
    }

    @Override
    public boolean validationCheck(){
        double firstSide = Math.sqrt(Math.pow(this.getPoints()[1].getX() - this.getPoints()[0].getX(), 2) +
                Math.pow(this.getPoints()[1].getY() - this.getPoints()[0].getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.getPoints()[2].getX() - this.getPoints()[1].getX(), 2) +
                Math.pow(this.getPoints()[2].getY() - this.getPoints()[1].getY(), 2));;
        double thirdSide = Math.sqrt(Math.pow(this.getPoints()[3].getX() - this.getPoints()[2].getX(), 2) +
                Math.pow(this.getPoints()[3].getY() - this.getPoints()[2].getY(), 2));
        double fourthSide = Math.sqrt(Math.pow(this.getPoints()[0].getX() - this.getPoints()[3].getX(), 2) +
                Math.pow(this.getPoints()[0].getY() - this.getPoints()[3].getY(), 2));
        return Math.hypot(firstSide,secondSide) == Math.hypot(thirdSide, fourthSide);
    }

    @Override
    public int numOfPoints(){
        return 4;
    }
}
