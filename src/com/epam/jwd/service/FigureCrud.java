package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureCrud {
    Figure createFigure(FigureFactory factory, FigureType type, Point... points) throws FigureException;
    List<Figure> createMultiFigure(int amountOfFigures, FigureFactory factory, FigureType type, Point ... points) throws FigureException;
    Figure deleteFigure(int id);
    Figure updateFigure(int id, Point ... points);
    Figure findFigure();
    Figure findById(int id);
}
