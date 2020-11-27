package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

public interface Strategy {
    double findPerimeter(Figure figure);
    double findSquare(Figure figure);
}
