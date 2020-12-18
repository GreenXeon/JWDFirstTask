package com.epam.jwd.model;

import com.epam.jwd.strategy.MultiAngleInfoStrategy;
import com.epam.jwd.strategy.Strategy;

import java.util.Arrays;
import java.util.List;

public class MultiAngleFigure extends Figure {
    private List<Point> points;
    public static Strategy figurePropertiesStrategy = MultiAngleInfoStrategy.getInstance();
    private FigureType type = FigureType.MULTIANGLE;

    MultiAngleFigure(Point ... points){
        this.points = Arrays.asList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString(){ //todo
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < points.size(); i++){
            result.append(this.points.get(i).toString());
            result.append(" - ");
        }
        return result.toString();
    }

    @Override
    public int numOfPoints(){
        return points.size();
    }
}
