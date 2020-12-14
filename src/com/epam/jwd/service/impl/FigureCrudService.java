package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FigureCrudService implements FigureCrud {
    private static FigureCrudService instance;
    private FigureCrudService(){
    }
    public static FigureCrudService getInstance(){
        if (instance == null){
            instance = new FigureCrudService();
        }
        return instance;
    }

    private Map<Integer, Figure> figureStorage = new LinkedHashMap<>();
    private int index = 0;

    @Override
    public Figure createFigure(FigureFactory factory, FigureType type, Point... points) throws FigureException {
        Figure createdFigure = factory.createFigure(type, points);
        figureStorage.put(index, createdFigure);
        index++;
        return createdFigure;
    }

    @Override
    public List<Figure> createMultiFigure(int amountOfFigures, FigureFactory factory, FigureType type, Point... points) throws FigureException {
        Figure createdFigure;
        List<Figure> listOfFigures = new ArrayList<>();
        for ( int i = 0; i < amountOfFigures; i++){
            createdFigure = factory.createFigure(type, points);
            figureStorage.put(index, createdFigure);
            listOfFigures.add(createdFigure);
            index++;
        }
        return listOfFigures;
    }

    @Override
    public Figure deleteFigure(int id) {
        figureStorage.remove(id);
        return null;
    }

    @Override
    public Figure updateFigure(int id, Point ... points) {
        Figure figure = figureStorage.get(id);
        figure.setPoints(points);
        figureStorage.put(id, figure);
        return null;
    }

    @Override
    public Figure findFigure() {
        return null;
    }

    @Override
    public Figure findById(int id) {
        System.out.println(figureStorage.get(id));
        return figureStorage.get(id);
    }
}
