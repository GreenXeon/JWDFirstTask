package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class FigureCache {
    private static FigureCache instance;
    private FigureCache(){
    }
    public static FigureCache getInstance(){
        if (instance == null){
            instance = new FigureCache();
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
                List<Point> arrCached = currentFigure.getPoints();
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
                toReturn = new Line(Arrays.asList(points));
                break;
            case TRIANGLE:
                toReturn = new Triangle(Arrays.asList(points));
                break;
            case SQUARE:
                toReturn = new Square(Arrays.asList(points));
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
