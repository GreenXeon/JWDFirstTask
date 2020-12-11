package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(FigureType type, Point ... figureConstituents) throws FigureException {
        Figure toReturn = null;
        switch (type){
            case LINE:
                toReturn = new Line(figureConstituents);
                break;
            case TRIANGLE:
                toReturn = new Triangle(figureConstituents);
                break;
            case SQUARE:
                toReturn = new Square(figureConstituents);
                break;
            case MULTIANGLE:
                toReturn = new MultiAngleFigure(figureConstituents);
                break;
            default:
                throw new FigureException("Wrong figure name: " + type);
        }
        return toReturn;
    }
}
