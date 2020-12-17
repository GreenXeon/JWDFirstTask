package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

import java.util.ArrayList;
import java.util.List;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private List<FigurePreProcessor> preProcessors = new ArrayList<>() {{
        add(FigureExistencePreProcessor.getInstance());
    }};
    private FigureFactory figureFactory;

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
