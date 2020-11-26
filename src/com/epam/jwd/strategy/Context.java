package com.epam.jwd.strategy;

import com.epam.jwd.data.Figure;

public class Context {
    private Strategy strategy;

    public Context (Strategy strategy){
        this.strategy = strategy;
    }

    public double ContextFindPerimeter(Figure figure){
        return strategy.findPerimeter(figure);
    }

    public double ContextFindSquare(Figure figure){
        return strategy.findSquare(figure);
    }
}
