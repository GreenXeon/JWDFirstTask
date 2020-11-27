package com.epam.jwd.module;

import com.epam.jwd.data.Point;
import com.epam.jwd.data.Square;

public class SquareFactory{
    private static Square[] allCreatedSquares = new Square[15];
    private static int amountOfSquares = 0;

    public static Square createFigure(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        final Square square = popFromCacheorCreate(firstPoint, secondPoint, thirdPoint, fourthPoint);
        return square;
    }

    private static Square popFromCacheorCreate(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        for (Square square : allCreatedSquares){
            if (square != null && square.getFirstPoint() == firstPoint
            && square.getSecondPoint() == secondPoint && square.getThirdPoint() == thirdPoint
            && square.getFourthPoint() == fourthPoint){
                System.out.println("exists");
                return square;
            }
        }
        final Square square = new Square(firstPoint, secondPoint, thirdPoint, fourthPoint);
        allCreatedSquares[amountOfSquares] = square;
        amountOfSquares++;
        System.out.println("new");
        return square;
    }
}
