package com.epam.jwd.strategy;

import com.epam.jwd.data.Figure;
import com.epam.jwd.data.Square;

public class SquareInfoStrategy implements Strategy {
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
    private double thirdSide;
    private double fourthSide;

    @Override
    public double findPerimeter(Figure figure) {
        Square obj = (Square)figure;
        firstSide = Math.sqrt(Math.pow(obj.getSecondPoint().getX() - obj.getFirstPoint().getX(), 2) +
                Math.pow(obj.getSecondPoint().getY() - obj.getFirstPoint().getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getThirdPoint().getX() - obj.getSecondPoint().getX(), 2) +
                Math.pow(obj.getThirdPoint().getY() - obj.getSecondPoint().getY(), 2));
        thirdSide = Math.sqrt(Math.pow(obj.getFourthPoint().getX() - obj.getThirdPoint().getX(), 2) +
                Math.pow(obj.getFourthPoint().getY() - obj.getThirdPoint().getY(), 2));
        fourthSide = Math.sqrt(Math.pow(obj.getFirstPoint().getX() - obj.getFourthPoint().getX(), 2) +
                Math.pow(obj.getFirstPoint().getY() - obj.getFourthPoint().getY(), 2));
        return firstSide + secondSide + thirdSide + fourthSide;
    }

    @Override
    public double findSquare(Figure figure) {
        Square obj = (Square)figure;
        firstSide = Math.sqrt(Math.pow(obj.getSecondPoint().getX() - obj.getFirstPoint().getX(), 2) +
                Math.pow(obj.getSecondPoint().getY() - obj.getFirstPoint().getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getThirdPoint().getX() - obj.getSecondPoint().getX(), 2) +
                Math.pow(obj.getThirdPoint().getY() - obj.getSecondPoint().getY(), 2));
        return firstSide * secondSide;
    }
}
