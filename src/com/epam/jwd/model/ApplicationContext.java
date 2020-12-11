package com.epam.jwd.model;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.factory.FigureFactory;

public class ApplicationContext {
    public FigureFactory createFigureFactory(){
        return new PostProcessingFactory(new PreProcessingFactory(SimpleFigureFactory.getInstance()));
    }
}
