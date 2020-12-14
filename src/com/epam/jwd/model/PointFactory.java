package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PointFactory{
    private static List<Point> allCreatedPoints = new ArrayList<>();

    public static Point createFigure(int x, int y) {
        return popFromCacheorCreate(x, y);
    }

    private static Point popFromCacheorCreate(int x, int y){
        ListIterator<Point> pointIterator = allCreatedPoints.listIterator();
        Point currentPoint;

        while (pointIterator.hasNext()){
            currentPoint = pointIterator.next();
            if (currentPoint.getX() == x && currentPoint.getY() == y){
                return currentPoint;
            }
        }
        final Point point = new Point(x, y);
        allCreatedPoints.add(point);
        return point;
    }
}
