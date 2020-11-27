package com.epam.jwd.module;

import com.epam.jwd.data.Point;
import com.epam.jwd.data.Triangle;

public class TriangleFactory {
    private static Triangle[] allCreatedTriangles = new Triangle[15];
    private static int amountOfTriangles = 0;

    public static Triangle createFigure(Point firstPoint, Point secondPoint, Point thirdPoint) {
        final Triangle triangle = popFromCacheorCreate(firstPoint, secondPoint, thirdPoint);
        return triangle;
    }

    private static Triangle popFromCacheorCreate(Point firstPoint, Point secondPoint, Point thirdPoint){
        for (Triangle triangle : allCreatedTriangles){
            if (triangle != null && triangle.getFirstPoint() == firstPoint
                    && triangle.getSecondPoint() == secondPoint && triangle.getThirdPoint() == thirdPoint){
                System.out.println("exists");
                return triangle;
            }
        }
        final Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        allCreatedTriangles[amountOfTriangles] = triangle;
        amountOfTriangles++;
        System.out.println("new");
        return triangle;
    }
}
