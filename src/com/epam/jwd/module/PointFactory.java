package com.epam.jwd.module;

import com.epam.jwd.data.Point;

public class PointFactory{
    private static Point[] allCreatedPoints = new Point[15];
    private static int amountOfPoints = 0;

    public static Point createFigure(int x, int y) {
        final Point point = popFromCacheorCreate(x, y);
        return point;
    }

    private static Point popFromCacheorCreate(int x, int y){
        for (Point point : allCreatedPoints){
            if (point != null && point.getX() == x
                    && point.getY() == y){
                System.out.println("exists");
                return point;
            }
        }
        final Point point = new Point(x, y);
        allCreatedPoints[amountOfPoints] = point;
        amountOfPoints++;
        System.out.println("new");
        return point;
    }
}
