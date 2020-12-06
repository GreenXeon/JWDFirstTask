package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;

public abstract class Figure{
    private Strategy figurePropertiesStrategy;

    public boolean equalityCheck(){
        return true;
    }

    public boolean validationCheck() {
        return false;
    }
}
