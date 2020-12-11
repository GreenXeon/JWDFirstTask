package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

public class FigureExistencePreProcessor implements FigurePreProcessor {
    private static FigureExistencePreProcessor instance;
    private FigureExistencePreProcessor(){
    }
    public static FigureExistencePreProcessor getInstance(){
        if (instance == null){
            instance = new FigureExistencePreProcessor();
        }
        return instance;
    }

    @Override
    public void preProcess(Point... points) throws FigureException {
        boolean different = true;
        for(int i = 0; i < points.length-1; i++){
            for (int j = i+1; j < points.length; j++) {
                if (points[i] == points[j]) {
                    different = false;
                    break;
                }
            }
        }
        if (!different){
            throw new FigureNotExistException("Cannot create figure with equal points");
        }
    }
}
