package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private FigurePostProcessor[] postProcessors = new FigurePostProcessor[]{new FigureExistencePostProcessor()};
    private FigureFactory figureFactory;

    public PostProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure = figureFactory.createFigure(type, figureConstituents);
        for (FigurePostProcessor postProcessor : postProcessors){
            figure = postProcessor.process(figure);
        }
        return figure;
    }
}
