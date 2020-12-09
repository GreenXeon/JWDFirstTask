package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure instanceof Line)
            return figure;
        int equalX = 1;
        int equalY = 1;
        Point[] points = figure.getPoints();
        boolean different = true;
        for(int i = 0; i < figure.numOfPoints()-1; i++){
            for (int j = i+1; j < figure.numOfPoints(); j++){
                if (points[i].getX() == points[j].getX()){
                    equalX++;
                }
                if (points[i].getY() == points[j].getY()){
                    equalY++;
                }
            }
        }
        if (equalX == figure.numOfPoints() || equalY == figure.numOfPoints()){
            throw new FigureNotExistException("Figure can't exist");
        }

        /*if(!figure.validationCheck()){
            throw new FigureException("Figure can't exist");
        }*/
        return figure;
    }
}
