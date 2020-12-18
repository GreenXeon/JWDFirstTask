package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;

import java.util.List;

public abstract class Figure {
    private Strategy figurePropertiesStrategy;
    private List<Point> points;
    private FigureType type;

    public boolean validationCheck() {
        return true;
    }

    public boolean equalityCheck(){
        List<Point> points = this.getPoints();
        for (int i = 0; i < points.size() - 1; i++){
            for ( int j = i+1; j < points.size(); j++){
                if (points.get(i).equals(points.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public FigureType getType() {
        return type;
    }

    public Strategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public int numOfPoints() {
        return 0;
    }

    public List<Point> getPoints(){
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
