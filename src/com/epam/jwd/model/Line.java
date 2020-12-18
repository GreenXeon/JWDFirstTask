package com.epam.jwd.model;

import com.epam.jwd.strategy.LineInfoStrategy;
import com.epam.jwd.strategy.Strategy;

import java.util.List;

public class Line extends Figure {
    private List<Point> points;
    public static Strategy figurePropertiesStrategy = LineInfoStrategy.INSTANCE;
    private FigureType type = FigureType.LINE;

    Line(List<Point> points){
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public FigureType getType() {
        return type;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString(){
        return this.getPoints().get(0).toString() + " - " + this.getPoints().get(1).toString();
    }

    @Override
    public int numOfPoints(){
        return 2;
    }
}
