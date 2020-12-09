package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private FigureFactory figureFactory;
    private FigurePreProcessor[] preProcessors = new FigurePreProcessor[]{new FigureExistencePreProcessor()};

    public PreProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point ... figureConstituents) throws FigureException{
        for (FigurePreProcessor preProcessor : preProcessors){
            preProcessor.preProcess(figureConstituents);
        }
        return figureFactory.createFigure(type, figureConstituents);
    }
}
