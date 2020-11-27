package com.epam.jwd.module;

import com.epam.jwd.data.Line;
import com.epam.jwd.data.Point;

public class LineFactory{
    private static Line[] allCreatedLines = new Line[15];
    private static int amountOfLines = 0;

    public static Line createFigure(Point firstPoint, Point secondPoint) {
        final Line line = popFromCacheorCreate(firstPoint, secondPoint);
        return line;
    }

    private static Line popFromCacheorCreate(Point firstPoint, Point secondPoint){
        for (Line line : allCreatedLines){
            if (line != null && line.getFirstPoint() == firstPoint
                    && line.getSecondPoint() == secondPoint){
                System.out.println("exists");
                return line;
            }
        }
        final Line line = new Line(firstPoint, secondPoint);
        allCreatedLines[amountOfLines] = line;
        amountOfLines++;
        System.out.println("new");
        return line;
    }
}
