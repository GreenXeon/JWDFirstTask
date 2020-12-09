package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Point;

public interface FigurePreProcessor {
    void preProcess(Point... points) throws FigureException;
}
