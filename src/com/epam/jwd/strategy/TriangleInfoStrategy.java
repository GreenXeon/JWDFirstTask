package com.epam.jwd.strategy;

import com.epam.model.Figure;
import com.epam.model.Triangle;

public class TriangleInfoStrategy implements Strategy {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    @Override
    public double findPerimeter(Figure figure) {
        Triangle obj = (Triangle)figure;
        firstSide = Math.sqrt(Math.pow(obj.getSecondPoint().getX() - obj.getFirstPoint().getX(), 2) +
                Math.pow(obj.getSecondPoint().getY() - obj.getFirstPoint().getY(), 2));
        secondSide = Math.sqrt(Math.pow(obj.getThirdPoint().getX() - obj.getFirstPoint().getX(), 2) +
                Math.pow(obj.getThirdPoint().getY() - obj.getFirstPoint().getY(), 2));;
        thirdSide = Math.sqrt(Math.pow(obj.getThirdPoint().getX() - obj.getSecondPoint().getX(), 2) +
                Math.pow(obj.getThirdPoint().getY() - obj.getSecondPoint().getY(), 2));
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double findSquare(Figure figure) {
        double halfPerimeter = findPerimeter(figure) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) *
                (halfPerimeter - thirdSide));
    }
}
