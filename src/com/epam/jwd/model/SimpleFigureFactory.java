package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

public final class SimpleFigureFactory implements FigureFactory {
    private static SimpleFigureFactory instance;
    private SimpleFigureFactory(){
    }
    public static SimpleFigureFactory getInstance(){
        if (instance == null){
            instance = new SimpleFigureFactory();
        }
        return instance;
    }

    private FigureCache figureCache = FigureCache.getInstance();

    @Override
    public Figure createFigure(FigureType type, Point ... figureConstituents) throws FigureException {
        return figureCache.popFromCacheOrCreateFigure(type, figureConstituents);
    }
}
