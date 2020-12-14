package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private static List<Figure> allCreatedFigures = new ArrayList<>();

    Figure popFromCacheOrCreateFigure(FigureType type, Point... points) {
        int equalPointCounter = 0;
        Figure toReturn;
        Iterator<Figure> figureIterator = allCreatedFigures.iterator();
        Figure currentFigure;

        while(figureIterator.hasNext()){
            currentFigure = figureIterator.next();
            if (currentFigure.numOfPoints() == points.length){
                Point[] arrCached = currentFigure.getPoints();
                for (Point newPoint : points){
                    for (Point cachedPoint : arrCached){
                        if (newPoint == cachedPoint){
                            equalPointCounter++;
                        }
                    }
                }
                if (equalPointCounter == points.length){
                    return currentFigure;
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
        allCreatedFigures.add(toReturn);
        return toReturn;
    }
}
