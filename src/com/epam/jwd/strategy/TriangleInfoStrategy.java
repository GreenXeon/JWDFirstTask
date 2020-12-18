package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Triangle;

public final class TriangleInfoStrategy implements Strategy {
    private static TriangleInfoStrategy instance = new TriangleInfoStrategy();
    private TriangleInfoStrategy(){
    }
    public static TriangleInfoStrategy getInstance(){
        return instance;
    }

    private double firstSide;
    private double secondSide;
    private double thirdSide;

    @Override
    public double findPerimeter(Figure figure) {
        Triangle obj = (Triangle)figure;
        firstSide = Math.sqrt(Math.pow(obj.getPoints().get(1).getX() - obj.getPoints().get(0).getX(), 2) +
                Math.pow(obj.getPoints().get(1).getY() - obj.getPoints().get(0).getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getPoints().get(2).getX() - obj.getPoints().get(0).getX(), 2) +
                Math.pow(obj.getPoints().get(2).getY() - obj.getPoints().get(0).getY(), 2));;
        thirdSide = Math.sqrt(Math.pow(obj.getPoints().get(2).getX() - obj.getPoints().get(1).getX(), 2) +
                Math.pow(obj.getPoints().get(2).getY() - obj.getPoints().get(1).getY(), 2));
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double findSquare(Figure figure) {
        double halfPerimeter = findPerimeter(figure) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) *
                (halfPerimeter - thirdSide));
    }
}
