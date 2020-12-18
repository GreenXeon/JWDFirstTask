package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;
import com.epam.jwd.strategy.TriangleInfoStrategy;

import java.util.List;

public class Triangle extends Figure {
    public static Strategy figurePropertiesStrategy = TriangleInfoStrategy.getInstance();
    private List<Point> points;
    private FigureType type = FigureType.TRIANGLE;

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    Triangle(List<Point> points){
        this.points = points;
    }

    @Override
    public String toString() {
        return this.getPoints().get(0).toString() + " - " + this.getPoints().get(1).toString() +
                " - " + this.getPoints().get(2).toString();
    }

    @Override
    public boolean validationCheck() {
        double firstSide = Math.sqrt(Math.pow(this.getPoints().get(1).getX() - this.getPoints().get(0).getX(), 2) +
                Math.pow(this.getPoints().get(1).getY() - this.getPoints().get(0).getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.getPoints().get(2).getX() - this.getPoints().get(0).getX(), 2) +
                Math.pow(this.getPoints().get(2).getY() - this.getPoints().get(0).getY(), 2));
        double thirdSide = Math.sqrt(Math.pow(this.getPoints().get(2).getX() - this.getPoints().get(1).getX(), 2) +
                Math.pow(this.getPoints().get(2).getY() - this.getPoints().get(1).getY(), 2));
        return (firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                && (secondSide + thirdSide > firstSide);
    }

    @Override
    public int numOfPoints(){
        return 3;
    }
}
