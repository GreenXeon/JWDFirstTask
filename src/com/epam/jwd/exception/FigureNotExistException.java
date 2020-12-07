package com.epam.jwd.exception;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.strategy.Strategy;

public class FigureNotExistException extends FigureException {
    public FigureNotExistException(String message){
        super(message);
    }
}
