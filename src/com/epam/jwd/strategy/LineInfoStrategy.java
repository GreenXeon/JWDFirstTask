package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;

public enum LineInfoStrategy implements Strategy {
    INSTANCE;
    @Override
    public double findPerimeter(Figure figure) {
        Line obj = (Line)figure;
        return Math.sqrt(Math.pow(obj.getSecondPoint().getX() - obj.getFirstPoint().getX(), 2)
        + Math.pow(obj.getSecondPoint().getY() - obj.getFirstPoint().getY(), 2));
    }

    @Override
    public double findSquare(Figure figure) {
        return 0;
    }
}
