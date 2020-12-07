package com.epam.jwd.model;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.strategy.Strategy;

public abstract class FigureFactory {
    private static Figure[] allCreatedFigures = new Figure[64];
    private static int amountOfFigures = 0;
    private Strategy figurePropertiesStrategy;

    public Strategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(Strategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public static Figure createFigure(FigureType type, Point ... points) {
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
                    System.out.println("exists");
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
        System.out.println("new");
        return toReturn;
    }
}
