package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Square;

public final class SquareInfoStrategy implements Strategy {
    private static SquareInfoStrategy instance;
    private SquareInfoStrategy(){
    }
    public static SquareInfoStrategy getInstance(){
        if (instance == null){
            instance = new SquareInfoStrategy();
        }
        return instance;
    }

    private double firstSide;
    private double secondSide;

    @Override
    public double findPerimeter(Figure figure) {
        Square obj = (Square)figure;
        firstSide = Math.sqrt(Math.pow(obj.getPoints()[1].getX() - obj.getPoints()[0].getX(), 2) +
                Math.pow(obj.getPoints()[1].getY() - obj.getPoints()[0].getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getPoints()[2].getX() - obj.getPoints()[1].getX(), 2) +
                Math.pow(obj.getPoints()[2].getY() - obj.getPoints()[1].getY(), 2));
        double thirdSide = Math.sqrt(Math.pow(obj.getPoints()[3].getX() - obj.getPoints()[2].getX(), 2) +
                Math.pow(obj.getPoints()[3].getY() - obj.getPoints()[2].getY(), 2));
        double fourthSide = Math.sqrt(Math.pow(obj.getPoints()[0].getX() - obj.getPoints()[3].getX(), 2) +
                Math.pow(obj.getPoints()[0].getY() - obj.getPoints()[3].getY(), 2));
        return firstSide + secondSide + thirdSide + fourthSide;
    }

    @Override
    public double findSquare(Figure figure) {
        Square obj = (Square)figure;
        firstSide = Math.sqrt(Math.pow(obj.getPoints()[1].getX() - obj.getPoints()[0].getX(), 2) +
                Math.pow(obj.getPoints()[1].getY() - obj.getPoints()[0].getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getPoints()[2].getX() - obj.getPoints()[1].getX(), 2) +
                Math.pow(obj.getPoints()[2].getY() - obj.getPoints()[1].getY(), 2));
        return firstSide * secondSide;
    }
}
