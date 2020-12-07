package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

public interface Strategy {
    double findPerimeter(Figure figure);
    double findSquare(Figure figure);
    //double findSide(Point first, Point second);
}
