package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;

final class FigureStorage {
    private static FigureStorage instance;
    private FigureStorage(){
    }
    public static FigureStorage getInstance(){
        if (instance == null){
            instance = new FigureStorage();
        }
        return instance;
    }

    private static Figure[] allCreatedFigures = new Figure[64];
    private static int amountOfFigures = 0;

    Figure popFromCacheOrCreateFigure(FigureType type, Point... points) throws FigureNotExistException {
        int equalPointCounter = 0;
        Figure toReturn = null;

        for(Figure cachedFigure : allCreatedFigures){
            if (cachedFigure!= null && cachedFigure.numOfPoints() == points.length){
                Point[] arrCached = cachedFigure.getPoints();
                for (Point newPoint : points){
                    for (Point cachedPoint : arrCached){
                        if (newPoint == cachedPoint){
                            equalPointCounter++;
                        }
                    }
                }
                if (equalPointCounter == points.length){
                    return cachedFigure;
                }
            }
        }
        switch (type){
            case LINE:
                toReturn = new Line(points);
                break;
            case TRIANGLE:
                toReturn = new Triangle(points);
                break;
            case SQUARE:
                toReturn = new Square(points);
                break;
            case MULTIANGLE:
                toReturn = new MultiAngleFigure(points);
                break;
            default:
                throw new IllegalArgumentException("Wrong figure name: " + type);
        }
        allCreatedFigures[amountOfFigures] = toReturn;
        amountOfFigures++;
        return toReturn;
    }
}
