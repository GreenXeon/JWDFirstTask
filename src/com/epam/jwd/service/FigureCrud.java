package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureCriteria;

import java.util.List;

public interface FigureCrud {
    void createFigure(FigureFactory factory, FigureType type, Point... points) throws FigureException;
    void createMultiFigure(int amountOfFigures, FigureFactory factory, FigureType type, Point ... points) throws FigureException;
    void deleteFigure(Figure figure);
    void updateFigure(int id, Point ... points) throws FigureException;
    List<Figure> findByCriteria(FigureCriteria criteria);
    Figure findById(int id);
    Figure findFigure(Figure figure);
}
