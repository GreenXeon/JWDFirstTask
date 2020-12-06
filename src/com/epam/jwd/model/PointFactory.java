package com.epam.jwd.model;

public class PointFactory{
    private static Point[] allCreatedPoints = new Point[15];
    private static int amountOfPoints = 0;

    public static Point createFigure(int x, int y) {
        return popFromCacheorCreate(x, y);
    }

    private static Point popFromCacheorCreate(int x, int y){
        for (Point point : allCreatedPoints){
            if (point != null && point.getX() == x
                    && point.getY() == y){
                return point;
            }
        }
        final Point point = new Point(x, y);
        allCreatedPoints[amountOfPoints] = point;
        amountOfPoints++;
        return point;
    }
}
