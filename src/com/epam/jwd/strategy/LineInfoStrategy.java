package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;

public enum LineInfoStrategy implements Strategy {
    INSTANCE;

    @Override
    public double findPerimeter(Figure figure) {
        Line obj = (Line)figure;
        return Math.sqrt(Math.pow(obj.getPoints()[1].getX() - obj.getPoints()[0].getX(), 2)
        + Math.pow(obj.getPoints()[1].getY() - obj.getPoints()[0].getY(), 2));
    }

    @Override
    public double findSquare(Figure figure) {
        return 0;
    }
}
