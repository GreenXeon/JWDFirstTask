package com.epam.jwd.model;

import com.epam.jwd.strategy.Strategy;

import java.util.Arrays;
import java.util.List;

public abstract class Figure {
    private Strategy figurePropertiesStrategy;
    private Point[] points = {};

    public boolean validationCheck() {
        return true;
    }

    public boolean equalityCheck(){
        List<Point> points = Arrays.asList(this.getPoints());
        for (int i = 0; i < points.size() - 1; i++){
            for ( int j = i+1; j < points.size(); j++){
                if (points.get(i).equals(points.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public int numOfPoints() {
        return 0;
    }

    public Point[] getPoints(){
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
