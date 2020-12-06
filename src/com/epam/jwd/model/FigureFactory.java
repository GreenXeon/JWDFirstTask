package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;

public abstract class FigureFactory {
    private Strategy figurePropertiesStrategy;

    public Strategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(Strategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public static Figure createFigure(FigureType type, Point ... points){
        Figure toReturn = null;
        switch(type){
            case LINE:
                toReturn = new Line(points[0], points[1]);
                break;
            case TRIANGLE:
                toReturn = new Triangle(points[0], points[1], points[2]);
                break;
            case SQUARE:
                toReturn = new Square(points[0], points[1], points[2], points[3]);
                break;
            case MULTIANGLE:
                toReturn = new MultiAngleFigure();
                break;
            default:
                throw new IllegalArgumentException("Wrong figure name: " + type);
        }
        return toReturn;
    }
}
