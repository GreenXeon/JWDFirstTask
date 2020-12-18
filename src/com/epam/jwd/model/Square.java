package com.epam.jwd.model;

import com.epam.jwd.strategy.SquareInfoStrategy;
import com.epam.jwd.strategy.Strategy;

import java.util.List;

public class Square extends Figure{
    public static Strategy figurePropertiesStrategy = SquareInfoStrategy.getInstance();
    private List<Point> points;
    private FigureType type = FigureType.SQUARE;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }



    Square(List<Point> points){
        this.points = points;
    }

    @Override
    public String toString(){
        return this.getPoints().get(0).toString() + " - " + this.getPoints().get(1).toString() +
                " - " + this.getPoints().get(2).toString() + " - " + this.getPoints().get(3).toString();
    }

    @Override
    public boolean validationCheck(){
        double firstSide = Math.sqrt(Math.pow(this.getPoints().get(1).getX() - this.getPoints().get(0).getX(), 2) +
                Math.pow(this.getPoints().get(1).getY() - this.getPoints().get(0).getY(), 2));
        double secondSide = Math.sqrt(Math.pow(this.getPoints().get(2).getX() - this.getPoints().get(1).getX(), 2) +
                Math.pow(this.getPoints().get(2).getY() - this.getPoints().get(1).getY(), 2));;
        double thirdSide = Math.sqrt(Math.pow(this.getPoints().get(3).getX() - this.getPoints().get(2).getX(), 2) +
                Math.pow(this.getPoints().get(3).getY() - this.getPoints().get(2).getY(), 2));
        double fourthSide = Math.sqrt(Math.pow(this.getPoints().get(0).getX() - this.getPoints().get(3).getX(), 2) +
                Math.pow(this.getPoints().get(0).getY() - this.getPoints().get(3).getY(), 2));
        return Math.hypot(firstSide,secondSide) == Math.hypot(thirdSide, fourthSide);
    }

    @Override
    public int numOfPoints(){
        return 4;
    }
}
